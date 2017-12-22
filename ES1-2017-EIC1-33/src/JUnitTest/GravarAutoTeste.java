package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import antiSpamFilter.GravarAuto;
import antiSpamFilter.Gui_Cliente;

public class GravarAutoTeste {

	@Test
	public void test() { 
		Gui_Cliente gui = new Gui_Cliente();
		GravarAuto ga = new GravarAuto(gui);
		ga.gravar();
	}

}
