import java.io.*;
import java.util.*;

public class AssemblerPrinting {

	public static String line = null;
	public static String message = "message";
	public static void main(String[] args) throws IOException {
		
		try{
			BufferedReader buffer= new BufferedReader(new FileReader("C/Test1.c"));
			FileWriter fw = new FileWriter("convertedtest1.asm", true);
			
			String line = buffer.readLine();
			int i = 0;
			System.out.print("\n.model small\n.data");
			while (line!=null) {
				if(line.contains("printf")){
					int apostrophe1 = line.indexOf("\"");
					int apostrophe2 = line.lastIndexOf("\"");
					String var1 = line.substring(apostrophe1, apostrophe2+1);
					//var1 = var1.replaceAll("(\r\n|\n)", "13d");
					//System.out.println(var1);
					var1 = var1.replaceAll("\\\\n", "\", 10 , \"");
					var1 = var1.replaceAll(", \"\"", "");
					var1 = var1.replaceAll("'", "\", 39 ,\"");
					var1 = var1.replaceAll("\"", "'");
					var1 = "\n\t" + message + i + " db " + var1 + ", \"$\"";
					System.out.print(var1);
					i++;
				}
				line = buffer.readLine();
			}
			
			fw.close();
			buffer.close();
			
			buffer= new BufferedReader(new FileReader("C/Test1.c"));
			fw = new FileWriter("convertedtest1.asm", true);
			
			line = buffer.readLine();
			i = 0;
			System.out.print("\n.stack 100h\n.code");
			while (line!=null) {
				if(line.contains("printf")){
					System.out.print("\n\n\tlea dx, " + message + i);
					System.out.print("\n\tmov ah, 09h");
					System.out.print("\n\tint 21h");
					i++;
				}
				else{
					StringTokenizer st = new StringTokenizer(line," ");
					while(st.hasMoreElements()){
						String intmain = st.nextToken();
						//Check all cases of int main(){
						if(intmain.equals("int")){
							intmain = st.nextToken();
							if(intmain.equals("main(){")){
								//fw.append("main proc");
								System.out.print("\n\tmain proc\n\tmov ax, @data\n\tmov ds, ax");
							}
							else if(intmain.equals("main")){
								intmain = st.nextToken();
								if(intmain.equals("()")){
									intmain = st.nextToken();
									if(intmain.equals("{")){
										System.out.print("\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax");
									}
								}
								else if(intmain.equals("(){")){
									System.out.print("\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax");
								}
							}
							if(intmain.equals("main()")){
								if(st.hasMoreElements()){
									intmain = st.nextToken();
									if(intmain.equals("{")){
										System.out.print("\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax");
									}
								}
								else{
									line = buffer.readLine();
									st = new StringTokenizer(line," ");
									intmain = st.nextToken();
									if(intmain.equals("{")){
										System.out.print("\n\tmain proc\n\n\tmov ax, @data\n\tmov ds, ax");
									}
								}
							}
						}//end of Check all cases of int main(){
						else if(intmain.equals("return")){
							intmain = st.nextToken();
							if(intmain.equals("0;")){
								System.out.print("\n\n\tmov ax, 4c00h\n\tint 21h");
							}
						}
						else if(intmain.equals("}")){
							System.out.print("\n\n\tmain endp\n\tend main");
						}
					}
				}
				line = buffer.readLine();
			}

			fw.close();
			buffer.close();
		}

			
			catch(IOException e){
				e.printStackTrace();
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}
	}


}
