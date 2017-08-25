import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; 

public class inputText {
	Hashtable<String, ArrayList<String>> writer = new Hashtable<String, ArrayList<String>>();
	int LEVEL = 10;
	int ADD = LEVEL+1;
	public inputText(String dictionaryFileName) throws IOException
	{
		 int x=0;
		 String book = readFile(dictionaryFileName);
		 while (x+ADD<book.length())
		 {
			 String str = book.substring(x,x+ADD);
			 if (writer.containsKey(str.substring(0,LEVEL)))
			 {
				 writer.get(str.substring(0,LEVEL)).add(str.substring(LEVEL));
			 }
			 else
			 {
				 ArrayList<String> temp= new ArrayList<String>();
				 temp.add(str.substring(LEVEL));
				 
				 writer.put(str.substring(0, LEVEL),temp);
			 }
			 x++;
			 
		 }
		
	}
	private String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	
	public void toStrng() throws IOException
	{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("practice")));
		out.print(writer.toString());
	}
	
	public void writeBook(String filename, int length) throws IOException
	{
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
		Set<String> keys= writer.keySet();
		int longest=0;
		String starter="";
		for (String key : keys)
		{
			if (writer.get(key).size()>longest)
			{
				longest=writer.get(key).size();
				starter = key;
			}
		}
		String letters=starter;
		out.print(letters);
		int x=0;
		
		while (x<length)
		{
			ArrayList<String> temp = writer.get(letters);
			int random = ((int)(Math.random()*temp.size()));
			String next = temp.get(random);
			out.print(next);
			letters= letters.substring(1)+next;
			x++;
		}
		
		out.close();
		
		
	}
	
	
	
//in the hashtable, import two letters at a time into the key, then add the next letter as the value in the arraylist
//then do a Math.random to get the next letter	
}
