package ProjetRefacto.Evenement;

import ProjetRefacto.ValueObject.*;

public abstract class Event {
    protected Title title;
    protected Proprietaire proprietaire;
    protected DateDebut dateDebut;
    protected DureeMinutes duree;

    public Event(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes duree) {
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public abstract String toString();
}
