package ProjetRefacto.src.main.java.com.projectRefactor.Evenement;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.DateDebut;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.DureeMinutes;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.Proprietaire;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.Title;

import java.time.LocalDateTime;


public class EventPersonnel extends Event{

    public EventPersonnel(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes) {
        super(title, proprietaire, dateDebut, dureeMinutes);
    }

    @Override
    public boolean EventDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return dateDebut.getDateDebut().isAfter(debut) && dateDebut.getDateDebut().isBefore(fin);
    }

    @Override
    public boolean EventEnConflit(Event event) {
        LocalDateTime fin1 = dateDebut.getDateDebut().plusMinutes(dureeMinutes.getDureeMinutes());
        LocalDateTime fin2 = event.dateDebut.getDateDebut().plusMinutes(event.dureeMinutes.getDureeMinutes());

        return dateDebut.getDateDebut().isBefore(fin2) && fin1.isAfter(event.dateDebut.getDateDebut());
    }

    @Override
    public String toString() {
        return "RDV : " + title.getTitle() + " à " + dateDebut.getDateDebut().toString();
    }
}
