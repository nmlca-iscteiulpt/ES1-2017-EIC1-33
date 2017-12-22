package antiSpamFilter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GravarAuto {
	private Gui_Cliente gui;
	private String[] val = new String[335];

	public GravarAuto(Gui_Cliente gui){
		this.gui=gui; 
	}
	
	public void gravar() {
		try {
			int g=0; 
			for (int i = 0; i < gui.getModel3().size(); i++){
				String line = gui.getModel3().get(i);
				String[] parts = line.split("->");
				val[g]=parts[1];
				g++;
			}
			PrintWriter writer = new PrintWriter("AntiSpamConfigurationForProfessionalMailbox/saveAutoConf.txt");
			for(int i=0; i<335; i++){
				writer.println(val[i]);
			}
			writer.close();
		} catch (FileNotFoundException e) {
		}

	}

}