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

public class StatsTest {
	private static final Logger LOGGER = Logger.getLogger(ImpresaTest.class.getName());
	
	@Test
	public void sendInserimentoCedolini()
	{
		JwtClient client = PresenzeApiTest.clientFactory();

		String path = "stats/cedolini";
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputJson = loader.getResourceAsStream("statistiche-cedolino.json");
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
	
	@Test
	public void receiveCedolino()
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		
		String mese = "09";
		String anno = "2017";
		String path = "stats/cedolini/mese/" + mese +"/anno/" + anno;

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
