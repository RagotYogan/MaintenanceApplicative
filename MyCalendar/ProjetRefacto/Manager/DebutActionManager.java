package ProjetRefacto.Manager;

import ProjetRefacto.Action.Action;
import ProjetRefacto.Action.CreerCompteAction;
import ProjetRefacto.Action.SeConnecterAction;
import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.CalendarManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DebutActionManager {
    private final List<Action> actions;

    public DebutActionManager(CalendarManager calendar) {
        this.actions = new ArrayList<>();
        this.actions.add(new SeConnecterAction());
        this.actions.add(new CreerCompteAction());
    }

    public void executeAction(int index, Scanner scanner, String utilisateur, CalendarManager calendar) {
        if (index >= 0 && index <= actions.size()) {
            actions.get(index - 1).execute(scanner, utilisateur, calendar);
        } else {
            System.out.println("Action invalide. Veuillez réessayer.");
            AffichageConnexion.afficherEchec(calendar);
        }
    }
}
