package models;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class Utilities {

	
	public Map<Integer, ArrayList<Integer>> extractCSV () throws IOException{
    File file = new File("src/loto_201911.csv");
    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
    Map<Integer, ArrayList<Integer>> dic = new TreeMap<Integer, ArrayList<Integer>>();
    int i = 0 ; 
    for (String line : lines) {
    	
    	if (i!= 0) {
    		ArrayList<Integer> comb = new ArrayList<>();
	        String[] array = line.split(";", -1);  
	        for (int j = 4; j < 10; j++) {
	        	comb.add(Integer.parseInt(array[j]));
			}
	        dic.put(i, comb);  
        }
    	
    	i++;   
    }
    return dic;
	}
	
	public Map<Integer, Integer> extractNumChance () throws IOException{
	    File file = new File("src/////loto_201911.csv");
	    List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
	    Map<Integer, Integer> dic = new TreeMap<Integer,Integer>();
	    int i = 0 ; 
	    for (String line : lines) {
	    	
	    	if (i!= 0) {
	    		int num;
		        String[] array = line.split(";", -1);  
		        for (int j = 9; j < 10; j++) {
		        	dic.put(i, Integer.parseInt(array[j]));
				}
		         
	        }
	    	
	    	i++;   
	    }
	    return dic;
		}
	
	
}
	
	


