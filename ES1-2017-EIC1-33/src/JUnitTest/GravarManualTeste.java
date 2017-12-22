package JUnitTest;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

import antiSpamFilter.GravarManual;
import antiSpamFilter.Gui_Cliente;

public class GravarManualTeste {

	@Test 
	public void test() {
		Gui_Cliente gui = new Gui_Cliente();
		GravarManual gm = new GravarManual(gui);
		gm.gravar();
	}
}
