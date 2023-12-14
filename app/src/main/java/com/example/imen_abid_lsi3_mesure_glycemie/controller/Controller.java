package com.example.imen_abid_lsi3_mesure_glycemie.controller;

import com.example.imen_abid_lsi3_mesure_glycemie.model.Patient;
import com.example.imen_abid_lsi3_mesure_glycemie.model.User;

//hedheya ya3ty les donnees ll patient (model) w yheb yekhou notify (resultat)
public class Controller {
    //l'controller besh yest'hak ll instansiation private static patient w hiya private khater hiya teb3a ll'controller w l'view moush besh y3aytel'ha

    private static Patient patient;
    private static Controller instance=null;
    //hedheya constructeur par default(super w k'hw) hedhy instance elly tnajam twassalny lldeux methode principale ta3 controller
    public Controller() {
        super();

    }
    public static final Controller getInstance(
    ){
       if(Controller.instance==null)
           Controller.instance= new Controller();
        return Controller.instance;//hedhy fy else yaanay ken lkaha moush null ya3tihely toul
    }

    //elly fy parametrs : user action view-->controller
    public void createPatient(int age, float valeur, boolean isfasting) {//tekhou en paramtrs elly ya3tihomlaha
        patient =new Patient (age, valeur, isfasting);
    }//hedhy methode na3tiha les donnees twassal'hom llpatient
    //parametres mte3ha sont les donnees elly 3tahomly l'view elly yes'hakhom l'patient (model)en tant que controller
    //les donnes hedhom besh njib'hom men view w view besh t3adihom llconroller bi l'instance t3  controller : "controller." w
    //t3atyet llmethode createPatient


    // updade controller -->model

    //notifty controller -->view
    public  String getResult(){
        //notify model-->controller
        return patient.getResult();//update patient to controller

    }// l'controller tout simplement l'view besh ta3tih user action besh ywassal'ha l'model
    // w l'model ya3mel notification l'controller besh ywassalha l'view
    // khater ma najamsh nkhally l'model w l'view yahkiw m3a b3adh'hom
    //leklem hedha bi'java ywally: l'view me tnajamesh ta3mel instance 3al patient
    // w l'patient me ynajamesh ya3mel instance 3al model


}


