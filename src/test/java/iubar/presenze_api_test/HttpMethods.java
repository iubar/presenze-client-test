package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import it.iubar.desktop.api.JwtClient;

public class HttpMethods {
	private static final Logger LOGGER = Logger.getLogger(HttpMethods.class.getName());

	private static void httpResponse(Response response, String restUrl)
	{
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
	public static void receive(String path)
	{
		JwtClient client = PresenzeApiTest.clientFactory();

		String restUrl = PresenzeApiTest.BASE_ROUTE + path;
		
		Response response = client.get(restUrl);
		
		HttpMethods.httpResponse(response, restUrl);
	}	
	
	private static JSONObject getObjectInput(InputStream inputJson)
	{
		JSONObject input = null;
			
			try {
				input = new JSONObject(new JSONTokener(inputJson));
			}
			catch (JSONException e)
			{
				e.printStackTrace();
		}
		return input;
	}
	
	private static JSONArray getArrayInput(InputStream inputJson)
	{
		JSONArray input = null;
			
			try {
				input = new JSONArray(new JSONTokener(inputJson));
			}
			catch (JSONException e)
			{
				e.printStackTrace();
		}
		return input;
	}
	
	public static void send(String path, String jsonFileName, boolean isJsonObject)
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputJson = loader.getResourceAsStream(jsonFileName);
		
		
		String restUrl = PresenzeApiTest.BASE_ROUTE + path;
		Response response;
		
		if(isJsonObject)
		{
			response = client.post(restUrl, HttpMethods.getObjectInput(inputJson));
		}
		else
		{
			response = client.post(restUrl, HttpMethods.getArrayInput(inputJson));
		}
		
		HttpMethods.httpResponse(response, restUrl);
	}
}
