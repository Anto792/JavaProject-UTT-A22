package javaproject.utt.a22;

import java.util.*;

/**
 * Classe representant les joueurs jouant dans une partie.
 */
public class Joueur{
    
    /*
     * Liste de pions que possede le joueur.
     */
    ArrayList<Pion> arrayPion = new ArrayList<Pion>();

    /**
     * Nom du joueur (utile pour les teams 1 et 2).
     */
    private String nom;

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
    public Joueur(Partie partie, String nom){
        this.partie = partie;
        this.nom = nom;

        this.partie.addJoueur(this);
    }


    /**
     * Methode pour ajouter ou retirer des points que le joueur possede.
     * @param point
     */
    public void changerPoint(int point){
        this.point += point;
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
        this.setZoneControlee.add(zone);
    }

    /**
     * Methode pour retirer une zone controlee par le joueur du set de zone controlee (setZoneControlee).
     * @param zone
     */
    public void removeZoneControlee(Zone zone){
        if(this.setZoneControlee.contains(zone)){
            this.setZoneControlee.remove(zone);
        }
    }


    /**
     * Methode pour ajouter un pion dans la liste.
     * @param pion
     */
    public void addPion(Pion pion){
        if(this.arrayPion.contains(pion)){
            System.out.println("Ce pion appartient déjà à ce joueur.");
        } else{
            this.arrayPion.add(pion);
        }
    }

    /**
     * Methode pour retirer un pion de la liste.
     * @param pion
     */
    public void removePion(Pion pion){
        if(this.arrayPion.contains(pion)){
            this.arrayPion.remove(pion);
        } else{
            System.out.println("Ce pion n'appartient pas à ce joueur.");
        }
    }


    /**
     * Methode pour changer le status du joueur.
     * @param status
     */
    public void setStatus(StatusJoueur status){
        this.status = StatusJoueur.Ready; //A revoir.
    }

    /**
     * Methode pour recuperer le status du joueur.
     * @return this.status
     */
    public StatusJoueur getStatus(){
        return this.status;
    }


    /**
     * Methode pour recuperer le nom du joueur.
     * @return
     */
    public String getNom(){
        return this.nom;
    }
}
