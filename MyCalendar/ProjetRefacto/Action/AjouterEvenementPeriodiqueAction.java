package ProjetRefacto.Action;


import ProjetRefacto.*;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;


import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterEvenementPeriodiqueAction implements Action {
    private final CalendarManager calendar;

    public AjouterEvenementPeriodiqueAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.nextLine();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.nextLine());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.nextLine());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.nextLine());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.nextLine());
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.nextLine());

        calendar.ajouterEvenement(EventFactory.createEvenement(
                new Title(titre),
                new Proprietaire(utilisateur),
                new DateDebut(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                new DureeMinutes(0),
                new FrequenceJours(frequence)
        ));

        System.out.println("Événement ajouté.");
    }
}
