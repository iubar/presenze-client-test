package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class StatsTest {
	
	@Test
	public void sendInserimentoCedolini()
	{
		String path = "stats/cedolini";
		String jsonFileName = "statistiche-cedolino.json";
		
		try{
			HttpMethods.send(path, jsonFileName, false);
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void receiveCedolino()
	{
		String mese = "09";
		String anno = "2017";
		String path = "stats/cedolini/mese/" + mese +"/anno/" + anno;

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
}
