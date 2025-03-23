package ProjetRefacto.Action;

import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.CalendarManager;
import ProjetRefacto.Evenement.Event;
import ProjetRefacto.Evenement.ListeEvenements;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AfficherEvenementsJourAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.next());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.next());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.next());

        LocalDateTime debutJour = LocalDateTime.of(annee, mois, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        ListeEvenements evenements = calendar.eventsDansPeriode(debutJour, finJour);
        for (Event event : evenements.getAllEvents()) {
            System.out.println(event);
        }

        AffichageConnexion.afficherSuccess(calendar, utilisateur);
    }
}
