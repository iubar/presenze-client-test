package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;

public class PresenzaTest {
			
	@Test
	public void sendInserimentoDaLavoratore()
	{
		String path = "presenze";
		String jsonFileName = "presenza-lavoratore.json";
		
		HttpMethods.send(path, jsonFileName, true);
	}
	
	@Test
	public void receiveElencoPerImpresa()
	{
		String from = "2016-01-01";
		String to = "2017-01-01";
		String path = "presenze/impresa/piva/" + PresenzeApiTest.PIVA + "/da/" + from + "/a/" + to;

		HttpMethods.receive(path);
	}
	
	@Test
	public void receiveElencoPerLavoratore()
	{
		String cf = "VNTCNZ70P58I480Y";
		String data_ass = "2005-01-18";
		String from = "2016-01-01";
		String to = "2017-01-01";
		String path = "presenze/cf/" +cf +"/dataassunzione/"+data_ass+"/impresa/piva/"+ PresenzeApiTest.PIVA + "/da/" + from + "/a/" + to;

		HttpMethods.receive(path);
	}

}
