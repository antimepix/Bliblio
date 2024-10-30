import java.util.HashMap;
import java.util.List;

public class Utilisateur {
    private String id;
    private HashMap<String, Livre> livresLoues;
    private List<Utilisateur> catalogue;

    public Utilisateur(String id) {
        this.id = id;
        this.livresLoues = new HashMap<>();
        this.catalogue = JsonUtil.chargerCatalogue("C:\\Users\\Utilisateur\\IdeaProjects\\bibliotemple\\src\\utilisateur.json");
    }

    public boolean louerLivre(Livre livre) {
        if (livresLoues.size() < 3 && !livresLoues.containsKey(livre.getIsbn())) {
            livresLoues.put(livre.getIsbn(), livre);
            livre.setExemplairesDisponibles(livre.getExemplairesDisponibles() - 1);
            return true;
        }
        return false;
    }

    public void rendreLivre(String isbn) {
        if (livresLoues.containsKey(isbn)) {
            livresLoues.remove(isbn);
        }
    }

    public String getId() {
        return id;
    }

    public HashMap<String, Livre> getLivresLoues() {
        return livresLoues;
    }


}