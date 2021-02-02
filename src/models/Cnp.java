package models;

import java.util.ArrayList;


public class Cnp {
	private int n,p;
	 
	// liste des solutions  
	public int[] results;
 
	// pointeur sur l'element courant de la liste
	private int ptr=0;
 
	public Cnp(int n,int p) {
		this.n=n;
		this.p=p;
 
		// calcul de la taille de la liste des solutions
		// = nombre de combinaisons (n,p) = A(n,p)/!p
		int arrangement = 1, factorielle=1;
		for(int i=0;i<p;i++) {arrangement*=(n-i);factorielle*=(i+1);}
		int combinaison=arrangement/factorielle;
 
		results = new int[combinaison];
 
		build(0,0,0);
	}
 
	// construction recursive des combinaisons possibles
	private void build(int value, int index, int count) {
 
		// impossible de construire une solution
		if ((n-index)<(p-count)) return;
		//System.out.println(value + " " + index + " "+count);
		// la combinaison est construite -> ajout a la liste des solutions 
		if (count==p) {
			results[ptr++]=value;
			return;
		}
 
		// explore les 2 chemins possibles pour poursuivre la constuction
 
		// 1. on ne choisit pas l'element numero "index"
		build(value,index+1,count);
 
		// 2. on choisit l'element numero "index"
		build(value+(1<<index),index+1,count+1);
	}
 
	/**
         * Affiche d'une valeur sous forme de chaine texte
         * 
         * @param value valeur sous forme binaire
         * @return la valeur sous forme de chaine texte
         */
	public static String asTicket(int value) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i=0;
		while(value!=0) {
			i++;
			if ((value & 1)==1) sb.append(i).append(" "); 
			value=value>>1;
		}
		sb.append("]");
		//System.out.println(sb);
		return sb.toString();
	}
	public static ArrayList<Integer> combi(int value){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i=0;
		while(value!=0) {
			i++;
			if ((value & 1)==1) list.add(i); 
			value=value>>1;
		}
		return list;
		
	}
	
}
