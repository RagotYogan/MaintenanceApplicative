package ProjetRefacto.Evenement;


import ProjetRefacto.ValueObject.*;

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
    public String toString() {
        return "Réunion : " + title + " à " + lieu + " avec " + participants;
    }
}
