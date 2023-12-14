package com.example.imen_abid_lsi3_mesure_glycemie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imen_abid_lsi3_mesure_glycemie.R;
import com.example.imen_abid_lsi3_mesure_glycemie.controller.LoginController;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsulter;
    private EditText etUserName;
    private EditText etPassword;
    private LoginController loginController;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        etUserName.setText((loginController.getUserName()));
        etPassword.setText(loginController.getPassword());


        btnConsulter= (Button) findViewById(R.id.btnConsultation);
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName , password;
                boolean verifUserName = false , verifPasswod = false;

                if (!etUserName.getText().toString().isEmpty())
                    verifUserName=true;
                else
                    Toast.makeText(HomeActivity.this,"veuillez saisir votre nom",Toast.LENGTH_SHORT).show();
                if (!etPassword.getText().toString().isEmpty())
                    verifPasswod=true;
                else
                    Toast.makeText(HomeActivity.this,"veuillez saisir votre mot de passe",Toast.LENGTH_SHORT).show();
                if (verifUserName && verifPasswod){

                    userName=etUserName.getText().toString();
                    password=etPassword.getText().toString();
                    LoginController.createUser(userName,password,HomeActivity.this);

                    //intent sans retour
                    Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                    startActivity (intent);
                    finish();

                }





            }
        });

        }
        private void init(){
             //kif 3ayyat ll getInstance ta3 la creation de loginController yezemny na3tiha le contexte de travail besh twaslou ll recapUser
            // Ellymeshya besh t3adih wela t'aceedi bih ll sharedPreference
            // ya3ny context dar men and hommeActivity -->controller-->recapUser-->sharedPrederences.getSharedPrefs
            loginController = LoginController.getInstance(HomeActivity.this);
            btnConsulter=(Button) findViewById(R.id.btnConsultation);
            etPassword=(EditText) findViewById(R.id.etPassword);
            etUserName=(EditText)  findViewById(R.id.etUserName);
        }

    }
