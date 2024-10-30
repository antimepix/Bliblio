import java.util.ArrayList;
import java.util.List;

public class Bibliotheque {
    private List<Livre> catalogue;

    public Bibliotheque() {
        this.catalogue = JsonUtil.chargerCatalogue("C:\\Users\\Utilisateur\\IdeaProjects\\bibliotemple\\src\\catalogue_livres.json");
    }

    public List<Livre> listerLivresDisponibles() {
        List<Livre> livresDisponibles = new ArrayList<>();
        for (Livre livre : this.catalogue) {
            if (livre.getExemplairesDisponibles() > 0) {
                livresDisponibles.add(livre);
            }
        }
        return livresDisponibles;
    }

    public Livre obtenirDetailsLivre(String isbn) {
        for (Livre livre : catalogue) {
            if (livre.getIsbn().equals(isbn)) {
                return livre;
            }
        }
        return null;
    }

    public void exporterCatalogue() {
        JsonUtil.exporterCatalogue(catalogue, "catalogue_livres.json");
    }

    public void louerLivre(String isbn, Utilisateur utilisateur) {
        Livre livre = obtenirDetailsLivre(isbn);
        if (livre != null && livre.getExemplairesDisponibles() > 0) {
            if (utilisateur.louerLivre(livre)) {
                System.out.println("Livre loué avec succès : " + livre.getTitre());
            } else {
                System.out.println("Impossible de louer le livre.");
            }
        } else {
            System.out.println("Livre non disponible.");
        }
    }

    public void rendreLivre(String isbn, Utilisateur utilisateur) {
        if (utilisateur.getLivresLoues().containsKey(isbn)) {
            utilisateur.rendreLivre(isbn);
            Livre livre = obtenirDetailsLivre(isbn);
            if (livre != null) {
                livre.setExemplairesDisponibles(livre.getExemplairesDisponibles() + 1);
                System .out.println("Livre rendu avec succès : " + livre.getTitre());
            }
        } else {
            System.out.println("Vous n'avez pas loué ce livre.");
        }
    }
}