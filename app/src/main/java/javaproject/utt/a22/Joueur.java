package javaproject.utt.a22;

import java.util.*;

/**
 * Classe representant les joueurs jouant dans une partie.
 */
public class Joueur{
    
    /*
     * List de pion (soit 20 Pion, soit 15 Etudiant, 4 Elite et 1 Maitre)
     */
    ArrayList<Pion> arrayPion = new ArrayList<Pion>();

    /**
     * Nombre de point que le joueur peut distribuer à ses pions.
     */
    private int point = 400;

    /**
     * Attribut representant l'equipe du joueur.
     */
    Equipe equipe;

    /**
     * Enumeration des equipes disponibles pour le joueur.
     */
    enum Equipe{
        A2I, GI, GM, ISI, MM, MTE, RT;
    }

    /**
     * Attribut representant le status du joueur.
     */
    StatusJoueur status;

    /**
     * Enumeration des status du joueur.
     */
    enum StatusJoueur{
        Ready, Preparation;
    }

    /**
     * Attribut indiquant que le joueur est dans une partie.
     */
    Partie partie;

    /**
     * Set de zone que le joueur controle.
     */
    Set<Zone> setZoneControlee = new HashSet<Zone>();

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        
    }

    /**
     * Constructeur de la classe Joueur.
     */
    public Joueur(Partie partie){
        this.partie = partie;
        this.partie.addJoueur(this);
    }


    /**
     * Methode pour ajouter ou retirer des points que le joueur possede.
     * @param point
     */
    public void changerPoint(int point){
        /*
         * Changement du nombre de point que le joueur possède.
         */
    }

    /**
     * Methode pour recuperer le nombre de point que le joueur possede.
     * @return this.point
     */
    public int getPoint(){
        return this.point;
    }


    /**
     * Methode pour ajouter une zone controlee par le joueur dans le set de zone controlee (setZoneControlee).
     * @param zone
     */
    public void addZoneControlee(Zone zone){
        /*
         * Ajout de la zone controlee.
         */
    }

    /**
     * Methode pour retirer une zone controlee par le joueur du set de zone controlee (setZoneControlee).
     * @param zone
     */
    public void removeZoneControlee(Zone zone){
        /*
         * Retret de la zone controlee.
         */
    }


    /**
     * Methode pour ajouter un pion dans la liste.
     * @param pion
     */
    public void addPion(Pion pion){
        /*
         * Ajout du pion dans la liste.
         */
    }

    /**
     * Methode pour retirer un pion de la liste.
     * @param pion
     */
    public void removePion(Pion pion){
        /**
         * Retrait du pion de la liste.
         */
    }


    /**
     * Methode pour changer le status du joueur.
     * @param status
     */
    public void setStatus(StatusJoueur status){

    }

    /**
     * Methode pour recuperer le status du joueur.
     * @return this.status
     */
    public StatusJoueur getStatus(){
        return this.status;
    }

}
