
package logic;




import java.util.List;
import java.util.ArrayList;


public class Polinom {
    //fiecare polinom este format dintr-o lista de monoame
    //arraylist e clasa care implementeaza interfata list
    private List<Monom> p;
    private int gradMax;

    //constructorul clasei Polinom
    public Polinom() {
        p = new ArrayList<Monom>();
        gradMax = 0;
    }

    //metoda care adauga un monom, dat ca si parametru, la polinom
    public void adauga(Monom m) {
        if (m.getCoeficient() != 0)
            p.add(m);
        if (m.getExponent() > gradMax)
            gradMax = m.getExponent();
    }

    //getter pentru polinom pe care o sa il folosim la operatii
    public List<Monom> getPolinom() {

        return p;

    }

    public String toString() {

        for (Monom m : p)
            return m.toString();
        return null;
    }

    public Integer getGradMax() {
        return this.gradMax;
    }
}
