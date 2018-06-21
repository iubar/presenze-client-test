package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class AssenzaTest {


	@Test
	public void receiveElencoPerImpresa() {
		String from = "2016-01-01";
		String to = "2017-01-01";		String path ="assenze/impresa/piva/" + PresenzeApiTest.PIVA + "/da/" +from+ "/a/" +to;

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void receiveElencoPerLavoratore() {

		String cf = "VNTCNZ70P58I480Y";
		String data_ass = "2005-01-18";
		String from = "2016-01-01";
		String to = "2017-01-01";
		
		String path ="assenze/cf/" +cf+"/dataassunzione/"+ data_ass+"/impresa/piva/"+PresenzeApiTest.PIVA+ "/da/" +from+ "/a/" +to;

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}

}
