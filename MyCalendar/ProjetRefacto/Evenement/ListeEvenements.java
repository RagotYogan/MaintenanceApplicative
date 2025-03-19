package ProjetRefacto.Evenement;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ListeEvenements {
    private List<Event> events;

    public ListeEvenements() {
        this.events = new ArrayList<>();
    }

    // Ajouter un événement à la liste
    public void ajouterEvent(Event event) {
        events.add(event);
    }

    // Obtenir tous les événements
    public List<Event> getAllEvents() {
        return new ArrayList<>(events);
    }

    // Obtenir les événements dans une période donnée
    public ListeEvenements eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        ListeEvenements result = new ListeEvenements();
        for (Event e : events) {
            if (e.EventDansPeriode(debut, fin)) {
                result.ajouterEvent(e);
            }
        }
        return result;
    }

    // Vérifier les conflits entre deux événements
    public boolean conflit(Event e1, Event e2) {
        return e1.EventEnConflit(e2);
    }

    // Afficher les événements
    public void afficherEvenements() {
        for (Event e : events) {
            System.out.println(e.toString());
        }
    }
}
