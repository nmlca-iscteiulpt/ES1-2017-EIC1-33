package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AvaliarManual {
	
	private static ArrayList<String> mspam = ReadFiles.getSpam();
	private static ArrayList<String> mham = ReadFiles.getHam();
	private static ArrayList<String> mrules = ReadFiles.getRules();
	private String[] mval = new String[335];
	private Gui_Cliente gui;
	
	public AvaliarManual(Gui_Cliente gui){
		this.gui=gui;
	}
	
	public void avaliar() {
		int t=0;

		File file = new File("GravarConfiguraçaoManual/saveManualConf.txt");
		try {
			Scanner s = new Scanner(file);
		
		while (s.hasNextLine()) {
			String line = s.nextLine();	
			mval[t]=line;
			t++;
		}
		
		int fn=0;
		for(String w:mspam){
			double count=0;
			String[] parts = w.split("	");
			for(int v=1;v<parts.length;v++){
				for(String u:mrules){
					if(u.equals(parts[v]))
						count=count+(Double.parseDouble(mval[mrules.indexOf(u)]));
				}	
			}
			if (count < 5)
				fn++;
		} 
		gui.getFN1().setText("FN: " + fn);
		
		int fp = 0;
		for(String h:mham){
			double count=0;
			String[] parts = h.split("	");
			for(int v=1;v<parts.length;v++){
				for(String u:mrules){
					if(u.equals(parts[v]))
						count=count+(Double.parseDouble(mval[mrules.indexOf(u)]));
				}
			}
			if (count > 5)
				fp++;
		} 
		gui.getFP1().setText("FP: "+ fp);
		s.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static ArrayList<String> getMspam() {
		return mspam;
	}

	public static void setMspam(ArrayList<String> mspam) {
		AvaliarManual.mspam = mspam;
	}

	public static ArrayList<String> getMham() {
		return mham;
	}

	public static void setMham(ArrayList<String> mham) {
		AvaliarManual.mham = mham;
	}

	public static ArrayList<String> getMrules() {
		return mrules;
	}

	public static void setMrules(ArrayList<String> mrules) {
		AvaliarManual.mrules = mrules;
	}

}
