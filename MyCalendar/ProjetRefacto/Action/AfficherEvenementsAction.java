package ProjetRefacto.Action;


import ProjetRefacto.*;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.Manager.AfficherEvenementManager;

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

        int choix = Integer.parseInt(scanner.next()) - 1;
        AfficherEvenementManager afficherEvenementManager = new AfficherEvenementManager();
        afficherEvenementManager.executeAction(choix, scanner, utilisateur, calendar);
    }


}

