package logic;

import java.util.Collections;

public class Operatii {

    public static Polinom Adunare(Polinom p1, Polinom p2) {

        Polinom rezultat = new Polinom();
        Monom mRez;
        for (Monom m1: p1.getPolinom()) {
            //boolean gasit = false;
            for(Monom m2: p2.getPolinom()){
                if(m1.getExponent() == m2.getExponent() && !m1.getParcurs() && !m2.getParcurs()){//daca exponentii sunt egali --> ii adunam
                    //gasit = true;
                    mRez = new Monom(m1.getCoeficient() + m2.getCoeficient(),m1.getExponent());//formam un monom nou, rezultat al adunarii
                    rezultat.adauga(mRez); //adaugam monomul rezultat la raspuns
                    m1.setParcurs(true);
                    m2.setParcurs(true);
                }
            }

        }
        for(Monom m1: p1.getPolinom())
            if(!m1.getParcurs())//exponentii sunt diferiti si n au fost parcursi(adaugati la rez)
            {
                m1.setParcurs(true);
                rezultat.adauga(m1);
            }
        for(Monom m2: p2.getPolinom())
            if(!m2.getParcurs())//exponentii sunt diferiti si n au fost parcursi(adaugati la rez)
            {
                m2.setParcurs(true);
                rezultat.adauga(m2);
            }
        Collections.sort(rezultat.getPolinom());

        return rezultat;
    }

    public static Polinom Scadere(Polinom p1, Polinom p2){
        Polinom rezultat = new Polinom();
        Monom mRez;
        for (Monom m1: p1.getPolinom()) {
            for(Monom m2: p2.getPolinom()){
                if(m1.getExponent() == m2.getExponent() && !m1.getParcurs() && !m2.getParcurs()) {//daca exponentii sunt egali --> ii adunam
                    m1.setParcurs(true);
                    m2.setParcurs(true);
                    mRez = new Monom(m1.getCoeficient() - m2.getCoeficient(),m1.getExponent());//formam un monom nou, rezultat al adunarii
                    rezultat.adauga(mRez); //adaugam monomul rezultat la raspuns
                }
            }

        }
        for(Monom m1: p1.getPolinom())
            if(!m1.getParcurs())//exponentii sunt diferiti si n au fost parcursi(adaugati la rez)
            {
                m1.setParcurs(true);
                rezultat.adauga(m1);
            }
        for(Monom m2: p2.getPolinom())
            if(!m2.getParcurs())//exponentii sunt diferiti si n au fost parcursi(adaugati la rez)...fiind polinomul din care se scade trebuie sa adaugam - in fata coef
            {
                m2.setParcurs(true);
                m2.setCoeficient(-m2.getCoeficient()); //
                rezultat.adauga(m2);
            }
        Collections.sort(rezultat.getPolinom());
        return rezultat;
    }

    public static Polinom Inmultire(Polinom p1, Polinom p2) {
        Polinom rezultat = new Polinom();
        Monom mRez;
        //parcurgem fiecare element al polinomului p1(monom) si ii inmultim cu fiecare elem din pol p2
        for(Monom m1: p1.getPolinom()) {
            for(Monom m2: p2.getPolinom()) {
                if(m1.getExponent()!=0 && m2.getExponent()!=0) {
                    mRez = new Monom(m1.getCoeficient()*m2.getCoeficient(),m1.getExponent()*m2.getExponent());
                    rezultat.adauga(mRez);
                }
                if(m1.getExponent()==0 && m2.getExponent()!=0) {
                    mRez = new Monom(m1.getCoeficient()*m2.getCoeficient(),(m1.getExponent()+1)*m2.getExponent());
                    rezultat.adauga(mRez);
                }
                if(m1.getExponent()!=0 && m2.getExponent()==0) {
                    mRez = new Monom(m1.getCoeficient()*m2.getCoeficient(),m1.getExponent()*(m2.getExponent()+1));
                    rezultat.adauga(mRez);
                }
                if(m1.getExponent()==0 && m2.getExponent()==0) {
                    mRez = new Monom(m1.getCoeficient()*m2.getCoeficient(),(m1.getExponent())*(m2.getExponent()));
                    rezultat.adauga(mRez);
                }
            }
        }
    	Polinom rezultat2 = new Polinom();
    	Collections.sort(rezultat.getPolinom());
    	for(Monom m1: rezultat.getPolinom()) {
    		int c = 0;
    		for(Monom m2: rezultat.getPolinom())
    			if(m1.getExponent() == m2.getExponent() && m1.getParcurs() == false && m2.getParcurs() == false){
    				if(c>0) {
    				mRez = new Monom(m1.getCoeficient()+m2.getCoeficient(),m1.getExponent());
    				m1.setParcurs(true);
    				m2.setParcurs(true);
    				rezultat2.adauga(mRez);
    				}else c++;

    			}
    		if(m1.getParcurs() == false) {
                rezultat2.adauga(m1);
                m1.setParcurs(true);
    		}
    	}
        Collections.sort(rezultat2.getPolinom());
        return rezultat2;
    }




    //ma folosesc de formula p(x) = ax^n -> p'(x) = a*n*x^(n-1)
    public static Polinom Derivare(Polinom p1) {
        Polinom rezultat = new Polinom();
        Monom mRez;
        for(Monom m1: p1.getPolinom()) {
            mRez = new Monom(m1.getCoeficient()*m1.getExponent(),m1.getExponent()-1);
            rezultat.adauga(mRez);
        }
        return rezultat;
    }

    public static StringBuilder Integrare(Polinom p1) {
        Polinom rezultat = new Polinom();
        Monom mRez;
        StringBuilder rez= new StringBuilder();
        for(Monom m1: p1.getPolinom()) {
            if(m1.getCoeficient()!=1 && m1.getCoeficient()!=-1) {
                rez.append(m1.getSemnCoef()+m1.getCoeficient()+"/"+(m1.getExponent()+1)+"x'"+(m1.getExponent()+1));
            }
            if(m1.getCoeficient() == 1)
            {
                rez.append(m1.getSemnCoef()+"1/"+(m1.getExponent()+1)+"x'"+(m1.getExponent()+1));
            }
            if(m1.getExponent() < 0) {
                rez.append(m1.getSemnCoef()+m1.getCoeficient()+"/"+(m1.getExponent()+1)+"x'"+(m1.getExponent()+1));
            }

        }
        return rez;

    }











}
