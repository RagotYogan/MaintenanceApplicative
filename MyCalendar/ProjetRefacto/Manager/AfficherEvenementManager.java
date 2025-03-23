package ProjetRefacto.Manager;

import ProjetRefacto.Action.*;
import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.CalendarManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AfficherEvenementManager {
    private final List<Action> actions;

    public AfficherEvenementManager() {
        this.actions = new ArrayList<>();
        this.actions.add(new AfficherTousEvenementsAction());
        this.actions.add(new AfficherEvenementsMoisAction());
        this.actions.add(new AfficherEvenementsSemaineAction());
        this.actions.add(new AfficherEvenementsJourAction());
    }

    public void executeAction(int index, Scanner scanner, String utilisateur, CalendarManager calendar) {
        if (index >= 0 && index < actions.size()) {
            actions.get(index).execute(scanner, utilisateur, calendar);
        } else {
            System.out.println("Action invalide. Veuillez réessayer.");
            AffichageConnexion.afficherSuccess(calendar, utilisateur);
        }
    }
}
