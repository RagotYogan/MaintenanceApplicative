package ProjetRefacto.src.main.java.com.projectRefactor.Evenement;


import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.*;

import java.time.LocalDateTime;

public class EventReunion extends Event {
    private Lieu lieu;
    private Participants participants;

    public EventReunion(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes, Participants participants, Lieu lieu) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.lieu = lieu;
        this.participants = participants;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
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
        return "Réunion : " + title.getTitle() + " à " + lieu.getLieu() + " avec " + participants.getParticipants();
    }
}
