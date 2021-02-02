package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Statistiques {
	

	

	public static TreeMap<Integer, Integer> reussiteTot(Map<Integer, ArrayList<Integer>> dic2) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 1; i < 50; i++) {
			int counter = 0;
			for (int j = 1; j < dic2.size()+1; j++) {
				ArrayList<Integer> list = dic2.get(j);
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k)==i) counter++; 
				}
			}
			map.put(i, counter);
		}
		return (TreeMap<Integer, Integer>) map;
	}
	
	

	public static TreeMap<Integer, Integer> sortieRec(Map<Integer, ArrayList<Integer>> dic2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 1; i < 50; i++) {
			int counter = 0;
			for (int j = 1; j < 10; j++) {
				ArrayList<Integer> list = dic2.get(j);
				//if (list == null) return 0;
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k)==i) counter++; 	
				}
			}
			map.put(i, counter);
		}
		return map;
	}
	
	public static TreeMap<Integer, Integer> ecartMax(Map<Integer, ArrayList<Integer>> dic2){
		TreeMap<Integer,Integer> map = new TreeMap<>();
		
		for (int i = 1; i < 50; i++) {
			ArrayList<Integer> ecarts = new ArrayList<>();
			int counter = 0;
			for (int j=1; j< dic2.size()+1; j++) {	
				int t = 0;
				
				ArrayList<Integer> list = dic2.get(j);
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k)==i) t++ ;
					
				}
				if(t==0) {
					counter++;
					ecarts.add(counter);
				}
				else counter =0;
			}
			Collections.sort(ecarts);
			int k = ecarts.get(ecarts.size()-1);
			map.put(i, k);
		}
		return map;
	}
	
	public static TreeMap<Integer,Integer> EcartActuel(Map<Integer, ArrayList<Integer>> dic2 ){
		TreeMap<Integer, Integer> treeE = new TreeMap<Integer, Integer>();
		Set<Integer> keys = dic2.keySet();
		int number = 0;
		for(Integer key : keys) {
			if(number < 49) 
			{
				List <Integer> liste = dic2.get(key);
				//System.out.println(liste);
				for (int i = 0 ; i < liste.size()-1 ; i++) {
					int num = liste.get(i);
					if (treeE.containsKey(num) == false && number < 49) {
						treeE.put(num, key);
						number = number + 1;
					}
				}
			}
			else{
				return treeE;
			}
		}
		return treeE ;
		
		
	}
	public static TreeMap<Integer,Integer> Affinite (int n, Map<Integer, ArrayList<Integer>> dic2 ){
		TreeMap<Integer, Integer> treeA = new TreeMap<Integer, Integer>();
		Set<Integer> keys = dic2.keySet();
		for(Integer key : keys) {
			List <Integer> liste = dic2.get(key); 
			if(liste.contains(n)) {
				for (int i = 0 ; i < liste.size()-1 ; i++) {
					Integer num = liste.get(i);
					if(num != n) {
						if (treeA.containsKey(num) == false) {
							treeA.put(num,1);
						}else {
							treeA.put( num , treeA.get(num)+1);
						}
					}		
				}
			}
		}
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		Map.Entry<Integer, Integer> maxEntry = null;
		
		for(Entry<Integer, Integer> entry : treeA.entrySet()){
		   if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		     maxEntry = entry;
		}
		Map.Entry<Integer, Integer> minEntry = null;
		for(Entry<Integer, Integer> entry : treeA.entrySet()){
			   if(minEntry == null || entry.getValue().compareTo(minEntry.getValue()) < 0)
			     minEntry = entry;
			}
		
		int max = maxEntry.getKey(); 
		int min = minEntry.getKey(); 
		tree.put(0, min);
		tree.put(1, max);
		return tree;
	}
	
	
	//l'output est une TreeMap qui a comme clé le numero de la boule et comme valeur une arraylist 
	//de deux valeurs la première est la meilleure affinité et la deuxième est la moins bonne.
	public static TreeMap<Integer,ArrayList<Integer>> AffiniteF (Map<Integer, ArrayList<Integer>> dic2 ){
		TreeMap<Integer,ArrayList<Integer>> tree = new TreeMap<Integer, ArrayList<Integer>>();
		TreeMap<Integer,Integer> tmp = new TreeMap<Integer, Integer>();
		
		for(int i = 1 ; i <= 49 ; i++) {
			ArrayList<Integer> liste = new ArrayList<Integer>();
			tmp = Affinite (i , dic2 );
			liste.add(tmp.get(0));
			liste.add(tmp.get(1));
			tree.put( i, liste);
		}
		return tree;
		
	}
	
	
	public static TreeMap<Integer,ArrayList<Integer>> statF (Map<Integer, ArrayList<Integer>> dic2){
		TreeMap<Integer,ArrayList<Integer>> resultat = new TreeMap<Integer, ArrayList<Integer>>();
		TreeMap<Integer,Integer> y = (TreeMap<Integer, Integer>) reussiteTot(dic2);
		TreeMap<Integer,Integer> t = (TreeMap<Integer, Integer>) sortieRec(dic2);
		TreeMap<Integer,Integer> z = (TreeMap<Integer, Integer>) ecartMax(dic2);
		TreeMap<Integer,Integer> n = EcartActuel(dic2);
		TreeMap<Integer, ArrayList<Integer>> x = AffiniteF(dic2);
		
		for(int i = 1 ; i <= 49 ; i++) {
			ArrayList<Integer> liste = new ArrayList<Integer>();
			liste.add(y.get(i));
			liste.add(t.get(i));
			liste.add(z.get(i));
			liste.add(n.get(i));
			//System.out.println("liste " + liste);
			liste.add(x.get(i).get(0));
			liste.add(x.get(i).get(1));
			resultat.put( i, liste);
		}
		return resultat;
	}
	
	public static TreeMap<Integer, Integer> reussiteTot2(Map<Integer, Integer> dic2) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 1; i < 11; i++) {
			int counter = 0;
			for (int j = 1; j < dic2.size()+1; j++) {
				int num = dic2.get(j);
				
					if (num==i) counter++; 
				
			}
			map.put(i, counter);
		}
		return (TreeMap<Integer, Integer>) map;
	}
	
	
	public static TreeMap<Integer, Integer> sortieRec2(Map<Integer, Integer> dic2) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 1; i < 11; i++) {
			int counter = 0;
			for (int j = 1; j < 11; j++) {
				int num = dic2.get(j);
				
					if (num==i) counter++; 
				
			}
			map.put(i, counter);
		}
		return (TreeMap<Integer, Integer>) map;
	}
	
	
	public static TreeMap<Integer,ArrayList<Integer>> statF2 (Map<Integer, Integer> dic2){
		TreeMap<Integer,ArrayList<Integer>> resultat = new TreeMap<Integer, ArrayList<Integer>>();
		TreeMap<Integer,Integer> y = (TreeMap<Integer, Integer>) reussiteTot2(dic2);
		TreeMap<Integer,Integer> t = (TreeMap<Integer, Integer>) sortieRec2(dic2);
		
		
		
		for(int i = 1 ; i < 11 ; i++) {
			ArrayList<Integer> liste = new ArrayList<Integer>();
			liste.add(y.get(i));
			liste.add(t.get(i));
			
			//System.out.println("liste " + liste);
			
			resultat.put( i, liste);
		}
		return resultat;
	}
	
	public static void main(String[] args) throws Exception  {
		
		Utilities u = new Utilities();
		Map<Integer, ArrayList<Integer>> dic2 = new TreeMap<>();
		dic2 = u.extractCSV();
		System.out.println(dic2);
		TreeMap<Integer,Integer> n = EcartActuel((TreeMap<Integer, ArrayList<Integer>>) dic2);
		 System.out.println(n);
		/*TreeMap<Integer, ArrayList<Integer>> x = AffiniteF((TreeMap<Integer, ArrayList<Integer>>) dic2);
		//System.out.println(x);
		TreeMap<Integer,Integer> y = (TreeMap<Integer, Integer>) reussiteTot(dic2);
		System.out.println(y);
		TreeMap<Integer,Integer> t = (TreeMap<Integer, Integer>) sortieRec(dic2);
		//System.out.println(t);*/
		TreeMap<Integer,Integer> z = (TreeMap<Integer, Integer>) ecartMax(dic2);
		System.out.println(z);
		//TreeMap<Integer,ArrayList<Integer>> f = statF(dic2);
		//System.out.println(f);
		Map<Integer, Integer> dic3 = new TreeMap<>();
		dic3 = u.extractNumChance();
		//System.out.println(dic3);
		
		TreeMap<Integer, Integer> y = reussiteTot2(dic3);
	//	System.out.println(y);
		
		TreeMap<Integer, Integer> e = sortieRec2(dic3);
	//	System.out.println(e);
		
		TreeMap<Integer,ArrayList<Integer>> f = statF2(dic3);
		//System.out.println(f);
	}
	

}