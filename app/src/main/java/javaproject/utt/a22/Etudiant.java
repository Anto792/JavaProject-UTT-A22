package javaproject.utt.a22;

public class Etudiant extends Pion{

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        
    }
    

    /**
     * Constructeur de la classe Etudiant.
     */
    public Etudiant(Joueur joueur, String nom){
        super(joueur, nom);
        super.joueur = joueur;
        super.nom = nom;
        super.dexterite = 0;
        super.force = 0;
        super.resistance = 0;
        super.constitution = 0;
        super.initiative = 0;

        super.joueur.addPion(this);
    }
}
