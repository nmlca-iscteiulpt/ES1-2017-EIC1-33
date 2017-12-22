package JUnitTest;

import static org.junit.Assert.*;

import javax.swing.JList;
import javax.swing.JTextPane;

import org.junit.Test;

import antiSpamFilter.Gui_Cliente;

public class Gui_ClienteTeste {

	@Test
	public void test() {
		Gui_Cliente gui = new Gui_Cliente();
		JTextPane FP1 = new JTextPane();
		JTextPane FN1 = new JTextPane();
		JTextPane FP2 = new JTextPane();
		JTextPane FN2 = new JTextPane();
		JList<String> boxrightauto = new JList<String>();
		gui.addFrameContent();
		String[] args = null;
		gui.main(args);
		gui.getBoxrightmanual();
		gui.getFP1() ;
		gui.setFP1(FP1);
		gui.getFN1();
		gui.setFN1( FN1);
		gui.getFP2();
		gui.setFP2( FP2);
		gui.getFN2();
		gui.setFN2( FN2);
		gui.setBoxrightauto(boxrightauto);
	}
}
