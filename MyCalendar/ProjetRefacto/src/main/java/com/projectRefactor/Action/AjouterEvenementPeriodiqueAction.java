package ProjetRefacto.src.main.java.com.projectRefactor.Action;


import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;
import ProjetRefacto.src.main.java.com.projectRefactor.Evenement.EventFactory;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.*;


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
        System.out.print("Frequence (en jours) : ");
        int frequence = Integer.parseInt(scanner.next());

        calendar.ajouterEvenement(EventFactory.createEvenement(
                new Title(titre),
                new Proprietaire(utilisateur),
                new DateDebut(LocalDateTime.of(annee, moisRdv, jourRdv, heure, minute)),
                new DureeMinutes(0),
                new FrequenceJours(frequence)
        ));

        AffichageConnexion.afficherSuccess(calendar, utilisateur);
    }
}
