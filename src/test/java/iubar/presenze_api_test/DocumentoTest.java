package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;


public class DocumentoTest {

	
	@Disabled("Ignorato perchè caricare un pdf ogni volta che viene lanciato un test richiederebbe troppe risorse")
	public void sendCaricamentoDocumento()
	{
		String path = "documento/upload";
		String jsonFileName = "documento.json";
		
		try {
			HttpMethods.send(path, jsonFileName, true);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void receiveDettaglioDocumento() {
		int id_doc = 67;
		String path = "documento/" + id_doc;

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void receiveElencodeiDocumenti() {
		int id_tipo_doc = 1;
		String path = "documenti/tipodocumento/" + id_tipo_doc;

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}
}
