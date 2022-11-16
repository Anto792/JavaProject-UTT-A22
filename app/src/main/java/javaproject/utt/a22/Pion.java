/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaproject.utt.a22;

import java.util.Iterator;

/**
 * Classe permettant le controle du pion (combattant).
 */
public class Pion{

    /**
     * Attribut specifiant à quel joueur appartient le pion.
     */
    protected Joueur joueur;

    /**
     * Nom du pion.
     */
    protected String nom;

    /**
     * L'attribut ECTS équivaut à la vie du pion, une fois à 0 notre pion meurt.
     */
    protected int ECTS = 30;

    /**
     * Statistique permettant l'esquive d'une attaque ou l'atteinte de la cible lors de l'attque (0 à 10).
     */
    protected int dexterite;
    /**
     * Valeur maximal de la dexterite.
     */
    private final int maxDexterite = 10;
    /**
     * Valeur minimale de la dexterite.
     */
    private final int minDexterite = 0;

    /**
     * Statistique de force de l'attaque. Augmente les degats de 10% par points affectes (0 à 10).
     */
    protected int force;
    /**
     * Valeur maximale de la force.
     */
    private final int maxForce = 10;
    /**
     * Valeur minimale de la force.
     */
    private final int minForce = 0;
    
    /**
     * Statistique de resistance aux attaques. Augmente la resistance de 5% par points affectes (0 à 10).
     */
    protected int resistance;
    /**
     * Valeur maximale de la resistance.
     */
    private final int maxResistance = 10;
    /**
     * Valeur minimale de la resistance.
     */
    private final int minResistance = 0;
    
    /**
     * Statistique de vie supplémentaire. Augmente la vie initiale du nombre de points affectes (0 à 30).
     */
    protected int constitution;
    /**
     * Valeur maximale de la constitution.
     */
    private final int maxConstitution = 30;
    /**
     * Valeur minimale de la constitution.
     */
    private final int minConstitution = 0;
    
    /**
     * Statistique d'initiative. Determine quel pion attaque le premier (0 à 10).
     */
    protected int initiative;
    /**
     * Valeur maximale de l'initiative.
     */
    private final int maxInitiative = 10;
    /**
     * Valeur minimale de l'initiative.
     */
    private final int minInitiative = 0;

    /**
     * Status de combat du pion (Combattant, Reserviste ou Indefini).
     */
    private StatusPion status = StatusPion.Indefini;

    /**
     * Enumeration du status de combat du pion.
     */
    enum StatusPion{
        Combattant, Reserviste, Indefini;
    }

    /**
     * Strategie que le pion adaptera pour combattre (Offensif, Defensif ou Aleatoire).
     */
    protected Strategie strategie;


    /**
     * Zone a laquelle le pion est affecte.
     */
    private Zone zone = null;


    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        Partie partie = new Partie();

        for(int i = 0; i<2; i++){
            Joueur joueur = new Joueur(partie, "Joueur "+i);
            partie.arrayJoueur.add(joueur);
        }

        for(int i = 1; i<16; i++){
            Pion pion = new Etudiant(partie.arrayJoueur.get(0), "Etudiant "+i);
            partie.arrayJoueur.get(0).arrayPion.add(pion); //A enlever une fois la methode addPion de la classe Joueur faite.
        }

        for(int i = 1; i<6; i++){
            Pion pion = new Elite(partie.arrayJoueur.get(0), "Elite "+i);
            partie.arrayJoueur.get(0).arrayPion.add(pion); //A enlever une fois la methode addPion de la classe Joueur faite.
        }

        Pion pion = new Maitre(partie.arrayJoueur.get(0), "Maitre");
        partie.arrayJoueur.get(0).arrayPion.add(pion);

        Iterator<Pion> it = partie.arrayJoueur.get(0).arrayPion.iterator();
        while(it.hasNext()){
            Pion p = it.next();
            p.changerConstitution(20);
            p.changerStrategie(new Aleatoire());
            System.out.println(p);
        }
    }


    /**
     * Constructeur Pion
     */
    public Pion(){

    }

    /**
     * Methode pour ajouter ou retirer des ECTS au pion.
     * @param constitution
     */
    public void changerECTS(int ECTS){
        /*
         * Changement des ECTS s.s.i. 60 > this.ECTS + ECTS >= 0.
         */
    }

    /**
     * Methode pour recuperer les ECTS du pion.
     * @return this.ECTS
     */
    public int getECTS(){
        return this.ECTS;
    }


    /**
     * Methode pour ajouter ou retirer de la dexterite au pion.
     * @param dexterite
     */
    public void changerDexterite(int dexterite){
        int var = 0; //Variable de stockage.

        if(dexterite > 0){ //Test si nous ajoutons de la dexterite.
            this.dexterite += dexterite; //Ajout des points de dexterite.

            if(this.dexterite > this.maxDexterite){ //Test si apres ajout, la dexterite depasse sa capacite.
                var = this.dexterite - this.maxDexterite; //Calcul du surplus.
                this.dexterite = this.maxDexterite; //La dexterite ne peut pas etre superieur a 10.
                joueur.changerPoint(-dexterite - var); //Retrait des points au joueur.
                System.out.println("Votre pion a déjà le maximum de dextérité.");
            } else{
                joueur.changerPoint(-dexterite); //Retrait des points au joueur.
            }

        } else if(dexterite < 0){ //Test si nous enlevons de la dexterite.
            var = this.dexterite; //Sauvegarde de notre ancienne dexterite.
            this.dexterite += dexterite; //Ajout des points de dexterite.

            if(this.dexterite < this.minDexterite){ //Test si apres retrait, la dexterite est en dessous de sa capacite.
                this.dexterite = this.minDexterite; //La dexterite ne peut pas etre en dessous.
                joueur.changerPoint(var); //Recuperation des points par le joueur.
            } else{
                joueur.changerPoint(dexterite); //Recuperation des points par le joueur.
            }

        } else{ //Test si nous ne faisons rien sur la dexterite.
            System.out.println("Vous devez ajouter ou retirer des points de dextérité.");
        }
    }

    /**
     * Methode pour recuperer la dexterite du pion.
     * @return this.dexterite
     */
    public int getDexterite(){
        return this.dexterite;
    }


    /**
     * Methode pour ajouter ou retirer de la force au pion.
     * @param force
     */
    public void changerForce(int force){
        int var = 0; //Variable de stockage.

        if(force > 0){ //Test si nous ajoutons de la force.
            this.force += force; //Ajout des points de force.

            if(this.force > this.maxForce){ //Test si apres ajout, la force depasse sa capacite.
                var = this.force - this.maxForce; //Calcul du surplus.
                this.force = this.maxForce; //La force ne peut pas etre superieur a sa capacite.
                joueur.changerPoint(-force - var); //Retrait des points au joueur.
                System.out.println("Votre pion a déjà le maximum de force.");
            } else{
                joueur.changerPoint(-force); //Retrait des points au joueur.
            }

        } else if(force < 0){ //Test si nous enlevons de la force.
            var = this.force; //Sauvegarde de notre ancienne force.
            this.force += force; //Ajout des points de force.

            if(this.force < this.minForce){ //Test si apres retrait, la force est en dessous de sa capacite.
                this.force = this.minForce; //La force ne peut pas etre en dessous de sa capacite.
                joueur.changerPoint(var); //Recuperation des points par le joueur.
            } else{
                joueur.changerPoint(force); //Recuperation des points par le joueur.
            }
            
        } else{ //Test si nous ne faisons rien sur la force.
            System.out.println("Vous devez ajouter ou retirer des points de force.");
        }
    }

    /**
     * Methode pour recuperer la force du pion.
     * @return this.force
     */
    public int getForce(){
        return this.force;
    }


    /**
     * Methode pour ajouter ou retirer de la resistance au pion.
     * @param resistance
     */
    public void changerResistance(int resistance){
        int var = 0; //Variable de stockage.

        if(resistance > 0){ //Test si nous ajoutons de la resistance.
            this.resistance += resistance; //Ajout des points de resistance.

            if(this.resistance > this.maxResistance){ //Test si apres ajout, la resistance depasse sa capacite.
                var = this.resistance - this.maxResistance; //Calcul du surplus.
                this.resistance = this.maxResistance; //La resistance ne peut pas etre superieur a sa capacite.
                joueur.changerPoint(-resistance - var); //Retrait des points au joueur.
                System.out.println("Votre pion a déjà le maximum de résistance.");
            } else{
                joueur.changerPoint(-resistance); //Retrait des points au joueur.
            }

        } else if(resistance < 0){ //Test si nous enlevons de la resistance.
            var = this.resistance; //Sauvegarde de notre ancienne resistance.
            this.resistance += resistance; //Ajout des points de resistance.

            if(this.resistance < this.minResistance){ //Test si apres retrait, la resistance est en dessous de sa capacite.
                this.resistance = this.minResistance; //La resistance ne peut pas etre en dessous de sa capacite.
                joueur.changerPoint(var); //Recuperation des points par le joueur.
            } else{
                joueur.changerPoint(resistance); //Recuperation des points par le joueur.
            }
            
        } else{ //Test si nous ne faisons rien sur la resistance.
            System.out.println("Vous devez ajouter ou retirer des points de résistance.");
        }
    }

    /**
     * Methode pour recuperer la resistance du pion.
     * @return this.resistance
     */
    public int getResistance(){
        return this.resistance;
    }


    /**
     * Methode pour ajouter ou retirer de la constitution au pion.
     * @param constitution
     */
    public void changerConstitution(int constitution){
        int var = 0; //Variable de stockage.

        if(constitution > 0){ //Test si nous ajoutons de la constitution.
            this.constitution += constitution; //Ajout des points de constitution.

            if(this.constitution > this.maxConstitution){ //Test si apres ajout, la constitution depasse sa capacite.
                var = this.constitution - this.maxConstitution; //Calcul du surplus.
                this.constitution = this.maxConstitution; //La constitution ne peut pas etre superieur a sa capacite.
                joueur.changerPoint(-constitution - var); //Retrait des points au joueur.
                System.out.println("Votre pion a déjà le maximum de constitution.");
            } else{
                joueur.changerPoint(-constitution); //Retrait des points au joueur.
            }

        } else if(constitution < 0){ //Test si nous enlevons de la constitution.
            var = this.constitution; //Sauvegarde de notre ancienne constitution.
            this.constitution += constitution; //Ajout des points de constitution.

            if(this.constitution < this.minConstitution){ //Test si apres retrait, la constitution est en dessous de sa capacite.
                this.constitution = this.minConstitution; //La constitution ne peut pas etre en dessous de se capacite.
                joueur.changerPoint(var); //Recuperation des points par le joueur.
            } else{
                joueur.changerPoint(constitution); //Recuperation des points par le joueur.
            }
            
        } else{ //Test si nous ne faisons rien sur la constitution.
            System.out.println("Vous devez ajouter ou retirer des points de constitution.");
        }
    }

    /**
     * Methode pour recuperer la constitution du pion.
     * @return this.constitution
     */
    public int getConstitution(){
        return this.constitution;
    }


    /**
     * Methode pour ajouter ou retirer de l'initiative au pion.
     * @param initiative
     */
    public void changerInitiative(int initiative){
        int var = 0; //Variable de stockage.

        if(initiative > 0){ //Test si nous ajoutons de la initiative.
            this.initiative += initiative; //Ajout des points d'initiative.

            if(this.initiative > this.maxInitiative){ //Test si apres ajout, l'initiative depasse sa capacite.
                var = this.initiative - this.maxInitiative; //Calcul du surplus.
                this.initiative = this.maxInitiative; //L'initiative ne peut pas etre superieur a sa capacite.
                joueur.changerPoint(-initiative - var); //Retrait des points au joueur.
                System.out.println("Votre pion a déjà le maximum d'initiative.");
            } else{
                joueur.changerPoint(-initiative); //Retrait des points au joueur.
            }

        } else if(initiative < 0){ //Test si nous enlevons de l'initiative.
            var = this.initiative; //Sauvegarde de notre ancienne initiative.
            this.initiative += initiative; //Ajout des points d'initiative.

            if(this.initiative < this.minInitiative){ //Test si apres retrait, l'initiative est en dessous de sa capacite.
                this.initiative = this.minInitiative; //La initiative ne peut pas etre en dessous de sa capacite.
                joueur.changerPoint(var); //Recuperation des points par le joueur.
            } else{
                joueur.changerPoint(initiative); //Recuperation des points par le joueur.
            }
            
        } else{ //Test si nous ne faisons rien sur la initiative.
            System.out.println("Vous devez ajouter ou retirer des points d'initiative.");
        }
    }

    /**
     * Methode pour recuperer l'initiative du pion.
     * @return this.initiative
     */
    public int getInitiative(){
        return this.initiative;
    }


    /**
     * Methode pour changer le status de combat du pion.
     * Verification du status souhaite puis verification du nombre de pion sous ce status.
     * @param status
     */
    public void setStatus(StatusPion status){
        if(status == StatusPion.Combattant){
            int var = 0;
            Iterator<Pion> it = this.joueur.arrayPion.iterator();
            while(it.hasNext()){
                Pion pion = it.next();
                if(pion.status == StatusPion.Combattant){
                    var++;
                }
            }
            if(var > 15){
                System.out.println("Vous avez trop de combattant.");
            } else{
                this.status = StatusPion.Combattant;
            }
        } else if(status == StatusPion.Reserviste){
            this.status = StatusPion.Reserviste;
        } else{
            System.out.println("Votre pion ne peut que être un Combattant ou un Reserviste.");
        }
    }

    /**
     * Methode pour recuperer le status de combat du pion.
     * @return this.status
     */
    public StatusPion getStatus(){
        return this.status;
    }


    /**
     * Methode pour changer la zone du pion.
     * Verification si nous changeons avec la meme zone. Si non, enlever le pion de la zone et mettre la nouvelle zone au pion.
     * @param zone
     */
    public void changerZone(Zone zone){
        if(this.zone.equals(zone)){
            System.out.println("Ce pion appartient déjà à cette zone.");
        } else{
            this.zone.removePion(this);
            this.zone = null;
        }

        if(this.zone == null){
            this.zone = zone;
            this.zone.addPion(this);
        }
    }

    /**
     * Methode pour recuperer la zone du pion.
     * @return
     */
    public String /*Zone*/ getZone(){
        return /*Nom de la zone ou la zone entiere*/"";
    }


    /**
     * Methode pour changer la strategie du pion.
     * @param strategie
     */
    public void changerStrategie(Strategie strategie){
        this.strategie = strategie;
    }

    /**
     * Methode pour recuperer la strategie du pion.
     * @return
     */
    public String getStrategie(){
        return this.strategie.getNom();
    }

    /**
     * Methode pour combattre en fonction de la strategie attribuee.
     */
    public void executerStrategie(){
        strategie.combattre();
    }


    /**
     * Methode pour parametrer un joueur au pion.
     * Verification si nous settons avec le meme joueur. Si non, enelever le pion du joueur et mettre le nouveau joueur au pion.
     * @param joueur
     */
    public void setJoueur(Joueur joueur){
        if(this.joueur.equals(joueur)){
            System.out.println("Ce pion appartient déjà à ce joueur.");
        } else{
            this.joueur.removePion(this);
            this.joueur = null;
        }

        if(this.joueur == null){
            this.joueur = joueur;
            this.joueur.addPion(this);
        }
    }


    /**
     * Redefinition de la methode toString
     * @return
     */
    @Override
    public String toString(){
        return this.nom + " {\n\tECTS = " + this.ECTS + ", Stratégie = " + this.strategie + ", Zone = " + this.zone +
                            "\n\tDextérité = " + this.dexterite +
                            ", Force = " + this.force +
                            ", Résistance = " + this.resistance +
                            ", Constitution = " + this.constitution +
                            ", Initiative = " + this.initiative +
                            "\n}";
    }
}