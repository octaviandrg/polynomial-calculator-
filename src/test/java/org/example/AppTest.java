package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import logic.Monom;
import logic.Operatii;
import logic.Polinom;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    /**
     * Rigorous Test :-)
     */
    @Test
    public void AdunaTest()
    {
        Monom m1 = new Monom(1,3);
        Monom m2 = new Monom(2,2);
        Monom m3 = new Monom(3,0);
        Monom m4 = new Monom(-2,3);
        Monom mrez1 = new Monom(-1,3);
        Monom mrez2 = new Monom(2,2);
        Monom mrez3 = new Monom(3,0);
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom rezultat = new Polinom();
        p1.adauga(m1);
        p1.adauga(m2);
        p2.adauga(m3);
        p2.adauga(m4);
        rezultat.adauga(mrez1);
        rezultat.adauga(mrez2);
        rezultat.adauga(mrez3);
        assertEquals(Operatii.Adunare(p1,p2),rezultat);
    }
}
