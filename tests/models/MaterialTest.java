package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialTest {

    @Test
    public void shouldSayDrugsAreAPharmaceutical() {
        assertTrue(Material.PHARMACEUTICALS.contains("Drugs"));
    }

}