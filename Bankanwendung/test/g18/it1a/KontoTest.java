package g18.it1a;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KontoTest {

	@Before
	public void test() {
		Konto konto = new Konto(12345678, 0.00, "GIROKONTO");
	}

}
