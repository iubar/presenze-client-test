package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;

public class LavoratoreTest {
	@Test
	public void receiveDatiLavoratore()
	{		
		String cf = "VNTCNZ70P58I480Y";
		String data_ass = "2005-01-18";
		String path = "lavoratore/cf/" + cf +"/impresa/piva/" + PresenzeApiTest.PIVA +"/dataassunzione/"
				+ data_ass;

		HttpMethods.receive(path);
	}
	@Test
	public void receiveElencoLavoratori()
	{
		String path = "lavoratori/impresa/piva/"+PresenzeApiTest.PIVA;

		HttpMethods.receive(path);
	}
	@Test
	public void sendInserimentoLavoratore()
	{
		String path = "lavoratore";
		String jsonFileName = "lavoratore.json";
		
		HttpMethods.send(path, jsonFileName, true);		
	}
	@Test
	public void sendInserimentoLavoratori()
	{
		String path = "lavoratori";
		String jsonFileName = "lavoratori.json";
		
		HttpMethods.send(path, jsonFileName, false);		
	}
}
