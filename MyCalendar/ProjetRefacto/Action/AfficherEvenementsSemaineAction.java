package ProjetRefacto.Action;

import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.CalendarManager;
import ProjetRefacto.Evenement.Event;
import ProjetRefacto.Evenement.ListeEvenements;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class AfficherEvenementsSemaineAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Entrez l'année (AAAA) : ");
        int annee = Integer.parseInt(scanner.next());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.next());

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(annee)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        ListeEvenements evenements = calendar.eventsDansPeriode(debutSemaine, finSemaine);
        for (Event event : evenements.getAllEvents()) {
            System.out.println(event);
        }

        AffichageConnexion.afficherSuccess(calendar, utilisateur);
    }
}
