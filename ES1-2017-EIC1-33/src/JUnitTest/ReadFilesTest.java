package JUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import antiSpamFilter.ReadFiles;

public class ReadFilesTest { 

	@Test
	public void testLerFicheiros() {
		ReadFiles x = new ReadFiles();
		ArrayList<String> pa = new ArrayList<String>();
		pa.add("C:\\Users\\bruno_000\\workspace\\ES1-2017\\Ficheiros\\ham.log.txt");
		pa.add("C:\\Users\\bruno_000\\workspace\\ES1-2017\\Ficheiros\\rules.cf"); 
		pa.add("C:\\Users\\bruno_000\\workspace\\ES1-2017\\Ficheiros\\spam.log.txt");
		x.lerFicheiros();
		x.setP(pa);
		x.lerFicheiros(); 
		x.getHam(); 
		x.getRules();
		x.getSpam();
	}
}
