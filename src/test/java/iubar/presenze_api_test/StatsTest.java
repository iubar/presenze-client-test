package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;

public class StatsTest {
	
	@Test
	public void sendInserimentoCedolini()
	{
		String path = "stats/cedolini";
		String jsonFileName = "statistiche-cedolino.json";
		
		HttpMethods.send(path, jsonFileName, false);
	}
	
	@Test
	public void receiveCedolino()
	{
		String mese = "09";
		String anno = "2017";
		String path = "stats/cedolini/mese/" + mese +"/anno/" + anno;

		HttpMethods.receive(path);
	}
}
