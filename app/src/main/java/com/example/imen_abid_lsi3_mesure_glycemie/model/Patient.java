package com.example.imen_abid_lsi3_mesure_glycemie.model;

public class Patient {
    private int age ;
    private float valeur;
    private boolean isfasting;
    private String result ;
    //update controller -->model

    public Patient( int age, float valeur ,boolean isfasting) {
        this.age = age;
        this.valeur = valeur;
        this.isfasting = isfasting;

        calculer();//calcul de resultat
    }
            private void calculer(){
                if (isfasting)
                    if(age>=13)
                        if(valeur<5)
                            result ="niveau clycemie est bas";
                //else..........w nkamal elly tah't'hom


            }//notify model -->controller

            public String getResult(){
                return result;

            }




    }

