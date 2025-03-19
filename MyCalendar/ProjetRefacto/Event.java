package ProjetRefacto;

import java.time.LocalDateTime;

public class Event {
    public Type type; // "RDV_PERSONNEL", "REUNION", "PERIODIQUE"
    public Title title;
    public Proprietaire proprietaire;
    public DateDebut dateDebut;
    public DureeMinutes dureeMinutes;
    public Lieu lieu; // utilisé seulement pour REUNION
    public Participants participants; // séparés par virgules (pour REUNION uniquement)
    public FrequenceJours frequenceJours; // uniquement pour PERIODIQUE

    public Event(Type type, Title title, Proprietaire proprietaire, DateDebut dateDebut, DureeMinutes dureeMinutes,
                 Lieu lieu, Participants participants, FrequenceJours frequenceJours) {
        this.type = type;
        this.title = title;
        this.proprietaire = proprietaire;
        this.dateDebut = dateDebut;
        this.dureeMinutes = dureeMinutes;
        this.lieu = lieu;
        this.participants = participants;
        this.frequenceJours = frequenceJours;
    }

    public String description(){
        String desc = "";
        if(type == Type.RDV_PERSONNEL){
            desc = "RDV : " + title.getTitle() + " à " + dateDebut.getDateDebut().toString();
        }else if(type == Type.REUNION){
            desc = "Réunion : " + title.getTitle() + " à " + lieu.getLieu() + " avec " + participants.getParticipants();
        }else if(type == Type.PERIODIQUE){
            desc = "Événement périodique : " + title.getTitle() + " tous les " + frequenceJours.getFrequenceJours() + " jours";
        }
        return desc;
    }



}
