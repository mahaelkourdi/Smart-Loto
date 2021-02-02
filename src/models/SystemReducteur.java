package models;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.TreeMap;

public class SystemReducteur {
	private final int N,P,K;
	 
	/**
         * @param n,p,k Tirage de P elements parmis N, avec au moins K gagnants
         */
	public SystemReducteur(int n, int p, int k) {
		this.N=n;
		this.P=p;
		this.K=k;
	}
 
	/**
         * Compte le nombre d'elements en commun entre 2 tirages
         * 
         * @param value1, value2 2 tirages  
         * @return le nombre d'elements en commun
         */
	private int match(int value1,int value2) {
		int and = value1 & value2;
		int bitcount = Integer.bitCount(and);
		return bitcount;
	}
 
	/**
         * Heuristique pour la recherche des candidats
         * 
         * @param value un tirage
         * @param liste la liste des tirages possibles restants
         * @return le nombre de fois que ce tirage est gagnant
         */
	private int score(int value,int[] liste) {
		int score = 0;
		for(int item:liste) {
			if (item==0) continue; // a été supprimé
			int d=match(value,item);
			if (d>=K) score++;
		}
		return score;
	}
 
	/**
         * retourne la liste des meilleurs tirages
         * au sens de l'heuristique "score()"
         * 
         * @param list la liste des tirages possibles restants 
         * @return la liste des meilleurs tirages
         */
	public int[] findCandidats(int[] list) {
		int[] candidats = new int[list.length];
		int count=0;
 
		// recherche exhaustive des meilleures tirages 
		int maxscore=-1;
		for(int item:list) {
			if (item==0) continue; // a été supprimé
			int score = score(item,list);
			if (score>maxscore) {count=0; maxscore=score;}
			if (score==maxscore) candidats[count++]=item;
		}
		return Arrays.copyOf(candidats,count);
	}
 
	/**
         * Supprime (=mise à zéro) tous les tirages gagnants 
         * de la liste des tirages possibles
         * 
         * @param tirage le tirage de reference
         * @param list la liste des tirages possibles restants
         * @return le nombre de tirages possibles restants après suppression
         */
	public int removeMatching(int tirage, int[] list) {
		int count=0;
		for(int i=0;i<list.length;i++) {
			if (list[i]==0) continue; // a déjà été supprimé
			int match = match(tirage,list[i]);
			if (match>=K) list[i]=0; else count++;
		}
		return count;
	}
 
	/**
         * retourne une liste des solutions du système de réduction
         * 
         * @return la liste des tirages après réduction
         */
	public int[] computeSolutions() {
		// calcul de la liste de tous les tirages possibles
		int[] tirages = new Cnp(N,P).results;
		int tiragescount=tirages.length;
 
		// allocation de la liste des solutions
		int[] solutions = new int[tirages.length];
		int solutionscount=0;
 
		// tant qu'il reste des tirages possibles
		while(tiragescount>0) {
 
			// recherche des meilleurs candidats
			int[] candidats = findCandidats(tirages);
 
			// on prend un des candidats, au hasard
			int random = (int)(Math.random()*candidats.length);
			int grille = candidats[random];
 
			// on ajoute le candidat a la liste des solutions
			solutions[solutionscount++]=grille;
 
			// on supprime les tirages gagnants de la liste des tirages possibles
			tiragescount=removeMatching(grille, tirages);
		}
 
		// on retourne la liste des solutions 
		return Arrays.copyOf(solutions, solutionscount);
	}
	
	public static TreeMap<Integer, ArrayList<Integer>> SysReducteur(ArrayList<Integer> list, SystemReducteur tf ){
		TreeMap<Integer, ArrayList<Integer>> listeF = new TreeMap<Integer, ArrayList<Integer>>();
		//SystemReducteur tf = new SystemReducteur(list.size(),6,K);
		ArrayList<Integer> listeEmplacement = new ArrayList<Integer>();
		
		// calcul des solutions et conserve la meilleure
		int[] bestsolution = null;
		for(int loop=0;loop<100;loop++) {
			int[] solutions = tf.computeSolutions();
			if (bestsolution==null || solutions.length<bestsolution.length) { 
				System.out.println("found a solution of size:"+solutions.length);
				bestsolution=solutions;
			}
		}
		
		int j = 0;
		// affiche la meilleure solution
		for(int solution : bestsolution) {
			ArrayList<Integer> listeCombi = new ArrayList<Integer>();
			
			listeEmplacement= Cnp.combi(solution);
			
			j++;
			
			//System.out.println("new one" + listeCombi + " " +listeEmplacement + " "+ j + " "+ listeF);
			for(int i = 0; i<= 4 ; i++) {
				int tmp = listeEmplacement.get(i);
				//System.out.println(tmp);
				
				listeCombi.add(list.get(tmp-1));
				
				
			}
			//System.out.println(listeCombi);
			listeF.put(j, listeCombi);
			//System.out.println("listeF " + listeF);
			
		}
		//System.out.println(listeF);
		
		return listeF;

	}
	
	
	
	// ------------------------------------------------------------------------
 
	/**
         * Main: Test du systeme reducteur  
         */
	public static void main(String[] args) {
		// creation du Systeme Reducteur 10/6/5
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(5);
		list.add(10);
		list.add(22);
		list.add(29);
		list.add(32);
		list.add(35);
		list.add(40);
		list.add(41);
		//list.add(48);
		
		SystemReducteur tf = new SystemReducteur(list.size(),5,4);
		TreeMap<Integer, ArrayList<Integer>> listFinal = new TreeMap<Integer, ArrayList<Integer>>();
		listFinal = SysReducteur( list, tf );
		System.out.println(listFinal);
	
		
		
	}
}
