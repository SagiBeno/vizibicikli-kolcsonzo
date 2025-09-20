import org.example.Kolcsonzes;
import org.example.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Tests {
    @Before
    public void before() {
        Main.isRunningTest = true;
        Main.testNev = "Dénes";
        Main.testIdopont = "12:50";
    }

    @Test
    public void testKolcsonzesClass() {
        Kolcsonzes k = new Kolcsonzes("Hunor;D;14;29;15;23");
        assert k.getNev().equals("Hunor");
        assert k.getJarmu() == 'D';
        assert k.getElvitelOra() == 14;
        assert k.getElvitelPerc() == 29;
        assert k.getVisszaOra() == 15;
        assert k.getVisszaPerc() == 23;
    }

    @Test
    public void testMainAndHandler1() throws IOException {
        Main.testNev = "Kata";
        Main.testIdopont = "10:9";
        Main.main(null);
    }

    @Test
    public void testMainAndHandler2() throws IOException {
        Main.testNev = "Dénes";
        Main.testIdopont = "12:50";
        Main.main(null);
    }

    @After
    public void vissza() {
        Main.isRunningTest = false;
    }
}
