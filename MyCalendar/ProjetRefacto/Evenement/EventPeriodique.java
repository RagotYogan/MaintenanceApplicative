package ProjetRefacto.Evenement;

import ProjetRefacto.ValueObject.*;

public class EventPeriodique extends Event {
    private FrequenceJours frequenceJours;

    public EventPeriodique(Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes, FrequenceJours frequenceJours) {
        super(title, proprietaire, dateDebut, dureeMinutes);
        this.frequenceJours = frequenceJours;
    }

    public FrequenceJours getFrequenceJours() {
        return frequenceJours;
    }

    public void setFrequenceJours(FrequenceJours frequenceJours) {
        this.frequenceJours = frequenceJours;
    }

    @Override
    public String toString() {
        return "Événement périodique : " + title + " tous les " + frequenceJours + " jours";
    }
}
