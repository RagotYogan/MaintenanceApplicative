package ProjetRefacto.src.main.java.com.projectRefactor.Manager;

import ProjetRefacto.src.main.java.com.projectRefactor.Action.*;
import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionManager {
    private final List<Action> actions;

    public ActionManager(CalendarManager calendar) {
        this.actions = new ArrayList<>();
        this.actions.add(new AfficherEvenementsAction(calendar));
        this.actions.add(new AjouterRendezVousPersoAction(calendar));
        this.actions.add(new AjouterReunionAction(calendar));
        this.actions.add(new AjouterEvenementPeriodiqueAction(calendar));
        this.actions.add(new SeDeconnecterAction());
    }

    public void executeAction(int index, Scanner scanner, String utilisateur, CalendarManager calendar) {
        if (index >= 0 && index <= actions.size()) {
            actions.get(index-1).execute(scanner, utilisateur, calendar);
        } else {
            System.out.println("Action invalide. Veuillez réessayer.");
            AffichageConnexion.afficherSuccess(calendar,utilisateur);
        }
    }
}
