package Huffmanencoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Heap.HeapGeneric;

public class HuffmanEncoding {

	HashMap<Character, String> encoder;
	HashMap<String, Character> decoder;

	class Node implements Comparable<Node> {
		char data;
		int cost; // frequency
		Node left;
		Node right;

		Node(char data, int cost) {
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}

		Node(Node left, Node right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {

			return this.cost - o.cost;
		}
	}

	public HuffmanEncoding(String feeder) {
		// 1) create frequency map of this feeder
		HashMap<Character, Integer> freq = new HashMap<>();
		for (int i = 0; i < feeder.length(); i++) {
			char cc = feeder.charAt(i);
			if (freq.containsKey(cc)) {
				int oldvalue = freq.get(cc);
				freq.put(cc, oldvalue + 1);
			} else
				freq.put(cc, 1);
		}

		// 2) To create the min heap of nodes
		HeapGeneric<Node> minheap = new HeapGeneric<>();

		Set<Map.Entry<Character, Integer>> entryset = freq.entrySet();

		for (Map.Entry<Character, Integer> entry : entryset) {

			Node node = new Node(entry.getKey(), entry.getValue());

			minheap.add(node);

		}
		// combine nodes untl one node left
		while (minheap.size() != 1) {

			Node minone = minheap.delete();
			Node mintwo = minheap.delete();

			Node combined = new Node(minone, mintwo);
			combined.cost = minone.cost + mintwo.cost;
			combined.data = '\0';

			minheap.add(combined);

		}

		Node lastnodefromheap = minheap.delete();

		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();

		this.initEncoderDecoder(lastnodefromheap, "");

	}

	public void initEncoderDecoder(Node root, String osf) {

		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			this.encoder.put(root.data, osf);
			this.decoder.put(osf, root.data);
		}
		// preorder traversal
		this.initEncoderDecoder(root.left, osf + "0");
		this.initEncoderDecoder(root.right, osf + "1");

	}
	public String encode(String source)
	{
		String rv="";

		for(int i=0;i<source.length();i++)
		{
			String k=this.encoder.get(source.charAt(i));
			rv+=k;
		}
		
		return rv;
	}
	
	public String decode(String codedstring)
	{
		String rv="";
		String key="";
		for(int i=0;i<codedstring.length();i++)
		{
			key=key+codedstring.charAt(i);
			if(this.decoder.containsKey(key))
			{
				rv+=this.decoder.get(key);
				key="";
			}
		}
		
		return rv;
	}
	
	public void display()
	{
		System.out.println(this.encoder);
		System.out.println(this.decoder);
	}
	
	
	public static void main(String[] args) {
		
		String str="abbccda";
		HuffmanEncoding hfc=new HuffmanEncoding(str);
		
		String codedstring=hfc.encode(str);
		System.out.println(codedstring);
		System.out.println("output : "+hfc.decode(codedstring));
		
	}

}
