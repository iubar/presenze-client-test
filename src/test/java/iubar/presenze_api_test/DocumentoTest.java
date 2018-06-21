package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;


public class DocumentoTest {

	
	@Disabled("Ignorato perchè caricare un pdf ogni volta che viene lanciato un test richiederebbe troppe risorse")
	public void sendCaricamentoDocumento()
	{
		String path = "documento/upload";
		String jsonFileName = "documento.json";
		
		HttpMethods.send(path, jsonFileName, true);
	}
	
	@Test
	public void receiveDettaglioDocumento() {
		int id_doc = 67;
		String path = "documento/" + id_doc;

		HttpMethods.receive(path);
	}
	
	@Test
	public void receiveElencodeiDocumenti() {
		int id_tipo_doc = 1;
		String path = "documenti/tipodocumento/" + id_tipo_doc;

		HttpMethods.receive(path);
	}
}
