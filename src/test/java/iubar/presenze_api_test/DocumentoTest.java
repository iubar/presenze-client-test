package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import it.iubar.desktop.api.JwtClient;

public class DocumentoTest {
	
	private static final Logger LOGGER = Logger.getLogger(DocumentoTest.class.getName());
	
	@Ignore("Ignorato perchè caricare un pdf ogni volta che viene lanciato un test richiederebbe troppe risorse")
	public void sendCaricamentoDocumento()
	{
		JwtClient client = PresenzeApiTest.clientFactory();

		String path = "documento/upload";
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputJson = loader.getResourceAsStream("documento.json");
		JSONObject input = null;
		try {
			input = new JSONObject(new JSONTokener(inputJson));
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		
		
		String restUrl = PresenzeApiTest.BASE_ROUTE + path;
		
		Response response = client.post(restUrl, input);
		
		LOGGER.info("Testing path \"" + restUrl + "\" ...");

		int statusCode = response.getStatus();
		String json = response.readEntity(String.class);
		JSONObject jsonObject = null;
		String message = null;
		int code = 0;
		try {
			jsonObject = new JSONObject(json);
			LOGGER.info("...response: " + jsonObject.toString() + "\n");
			message = jsonObject.getString("response");
			code = jsonObject.getInt("code");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		assertNotNull(message);
		assertEquals(Status.OK.getStatusCode(), statusCode);
		assertEquals(Status.OK.getStatusCode(), code);
	}
	
	@Test
	public void receiveDettaglioDocumento() {
		JwtClient client = PresenzeApiTest.clientFactory();

		int id_doc = 67;
		String path = "documento/" + id_doc;

		String restUrl = PresenzeApiTest.BASE_ROUTE + path;
		Response response = client.get(restUrl);

		LOGGER.info("Testing path \"" + restUrl + "\" ...");

		int statusCode = response.getStatus();
		String json = response.readEntity(String.class);
		JSONObject jsonObject = null;
		String message = null;
		int code = 0;
		try {
			jsonObject = new JSONObject(json);
			LOGGER.info("...response: " + jsonObject.toString() + "\n");
			message = jsonObject.getString("response");
			code = jsonObject.getInt("code");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		assertNotNull(message);
		assertEquals(Status.OK.getStatusCode(), statusCode);
		assertEquals(Status.OK.getStatusCode(), code);
	}
	@Test
	public void receiveElencodeiDocumenti() {
		JwtClient client = PresenzeApiTest.clientFactory();

		int id_tipo_doc = 1;
		String path = "documenti/tipodocumento/" + id_tipo_doc;

		String restUrl = PresenzeApiTest.BASE_ROUTE + path;
		Response response = client.get(restUrl);

		LOGGER.info("Testing path \"" + restUrl + "\" ...");

		int statusCode = response.getStatus();
		String json = response.readEntity(String.class);
		JSONObject jsonObject = null;
		String message = null;
		int code = 0;
		try {
			jsonObject = new JSONObject(json);
			LOGGER.info("...response: " + jsonObject.toString() + "\n");
			message = jsonObject.getString("response");
			code = jsonObject.getInt("code");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		assertNotNull(message);
		assertEquals(Status.OK.getStatusCode(), statusCode);
		assertEquals(Status.OK.getStatusCode(), code);
	}
}
