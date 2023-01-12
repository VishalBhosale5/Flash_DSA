package Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	
	public class Node
	{
		char data;
		boolean isTerminal;
		HashMap<Character,Node> children;
		
		
		Node(char data,boolean isTerminal)
		{
			this.data=data;
			this.isTerminal=isTerminal;
			this.children=new HashMap<>();
		}
		
	}
	
	
	
	int numWords;
	Node root;
	
	
	Trie()
	{
		this.root=new Node('\0',false);
		this.numWords=0;
	}
	
	
	public int NumWords()
	{
		return numWords;
	}
	
	
	public void addWord(String word)
	{
		
		
		
		this.addWord(this.root, word);
		
		
		
	}
	
	private void addWord(Node parent,String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
			{
				//word already exist
			}else
			{
			parent.isTerminal=true;
			this.numWords++;
			}
			return;
		}
		
		char cc=word.charAt(0);
		String ros=word.substring(1);
		
		Node child=parent.children.get(cc);
		if(child==null)
		{
			child=new Node(cc,false);
			parent.children.put(cc, child);
		}
	
			this.addWord(child, ros);
		
		
	}
	
	
	
	public boolean search(Node parnt,String word)
	{
		if(word.length()==0)
		{
			if(parnt.isTerminal)
				return true;
			else
				return false;
			
		}
		char cc=word.charAt(0);
		String ros=word.substring(1);
		
		Node child=parnt.children.get(cc);
		if(child==null)
		{
			return false;
		}
		
		return search(child,ros);
		
		
		
		
		
		
		
		
		/*if(word.length()==0 && root.isTerminal)
			return true;
		
		if(word.length()==0)
			return false;
		
			for(Character child:root.children.keySet())
			{
				if(child==word.charAt(0))
				{
			 if(search(root.children.get(child),word.substring(1)))
				 return true;
				}
		
			
			}
			*/
		
		
		//return false;
		
	}
	
	public void remove(String word)
	{
		this.remove(this.root, word);
	}
	public void remove(Node parent,String word)
	{
		if(word.length()==0)
		{
			if(parent.isTerminal)
			{
				parent.isTerminal=false;
				this.numWords--;
				
			}
			else
			{
				
			}
			
			return;
		}
		
		char cc=word.charAt(0);
		String ros=word.substring(1);
		
		Node child=parent.children.get(cc);
		if(child==null)
		{
			return;
		}
		
		this.remove(child,ros);
		
		if(!child.isTerminal && child.children.size()==0)
			parent.children.remove(cc);
	}
	
	
	
	
	
	
	public void display(Node node,String opsf)
	{
		
		
		if(node.isTerminal)
			System.out.println(opsf.substring(1)+node.data); // /0 at index 0
		
		Set<Map.Entry<Character,Node>> entries=node.children.entrySet();
		
		
		for(Map.Entry<Character, Node> set:entries)
		{
			this.display(set.getValue(), opsf+node.data);
		}
		
	}
	
	public static void main(String[] args) {
		Trie trie=new Trie();
		
		trie.addWord("arts");
		trie.addWord("art");
		trie.addWord("Bug");
		trie.addWord("boy");
		trie.addWord("sea");
		trie.addWord("seen");
		trie.addWord("see");
		trie.addWord("amit");
		System.out.println("******************************");
		trie.display(trie.root, "");
		System.out.println("******************************");
		//System.out.println(trie.search(trie.root,"arts"));
		trie.remove("sean");
		trie.display(trie.root, "");
	}
	
	

}
