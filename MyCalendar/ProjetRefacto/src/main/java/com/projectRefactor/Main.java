package ProjetRefacto.src.main.java.com.projectRefactor;

import ProjetRefacto.src.main.java.com.projectRefactor.Affichage.AffichageConnexion;
import ProjetRefacto.src.main.java.com.projectRefactor.Manager.ActionManager;
import ProjetRefacto.src.main.java.com.projectRefactor.Manager.DebutActionManager;
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
