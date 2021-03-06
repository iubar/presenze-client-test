package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.fail;

import it.iubar.desktop.api.JwtClient;

public class PresenzeApiTest{
	
	public static final String BASE_ROUTE = "http://presenze.iubar.it/api/v1/";
	public static String user = System.getenv("JWT_USER_PRESENZE");
	public static String apiKey = System.getenv("JWT_APIKEY_PRESENZE");
	public static final String PIVA = "99999999999";
	
	protected  static JwtClient clientFactory() {
		JwtClient client = null;
		try {		
		client = new JwtClient();

		// masterClient.loadConfig();
		// oppure
		// masterClient.setBaseUrl("http://httpbin.org/post");
		// oppure
		client.setBaseUrl(PresenzeApiTest.BASE_ROUTE);
		client.setAuth(true);
		client.setUser(PresenzeApiTest.user);
		client.setApiKey(PresenzeApiTest.apiKey);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}		
		return client;
	}
	
}
