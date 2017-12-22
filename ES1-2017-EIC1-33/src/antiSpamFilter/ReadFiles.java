package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles {

		private static ArrayList<String> ham = new ArrayList<String>();
		private static ArrayList<String> spam = new ArrayList<String>();
		private static ArrayList<String> rules = new ArrayList<String>();
		private static ArrayList<String> p = Gui_Cliente.getPaths();
		
		public ReadFiles() {

		}

		public static void lerFicheiros() {

			for (int i=0; i < p.size(); i++) { 

				if(i == 0) { //	ler o ficheiro rules e adicionar á lista    

					File f = new File(p.get(0));  

					try {
						Scanner s = new Scanner(f);
						while (s.hasNextLine()) {
							String line = s.nextLine();	
							rules.add(line);
						}	
						s.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
				}  

				if(i==1) { // ler o ficheiro spam e adicionar á lista

					File f = new File(p.get(1));

					try {
						Scanner s = new Scanner(f);
						while (s.hasNextLine()) {
							String line = s.nextLine();	
							spam.add(line);
						}	
						s.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
				}

				if(i==2) { // ler o ficheiro ham e adicionar á lista

					File f = new File(p.get(2));

					try {
						Scanner s = new Scanner(f);
						while (s.hasNextLine()) {
							String line = s.nextLine();	
							ham.add(line);
						}	
						s.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} 
				}  
			}
		}

		public static ArrayList<String> getHam() {
			return ham;
		}

		public static ArrayList<String> getSpam() {
			return spam;
		}

		public static ArrayList<String> getRules() {
			return rules;
		}

		public static void setP(ArrayList<String> p) {
			ReadFiles.p = p;
		}
		
	}
