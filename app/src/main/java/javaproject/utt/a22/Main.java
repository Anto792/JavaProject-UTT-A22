package javaproject.utt.a22;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
         * Initialisation de la partie.
         */
        Partie partie = new Partie();

        /*
         * Initialisation des joueurs.
         */
        for(int i = 0; i<2; i++){
            Joueur joueur = new Joueur(partie);
        }

        /*
         * Initialisation des pions.
         */
        for(int i = 1; i<16; i++){
            Pion pion = new Etudiant(partie.arrayJoueur.get(0), "Etudiant "+i);
        }
        System.out.println(partie.arrayJoueur.get(0).arrayPion.get(0));
        /*
        for(int i = 0; i<15; i++){
            System.out.println(partie.arrayJoueur.get(0).arrayPion.get(i));
        }
        */

        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Quel étudiant, élite ou maître voulez-vous ? \'Etudiant x\'', \'Elite x\'', \'Maitre x\'");
            String name = sc.nextLine();

            String[] tokens = name.split("\\s");
            int numeroPion = Integer.parseInt(tokens[1]);

            switch(tokens[0]){
                case "Etudiant":
                    System.out.println(partie.arrayJoueur.get(0).arrayPion.get(numeroPion-1));

                    break;
                case "Elite":
                    break;
                case "Maitre":
                    break;
                default:
                    System.out.println("Vous devez écrire \'Etudiant\', \'Elite\' ou \'Maitre\' avec le numero du pion.");
            }
        }
    }
}
