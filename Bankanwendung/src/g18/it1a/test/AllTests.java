package g18.it1a.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ KundeTest.class, KontoTest.class, GirokontoTest.class, SparkontoTest.class, ÜberweisungTest.class })
public class AllTests {

}
