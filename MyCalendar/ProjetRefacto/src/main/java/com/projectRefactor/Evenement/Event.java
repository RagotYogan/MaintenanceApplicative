package ProjetRefacto.src.main.java.com.projectRefactor.Evenement;

import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.DateDebut;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.DureeMinutes;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.Proprietaire;
import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.Title;

import java.time.LocalDateTime;

public abstract class Event {
    protected Title title;
    protected Proprietaire proprietaire;
    protected DateDebut dateDebut;
    protected DureeMinutes dureeMinutes;

    public Event(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes duree) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = duree;
    }

    public abstract boolean EventDansPeriode(LocalDateTime debut, LocalDateTime fin);
    public abstract boolean EventEnConflit(Event event);
    public abstract String toString();
}
