package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class LavoratoreTest {
	@Test
	public void receiveDatiLavoratore()
	{		
		String cf = "VNTCNZ70P58I480Y";
		String data_ass = "2005-01-18";
		String path = "lavoratore/cf/" + cf +"/impresa/piva/" + PresenzeApiTest.PIVA +"/dataassunzione/"
				+ data_ass;
		
		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void receiveElencoLavoratori()
	{
		String path = "lavoratori/impresa/piva/"+PresenzeApiTest.PIVA;

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
	@Test
	public void sendInserimentoLavoratore()
	{
		String path = "lavoratore";
		String jsonFileName = "lavoratore.json";
		
		try {
			HttpMethods.send(path, jsonFileName, true);
		} catch (Exception e) {
			fail();
		}		
	}
	@Test
	public void sendInserimentoLavoratori()
	{
		String path = "lavoratori";
		String jsonFileName = "lavoratori.json";
		
		try {
			HttpMethods.send(path, jsonFileName, false);
		} catch (Exception e) {
			fail();
		}		
	}
}
