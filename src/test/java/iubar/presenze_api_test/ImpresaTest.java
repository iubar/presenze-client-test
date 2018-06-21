
package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ImpresaTest {

	@Test
	public void receiveDatiImpresa() {
		String path = "imprese";

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void sendInserimentoImpresa(){
		String path = "impresa";
		String jsonFileName = "impresa.json";
		
		try {
			HttpMethods.send(path, jsonFileName, true);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void receiveElencoImpresa() {
		String path = "imprese";

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
}
