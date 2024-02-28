package villagegaulois;

import villagegaulois.Etal;
import personnages.*;

public class Marche {
	
	private Etal etal[];
	private int nbEtal;
	
	public Marche(int nbEtal) {
		this.nbEtal = nbEtal;
		etal = new Etal[nbEtal];
//		for (int i = 0; i < nbEtal; i++)
//		{
//			
//		}
	}
	
	
	public void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
		if (indiceEtal < nbEtal && indiceEtal >= 0) {
			etal[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
		else {
			System.out.println("L'indice n'est pas valide");
		}
	}
	
	public int trouverEtalLibre() {
		for (int i = 0; i < nbEtal; i++) {
			if (etal[i].isEtalOccupe())
			{
				
			}
			else {
				return i;
			}
		}
		return -1;
	}
	
	
	public Etal[] trouverEtals(String produit) {
		int c = 0;
		for (int i = 0; i < nbEtal; i++) {
			if (etal[i].contientProduit(produit)) {
				c++;
			}
		}
		
		Etal t[] = new Etal[c];
		int n = 0;
		for (int i = 0; i < nbEtal; i++) {
			if (etal[i].contientProduit(produit)) {
				t[n] = etal[i];
				n++;
			}
		}
		
		return t;
	}
	
	
	public Etal trouverVendeur(Gaulois gaulois) {
		for (int i = 0; i < nbEtal; i++) {
			if (etal[i].getVendeur() == gaulois) {
				return etal[i];
			}
		}
		return null;
	}
	
	
	public void afficherMarche() {
		System.out.println("Le marché :");
		int c = 0;
		for (int i = 0; i < nbEtal; i++) {
			etal[i].afficherEtal();
			c = i;
		}
		int nbEtalVide = nbEtal - c;
		if (nbEtalVide > 0) {
			System.out.println("Il reste " + nbEtalVide + " étals non utilisés dans le marché.");
		}
	}
	
	
	
}




