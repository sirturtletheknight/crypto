package playfair;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//First is Row, 2nd is Column

public class playfair {
	static char[][] parent_key = new char[5][5];
	static char[][] child_key = new char[5][5];
	static Map<String,Integer> scoreMap = new HashMap<String,Integer>();
	static long totalScore = 0;
	static Random rand = new Random();
	String string = "IGGMVMBOHNVIFOCZIGIYBWOCEHSYKHVZFALVGFIGVPQKOIRZGPVLPKLBZLOIXCPZYSYGPVPEZLIVDRPELVBUYGUZOBMBZVMUCIFZAKYHQYPINCUMBUYGPZYSIGGMVMBOHNVIBUSQZEZCSTOFVPIVELYMAOUIIKUSARXPPZSYZVBVVAWSIGBLQSQGYECHOICWYFIGFHNWBVVTCKYGPVPEZLKOOIPYYEPZYSHFFUFOQGAHHVFNWYYFNAISLVOWRPGLQGAHHVBUYHYGPEVFGZRZPZSYZVVBOIQTPEBUSTRAYBLNPZLELYCBSAGQIGSTLOLYHVZRCSNYIYXBBUIVYGNFYGCKPHLBZLDOYHYGGAIYMUFAYHYGGILYFVCKOIOCBOFGHSYFNAOWZLHBIVEKZBZRZCYFRAOUWSPEYGGZVIBUWSIGOBHVBUYHYGYFFUQSIGVIBUWSIYWGLEYXBUFHIVRPVQUFUELEYXMVFZCLVWLSACGFAONUZBZLOICUHFNTLAHFQYFAOWWBYSFPIVRPVQZEXPYBUBKCTGFGRPHSYBBVFZVBYGPEBUSTPILZPZUSVOFYKEOBIVYFYFKZPILBZLFUMRCKVTASQYUHLBZLOIMCGZPGCKTYIGTNUZOTCZPZYSFPOFIRXWIGFVEROISWLVLYGKYFFOCBNUYFFNCSNCWVPEWNLBZLOIBUGPIVXWIGBULVSAVLLPFVORVFNUZBZLOIBWAKGDGPBUYWNUZBZLOIXPYSVLOCXWIGNUVKPEWLCHRMUHLBZLOEANZCHVFZHNYSIGELQBDPIYWVBOFNMOPZYSCNOEVIPRPEFYIRKBDPNCHSPEVFFHHVPEZLVOBVVTFNKHGFIGCBYSFPEPUIIGBWOCDOGLALHIYFIYAQEUQSYGEPPZYSYGPENEPENFQTGZGFAOGEGFYXCAQSYGPEVZFALVGALYNUZRSYYGPVYFVFNUZBZLOIXWIGZOHIFUFGEKWNIYQKCKVXYWBUHSYFFGDRYHSYVLUDECWXYSHFEKPZSYBUOBBVIPBUFHFUTBWNYAAKHVNUZBZLOIZUQNPZYGFARAALTQTCUSPEVFFGPECKEHWSIGXYNYYPGYHFNUYAXMPZBVPILBZLOIXWIGOTZECPLBZLYNNUZBZLAGWNLBZLYGGAYGLYTGSQUNLBZLEACEYAARXCLEXBBUSTPFPEFEOWWYCBPEYGRAHFQYFAYBYSMVCZVPYGYFKPBOFVFNSXGFFPVIYGGFSUFPKEWNLBZLTCVIYGGAFOCZYGNFNUZBZLOIZCZVHSBUSCBSPEYGVFPDYMOQNUZBZLOIBWGFXLFVAQDWNUZBZLOICWYAARXBBUFHWDYMARBWRUVIZCMUUXYSHEYSFPYMAKHSLUQSFZXUGKXYKXCHUAQTCKPXYSCEYWXLLEBQNUZBZLOIXZOAPVWNLBZLOIXZOXUIICHSANWXYSNFGFXLFVAQYEYBUBNUZBZLWLCHIHLBZLZUTNCKVTQGLNPILBZLOICULVIRZCKVFZYMAOVEOIBWYXARBUQXXYSUQEEFCBTBFOCZHFFUFORUFZWOEPSYFUWHKXPZYSYFYGGZVIBUTZAERPZKCOFGWNLBZLHFNYYPGYFPLYTGYHSYZVGEGFYXIVLEYGPFFEPKLBZLOIZCALLNPZDWBUSTPFPEPACBPEYGVZEKXPPILBZLCKGZUIQYXYIGFOZRWVYSYGYFFPFPEPTCVINZPVOINUZBZLOIXWIGEPFPEPYGBOGFSUCZNASQNUZBZLCKCAEKHVYGRZFVORVFXOENLAVIQYUYTGCKPXYSCNUZZVVIVECKZCHVUFUOAKIRZLXWLNGZPGYGYFNBYFQSDPNQFHYMAYCBPEYGYFMVCZVPBUFHARSYYGPEGPUVARWDYMAYVDUICQYFPEFOEYCKQSQSVLHVQSEPLZOVUSBUSTVFPDYMARCDGWUSUASYKHLBZLLEYFIGQMLEVPRUUIFALVLENEPEFNZPSYSCBUFYQTHFIYYMMQNEPEFNZPRUUIVFNUZBZLBVAOYGGFCKEFQSNUVKPEASHFNUZRWBUSHSYSIGFUFGPKLBZLOBYGYFQELBYGVZLUYXLYZKTGSWOIHUHFFUFOENYMAUVPASOBZRIYAQBUIFKNLYFVWNLBZLUAYQLAXBBUSTCKBWLVOIZUZNHVBUIOEPYGVAKOXYUSVOZVSTGZVIALCBBVOIBUZTLVXWIYYXLYIUKVFZYMAOFVFZHOYGCKVYTZQELBYGVFQGFZZXYSUAYQIGYSIGVQNCZPVLOCCPLVIVVQNUZBZLOIXZPERAUGGZPGYFYGPENEPEBUSCBVVFQGGZGFXLYGOINQSYYGRZSAVMFEHVOBNUVOCZPEYFPILBZLOIMUFZENHVYGPENEPEZOKIQSUSYBUBFOCBAERABWOICUYFPESUQRWBYSPRVIEPUZCKPHLBZLYGLYTGHFBUVFHFONVFYHSYWVANAUCBWOYMAOOIXZLIGICZVAOWOFDLHNASYGPENEPEOFHFIUKVFZHNNUZBZLNFVYUBIOWYEPZPVBYPGYLNGZPGHFWORYATUIFZVYUBZPUALYSYWQHEGYBUWHBGLENUZBZLASNULPFVNUZBZLIYZUAKYHQYPGAUIPYFFUYQBVUILZWPLBZLLVOIVIQGVIHNZRHSNUZBZLLVOBZRYGCKVYWSIYSQLVYH";
	char[] cipher = string.toCharArray();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		double parentScore;
		double childScore; 
		int counter = 0;
		
		initScoreBoard();
		String key =  "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				child_key[i][j] = key.charAt((i*5)+j);
			}
		}
		
		playfair playfair = new playfair();
		char[] deciphered  = playfair.decipher();
		parentScore = score(deciphered);
		
		for(int i = 0; i < 5; i++){
		    parent_key[i] = child_key[i].clone();
		}

		while(counter<10000){
			int next = rand.nextInt(50);
			if(next == 1){
				swapAxis();
			} else {
				swapRandom();
			}
			deciphered  = playfair.decipher();
			childScore = score(deciphered);
			
			if(childScore < parentScore){
				for(int i = 0; i < 5; i++){
				    parent_key[i] = child_key[i].clone();
				}
			}
			System.out.println(deciphered);
			for(int i=0; i<5; i++){
				for(int j=0; j<5; j++){
					System.out.print(child_key[i][j]);
				}
			}
		}
	}
	
	
	
	public char[] decipher(){
		char[] deciphered = new char[2682];
		for(int i=0; i<2682;i= i+2){
			char[] digraph = new char[2];
			digraph[0] = cipher[i];
			digraph[1] = cipher[i+1];
			int[] position1 = getPosition(digraph[0]);
			int[] position2 = getPosition(digraph[1]);
			if(position1[0] == position2[0]){
				digraph = rowDecipher(digraph, position1, position2);
			} else { 
				if(position1[1] == position2[1]){
					digraph = columnDecipher(digraph, position1, position2);
				} else {
					digraph = squareDecipher(digraph,position1, position2);
				}
				
			}
			deciphered[i] = digraph[0];
			deciphered[i+1] = digraph[1];			
			
		}
		
		return  deciphered;
	}
	
	//In Same Column
	public char[] columnDecipher(char[] a, int[] position1, int[] position2){
		char[] b = new char[2];
		if(position1[0]==0){
			position1[0] = 5;
		}
		if(position2[0]==0){
			position2[0] = 5;
		}
		b[0] = child_key[(position1[0]-1)][position1[1]];
		b[1] = child_key[(position2[0]-1)][position2[1]];
		return b;
	}
	
	//in Same Row
	public char[] rowDecipher(char[] a, int[] position1, int[] position2){
		char[] b = new char[2];
		if(position1[1]==0){
			position1[1] = 5;
		}
		if(position2[1]==0){
			position2[1] = 5;
		}
		b[0] = child_key[position1[0]][(position1[1]-1)];
		b[1] = child_key[position2[0]][(position2[1]-1)];
		return b;
	}
	
	public char[] squareDecipher(char[] a, int[] position1, int[] position2){
		char[] b = new char[2];
		
		b[0] = child_key[position1[0]][position2[1]];
		b[1] = child_key[position2[0]][position1[1]];
		return b;
	}
	
	public int[] getPosition(char a){
		int[] position = new int[2];
		for(int i = 0; i<5; i++){
			for(int j=0; j<5; j++){
				if(a == child_key[i][j]){
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		return null;
	}
	
	public static void initScoreBoard() throws IOException{
		FileReader input = new FileReader("english_quadgrams.txt");
		BufferedReader bufRead = new BufferedReader(input);
		String myLine = null;

		while ( (myLine = bufRead.readLine()) != null)
		{    
		    String[] array1 = myLine.split(" ");
		    scoreMap.put(array1[0], Integer.valueOf(array1[1]));
		    totalScore = totalScore + Integer.valueOf(array1[1]);
		}
		
		bufRead.close();
		input.close();
	}
	
	public static double score( char[] text){
		double score = 0;
		
		for(int i=0; i<2682;i++){
			char[] temp = Arrays.copyOfRange(text,i , i+4);
			String quadgraph = new String(temp);
			if(quadgraph.length()==4 && scoreMap.containsKey(quadgraph)){
				score = score + Math.log10((float)scoreMap.get(quadgraph)/totalScore);
			} else {
				score = score + Math.log10(0.01/totalScore);
			}
		}
		
		return score;
	}
	
	public static void swapRandom(){
		int r1 = rand.nextInt(4);
		int r2 = rand.nextInt(4);
		int r3 = rand.nextInt(4);
		int r4 = rand.nextInt(4);
		char temp = child_key[r1][r2];
		child_key[r1][r2] = child_key[r3][r4];
		child_key[r3][r4] = temp;
	}
	
	public static void swapAxis(){
		char[][] newKey = new char[5][5];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				newKey[i][j] = child_key[j][i];
			}
		}
		child_key = newKey;
	}

}
