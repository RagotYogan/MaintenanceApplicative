package ProjetRefacto.Action;

import ProjetRefacto.CalendarManager;

import java.util.Scanner;

public interface Action {
    void execute(Scanner scanner, String utilisateur, CalendarManager calendar);
}
