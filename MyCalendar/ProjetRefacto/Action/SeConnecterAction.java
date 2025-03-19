package ProjetRefacto.Action;

import ProjetRefacto.*;


import java.util.Scanner;

public class SeConnecterAction implements Action {
    private String[] utilisateurs = new String[99];
    private String[] motsDePasses = new String[99];
    private int nbUtilisateurs = 0;


    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Nom d'utilisateur: ");
        String nomUtilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();

        utilisateur = authentifierUtilisateur(nomUtilisateur, motDePasse) ? nomUtilisateur : null;
    }

    private boolean authentifierUtilisateur(String nomUtilisateur, String motDePasse) {
        if ("Roger".equals(nomUtilisateur) && "Chat".equals(motDePasse)) {
            return true;
        }
        if ("Pierre".equals(nomUtilisateur) && "KiRouhl".equals(motDePasse)) {
            return true;
        }
        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].equals(nomUtilisateur) && motsDePasses[i].equals(motDePasse)) {
                return true;
            }
        }
        return false;
    }
}
