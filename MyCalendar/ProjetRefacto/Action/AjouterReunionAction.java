package ProjetRefacto.Action;


import ProjetRefacto.*;
import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterReunionAction implements Action {
    private final CalendarManager calendar;

    public AjouterReunionAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Titre de l'événement : ");
        scanner.nextLine();
        String titre = scanner.nextLine();

        System.out.print("Année (AAAA) : ");
        int annee = scanner.nextInt();

        System.out.print("Mois (1-12) : ");
        int moisRdv = scanner.nextInt();

        System.out.print("Jour (1-31) : ");
        int jourRdv = scanner.nextInt();

        System.out.print("Heure début (0-23) : ");
        int heure = scanner.nextInt();

        System.out.print("Minute début (0-59) : ");
        int minute = scanner.nextInt();

        System.out.print("Durée (en minutes) : ");
        int duree = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Lieu : ");
        String lieu = scanner.nextLine();

        String participants = utilisateur;
        System.out.println("Ajouter un participant ? (oui / non)");
        while ("oui".equals(scanner.next())) {
            System.out.print("Participants : " + participants + " ");
            scanner.nextLine();
            participants += ", " + scanner.nextLine();
            System.out.println("Ajouter un participant ? (oui / non)");
        }

        calendar.ajouterEvenement(EventFactory.createEvenement(
                new Title(titre),
                new Proprietaire(utilisateur),
                new DateDebut(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                new DureeMinutes(duree),
                new Participants(participants),
                new Lieu(lieu)
        ));

        AffichageConnexion.afficherSuccess(calendar, utilisateur);
    }
}
