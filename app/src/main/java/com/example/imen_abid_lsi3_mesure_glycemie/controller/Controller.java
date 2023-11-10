package com.example.imen_abid_lsi3_mesure_glycemie.controller;

import com.example.imen_abid_lsi3_mesure_glycemie.model.Patient;

public class Controller {
    private static Patient patient;

    public Controller() {
        super();

    }

    //elly fy parametrs : user action view-->controller
    public void createPatient(int age, float valeur, boolean isfasting) {//tekhou en paramtrs elly ya3tihomlaha
        patient =new Patient (age, valeur, isfasting);
    }
    // updade controller -->model

    //notifty controller -->view
    public  String getResult(){
        //notify model-->controller
        return patient.getResult();
    }

}

