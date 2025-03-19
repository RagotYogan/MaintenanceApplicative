package ProjetRefacto.Evenement;

import ProjetRefacto.ValueObject.*;

public class EventFactory {

    public static Event createEvenement(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes, FrequenceJours frequenceJours) {
        return new EventPeriodique(title, proprietaire, dateDebut, dureeMinutes, frequenceJours);
    }

    public static Event createEvenement(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes) {
        return new EventPersonnel(title, proprietaire, dateDebut, dureeMinutes);
    }

    public static Event createEvenement(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes, Participants participants, Lieu lieu) {
        return new EventReunion(title, proprietaire, dateDebut, dureeMinutes, participants, lieu);
    }
}