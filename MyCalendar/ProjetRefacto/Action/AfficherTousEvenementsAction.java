package ProjetRefacto.Action;

import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.CalendarManager;
import java.util.Scanner;

public class AfficherTousEvenementsAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        calendar.afficherEvenements();
        AffichageConnexion.afficherSuccess(calendar, utilisateur);

    }
}
