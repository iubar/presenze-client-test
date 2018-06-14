package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONException;
import org.json.JSONObject;

import it.iubar.desktop.api.JwtClient;

public class UserTest {
	private static final Logger LOGGER = Logger.getLogger(ImpresaTest.class.getName());
	
	@Test
	public void receiveValidazione()
	{
		JwtClient client = PresenzeApiTest.clientFactory();
		String path = "user/validate";

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
