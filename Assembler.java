import java.io.*;
import java.util.*;

public class Assembler {
	
	static List<String> listresult = new ArrayList<String>();
	static List<String> forloop = new ArrayList<String>();
	static List<String> operations = new ArrayList<String>();
	
	static String[] listresultarray = null;
	static String[] stringArr2 = null;
	static String[] forlooparray = null;
	static String[] performOpArray = null;
	static String[] operationsArray = null;
	static String[] addthesevalues;
	
	static boolean printforlooplater = false;
	static String line = "";
	static String forlooptobeprinted = "";
	static String tobeprinted = "";
	static StringTokenizer tokenizer;
	static String message = "message";
	static List<String> list = new ArrayList<String>();
	static List<String> addthese = new ArrayList<String>();//values to be added
	static int i = 1;
	static int j = 1;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		
		String filename = "";
		String newfilename = "";
		String line = "";
		BufferedReader buffer;
		FileWriter fw ;
		
		try{
			
			System.out.println("Enter filename\n(with .c extension including path): ");
			Scanner scanner = new Scanner(System.in);
			filename = scanner.nextLine();
			
			if(filename.contains("/") && filename.contains(".c")){
				newfilename = filename.substring(filename.lastIndexOf("/")+1,filename.indexOf(".c"));
			}
			else{
				newfilename = filename.substring(0, filename.indexOf(".c"));
			}
			buffer= new BufferedReader(new FileReader(filename));
			fw = new FileWriter("CConverted/converted"+newfilename+".asm");
		
			line = buffer.readLine();
			fw.append("\n.model small\n.data");
			
			while (line!=null) {
				checkhead(line, fw);
				line = buffer.readLine();
			}
			
			buffer.close();
			
			buffer= new BufferedReader(new FileReader(filename));
			line = buffer.readLine(); //supposed to be #include <stdio.h>
			fw.append("\n.stack 100h\n.code");
			i = 1;
			while (line!=null) {
				checkbody(line,fw, buffer);
				line = buffer.readLine();
			}
			fw.append("\n\n\tmain endp\n\tend main");
			fw.close();
			buffer.close();
			
			System.out.println(newfilename + ".c successfully converted to converted" + newfilename + ".asm!");
		}

			
			catch(IOException e){
				System.out.println("File not found! Please check your filename or file path");
			}
			catch(NullPointerException e){
				System.out.println("Null pointer Exception!");
			}
	}
	
	private static void checkbody(String line, FileWriter fw, BufferedReader buffer) {
		try {
			if(line.contains("/*")){
				int index1 = line.indexOf("/*");
				int index2 = line.indexOf("*/");
				String comment = line.substring(0, index1 ) + ";" + line.substring(index1+2, index2);
				fw.append(comment);
			}
			if(line.contains("printf")&& !line.contains("%d") && !line.contains("%s") && !line.contains("%c") && !line.contains("%i")){
				fw.append("\n\n\tlea dx, " + message + i);
				fw.append("\n\tmov ah, 09h");
				fw.append("\n\tint 21h\n");
				i++;
			}
			if(line.contains("printf") && line.contains("%d") || line.contains("%s") || line.contains("%c") || line.contains("%i")){
				int apostrophe1 = line.indexOf("\"");
				int apostrophe2 = line.lastIndexOf("\"");
				
				String var1 = line.substring(apostrophe1+1, apostrophe2);
				if(!var1.equals("%d") && !var1.equals("%s") && !var1.equals("%c") && !var1.equals("%i") && !var1.equals("%d") && !var1.contains("\n")){
					fw.append("\n\n\tlea dx, " + message + i);
					fw.append("\n\tmov ah, 09h");
					fw.append("\n\tint 21h\n");
					i++;
				}
				if(line.contains(",")){
					/*if(line.contains("%c") || line.contains("%i") || line.contains("%d")){
						fw.append("\n\tmov dl" + line.substring(line.indexOf(","), line.indexOf(")")));
						fw.append("\n\tmov ah, 02h");
						fw.append("\n\tint 21h\n");
					}*/
					if(line.contains("%s")){
						fw.append("\n\n\tlea dx"+ line.substring(line.indexOf(","), line.indexOf(")")));
						fw.append("\n\tmov ah, 09h");
						fw.append("\n\tint 21h\n");
					}
				}
					
			}
			
			
			
			  StringTokenizer st = new StringTokenizer(line," ");
				while(st.hasMoreElements()){
					String intmain = st.nextToken();
					//Check all cases of int main(){
					if(intmain.equals("int")){
						intmain = st.nextToken();
						if(intmain.equals("main(){")){
							//fw.append("main proc");
							fw.append("\n\tmain proc\n\tmov ax, @data\n\tmov ds, ax\n");
							printadd(listresult, fw);
						}
						else if(intmain.equals("main")){
							intmain = st.nextToken();
							if(intmain.equals("()")){
								intmain = st.nextToken();
								if(intmain.equals("{")){
									fw.append("\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax\n");
									printadd(listresult, fw);
								}
							}
							else if(intmain.equals("(){")){
								fw.append("\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax\n");
								printadd(listresult, fw);
							}
						}
						if(intmain.equals("main()")){
							if(st.hasMoreElements()){
								intmain = st.nextToken();
								if(intmain.equals("{")){
									fw.append("\n\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax\n");
									printadd(listresult, fw);
								}
							}
							else{
								line = buffer.readLine();
								st = new StringTokenizer(line," ");
								intmain = st.nextToken();
								if(intmain.equals("{")){
									fw.append("\n\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax\n");
									printadd(listresult, fw);
								}
							}
						}
						
					}//end of Check all cases of int main(){
					else if(intmain.equals("return")){
						intmain = st.nextToken();
						if(intmain.equals("0;")){
							fw.append("\n\nend_if:\n\tmov ax, 4c00h\n\tint 21h");
						}
					}
				}
			if(line.contains("if") && !line.contains("printf") && !line.contains("char") && !line.contains("int") ){
				String cmp = line.replace("else ","");
				cmp = cmp.replace(" ","");
				cmp = cmp.replace("(","");
				cmp = cmp.replace(")","");
				cmp = cmp.replace(">",", ");
				cmp = cmp.replace("<",", ");
				cmp = cmp.replace(">=",", ");
				cmp = cmp.replace("<=",", ");
				cmp = cmp.replace("==",", ");
				cmp = cmp.replace("if", "cmp ");
				
				if(line.contains("else if")){
					fw.append("\n label" + j + ":\n\t" + cmp);
					j++;
					//lolzzzz huhu
					;
					if(line.contains(">"))
						fw.append("\n\tjl label" + j + "\n");				
					if(line.contains("<"))
						fw.append("\n\tjg label" + j + "\n");				
					if(line.contains(">="))
						fw.append("\n\tjle label" + j + "\n");				
					if(line.contains("<="))
						fw.append("\n\tjge label" + j + "\n");	
					if(line.contains("=="))
						fw.append("\n\tjne label" + j + "\n");	
					if(line.contains("!="))
						fw.append("\n\tje label" + j + "\n");
					
				}
				else if(line.contains("if")){
					fw.append("\n\n\t" + cmp);
					if(line.contains(">"))
						fw.append("\n\tjl label" + j + "\n");				
					if(line.contains("<"))
						fw.append("\n\tjg label" + j + "\n");				
					if(line.contains(">="))
						fw.append("\n\tjle label" + j + "\n");				
					if(line.contains("<="))
						fw.append("\n\tjge label" + j + "\n");
					if(line.contains("=="))
						fw.append("\n\tjne label" + j + "\n");
					if(line.contains("!="))
						fw.append("\n\tje label" + j + "\n");	
					}
				line = buffer.readLine();
				if(line.contains("printf") && line.contains("%d") || line.contains("%i") || line.contains("%c")){
					tobeprinted = line.substring(line.indexOf(", ")+2, line.indexOf(");"));
					fw.append("\n\tadd " +  tobeprinted + ", '0'");
					fw.append("\n\tmov dl, " + tobeprinted);
					fw.append("\n\tmov ah, 02h");
					fw.append("\n\tint 21h\n");
					
					if(printforlooplater == true){
						parseforloop(forlooptobeprinted, tokenizer, fw);
					}
					
					fw.append("\n\tjmp end_if\n");
					
				}
			}
			else if(line.contains("else")){
				fw.append("\nlabel" + j + ":\n\t");	
			}
			if(line.contains("printf") && line.contains("%d") || line.contains("%i") || line.contains("%c")){
				tobeprinted = line.substring(line.indexOf(", ")+2, line.indexOf(");"));
				fw.append("\n\tadd " +  tobeprinted + ", '0'");
				fw.append("\n\tmov dl, " + tobeprinted);
				fw.append("\n\tmov ah, 02h");
				fw.append("\n\tint 21h\n");
				
				if(printforlooplater == true){
					parseforloop(forlooptobeprinted, tokenizer, fw);
				}
				
			}
			if(line.contains("printf") && line.contains("%c")){
				tobeprinted = line.substring(line.indexOf(", ")+2, line.indexOf(");"));
				fw.append("\n\tmov dl, " + tobeprinted);
				fw.append("\n\tmov ah, 02h");
				fw.append("\n\tint 21h\n");
				
			}
			if(line.contains("printf") && line.contains("%c") || line.contains("%s") || line.contains("%i") || line.contains("%d")){
				if(printforlooplater == true){
					parseforloop(forlooptobeprinted, tokenizer, fw);
				}
			}
			
			if(line.contains("for")){
				
				printforlooplater = true;
				
				line = line.replaceAll("for", "");
				line = line.replaceAll(" ", "");
				line = line.replace(")", "");
				line = line.replace("(", "");
				
				forlooptobeprinted = line;
				
				tokenizer = new StringTokenizer(line,";");
				String token = "";
				if(tokenizer.hasMoreElements()){
					token = tokenizer.nextToken();
					if(token.contains("=")){
						token = token.replace("\t", "");
						token = token.replace(" ", "");
						token = token.replace("=", ", ");
						fw.append("\n\tmov " + token);
						fw.append("\n\nforloop_block:");
					}
				}
			}
			else if(line.contains("+=")){
				parseoperation(line, fw);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void checkhead(String line, FileWriter fw){
		try {
			
			if(line.contains("printf") && !line.contains("%d") && !line.contains("%s") && !line.contains("%c") && !line.contains("%i")){
				int apostrophe1 = line.indexOf("\"");
				int apostrophe2 = line.lastIndexOf("\"");
				String var1 = line.substring(apostrophe1, apostrophe2+1);
				var1 = var1.replaceAll("\\\\n", "\", 10 , \"");
				var1 = var1.replaceAll(", \"\"", "");
				var1 = var1.replaceAll("'", "\", 39 ,\"");
				var1 = var1.replaceAll("\"", "'");
				var1 = "\n\t" + message + i + " db " + var1 + ", \"$\"";
				fw.append(var1);
				i++;
			}
			if(line.contains("printf") && line.contains("%d") || line.contains("%s") || line.contains("%c") || line.contains("%i")){
				int apostrophe1 = line.indexOf("\"");
				int apostrophe2 = line.lastIndexOf("\"");
				
				String var1 = line.substring(apostrophe1+1, apostrophe2+1-1);
				if(!var1.equals("%d") && !var1.equals("%s") && !var1.equals("%c") && !var1.equals("%i") && var1.contains("\n")){
					var1 = line.substring(apostrophe1, apostrophe2+1);
					var1 = var1.replaceAll("%d", "");
					var1 = var1.replaceAll("%s", "");
					var1 = var1.replaceAll("%c", "");
					var1 = var1.replaceAll("\\\\n", "\", 10 , \"");
					var1 = var1.replaceAll(", \"\"", "");
					var1 = var1.replaceAll("'", "\", 39 ,\"");
					var1 = var1.replaceAll("\"", "'");
					var1 = "\n\t" + message + i + " db " + var1 + ", \"$\"";
					fw.append(var1);
					i++;
				}
				if(var1 != "" && !var1.equals("%d") && !var1.equals("%s") && !var1.equals("%c") && !var1.equals("%i")){
					var1 = var1.replaceAll("%d", "");
					var1 = var1.replaceAll("%s", "");
					var1 = var1.replaceAll("%c", "");
					var1 = var1.replaceAll("\\\\n", "10");
					var1 = var1.replaceAll("\"", "");
					var1 = var1.replaceAll(",", "");
					
					var1 = var1.replaceAll(", \"\"", "");
					var1 = var1.replaceAll("'", "\", 39 ,\"");
					if(var1.equals("10")){
						var1 = "\n\t" + message + i + " db " + var1 + ", \"$\"";
					}
					else
						var1 = "\n\t" + message + i + " db '" + var1 + "', \"$\"";
					fw.append(var1);
					i++;
				}
			}
			if(line.contains("char") && line.contains("[") && line.contains("]")){
				line = line.substring(line.indexOf("]")+2, line.length());
				int apostrophe1 = line.indexOf("\"");
				int apostrophe2 = line.lastIndexOf("\"");
				
				String var1 = line.substring(apostrophe1+1, apostrophe2+1-1);
				
				if(line.endsWith(";")){
					line = line.replace(";",", \"$\"");
					line = line.replace("="," db ");

					line = line.replaceAll("\\\\n", "\", 10 , \"");
					line = line.replaceAll(", \"\"", "");
					line = line.replaceAll("'", "\", 39 ,\"");
					line = line.replaceAll("\"", "'");
					
				}
				fw.append("\n\t"+line);
			}
		StringTokenizer st = new StringTokenizer(line," ");
		int index = 0;
		String newline = "";

		while(st.hasMoreElements()){
			String var = st.nextToken();
			
			if(var.equals("int")){
				line   = line.replaceAll("int", "");
				var = st.nextToken();
				//int is a data type with two cases

				if(var.endsWith(";")){
					line = var.replace(";","") + " db ?";
					fw.append("\n\t"+line);
					list = savetoarray(line, list, fw);
					stringArr2 = list.toArray(new String[0]);
				}
				else if(var.endsWith(",")){
					index = line.indexOf("//");
					if(index > -1){
						newline = line.substring(index, line.length());
						line = line.substring(0, index);
					}
					StringTokenizer comma = new StringTokenizer(line,",");
					while(comma.hasMoreElements()){
						line = comma.nextToken();
						line = line.replaceAll(" ", "");
						line = line.replaceAll("=", " db ");
						line = line.replaceAll(";", "");
						
						
						fw.append("\n\t"+line + " db ?");
					}
					
				}
				else if(!var.equals("main") && !var.equals("main()") && !var.equals("main(){")){
					if(st.hasMoreElements()){
						String equals = st.nextToken();
						if(equals.equals("=")){
							index = line.indexOf("//");
							if(index > -1){
								newline = line.substring(index, line.length());
								line = line.substring(0, index);
							}
							StringTokenizer comma = new StringTokenizer(line,",");
							while(comma.hasMoreElements()){
								line = comma.nextToken();
								line = line.replaceAll(" ", "");
								line = line.replaceAll("=", " db ");
								line = line.replaceAll(";", "");
								if(line.contains("+") || line.contains("-") || line.contains("*") || line.contains("/")){
									add(line, addthese, fw);
									index = line.indexOf("db");
									String variables = line.substring(index+2, line.length());
									line = line.replace(variables, " ?");
								}
								else{
									list = savetoarray(line, list, fw);
									stringArr2 = list.toArray(new String[0]);
								}
								fw.append("\n\t"+line);
							}
						}
					}
				}
			}
			if(var.startsWith("//")){
				fw.append(" " + newline.replaceAll("//", ";"));
			}
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void parseoperation(String line, FileWriter fw) throws IOException {
		line = line.replace(" ", "");
		List<String> performOp = new ArrayList<String>();
		String tobeadded = "";
		for(int i = 0; i<line.length(); i ++){
			if(line.charAt(i) == '+'){
				if(line.charAt(i+1) == '='){
					performOp.add("+");
					i++;
				}
				else{
					performOp.add("+");
				}
				performOp.add(tobeadded);
				tobeadded = "";
			}
			else{
				tobeadded += line.charAt(i);
			}
		}
		tobeadded = tobeadded.replace(";", "");
		performOp.add(tobeadded);
		performOpArray = performOp.toArray(new String[0]);
		
		for(int i = performOpArray.length-1; i >0 ; i--){
			if(i == 1){
				if(performOpArray[0] == "+=" || performOpArray[0] == "+")
					fw.append("\n\tadd " + performOpArray[i] + ", bh\n");
				else if(performOpArray[0] == "-=" || performOpArray[0] == "-")
					fw.append("\n\tsub " + performOpArray[i] + ", bh\n");
			}
			else{
				fw.append("\n\tmov bh, " + performOpArray[i]);
			}
		}
	}

	private static void parseforloop(String line, StringTokenizer st, FileWriter fw) throws IOException {
		String printlater = "";
		String token = "";
		st  = new StringTokenizer(line,";");
		printlater = st.nextToken();
		printlater = st.nextToken();
		token = st.nextToken();
		if(line.contains("printf") && line.contains("%d") || line.contains("%i") || line.contains("%c")){
				fw.append("\n\tsub " + tobeprinted + ", '0'\n");
		}
		if(token.contains("++")){
			fw.append("\n\tinc " + token.replace("++", ""));
		}
		else if(token.contains("--")){
			fw.append("\n\tdec " + token.replace("--", ""));
		}
		if(printlater.contains(">")){
			fw.append("\n\tcmp " + printlater.replace(">", ", "));
		}
		if(printlater.contains("<")){
			fw.append("\n\tcmp " + printlater.replace("<", ", "));
			fw.append("\n\tjl forloop_block\n");
		}
	}

	private static void printadd(List<String> list, FileWriter fw) throws IOException {
		if(list!=null && addthesevalues!=null){
			fw.append("\n\tmov ah, " +addthesevalues[0]);
			for(int j = 0 ; j< addthesevalues.length; j++){
				if(operationsArray[j].equals("+")){
					fw.append("\n\tadd ah, " +addthesevalues[j+1]);
				}
				else if (operationsArray[j].equals("-")){
					fw.append("\n\tsub ah, " +addthesevalues[j+1]);
				}
			}

			listresultarray = list.toArray(new String[0]);
			for(int k = 0 ; k< listresultarray.length; k++){
				fw.append("\n\tmov " + listresultarray[k] + ", ah");
			}
		}
		if(stringArr2!=null){
			for(int k = 0 ; k< stringArr2.length-1; k++){
				if( stringArr2[k].equals("?")){
					fw.append("\n\tmov " + stringArr2[k-1] + ", 0");
				}
			}
		}
	}

	private static List<String> savetoarray(String line, List<String> list, FileWriter fw) {
		int index = line.indexOf("db");
		String var = line.substring(0, index);
		list.add(var);
		var = line.substring(index+3, line.length());
		list.add(var);
		return list;
	}

	private static void add(String line, List<String> addthese, FileWriter fw) {
		int index = line.indexOf("db");
		String tobeadded = "";

		String result = line.substring(0, index);//sum
		listresult = new ArrayList<String>();
		operations = new ArrayList<String>();
		listresult.add(result);

		line = line.substring(index+3,line.length());
		
		for(int i =0; i<line.length();i++){
			if(line.charAt(i) == '+' || line.charAt(i) == '-' || line.charAt(i) == '*' || line.charAt(i) == '/'){
				addthese.add(tobeadded);
				operations.add(""+line.charAt(i));
				tobeadded = "";
			}
			else{
				tobeadded += line.charAt(i);
			}
		}
		addthese.add(tobeadded);
		operations.add("");
		addthesevalues = addthese.toArray(new String[0]);
		operationsArray = operations.toArray(new String[0]);
		
	}
}
