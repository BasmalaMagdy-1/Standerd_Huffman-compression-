package h;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Enter 1 to encode string ");
	    System.out.println("Enter 2 to decode tags");
	    Scanner O1 = new Scanner(System.in); 
	    int op = O1.nextInt();
	    
	    
	    if(op==1) 
	    {
		String text;
		 Scanner O2 = new Scanner(System.in); 
		text = O2.nextLine();
		
		Huffman h=new Huffman();
		h.buildhuffmantree(text);
	    }
	    else if(op==2)
	    {
	    	String text;
			 Scanner O2 = new Scanner(System.in); 
			text = O2.nextLine();
			System.out.println("Enter the number of codes");
			Scanner O3 = new Scanner(System.in); 
		    int n = O3.nextInt();
		    System.out.println("Enter the codes");
	    	Scanner O4 = new Scanner(System.in); 
		    Scanner O5 = new Scanner(System.in); 
		    Map <String , Character>HuffmanTable=new HashMap<String , Character>();
			
			for(int i=0;i<n;i++) {
				char code_char= O4.next().charAt(0);
				String code=O4.next();
				
				HuffmanTable.put(code,code_char);
				
			}
			Huffman h=new Huffman();
			h.decode(text,HuffmanTable);
	    }
		


	}

}
