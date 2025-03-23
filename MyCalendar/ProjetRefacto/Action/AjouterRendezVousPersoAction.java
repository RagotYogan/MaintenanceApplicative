package ProjetRefacto.Action;


import ProjetRefacto.*;
import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AjouterRendezVousPersoAction implements Action {
    private final CalendarManager calendar;

    public AjouterRendezVousPersoAction(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.print("Titre de l'événement : ");
        String titre = scanner.next();
        System.out.print("Année (AAAA) : ");
        int annee = Integer.parseInt(scanner.next());
        System.out.print("Mois (1-12) : ");
        int moisRdv = Integer.parseInt(scanner.next());
        System.out.print("Jour (1-31) : ");
        int jourRdv = Integer.parseInt(scanner.next());
        System.out.print("Heure début (0-23) : ");
        int heure = Integer.parseInt(scanner.next());
        System.out.print("Minute début (0-59) : ");
        int minute = Integer.parseInt(scanner.next());
        System.out.print("Durée (en minutes) : ");
        int duree = Integer.parseInt(scanner.next());

        calendar.ajouterEvenement(EventFactory.createEvenement(
                new Title(titre),
                new Proprietaire(utilisateur),
                new DateDebut(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                new DureeMinutes(duree)
        ));

        System.out.println("Événement ajouté.");

        AffichageConnexion.afficherSuccess(calendar, utilisateur);
    }
}
