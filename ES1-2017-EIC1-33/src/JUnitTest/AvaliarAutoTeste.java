package JUnitTest;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import antiSpamFilter.AvaliarAuto;
import antiSpamFilter.Gui_Cliente;

public class AvaliarAutoTeste {


	@Test
	public void test() {
		
		Gui_Cliente gui = new Gui_Cliente();
		ArrayList<String> pa = new ArrayList<String>();
		pa.add(" oixdhvndfjkbC  Us  ers  bruno_000  work  ozsfnsdçkv  slkdj  knspace  ES1-2017  g.txt");
		pa.add("C:Users   bruno_000 worksxlmfbmdth  dnb  jdrs  rg  drg  db pace  ES1-201 Ficheiro   rules.cf"); 
		pa.add("C:Usersbrumkz  dlbgx sdfmr  lkdgs  erhgsr  rth  rth trno_000  workspace  ES1-2017  Ficheiros\\spam.log.txt");
		AvaliarAuto am = new AvaliarAuto(gui);
	am.setMham(pa);
	am.setMrules(pa);
	am.setMspam(pa);
	am.avaliarAuto();
	am.getMham();
	am.getMrules(); 
	am.getMspam();
	}

}
