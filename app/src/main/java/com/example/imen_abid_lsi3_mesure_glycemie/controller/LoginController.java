package com.example.imen_abid_lsi3_mesure_glycemie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.imen_abid_lsi3_mesure_glycemie.model.Patient;
import com.example.imen_abid_lsi3_mesure_glycemie.model.User;

public class LoginController {
    //attributs du classe
     private static final String SHARED_PREFS="sharedPrefs";
    private static User user;
    private static LoginController instance=null;
    //hedheya constructeur par default(super w k'hw) hedhy instance elly tnajam twassalny lldeux methode principale ta3 controller
    public LoginController() {
        super();

    }
    public static final LoginController getInstance(Context context){
        if(LoginController.instance==null){
            LoginController.instance= new LoginController();}
        recapUser(context);
        return LoginController.instance;//hedhy fy else yaanay ken lkaha moush null ya3tihely toul

    }
    private static void recapUser(Context context){ //recap hedhy t'accedy ll sharedpreference w ta3mel initialisationll user de loginController:
        //contoller andou communication m3a l'activity (activity hiya de type context) donc homeActivity.this hiya l'contexte
        //modification fy homeActivity twally wa9t elly t3ayat ll getInstance tzid fy parametres mte3ha "hommeActivity.this"
        //instance de type activity yaany instnce de type contexte

        //hedhy awwal acces ll aplli hiya bi shared besh ishouf famma user name enregistre ou non si non ykharraj chaine vide
        // w 2eme acces besh  yalka userName msajla khater heka lwakt 3mal create user
        //recuperer  les donnees( username , psw) w nhot'hom wost var esmou user :
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        String userName =sharedPreferences.getString("userName","");
        String password= sharedPreferences.getString("password","") ;
        user  = new User(userName,password);

    }

    public static void createUser(String userName, String password, Context context){
        user =new User(userName,password);
        SharedPreferences sharedPreferences= context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("userName",userName);
        editor.putString("password",password);
        editor.apply(); //hedhy ya3ny barra appliqui
    }
    public String getUserName() {
        return user.getUserName();
    }

    public String getPassword() {
        return  user.getPassword() ;
    }


}
