package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private Marche marche;

	public Village(String nom, int nbVillageoisMaximum, int nbEtals) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		marche = new Marche(nbEtals);
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {		
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	
	
	public String installerVendeur(Gaulois vendeur, String produit, int nbProduit) {
		int indice = marche.trouverEtalLibre();
		
		StringBuilder chaine = new StringBuilder();
		chaine.append(vendeur.getNom() + " cherche un endroit pour vendre " + nbProduit + " " + produit + ".\n");
		if (indice < 0) {
			chaine.append(vendeur.getNom() + " n'a pas trouve d'endroit pour vendre.\n");
		} else {
			chaine.append("Le vendeur "+ vendeur.getNom()+" vend des " + produit + " à l'étal n° " + indice);
		}
		return chaine.toString();
	}

	public String rechercherVendeursProduit(String produit) {
		
		StringBuilder chaine = new StringBuilder();
		

		Etal e[] = marche.trouverEtals(produit);
		
		int nbEtalTrouve = 0;
		for (int i = 0; i < e.length; i++) {
			if (e[i] == null) {
				nbEtalTrouve++;
			}
		}
		
		
		int nbVendeurs = 0;
		
		if (nbEtalTrouve == 0) {
				chaine.append("Il n'y a pas de vendeur qui propose des " + produit + " au marché.\n");
		} 
		
		if (nbEtalTrouve == 1) {
			chaine.append("Seul le vendeur "+ e[0].getVendeur()+" propose des " + produit + " au marché.");
		}
		else {
			chaine.append("Les vendeurs qui proposent des " + produit + " sont :\n");
			for (int i = 0; i < e.length; i++) {
			chaine.append("- " + e[i].getVendeur());
			}
		}
		return chaine.toString();
	}
	
	/*
	public Etal rechercherEtal(Gaulois vendeur) {
		
	}
	
	
	public String partirVendeur(Gaulois vendeur) {
		StringBuilder chaine = new StringBuilder();
		
		
		return chaine.toString();
	}
	
	public String afficherMarche() {
StringBuilder chaine = new StringBuilder();
		
		
		return chaine.toString();
	}
	
	*/
	
}