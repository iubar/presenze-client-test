package iubar.presenze_api_test;

import org.junit.jupiter.api.Test;

public class UserTest {	
	@Test
	public void receiveValidazione()
	{
		String path = "user/validate";

		HttpMethods.receive(path);
	}

}
