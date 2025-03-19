package ProjetRefacto.Action;

import ProjetRefacto.*;
import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;
import java.util.Scanner;

public class SeDeconnecterAction implements Action {
    @Override
    public void execute(Scanner scanner, String utilisateur, CalendarManager calendar) {
        System.out.println("Déconnexion ! Voulez-vous continuer ? (O/N)");
        if (!"oui".equalsIgnoreCase(scanner.nextLine().trim())) {
            System.exit(0);
        }
    }
}
