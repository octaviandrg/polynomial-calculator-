package logic;


public class Monom implements Comparable<Monom>{
    // 7*x^2  --->  7 = coeficientul     2 = exponentul
    private Integer exponent;
    private int coeficient;
    private boolean parcurs;

    public Monom(int coeficient, int exponent){
        this.coeficient = coeficient;
        this.exponent = exponent;
        this.parcurs = false;
    }


    public void setParcurs(boolean parcurs)
    {
        this.parcurs = parcurs;
    }

    public boolean getParcurs()
    {
        return parcurs;
    }
    
    public int getExponent( )
    {
        return exponent;
    }

    public void setCoeficient(int coeficient)
    {
        this.coeficient = coeficient;
    }

    public int getCoeficient( )
    {
        return coeficient;
    }

    public String getSemnCoef() {
        if(this.coeficient>=0)
            return " +";
        else
            return " ";
    }

    public String toString(){
        if (coeficient == 0){
            return " ";
        }
        if(coeficient != 0 && exponent == 0){
            if(coeficient > 0){
                //return String.valueOf(coeficient);
                return "+" + coeficient;
            }else
                return "" + coeficient;
        }
        if(coeficient > 0 && exponent > 0){
            return "+" + coeficient + "x'" + exponent;
        }
        if(coeficient < 0 && exponent > 0){
            return "" + coeficient + "x'" + exponent;
        }
        return null;
    }
    

    @Override
    public int compareTo(Monom m) {
        return m.exponent.compareTo(this.exponent);

    }
}
