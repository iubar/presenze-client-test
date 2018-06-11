package iubar.presenze_api_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import it.iubar.desktop.api.JwtClient;

public class LavoratoreTest {
	
	private static final Logger LOGGER = Logger.getLogger(ImpresaTest.class.getName());
	
	@Test
	public void receiveDatiLavoratore()
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		
		String cf = "VNTCNZ70P58I480Y";
		String data_ass = "2005-01-18";
		String path = "lavoratore/cf/" + cf +"/impresa/piva/" + PresenzeApiTest.PIVA +"/dataassunzione/"
				+ data_ass;

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
	public void receiveElencoLavoratori()
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		String path = "lavoratori/impresa/piva/"+PresenzeApiTest.PIVA;

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
	public void sendInserimentoLavoratore()
	{
		JwtClient client = PresenzeApiTest.clientFactory();

		String path = "lavoratore";
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputJson = loader.getResourceAsStream("lavoratore.json");
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
	public void sendInserimentoLavoratori()
	{
		JwtClient client = PresenzeApiTest.clientFactory();

		String path = "lavoratori";
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputJson = loader.getResourceAsStream("lavoratori.json");
		JSONArray input = null;
		try {
			input = new JSONArray(new JSONTokener(inputJson));
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
}
