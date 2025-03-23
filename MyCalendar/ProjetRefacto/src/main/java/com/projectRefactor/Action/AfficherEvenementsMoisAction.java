package ProjetRefacto.src.main.java.com.projectRefactor.Action;

import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;
import ProjetRefacto.src.main.java.com.projectRefactor.Evenement.Event;
import ProjetRefacto.src.main.java.com.projectRefactor.Evenement.ListeEvenements;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AfficherEvenementsMoisAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.next());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.next());

        LocalDateTime debutMois = LocalDateTime.of(annee, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        ListeEvenements evenements = calendar.eventsDansPeriode(debutMois, finMois);
        for (Event event : evenements.getAllEvents()) {
            System.out.println(event);
        }

        AffichageConnexion.afficherSuccess(calendar, utilisateur);

    }
}
