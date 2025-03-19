package ProjetRefacto.Action;

import ProjetRefacto.*;

import java.util.Scanner;

public class CreerCompteAction implements Action {
    private String[] utilisateurs = new String[99];
    private String[] motsDePasses = new String[99];
    private int nbUtilisateurs = 0;

    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Nom d'utilisateur: ");
        String nomUtilisateur = scanner.nextLine();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.nextLine();
        System.out.print("Répéter mot de passe: ");
        if (scanner.nextLine().equals(motDePasse)) {
            utilisateurs[nbUtilisateurs] = nomUtilisateur;
            motsDePasses[nbUtilisateurs] = motDePasse;
            nbUtilisateurs++;
            System.out.println("Compte créé avec succès.");
        } else {
            System.out.println("Les mots de passe ne correspondent pas...");
        }
    }
}
