package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IniciarAuto {
	private Gui_Cliente gui;
	private static ArrayList<String> val = new ArrayList<String>();
	private static ArrayList<String> reg = new ArrayList<String>();
	
	public IniciarAuto(Gui_Cliente gui){
		this.gui=gui;
	} 
	
	public void start() {  
		try {
			AntiSpamFilterAutomaticConfiguration.auto();
			results();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

	}
 public void results() {
		Scanner s = new Scanner("experimentBaseDirectory/results/AntiSpamFilterProblem.rf");
		File file = new File(s.nextLine());
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (s.hasNext()) {
			String line = s.nextLine();
			val.add(line);
		}
		
		s.close();
		int count=0;
		double max=335;
		int linha=0;
		for(String w:val){
			String[] parts = w.split(" ");
			if(Double.parseDouble(parts[0])<max){
				max=Double.parseDouble(parts[0]);
				linha=count;
			}
			count++;
		}
		
		Scanner d = new Scanner("experimentBaseDirectory/results/AntiSpamFilterProblem.rs");
		File file2 = new File(d.nextLine());
		try {
			d = new Scanner(file2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (d.hasNext()) {
			String line2 = d.nextLine();
			reg.add(line2);
		}
		d.close();
		String lin = reg.get(linha);
		String[] partes = lin.split(" ");
		for(int i=0;i<335;i++){
			gui.getModel3().addElement(i + "->" + partes[i]);
		}
		
	}

public static ArrayList<String> getVal() {
	return val;
}

public static void setVal(ArrayList<String> val) {
	IniciarAuto.val = val;
}

public static ArrayList<String> getReg() {
	return reg;
}

public static void setReg(ArrayList<String> reg) {
	IniciarAuto.reg = reg;
}

}
