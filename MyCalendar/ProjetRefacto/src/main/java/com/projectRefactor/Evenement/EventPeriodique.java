package ProjetRefacto.src.main.java.com.projectRefactor.Evenement;

import ProjetRefacto.src.main.java.com.projectRefactor.ValueObject.*;

import java.time.LocalDateTime;

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
    public boolean EventDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        LocalDateTime temp = this.dateDebut.getDateDebut();
        while (temp.isBefore(fin)) {
            if (!temp.isBefore(debut)) {
                return true;
            }
            temp = temp.plusDays(frequenceJours.getFrequenceJours());
        }
        return false;
    }

    @Override
    public boolean EventEnConflit(Event event) {
        return false;
    }

    @Override
    public String toString() {
        return "Événement périodique : " + title.getTitle() + " tous les " + frequenceJours.getFrequenceJours() + " jours";
    }
}
