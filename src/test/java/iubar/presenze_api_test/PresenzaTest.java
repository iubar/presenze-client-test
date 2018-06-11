package iubar.presenze_api_test;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import it.iubar.desktop.api.JwtClient;

public class PresenzaTest {
	private static final Logger LOGGER = Logger.getLogger(ImpresaTest.class.getName());
			
	@Test
	public void sendInserimentoDaLavoratore()
	{
		JwtClient client = PresenzeApiTest.clientFactory();

		String path = "presenze";
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputJson = loader.getResourceAsStream("presenza-lavoratore.json");
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
	public void receiveElencoPerImpresa()
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		String from = "2016-01-01";
		String to = "2017-01-01";
		String path = "presenze/impresa/piva/" + PresenzeApiTest.PIVA + "/da/" + from + "/a/" + to;

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
	public void receiveElencoPerLavoratore()
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		String cf = "VNTCNZ70P58I480Y";
		String data_ass = "2005-01-18";
		String from = "2016-01-01";
		String to = "2017-01-01";
		String path = "presenze/cf/" +cf +"/dataassunzione/"+data_ass+"/impresa/piva/"+ PresenzeApiTest.PIVA + "/da/" + from + "/a/" + to;

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
