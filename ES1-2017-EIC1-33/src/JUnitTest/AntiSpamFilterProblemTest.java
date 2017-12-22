package JUnitTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.uma.jmetal.solution.DoubleSolution;

import antiSpamFilter.AntiSpamFilterProblem;
public class AntiSpamFilterProblemTest {

	@Test
	public void test() {
		ArrayList<String> pa = new ArrayList<String>();
		pa.add(" oixdhvndfjkbC  Us  ers  bruno_000  work  ozsfnsdçkv  slkdj  knspace  ES1-2017  g.txt");
		pa.add("C:Users   bruno_000 worksxlmfbmdth  dnb  jdrs  rg  drg  db pace  ES1-201 Ficheiro   rules.cf"); 
		pa.add("C:Usersbrumkz  dlbgx sdfmr  lkdgs  erhgsr  rth  rth trno_000  workspace  ES1-2017  Ficheiros\\spam.log.txt");
		AntiSpamFilterProblem asp =new AntiSpamFilterProblem();
		DoubleSolution n = asp.createSolution();
		asp.setMham(pa); 
		asp.setMrules(pa);
		asp.setMspam(pa);
		asp.evaluate(n); 
		asp.getMham();
		asp.getMrules(); 
		asp.getMspam();
	}

}
