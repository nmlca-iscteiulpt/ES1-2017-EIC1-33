package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import antiSpamFilter.Gui_Cliente;
import antiSpamFilter.IniciarAuto;

public class IniciarAutoTeste {

	@Test
	public void test() {
		Gui_Cliente gui = new Gui_Cliente();
		IniciarAuto ia =new  IniciarAuto(gui);
		ia.start();
		ia.results();
	}

	public IniciarAutoTeste() {
		super();
	}
}
