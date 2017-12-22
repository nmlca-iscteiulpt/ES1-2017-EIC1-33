package JUnitTest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;
import antiSpamFilter.Gui_Cliente;
import antiSpamFilter.IniciarAuto;

public class IniciarTeste {

	@Test
	public void testIniciarAuto() {
		Gui_Cliente gui = new Gui_Cliente();
		IniciarAuto ia =new  IniciarAuto(gui);
		ia.results();
	}

	@Test
	public void testStart() {
		AntiSpamFilterAutomaticConfiguration aac = new  AntiSpamFilterAutomaticConfiguration();
		try {
			aac.auto();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
