public class Livre {
    private String isbn;
    private String titre;
    private String description;
    private String auteur;
    private double prix;
    private int exemplairesDisponibles;

    public Livre(String isbn, String titre, String description, String auteur, double prix, int exemplairesDisponibles) {
        this.isbn = isbn;
        this.titre = titre;
        this.description = description;
        this.auteur = auteur;
        this.prix = prix;
        this.exemplairesDisponibles = exemplairesDisponibles;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getAuteur() {
        return auteur;
    }

    public double getPrix() {
        return prix;
    }

    public int getExemplairesDisponibles() {
        return exemplairesDisponibles;
    }

    public void setExemplairesDisponibles(int exemplairesDisponibles) {
        this.exemplairesDisponibles = exemplairesDisponibles;
    }
}
