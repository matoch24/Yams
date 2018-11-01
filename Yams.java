//Jeu solo sans tri des dés
import java.util.Scanner ;

class Yams {

    static Scanner in = new Scanner (System.in) ;

	public static void relancerDes (int [] stock) {
		int essai;
		int reponse ;
		int combien ;
		int choisi ;
		int question ;
		for (int e=1; e<=3; e++) {
			System.out.println ("Essai "+e);
			System.out.println ( "Si vous voulez relancer, tapez 1. Sinon, tapez 0." ) ;
			reponse = in.nextInt ();
			if (reponse == 1 ) {
				System.out.print("Combien de dés voulez vous relancer?");
				combien = in.nextInt () ;
				for (int i=1; i<=combien; i++ ) {
					System.out.print ("Quel dé voulez vous relancer?");
					choisi = in.nextInt();
					stock[choisi-1] = (int) (Math.random()*6+1) ;
					afficherDes (stock);
				}
			}
		}
}

	public static void triDes( int [] stock ) {
	}
	//public static void echanger (int [] stock , int j , int j+1){
		//int p , int x;
		//x = stock[i]
		//stock[i] = stock[p]
		//stock[p] = x
	//}


	public static void afficherDes ( int [] stock ) {
		triDes (stock);
		for ( int i = 0; i <= stock.length-1; i++) {
			System.out.print (stock[i] + " " ) ;
		}
	}

	public static void listeCombinaisons (boolean [] contrats) {
		System.out.println ("Combinaison 1 : somme des 1");
		System.out.println ("Combinaison 2 : somme des 2");
		System.out.println ("Combinaison 3 : somme des 3");
		System.out.println ("Combinaison 4 : somme des 4");
		System.out.println ("Combinaison 5 : somme des 5");
		System.out.println ("Combinaison 6 : somme des 6");
		System.out.println ("Combinaison 7 : brelan ( 3 dés identiques)");
		System.out.println ("Combinaison 8 : full ( 3 dés identiques + 2 autres dés identiques)");
		System.out.println ("Combinaison 9 : carré ( 4 dés identiques )");
		System.out.println ("Combinaison 10 : petite suite ( 4 dés qui se suivent)");
		System.out.println ("Combinaison 11 : grande suite ( 5 dés qui se suivent)");
		System.out.println ("Combinaison 12 : Yams ( 5 dés identiques)");
		System.out.println ("Combinaison 13 : chance");

	}

	public static void validationCombinaisons (boolean [] contrats ,int [] score , int [] stock){
		int choixcontrat;
		int somme=0;
		System.out.print ("QUelle combinaison valider?");
		choixcontrat = in.nextInt();
		for ( int j = 0; j <= score.length-1; j++) {
			if (choixcontrat==0){
				score[j]=score[j]=0;
				}else if (contrats[choixcontrat-1]){
				System.out.println ("Combinaison validée plus tôt! Réessayer!");
				choixcontrat = in.nextInt();
				contrats[choixcontrat-1] = true;
				}else {
					contrats[choixcontrat-1] = true;
				}


		for (int i=0; i<=4;i++){
			somme=somme+stock[i];
		if (choixcontrat==1){
			score[j] = score[j]+calculd1(stock);
		} else if (choixcontrat==2){
			score[j]=score[j]+calculd2(stock);
		} else if (choixcontrat==3){
			score[j]=score[j]+calculd3(stock);
		} else if (choixcontrat==4){
			score[j]=score[j]+calculd4(stock);
		} else if (choixcontrat==5){
			score[j]=score[j]+calculd5(stock);
		} else if (choixcontrat==6){
			score[j]=score[j]+calculd6(stock);
		} else if (choixcontrat==7){
			score[j]=score[j]+somme;
		} else if (choixcontrat==8){
			score[j]=score[j]+25;
		} else if (choixcontrat==9){
			score[j]=score[j]+somme;
		} else if (choixcontrat==10){
			score[j]=score[j]+30;
		} else if (choixcontrat==11){
			score[j]=score[j]+40;
		} else if (choixcontrat==12){
			score[j]=score[j]+50;
		} else if (choixcontrat==13){
			score[j]=score[j]+somme;}
		}
	}
		for ( int i = 0; i <= score.length-1; i++) {
			System.out.println ("score :" + score[i]/5 + " " ) ;
		}
	}

	public static int calculd1 (int [] stock ){
		int d1;
		d1=0;
		for (int i=0; i<=4;i++){
			if (stock[i]==1){
				d1=d1+1;
			}}
			return d1;
		}

	public static int calculd2 (int [] stock ){
		int d2;
		d2=0;
		for (int i=0; i<=4;i++){
			if (stock[i]==2){
				d2=d2+2;
			}}
			return d2;
		}

	public static int calculd3 (int [] stock ){
		int d3;
		d3=0;
		for (int i=0; i<=4;i++){
			if (stock[i]==3){
				d3=d3+3;
			}}
			return d3;
		}

	public static int calculd4 (int [] stock ){
		int d4;
		d4=0;
		for (int i=0; i<=4;i++){
			if (stock[i]==4){
				d4=d4+4;
			}}
			return d4;
		}

	public static int calculd5 (int [] stock ){
		int d5;
		d5=0;
		for (int i=0; i<=4;i++){
			if (stock[i]==5){
				d5=d5+5;
			}}
			return d5;
		}

	public static int calculd6 (int [] stock ){
		int d6;
		d6=0;
		for (int i=0; i<=4;i++){
			if (stock[i]==6){
				d6=d6+6;
			}}
			return d6;
		}
// bonus non testé
	public static void bonus (int [] stock , int [] score){
		int test;
		test=calculd1(stock)+calculd2(stock)+calculd3(stock)+calculd4(stock)+calculd5(stock)+calculd6(stock);
		for ( int j = 0; j <= score.length-1; j++) {
		if (test>=63){
			score[j]=score[j]+35;
		}}}

	public static void combinaisonsRestantes (boolean [] contrats){
		System.out.println (" ");
		System.out.println ("Combinaisons restantes :");
		for(int c=0; c<= contrats.length-1; c++){
			if (contrats[c] == false) {
				System.out.println ( "combinaison" + (c+1) );
			}
		}
	}

    public static void main ( String [] args ) {

	System.out.println ("Jeu SOLO");
	int nbj ;
	System.out.print ("nombre de joueurs : ") ;
	nbj = in.nextInt (	) ;
	System.out.println (nbj + " joueur(s)");


	int [] score;
	score = new int [ nbj ];
	for ( int i = 0; i <= score.length-1; i++) {
		System.out.println (" ");
		System.out.print ("score :" + score[i]/5 + " " ) ;
	}


	boolean [] contrats;
	contrats = new boolean [13];
	for (int c=0; c<= contrats.length-1; c++){
			contrats[c] = false;
		}


	int [] stock ;
	stock = new int [ 5*nbj ] ;

	for (int t=1; t<=13;t++){
		System.out.println (" ");
		System.out.println("Tour numéro "+t);
	for ( int i = 0; i <= stock.length-1; i++) {
	stock[i] = (int) (Math.random()*6+1) ;
	triDes( stock) ;
	System.out.print (" " + stock[i] + " " ) ;
	}
	System.out.println (" ");
	relancerDes ( stock ) ;
	System.out.println (" ");
	System.out.println (" ");
	listeCombinaisons(contrats);

	validationCombinaisons (contrats , score , stock) ;
	combinaisonsRestantes ( contrats ) ;
}
}
}
