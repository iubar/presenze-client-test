
package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;

public class ImpresaTest {

	@Test
	public void receiveDatiImpresa() {
		String path = "imprese";

		HttpMethods.receive(path);
	}
	
	@Test
	public void sendInserimentoImpresa(){
		String path = "impresa";
		String jsonFileName = "impresa.json";
		
		HttpMethods.send(path, jsonFileName, true);
	}
	
	@Test
	public void receiveElencoImpresa() {
		String path = "imprese";

		HttpMethods.receive(path);
	}
}
