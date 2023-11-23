package com.example.imen_abid_lsi3_mesure_glycemie.model;

public class Patient {
    private int age ;
    private float valeur;
    private boolean isfasting;
    private String result ;

    //update controller -->model
   //update controller -->patient :constructeur besh yekhou les donnees w y3adihom ll patient
    //pconstructeur yraja3ly un patient : houwa dekhel fy partie ta3 update
    //ahna cote model la methode mawjouda fy updata

    // Constructeur pour initialiser les données du patient
    public Patient( int age, float valeur ,boolean isfasting) {
        this.age = age;
        this.valeur = valeur;
        this.isfasting = isfasting;

        calculer();// Appelle la méthode de calcul pour déterminer le résultat
    }
    public int getAge() {
        return age;
    }// hedhyy**
    public float getVm() {
        return valeur;}//w hedhyy zeydin khater ena hajty ken bi get ta3 resultat



    //notify model -->controller
    public String getResult(){
        return result;

    } //get lwahida elly hajty beha lehna fy cas ta3 patient
    // khater hiya resultat du traitement ta3y hedha string elly gedsin nehsbou fih
    // w hedha elly lezmou yokhrej ll'utilisateur elly lbarra
    //heka alesh lview 3adet les donnees ta3ha(age,valeu, boolean) ll'controller
    //besh heka lcontroller ywassalho ll'model ellybesh ya3tihom resultat w resultat tousel llview besh yafichiha ll'utilisateur
    public boolean getisFasting() {
        return isfasting;
    }


    //ki yebda l'controller jeyebly les donnees w y3ayat (ll'instance wela)llconstructeur t3 l'patient w 3tah l'age w val w boolean
    //donc methode calculernhiya elly besh temshy ta3mel mise a jour mte3 string result
    //donc m3a la creation d'un patient 3andy les donnees directement nemshy nehseb les resultats

    // Méthode privée pour calculer le résultat en fonction des critères
    private void calculer(){
                if (isfasting)
                {
                    if(age >=13){
                        if(valeur<5)
                            result="niveau de glycemie est bas";
                        else
                        if(valeur>=5 && valeur<=7)
                            result="niveau de glycemie est normal";
                        else
                            result="niveau de glycemie ese eleve ";
                    }
                    else if(age >=6 && age <=12)
                    {
                        if(valeur<5)
                            result="niveau de glycemie est bas";
                        else
                        if(valeur>=5 && valeur<=10)
                            result="niveau de glycemie est normal";
                        else
                            result="niveau de glycemie ese eleve "
                                    ;}
                    else if(age <6) {
                        if(valeur<5.5)
                            result="niveau de glycemie est bas";
                        else
                        if(valeur>=5.5 && valeur<=10)
                            result="niveau de glycemie est normal";
                        else
                            result="niveau de glycemie ese eleve ";}


                }else //false {
                    if(valeur>10.0)
                        result="niveau eleve";
                    else result="niveau normal";


            }



} //hnaa hadharna l'patient  w les methodes wost lpatient









