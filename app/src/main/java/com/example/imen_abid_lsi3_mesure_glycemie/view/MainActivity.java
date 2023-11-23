package com.example.imen_abid_lsi3_mesure_glycemie.view;
//Ce sont les différentes importations de classes nécessaires pour le code.
//Par exemple, AppCompatActivity est hérité pour créer une activité Android,
//et d'autres classes sont importées pour utiliser des widgets graphiques et des fonctionnalités Android
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;//

import com.example.imen_abid_lsi3_mesure_glycemie.R;
import com.example.imen_abid_lsi3_mesure_glycemie.controller.Controller;
public class MainActivity extends AppCompatActivity {
//La classe MainActivity étend AppCompatActivity, ce qui signifie qu'elle est une activité Android.
    //mainActivity hattayneha fy view khater fiha al'interface
    private TextView tvage, TvRes;//elly mawjoud fy id ta3 Age
    private SeekBar sbAge;
    private RadioButton rbtOui, rbtNon;
    private EditText ValMes;
    private Button btnConsulter;

    private Controller controller = Controller.getInstance();//

    //Ces lignes déclarent des variables pour les éléments d'interface utilisateur, qui seront référencés dans le code.


    @Override
    // La méthode onCreate est appelée lorsque l'activité est créée
    protected void onCreate(Bundle savedInstanceState) { //bundle sauvgrd l'etat de l'app en arriere plan
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //contentview :fichr.xml
        //R : c'est une clss finale cst ,contient des sous classe
        //layout : clss finale contient les identifients de touts les interfaces  de l'app
        init();
        // action sur le seekbar:(listener)
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()

        /*La méthode onCreate est exécutée lorsque l'activité est créée.
        Elle configure l'interface utilisateur en utilisant le fichier de mise en page
        activity_main.xml et initialise les éléments d'interface utilisateur en appelant la méthode init().
        De plus, des écouteurs sont initialisés pour le SeekBar et le bouton.*/
        {
            @Override
            //i: hiya valeur de retour elly besh yraja3helna
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.i("Information", "onProgressChanged" + progress);
                tvage.setText(getString(R.string.age) + " " + progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });//elly wost set lkollou implementation ta3 les methodes

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulter(v);
            }
        });
    }

    public void consulter(View v) { // Logique pour effectuer la consultation en fonction des valeurs des éléments d'interface utilisateur.
      /*  La méthode consulter est appelée lorsque le bouton "Consulter" est cliqué.
       Elle effectue des calculs basés sur les valeurs des éléments d'interface utilisateur tels que le SeekBar,
        le EditText et les boutons radio, puis affiche les résultats dans le TextView TvRes.*/

        int age;
        float valMesu;
        boolean verifAge = false, verifValeur = false;

        if (sbAge.getProgress() != 0)
            verifAge = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir votre âge !", Toast.LENGTH_SHORT).show();
        //affichage immédiate
        if (!ValMes.getText().toString().isEmpty())
            verifValeur = true;
        else
            Toast.makeText(MainActivity.this, "Veuillez saisir une valeur mesurée valide !", Toast.LENGTH_LONG);
        //affichage de toast apres 1seconde
        if (verifAge && verifValeur) {
            age = sbAge.getProgress();
            valMesu = Float.valueOf(ValMes.getText().toString());
            boolean IsFasting = rbtOui.isChecked();
            //useraction:view to controller
            controller.createPatient(age, valMesu, IsFasting);
            //update cntroller to view
            TvRes.setText(controller.getResult());

/*
            if(rbtOui.isChecked()) {    // il est a jeun
                if(age >= 13) {   //nrmlment men hnee bdina nhezzou ll patient
                    if (valMesu < 5.0)
                        TvRes.setText("Le niveau de glycèmie est bas !");
                    else if (valMesu >= 5.0 && valMesu <= 7.2)
                        TvRes.setText("Le niveau de glycèmie est normal !");
                    else
                        TvRes.setText("Le niveau de glycèmie est élevé !");
                }
                else
                if(age >= 6 && age <= 12) {
                    if (valMesu < 5.0)
                        TvRes.setText("Le niveau de glycèmie est bas !");
                    else
                    if (valMesu >= 5.0 && valMesu <= 10.0)
                        TvRes.setText("Le niveau de glycèmie est normal !");
                    else
                        TvRes.setText("Le niveau de glycèmie est élevé !");
                }
                else
                if(valMesu < 5.50)
                    TvRes.setText("Le niveau de glycèmie est bas !");
                else
                if(valMesu >= 5.5 && valMesu <= 10.0)
                    TvRes.setText("Le niveau de glycèmie est normal !");
                else
                    TvRes.setText("Le niveau de glycèmie est élevé !");
            }
            else
            if(valMesu <= 10.5)
                TvRes.setText("Le niveau de glycèmie est normal !");
            else
                TvRes.setText("Le niveau de glycèmie est élevé !");
        }*/
        }

    /*La méthode init() initialise les variables en associant les éléments d'interface utilisateur définis
    dans le fichier de mise en page XML aux variables déclarées dans le code.
     */
    }
    public void init() {
        tvage = (TextView) findViewById(R.id.tvage);//type de retour hiya class heka alesh 3malna cast
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        rbtOui = (RadioButton) findViewById(R.id.rbtOui);
        rbtNon = (RadioButton) findViewById(R.id.rbtNon);
        ValMes = (EditText) findViewById(R.id.ValMes);
        btnConsulter = (Button) findViewById(R.id.btnConsulter);
        TvRes = (TextView) findViewById(R.id.TvRes);
    }
}