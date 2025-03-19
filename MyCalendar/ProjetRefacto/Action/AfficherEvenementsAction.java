package ProjetRefacto.Action;


import ProjetRefacto.*;
import ProjetRefacto.Evenement.*;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AfficherEvenementsAction implements Action {
    private final CalendarManager calendar;

    public AfficherEvenementsAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.println("\n=== Menu de visualisation d'Événements ===");
        System.out.println("1 - Afficher TOUS les événements");
        System.out.println("2 - Afficher les événements d'un MOIS précis");
        System.out.println("3 - Afficher les événements d'une SEMAINE précise");
        System.out.println("4 - Afficher les événements d'un JOUR précis");
        System.out.println("5 - Retour");
        System.out.print("Votre choix : ");

        int choix = Integer.parseInt(scanner.nextLine()) - 1;
        List<Action> sousActions = List.of(
                this::afficherTousEvenements,
                this::afficherEvenementsMois,
                this::afficherEvenementsSemaine,
                this::afficherEvenementsJour
        );
        sousActions.get(choix).execute(scanner, utilisateur, calendar);
    }

    private void afficherTousEvenements(Scanner scanner, String utilisateur, CalendarManager calendar) {
        calendar.afficherEvenements();
    }

    private void afficherEvenementsMois(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeMois = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int mois = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutMois = LocalDateTime.of(anneeMois, mois, 1, 0, 0);
        LocalDateTime finMois = debutMois.plusMonths(1).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutMois, finMois));
    }

    private void afficherEvenementsSemaine(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeSemaine = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le numéro de semaine (1-52) : ");
        int semaine = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutSemaine, finSemaine));
    }

    private void afficherEvenementsJour(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Entrez l'année (AAAA) : ");
        int anneeJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le mois (1-12) : ");
        int moisJour = Integer.parseInt(scanner.nextLine());
        System.out.print("Entrez le jour (1-31) : ");
        int jour = Integer.parseInt(scanner.nextLine());

        LocalDateTime debutJour = LocalDateTime.of(anneeJour, moisJour, jour, 0, 0);
        LocalDateTime finJour = debutJour.plusDays(1).minusSeconds(1);

        afficherListe(calendar.eventsDansPeriode(debutJour, finJour));
    }

    private void afficherListe(ListeEvenements evenements) {
        if (evenements.getAllEvents().isEmpty()) {
            System.out.println("Aucun événement trouvé pour cette période.");
        } else {
            System.out.println("Événements trouvés : ");
            evenements.afficherEvenements();
        }
    }
}

