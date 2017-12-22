package antiSpamFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AvaliarAuto {
	
	private ArrayList<String> mspam = ReadFiles.getSpam();
	private ArrayList<String> mham = ReadFiles.getHam();
	private ArrayList<String> mrules = ReadFiles.getRules();
	private String[] mval = new String[335];
	private Gui_Cliente gui;
	
	public AvaliarAuto(Gui_Cliente gui){
		this.gui=gui;
	}
	
	public void avaliarAuto() { 
		int t=0;

		File file = new File("AntiSpamConfigurationForProfessionalMailbox/saveAutoConf.txt");
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
		gui.getFN2().setText("FN: " + fn);
		
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
		gui.getFP2().setText("FP: "+ fp);
		s.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public ArrayList<String> getMspam() {
		return mspam;
	}

	public void setMspam(ArrayList<String> mspam) {
		this.mspam = mspam;
	}

	public ArrayList<String> getMham() {
		return mham;
	}

	public void setMham(ArrayList<String> mham) {
		this.mham = mham;
	}

	public ArrayList<String> getMrules() {
		return mrules;
	}

	public void setMrules(ArrayList<String> mrules) {
		this.mrules = mrules;
	}
	}