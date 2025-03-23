package ProjetRefacto.src.main.java.com.projectRefactor.Action;

import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;


import java.util.Scanner;

public class SeConnecterAction implements Action {


    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Nom d'utilisateur: ");
        String nomUtilisateur = scanner.next();
        System.out.print("Mot de passe: ");
        String motDePasse = scanner.next();

        authentifierUtilisateur(nomUtilisateur, motDePasse, calendar);
    }

    private void authentifierUtilisateur(String nomUtilisateur, String motDePasse, CalendarManager calendar) {
        if ("Roger".equals(nomUtilisateur) && "Chat".equals(motDePasse)) {
            System.out.println("Connexion réussie.");
            AffichageConnexion.afficherSuccess(calendar, "Roger");
        }
        if ("Pierre".equals(nomUtilisateur) && "KiRouhl".equals(motDePasse)){
            System.out.println("Connexion réussie.");
            AffichageConnexion.afficherSuccess(calendar, "Pierre");
        }
        for (int i = 0; i < calendar.nbUtilisateurs; i++) {
            if (calendar.utilisateur[i].equals(nomUtilisateur) && calendar.motDePasse[i].equals(motDePasse)) {
                System.out.println("Connexion réussie.");
                AffichageConnexion.afficherSuccess(calendar, nomUtilisateur);
            }
        }
        System.out.println("Nom d'utilisateur ou mot de passe incorrect.");
        AffichageConnexion.afficherEchec(calendar);
    }
}
