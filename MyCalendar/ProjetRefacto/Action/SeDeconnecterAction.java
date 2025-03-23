package ProjetRefacto.Action;

import ProjetRefacto.*;
import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;
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
