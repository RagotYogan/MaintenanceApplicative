package ProjetRefacto;

import ProjetRefacto.Affichage.AffichageConnexion;
import ProjetRefacto.Manager.ActionManager;
import ProjetRefacto.Manager.DebutActionManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalendarManager calendar = new CalendarManager();
        DebutActionManager debutManager = new DebutActionManager(calendar);
        ActionManager actionManager = new ActionManager(calendar);


        String utilisateur = null;
        boolean continuer = true;

        while (continuer) {
            AffichageConnexion.afficherEchec(calendar);

        }
    }

}
