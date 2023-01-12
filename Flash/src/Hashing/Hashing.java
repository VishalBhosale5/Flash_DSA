package Hashing;
import java.util.*;
public class Hashing {
	public static void main(String[] args) {
		
		
		HashMap<String,Integer> map=new HashMap<>();
		
		//insert O(1)
		//delete O(1)
		//search O(1)
		//add   O(1)
		map.put("USA", 150);
		map.put("India", 200);
		map.put("Sweden", 80);
		map.put("RSA", 90);
		map.get("USA"); //returns the values , if key is not present then return null.
		map.containsKey("USA");
		map.containsValue(150);
		Set<String> ss=map.keySet();
		Collection<Integer> c=map.values();
		map.remove("USA");
		System.out.println(map.keySet());
		
		Set<String> s=map.keySet();
		Collection<Integer> v=map.values();
		System.out.println(v);
		
	Set<Map.Entry<String, Integer>>  e=map.entrySet();
	
	for(Map.Entry<String, Integer> entry:e)
		System.out.println(entry.getKey()+" "+entry.getValue());
	
	
	String str="aabbaaacdkmmmmmmmmmgjhd";
	GetMaxFreqCharacter(str);
	
	}

	private static void GetMaxFreqCharacter(String s) {
			HashMap<Character, Integer> map=new HashMap<>();
			int l=0;
			for(int i=0;i<s.length();i++)
			{
					if( map.containsKey(s.charAt(i)))
							map.put(s.charAt(i),map.get(s.charAt(i))+1);
					else
						map.put(s.charAt(i), 1);
			}
			
			System.out.println(map);
			Collection<Integer> set=map.values();
			System.out.println(Collections.max(set));
			
	}

}
