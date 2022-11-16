package javaproject.utt.a22;

public class Elite extends Pion{

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        
    }
    
    /**
     * Constructeur de la classe Elite.
     */
    public Elite(Joueur joueur, String nom){
        super(joueur, nom);
        super.joueur = joueur;
        super.nom = nom;
        super.dexterite = 1;
        super.force = 1;
        super.resistance = 1;
        super.constitution = 5;
        super.initiative = 1;

        super.joueur.addPion(this);
    }

}
