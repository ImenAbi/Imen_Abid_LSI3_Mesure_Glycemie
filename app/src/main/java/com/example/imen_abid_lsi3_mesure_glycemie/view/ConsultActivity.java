package com.example.imen_abid_lsi3_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.imen_abid_lsi3_mesure_glycemie.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView tvReponse;
    private Button btnReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);
        init();

        Intent intent = getIntent();//getIntent existe par defaut on compatActivity
                                   // elle retourne l'intent qui a lance l'activite courante
                                  //de type intent
        //la retour de getIntent est une instance de la classe Intent
        String reponse =intent.getStringExtra("reponse");
        tvReponse.setText(reponse);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                if (reponse !=null)
                    setResult(RESULT_OK);
                else
                    setResult(RESULT_CANCELED);
            }
        });


    }
    private void init (){{
        tvReponse=( TextView)findViewById(R.id.tvReponse);
        btnReturn=(Button) findViewById(R.id.btnReturn);
    }
    }
}