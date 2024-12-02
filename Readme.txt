JsonUtil.java 

dans un premier temps import de bibliothèque

1 méthode charger catalogue
	Reader --> Lire le contenue d'un fichier
	TypeToken --> Crée un type qui représente List<Livre>
	Gson().fromJson(...) : Lit le contenu du fichier et le convertit en une liste d'objets.
	catch (IOException e) -->  Si une exception IOException se produit (par exemple, si le fichier n'existe pas ou ne peut pas être lu), elle est affiché et la méthode retourne null.

2 méthode exporterCatalogue
	Writer --> une liste d'objets Livre à écrire dans un fichier JSON
	Gson().toJson(...) --> Convertit la liste d'objets Livre en JSON et l'écrit dans le fichier.



Bibliotheque.java

dans un premier temps import de bibliothèque

1 private List<Livre> catalogue
	c'est une liste qui stocke tous les livres disponibles dans la bibliothèque
	chaque livre est représenté par un objet de la classe "Livre"

2 public Bibliotheque()
	Le constructeur de la classe Bibliotheque initialise le catalogue de livres en utilisant une méthode statique chargerCatalogue de la classe JsonUtil (au-dessus).

3 listerLivresDisponibles
	Cette méthode parcourt le catalogue et ajoute tous les livres qui ont des exemplaires disponibles à une nouvelle liste livresDisponibles

4 obtenirDetailsLivre 
	Cette méthode cherche un livre dans le catalogue en fonction de son ISBN, si le livre existe il est renvoyé sinon nul

5 exporterCatalogue
	Cette méthode utilise la méthode exporterCatalogue de JsonUtil pour sauvegarder l'état actuel du catalogue dans un fichier JSON

6 louerLivre
	Cette méthode permet à un utilisateur de louer un livre. Elle vérifie d'abord si le livre est disponible, Si le livre est disponible, elle appelle la méthode louerLivre de l'utilisateur pour effectuer la location. Si la location réussit, un message de succès est affiché (livre loué avec succès) ; sinon, un message d'erreur est affiché (Impossible de louer le livre).

7 rendreLivre
	Cette méthode permet à un utilisateur de rendre un livre. Elle vérifie d'abord si l'utilisateur a effectivement loué le livre. Si c'est le cas, le livre est retourné et le nombre d'exemplaires disponibles a +1. Un message de succès est affiché. Si l'utilisateur n'a pas loué le livre, un message d'erreur est affiché.



Utilisateur.java

dans un premier temps import de bibliothèque

1 louerLivre
	Cette méthode permet à l'utilisateur de louer un livre. Elle vérifie d'abord si l'utilisateur a déjà loué moins de 3 livres et si le livre qu'il souhaite louer n'est pas déjà dans sa collection de livres loués. Si ces conditions sont remplies, le livre est ajouté à livresLoues et le nombre d'exemplaires disponibles du livre est -1.

2 rendreLivre
	Cette méthode permet à l'utilisateur de rendre un livre. Elle vérifie si l'utilisateur a effectivement loué le livre. Si c'est le cas, le livre est retiré de la collection de livres loués.

3 getLivresLoues
	Cette méthode retourne la collection des livres loués par l'utilisateur




Livre.java

dans un premier temps import de bibliothèque

isbn : le numéro ISBN du livre, qui est un identifiant unique.
titre : le titre du livre.
description : une description du livre.
auteur : le nom de l'auteur du livre.
prix : le prix du livre.
exemplairesDisponibles : le nombre d'exemplaires disponibles à la vente ou à la location.

getters --> Elles permettent d'accéder aux valeurs des attributs privé
setters --> Elle prend un paramètre et met à jour l'attribut de l'objet avec cette valeur.