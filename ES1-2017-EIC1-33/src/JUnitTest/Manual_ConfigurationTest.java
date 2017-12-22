package JUnitTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import antiSpamFilter.Manual_Configuration;

public class Manual_ConfigurationTest {

	@Test
	public void test() {
		Manual_Configuration mc = new Manual_Configuration();
		mc.start();
		int[] valores = new int[335];
		mc.setValores(valores);
		mc.getValores();
	}
}
