package ProjetRefacto.src.main.java.com.projectRefactor.Action;

import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;

import java.util.Scanner;

public class SeDeconnecterAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.println("Déconnexion ! Voulez-vous continuer ? (Oui/Non)");
        if ("Oui".equalsIgnoreCase(scanner.next().trim())) {
            System.out.println("Déconnexion.");
            AffichageConnexion.afficherEchec(calendar);
        }else {
            System.out.println("Déconnexion annulée.");
            AffichageConnexion.afficherSuccess(calendar, utilisateur);
        }
    }
}
