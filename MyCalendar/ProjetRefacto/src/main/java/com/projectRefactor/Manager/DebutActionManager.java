package ProjetRefacto.src.main.java.com.projectRefactor.Manager;

import ProjetRefacto.src.main.java.com.projectRefactor.Action.Action;
import ProjetRefacto.src.main.java.com.projectRefactor.Action.CreerCompteAction;
import ProjetRefacto.src.main.java.com.projectRefactor.Action.SeConnecterAction;
import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;

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
