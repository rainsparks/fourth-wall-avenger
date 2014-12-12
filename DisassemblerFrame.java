import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


import javax.swing.*;


public class DisassemblerFrame extends JFrame implements ActionListener {
	
	static PrintWriter outputStream = null;
	 JTextField input=new JTextField(15);
	 JTextField result=new JTextField();
    public DisassemblerFrame() {
        initUI();
    }

    public final void initUI() {
    
       JPanel panel = new JPanel();
       getContentPane().add(panel);
       panel.setLayout(null);
       panel.setBackground(Color.black);
       
       
       JLabel title=new JLabel("     DISASSEMBLER");
       title.setForeground(Color.GRAY);
       title.setFont(new Font("Courier", Font.BOLD, 26));
       title.setBounds(70, 20, 200, 200);
       title.setSize(350,100);
       
       panel.add(title);
       
     
       JLabel instruc=new JLabel("Enter file name to convert(including filepath):");
       instruc.setForeground(Color.GRAY);
       instruc.setFont(new Font("Courier", Font.BOLD, 11));
       instruc.setBounds(90, 70, 200, 200);
       instruc.setSize(350,100);
       
       panel.add(instruc);
       
       
      
       input.setForeground(Color.GRAY);
       input.setFont(new Font("Courier", Font.BOLD, 15));
       input.setBounds(90, 150, 200, 200);
       input.setSize(300,50);
       
       panel.add(input);
       
       JButton submit = new JButton("Submit");
       submit.setBackground(Color.GRAY);
       submit.setForeground(Color.WHITE);
       submit.setFocusPainted(false);
       submit.setFont(new Font("Arial", Font.BOLD, 12));
       submit.setBounds(200, 210, 80, 30);
       submit.setSize(80,50);
       
       submit.addActionListener(this);

       panel.add(submit);
       
       result.setForeground(Color.black);
       result.setFont(new Font("Courier", Font.BOLD, 11));
       result.setBounds(15, 280, 200, 200);
       result.setSize(450,50);
       result.setEditable(false);
       
       panel.add(result);
       
       setTitle("Assembler/Disassembler");
       setSize(500, 400);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
      
           DisassemblerFrame x = new DisassemblerFrame();
           x.setVisible(true);
      
    }


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-public void actionPerformed(ActionEvent event e) {
		if(e.getActionCommand().equals("Submit"))
		{
			String filename = input.getText().trim();
			String newfilename = "", filenameout ="";
			
			String header = "#include <stdio.h>";
			String main = "int main(){";
			String endmain = "}";
			
			if(filename.contains("/") && filename.contains(".asm")){
				newfilename = filename.substring(filename.lastIndexOf("/")+1,filename.indexOf(".asm"));
			}
			else if (filename.contains(".asm")){
				newfilename = filename.substring(0, filename.indexOf(".asm"));
			}
			
			System.out.println(newfilename);
			filenameout = "AsmConverted/converted"+newfilename+".c";
			result.setText("File successfully converted to " +filenameout);
			
		try{
			outputStream = new PrintWriter(new FileOutputStream(filenameout));
			
			System.out.println("Opening file " + filename + "...");
			
			try{
				BufferedReader inputStream = new BufferedReader(new FileReader(filename));
				String str;
				
				//save it in an array:
		        List<String> list = new ArrayList<String>();
		        while((str = inputStream.readLine()) != null){
		            list.add(str);
		        }
		        String[] stringArr = list.toArray(new String[0]);
		        //print array to console:
		        for(int i=0;i<stringArr.length;i++){
		        	System.out.println("line "+ i + ": " + stringArr[i]);
		        }
		        
		        int noOfLines = stringArr.length;
		        
		        int startOfMain=0;
		        //find the start of main
		        for(int i=0; i<noOfLines; i++){
		        	if(stringArr[i].contains("main proc")){
		        		startOfMain = i+1;
		        		break;
		        	}
		        }
		        System.out.println("\nStart of main: Line " + startOfMain +"\n");

		        
		        System.out.println(filenameout + " would contain:\n");
		        
		        //PRINT OUTPUT TO CONSOLE FIRST
		        
		        System.out.println(header);
		        System.out.println(main);
		        
		        outputStream.println(header);
		        outputStream.println(main);
		        
		        //VARIABLES
		        for(int i=0; i<stringArr.length; i++){
		        	variables(stringArr, startOfMain, i);
		        }
		        //MAIN
		        
		        for(int i=startOfMain; i<stringArr.length; i++){
		        	if(stringArr[i].contains("mov ah") && stringArr[i].contains("01h")){
		        		input(stringArr,i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("mov dl")){
		        		printDigit(stringArr, i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("lea dx")){
		        		printString(stringArr,i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("cmp")){
		        		compare(stringArr, i, startOfMain);
		        	}
		        	
		        	if(stringArr[i].trim().contains("add")){
		        		add(stringArr,i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("sub")){
		        		subtract(stringArr,i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("inc") || stringArr[i].trim().contains("dec")){
		        		IncDec(stringArr, i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("loop")){
		        		loop(stringArr, i);
		        	}
		        	
		        	if(stringArr[i].trim().contains("mov ax, 4c00h")||stringArr[i].trim().contains("mov ax, 4ch")){
		        		System.out.println("\n   return 0;");
		        		outputStream.println("\n   return 0;");
		        	}
		        }
		        
		        System.out.println(endmain);
		        outputStream.println(endmain);
		        inputStream.close();
			}
		
			catch(Exception a){
				result.setText("Error reading from " + filename + ".");
				System.out.println("Error reading from " + filename + ".");
			}
			
			outputStream.close();
		}
		
		catch(Exception a){
			result.setText("Error  writing to " + filenameout + ".");
			System.out.println("Error  writing to " + filenameout + ".");
		}
		}
			
	}
		

		public static void printDigit(String[] stringArr, int i){ //array and ith line
			String printChar= "";
			if(stringArr[i-1].trim().contains("mov ah, 02h") || stringArr[i+1].trim().contains("mov ah, 02h")){
				String perLine[] = stringArr[i].split(" ");
				printChar = perLine[perLine.length-1];
				printChar = printChar.replaceAll("'", "");
				
			}
			
			//System.out.println("   printf(%d, "+ printChar + ");\n" );	
			System.out.println("   printf( \"%c\", "+ printChar + ");" );
			outputStream.println("   printf( \"%c\", "+ printChar + ");" );
		}
		
		public static void printString(String[] stringArr, int i){
			String printString="";
			if(stringArr[i-1].trim().contains("mov ah, 09h") || stringArr[i+1].trim().contains("mov ah, 09h")){
				String perLine[] = stringArr[i].split(" ");
				printString = perLine[perLine.length-1];
				printString = printString.replaceAll("'", "");
			}
			
			System.out.println("   printf( \"%s\", "+ printString + ");" );
			outputStream.println("   printf( \"%s\", "+ printString + ");" );
		}
		
		
		public static void compare(String[] stringArr, int i, int startOfMain){
			String compare1,compare2,label;
			
			String perLine[] = stringArr[i].trim().split(" ");
			compare1 = perLine[1];
			compare1 = compare1.replace(",", "");
			compare2 = perLine[2];
			compare2 = compare2.replace("'", "");
			
			if(compare2.contains("al") || compare2.contains("ah") || compare2.contains("bl")|| compare2.contains("bh")
					|| compare2.contains("cl") || compare2.contains("ch") || compare2.contains("dl") || compare2.contains("dh")
					|| compare2.contains("ax") || compare2.contains("bx") || compare2.contains("cx") || compare2.contains("dx")){
				String prev1, prev2;
				String prev[] = stringArr[i-1].trim().split(" ");
				prev1 = prev[1];
				prev2 = prev[2];
				prev2 = prev2.replace(",", "");
				compare2 = prev2;
				
			}
			if(stringArr[i+1].contains("jl")){
				System.out.println("   if(" + compare1 + " < "  + compare2 + "){");
				outputStream.println("   if(" + compare1 + " < "  + compare2 + "){");
				
				String[] word = stringArr[i+1].split(" ");
				label = word[1];
			}
			
			else if(stringArr[i+1].contains("je")){
				System.out.println("   if(" + compare1 + " == "  + compare2 + "){");
				outputStream.println("   if(" + compare1 + " == "  + compare2 + "){");
				
				String[] word = stringArr[i+1].split(" ");
				label = word[1];
				
			}
			
			else if(stringArr[i+1].contains("jg")){
				System.out.println("   if(" + compare1 + " > "  + compare2 + "){");
				outputStream.println("   if(" + compare1 + " > "  + compare2 + "){");
				
				String[] word = stringArr[i+1].split(" ");
				label = word[1];
				
			}
			
			else if (stringArr[i+1].contains("jmp")){
				String[] word = stringArr[i+1].split(" ");
				label = word[1];
				label = label + ":";
				for(int q=startOfMain; q<stringArr.length; q++){
					if(stringArr[q].contains(label)){
						i=q;
						break;
					}
				}			
				System.out.println();
				outputStream.println();
			}
			//System.out.println("   }");
		}
		
		private static void add(String[] stringArr, int i) {
			String add1, add2;
			String perLine[] = stringArr[i].trim().split(" ");
			add1 = perLine[1];
			add1 = add1.replace(",", "");
			add2 = perLine[2];
			add2 = add2.replace("'", "");
			
			if(add1.trim()=="ah" || add1.trim()=="al" || add1.trim()=="ax" || add1.trim()=="bh"
					|| add1.trim()=="bl" || add1.trim()=="bx"){
				//System.out.println("   "  + add1 + " = " + add1 + " + " + add2 + ";");
			}
			else{
				System.out.println("   "  + add1 + " = " + add1 + " + " + add2 + ";");
				outputStream.println("   "  + add1 + " = " + add1 + " + " + add2 + ";");
			}
		}
		
		private static void subtract(String[] stringArr, int i) {
			String sub1, sub2;
			String perLine[] = stringArr[i].trim().split(" ");
			sub1 = perLine[1];
			sub1 = sub1.replace(",", "");
			sub2 = perLine[2];
			sub2 = sub2.replace("'", "");
			
			if(sub1.trim()=="ah" || sub1.trim()=="al" || sub1.trim()=="ax" || sub1.trim()=="bh"
					|| sub1.trim()=="bl" || sub1.trim()=="bx"){
				//System.out.println("   "  + add1 + " = " + add1 + " + " + add2 + ";");
			}
			else{
				System.out.println("   "  + sub1 + " = " + sub1 + " - " + sub2 + ";");
				outputStream.println("   "  + sub1 + " = " + sub1 + " - " + sub2 + ";");
			}
		}
		
		private static void IncDec(String[] stringArr, int i){
			
			String var="";
			if(stringArr[i].contains("inc")){
				String[] words = stringArr[i].split(" ");
				var = words[1];
				System.out.println("   " + var + "++;");
				outputStream.println("   " + var + "++;");
			}
			
			else if(stringArr[i].contains("dec")){
				String[] words = stringArr[i].split(" ");
				var = words[1];
				System.out.println("   " + var + "--;");
				outputStream.println("   " + var + "--;");
			}
		
		}
		
		private static void loop(String[] stringArr, int i){
			
		}
		
		private static void input(String[] stringArr, int i){
			String input = "" ;
			if(stringArr[i+2].contains("mov") && stringArr[i+2].contains("al")){
				String[] line = stringArr[i+2].split(" ");
				input = line[1];
				input = input.replace(",", "");
			}
			else if(stringArr[i+3].contains("mov") && stringArr[i+3].contains("al")){
				String[] line = stringArr[i+3].split(" ");
				input = line[1];
				input = input.replace(",", "");
			}
			
			System.out.println("\n   scanf( \"%c\" " + input +");");
			outputStream.println("\n   scanf( \"%c\" " + input +");");
		}
		
		public static void variables(String[] stringArr, int startOfMain, int i){
			String variable="";
			String value="";
			String strValue="";
			
	        	if(stringArr[i].trim().contains("db")){
	        		String perLine[] = stringArr[i].trim().split(" ");
	        		variable = perLine[0];
	        		if(perLine.length>3){
	        			for(int k=2; k< perLine.length; k++){
	        				if(perLine[k].trim().contains("10")){
	        					perLine[k] = "\\n";
	        				}
	        				if(perLine[k].trim().contains("$") || perLine[k].trim().contains(",") || perLine[k].trim().contains("\'")){
	        					perLine[k] = perLine[k].replace("$", "");
	        					perLine[k] = perLine[k].replace(",", "");
	        					perLine[k] = perLine[k].replace("\'", "");
	        					
	        				}
	        				if(perLine[k].trim().contains("39")){
	        					perLine[k] = perLine[k].replace("39", "\'");
	        				}
	        				
	        				strValue = strValue + " " + perLine[k]; 
	        				
	        			}
	        			value = strValue; 
	        		}
	        		else{
	        			value = perLine[2];
	        		} 	
	        		
	        		if(perLine[2].contains("0")||perLine[2].contains("1")||perLine[2].contains("2")||perLine[2].contains("3")||
	        				perLine[2].contains("4")||perLine[2].contains("5")||perLine[2].contains("6")||perLine[2].contains("7")
	        				||perLine[2].contains("8")||perLine[2].contains("9")){
	        			System.out.println("   int " + variable + " = "+ value +";");
	        			outputStream.println("   int " + variable + " = "+ value +";");
	        		}
	        		else if(perLine[2].length()==1 && perLine[2].equalsIgnoreCase("a")){
	        			System.out.println("   char " + variable + " = "+ value +";");
	        			outputStream.println("   char " + variable + " = "+ value +";");
	        		}
	        		else if(perLine[2].equals("?")){
	        			System.out.println("   int " + variable + ";");
	        			outputStream.println("   int " + variable + ";");
	        		}	
	        		else{
	        			System.out.println("   char[] " + variable + " = \""+ value +"\";");
	        			outputStream.println("   char[] " + variable + " = \""+ value +"\";");
	        		}
	        		
	        	}
	        
		}
	}

		
