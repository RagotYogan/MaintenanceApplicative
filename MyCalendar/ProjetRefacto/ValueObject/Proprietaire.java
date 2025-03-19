package ProjetRefacto.ValueObject;

public class Proprietaire {
    private String proprietaire;

    public Proprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
}
