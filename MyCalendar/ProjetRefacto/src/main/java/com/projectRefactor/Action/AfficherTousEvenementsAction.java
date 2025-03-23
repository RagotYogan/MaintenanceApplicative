package ProjetRefacto.src.main.java.com.projectRefactor.Action;

import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;
import java.util.Scanner;

public class AfficherTousEvenementsAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        calendar.afficherEvenements();
        AffichageConnexion.afficherSuccess(calendar, utilisateur);

    }
}
