package ProjetRefacto.Action;

import ProjetRefacto.*;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionManager {
    private final List<Action> actions;

    public ActionManager(CalendarManager calendar) {
        this.actions = new ArrayList<>();
        this.actions.add(new SeConnecterAction());
        this.actions.add(new CreerCompteAction());
        this.actions.add(new AfficherEvenementsAction(calendar));
        this.actions.add(new AjouterRendezVousPersoAction(calendar));
        this.actions.add(new AjouterReunionAction(calendar));
        this.actions.add(new AjouterEvenementPeriodiqueAction(calendar));
        this.actions.add(new SeDeconnecterAction());
    }

    public void executeAction(int index, Scanner scanner, String utilisateur, CalendarManager calendar) {
        if (index >= 0 && index < actions.size()) {
            actions.get(index).execute(scanner, utilisateur, calendar);
        } else {
            System.out.println("Action invalide. Veuillez réessayer.");
        }
    }
}
