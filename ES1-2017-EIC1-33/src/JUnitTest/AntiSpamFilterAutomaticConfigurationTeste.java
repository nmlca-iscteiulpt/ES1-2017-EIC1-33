package JUnitTest;

import java.io.IOException;

import org.junit.Test;

import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;

public class AntiSpamFilterAutomaticConfigurationTeste {

	@Test
	public void test() throws IOException {
		AntiSpamFilterAutomaticConfiguration aac = new  AntiSpamFilterAutomaticConfiguration();
		aac.auto();

	}

}
