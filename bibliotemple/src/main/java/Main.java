import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliothèque = new Bibliotheque();
        Scanner scanner = new Scanner(System.in);
        Utilisateur utilisateur = null;

        while (true) {
            System.out.println("1. Se connecter");
            System.out.println("2. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrez votre identifiant : ");
                    String id = scanner.next();
                    utilisateur = new Utilisateur(id);
                    System.out.println("Connecté avec succès !");
                    break;
                case 2:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide.");
            }

            if (utilisateur != null) {
                while (true) {
                    System.out.println("1. Lister les livres disponibles");
                    System.out.println("2. Voir les détails d'un livre");
                    System.out.println("3. Louer un livre");
                    System.out.println("4. Rendre un livre");
                    System.out.println("5. Exporter le catalogue");
                    System.out.println("6. Quitter");
                    System.out.print("Choix : ");
                    int choixUtilisateur = scanner.nextInt();
                    switch (choixUtilisateur) {
                        case 1:
                            List<Livre> livresDisponibles = bibliothèque.listerLivresDisponibles();
                            for (Livre livre : livresDisponibles) {
                                System.out.println(livre.getTitre());
                            }
                            break;
                        case 2:
                            System.out.print("Entrez l'ISBN du livre : ");
                            String isbn = scanner.next();
                            Livre livre = bibliothèque.obtenirDetailsLivre(isbn);
                            if (livre != null) {
                                System.out.println("Titre : " + livre.getTitre());
                                System.out.println("Auteur : " + livre.getAuteur());
                                System.out.println("description :" + livre.getDescription());
                                System.out.println("Prix : " + livre.getPrix());
                                System.out.println("Exemplaires disponibles : " + livre.getExemplairesDisponibles());
                            } else {
                                System.out.println("Livre non trouvé.");
                            }
                            break;
                        case 3:
                            System.out.print("Entrez l'ISBN du livre à louer : ");
                            String isbnLouer = scanner.next();
                            bibliothèque.louerLivre(isbnLouer, utilisateur);
                            break;
                        case 4:
                            System.out.print("Entrez l'ISBN du livre à rendre : ");
                            String isbnRendre = scanner.next();
                            bibliothèque.rendreLivre(isbnRendre, utilisateur);
                            break;
                        case 5:
                            bibliothèque.exporterCatalogue();
                            System.out.println("Catalogue exporté avec succès !");
                            break;
                        case 6:
                            System.out.println("Au revoir !");
                            return;
                        default:
                            System.out.println("Choix invalide.");
                    }
                }
            }
        }
    }
}