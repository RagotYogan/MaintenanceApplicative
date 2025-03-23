package ProjetRefacto.Action;

import ProjetRefacto.*;
import ProjetRefacto.Affichage.AffichageConnexion;

import java.util.Scanner;

public class CreerCompteAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Nom d'utilisateur: ");
        String nomUtilisateur = scanner.next();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.next();
        System.out.print("Répéter mot de passe: ");
        if (scanner.next().equals(motDePasse)) {
            calendar.utilisateur[calendar.nbUtilisateurs] = nomUtilisateur;
            calendar.motDePasse[calendar.nbUtilisateurs] = motDePasse;
            calendar.nbUtilisateurs++;
            System.out.println("Compte créé avec succès.");
            AffichageConnexion.afficherSuccess(calendar, nomUtilisateur);
        } else {
            System.out.println("Les mots de passe ne correspondent pas...");
            AffichageConnexion.afficherEchec(calendar);
        }
    }

}
