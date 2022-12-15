package h;


	import java.util.Collections;
	import java.util.Comparator;
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	import java.util.Map;
	import java.util.PriorityQueue;
	import java.util.Scanner;

	public class Huffman {

		 static Map<Character,String> HuffmanTable = new LinkedHashMap<>();
		    private static int[] array;
		    private PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());

		    static {
		        array = new int[30];

		    }
		    class Node {
		        public int freq;
		        public Node left;
		        public Node right;
		        public char c =' ';

		    }
		    class NodeComparator implements Comparator<Node> {
		        public int compare(Node n1, Node n2) {
		            if (n1.freq < n2.freq)
		                return -1;
		            else if (n1.freq > n2.freq)
		                return 1;
		            return 0;
		        }
		    }
		static void encode(Node root, String str,
				Map<Character, String> huffmanCode)
		{
		if (root == null)
			return;

		if (root.left==null && root.right==null) {
			huffmanCode.put(root.c, str);
		}

		encode(root.left, str + "0", huffmanCode);
		encode(root.right, str + "1", huffmanCode);
		}

		void buildhuffmantree(String text)
		{
			 for (int i = 0; i < text.length(); i++) {
		            int index = text.charAt(i) - 'a' ;
		            array[index]++;
		        }
			

			 for (int i = 0; i < 26; i++) {
		            Node tempNode = new Node();
		            if (array[i] != 0) {
		                tempNode.freq = array[i];
		                tempNode.c = (char) (i + 'a');
		                pq.add(tempNode);

		            }
			 }

			
			while (pq.size() >= 2)
			{
				Node left = pq.poll();
				Node right = pq.poll();

				
				int sum = left.freq + right.freq;
				Node n=new Node();
				n.c='\0';
				n.freq=sum;
				n.left=left;
				n.right=right;
				pq.add(n);
			}
			
				Node root = pq.peek();

				
				Map<Character, String> huffmanCode = new HashMap<Character, String>();;
				encode(root, "", huffmanCode);

				
				System.out.println( "\nOriginal string was :" + text);

				
				String str = "";
				for (int i1=0;i1<text.length();i1++) {
					
				
					str += huffmanCode.get(text.charAt(i1));
				}
				System.out.println( "\nEncoded string is :" +str );
		}
	static void decode(String text,Map<String,Character> HuffmanTable)
	{
		  String Result = "";
	        for (int i = 0; i < text.length(); i++)
	        {
	            String subString = "";
	            for (int j = i; j < text.length(); j++)
	            {
	                subString += text.charAt(j);
	                if(HuffmanTable.get(subString) != null)
	                {
	                    Result += HuffmanTable.get(subString);
	                    break;
	                }
	            }
	            i += subString.length()-1;
	        }
	        System.out.println( "\nEncoded string is :" +Result );
	        
	}

			public static void main(String[] args) {
							
				
				  
				
			}


	}


