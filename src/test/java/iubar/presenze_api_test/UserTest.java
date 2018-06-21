package iubar.presenze_api_test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class UserTest {	
	@Test
	public void receiveValidazione()
	{
		String path = "user/validate";

		try {
			HttpMethods.receive(path);
		} catch (Exception e) {
			fail();
		}
	}

}
