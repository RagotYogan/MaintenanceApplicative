package ProjetRefacto;

import ProjetRefacto.Evenement.*;
import ProjetRefacto.ValueObject.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CalendarManager {
    public ListeEvenements events;
    public String[] utilisateur = new String[100];
    public String[] motDePasse = new String[100];
    public int nbUtilisateurs = 0;

    public CalendarManager() {
        this.events = new ListeEvenements();
    }

    public void ajouterEvenement(Event e) {
        events.ajouterEvent(e);
    }

    public ListeEvenements eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return events.eventsDansPeriode(debut, fin);
    }

    public boolean conflit(Event e1, Event e2) {
        return events.conflit(e1, e2);
    }

    public void afficherEvenements() {
        events.afficherEvenements();
    }
}