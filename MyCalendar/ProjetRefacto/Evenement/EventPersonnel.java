package ProjetRefacto.Evenement;
import ProjetRefacto.ValueObject.*;


public class EventPersonnel extends Event{

    public EventPersonnel(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public String toString() {
        return "RDV : " + title + " à " + dateDebut.toString();
    }
}
