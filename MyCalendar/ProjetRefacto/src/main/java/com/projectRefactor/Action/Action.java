package ProjetRefacto.src.main.java.com.projectRefactor.Action;

import ProjetRefacto.src.main.java.com.projectRefactor.CalendarManager;

import java.util.Scanner;

public interface Action {
    void execute(Scanner scanner, String utilisateur, CalendarManager calendar);
}
