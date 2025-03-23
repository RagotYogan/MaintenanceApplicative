package ProjetRefacto.src.main.java.com.projectRefactor.Affichage;

import ProjetRefacto.src.main.java.com.projectRefactor.Manager.ActionManager;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;
import ProjetRefacto.src.main.java.com.projectRefactor.Manager.DebutActionManager;

import java.util.Scanner;

public class AffichageConnexion {
    public static void afficherSuccess(CalendarManager calendar, String utilisateur) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nBonjour, " + utilisateur);
        System.out.println("=== Menu Gestionnaire d'Événements ===");
        System.out.println("1 - Voir les événements");
        System.out.println("2 - Ajouter un rendez-vous perso");
        System.out.println("3 - Ajouter une réunion");
        System.out.println("4 - Ajouter un évènement périodique");
        System.out.println("5 - Se déconnecter");
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        ActionManager actionManager = new ActionManager(calendar);
        actionManager.executeAction(choix, scanner, utilisateur, calendar);
    }

    public static void afficherEchec(CalendarManager calendar) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  _____         _                   _                __  __");
        System.out.println(" / ____|       | |                 | |              |  \\/  |");
        System.out.println("| |       __ _ | |  ___  _ __    __| |  __ _  _ __  | \\  / |  __ _  _ __    __ _   __ _   ___  _ __");
        System.out.println("| |      / _` || | / _ \\| '_ \\  / _` | / _` || '__| | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|");
        System.out.println("| |____ | (_| || ||  __/| | | || (_| || (_| || |    | |  | || (_| || | | || (_| || (_| ||  __/| |");
        System.out.println(" \\_____| \\__,_||_| \\___||_| |_| \\__,_| \\__,_||_|    |_|  |_| \\__,_||_| |_| \\__,_| \\__, | \\___||_|");
        System.out.println("                                                                                   __/ |");
        System.out.println("                                                                                  |___/");
        System.out.println("1 - Se connecter");
        System.out.println("2 - Créer un compte");
        System.out.println("Choix : ");
        int choix = scanner.nextInt();
        DebutActionManager debutActionManager = new DebutActionManager(calendar);
        debutActionManager.executeAction(choix, scanner, null, calendar);
    }
}
