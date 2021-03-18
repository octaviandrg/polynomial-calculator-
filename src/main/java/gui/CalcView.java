package gui;
import logic.Monom;
import logic.Operatii;
import logic.Polinom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcView extends JFrame {
	protected JButton butonAdunare;
	protected JButton butonScadere;
	protected JButton butonInmultire;
	protected JButton butonDerivare;
	protected JButton butonIntegrare;


	protected JTextField tf_polinom2;
	protected JTextField tf_polinom1;
	protected JTextField tf_rezultat;
	public CalcView(){
    JFrame frame  = new JFrame ("Calculator polinoame");
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setSize(550, 350);
        	frame.setResizable(false);
        	frame.setLocationRelativeTo(null);



    JPanel panel_principal = new JPanel();
    JPanel panel_polinoame = new JPanel();
    JPanel panel_butoane= new JPanel();

        	panel_principal.setLayout(new  BoxLayout(panel_principal, BoxLayout.Y_AXIS));

    JButton butonScadere = new JButton("-");
    JButton butonAdunare = new JButton("+");
    JButton butonInmultire = new JButton("*");
    JButton butonDerivare = new JButton("'");
    JButton butonIntegrare = new JButton("I");



    JLabel jl_polinom1 = new JLabel ("Polinom 1: \n");
    JLabel jl_polinom2 = new JLabel ("Polinom 2: ");
    JLabel jl_rezultat = new JLabel ("Rezultat: ");

    final JTextField tf_polinom2 = new JTextField(40);
    final JTextField tf_polinom1  = new JTextField(40);
    final JTextField tf_rezultat  = new JTextField(40);

    tf_rezultat.setHorizontalAlignment(JTextField.CENTER);
        	tf_rezultat.setEditable(false);

        	panel_polinoame.add(jl_polinom1);
        	panel_polinoame.add(tf_polinom1);
        	panel_polinoame.add(jl_polinom2);
        	panel_polinoame.add(tf_polinom2);
        	panel_polinoame.add(jl_rezultat);
        	panel_polinoame.add(tf_rezultat);

        	panel_butoane.add(butonAdunare);
        	panel_butoane.add(butonScadere);
        	panel_butoane.add(butonInmultire);
        	panel_butoane.add(butonDerivare);
        	panel_butoane.add(butonIntegrare);


        	panel_principal.add(panel_polinoame);
        	panel_principal.add(panel_butoane);


        	frame.setContentPane(panel_principal);
        	frame.setVisible(true);

		butonAdunare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CITIM DATELE DE PE TEXTFIELD
				String pol1 = tf_polinom1.getText();
				String pol2 = tf_polinom2.getText();
				Pattern pattern = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)"); //pattern-ul monomului: !!  coeficientX^exponent   !!
				Matcher matcher1 = pattern.matcher(pol1);
				Monom m;
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				while (matcher1.find()) {
					int coef = Integer.parseInt(matcher1.group(1));
					int exp = Integer.parseInt(matcher1.group(2));
					m = new Monom(coef,exp);
					p1.adauga(m);
				}
				Matcher matcher2 = pattern.matcher(pol2);
				while (matcher2.find()) {
					int coef = Integer.parseInt(matcher2.group(1));
					int exp = Integer.parseInt(matcher2.group(2));
					m = new Monom(coef,exp);
					p2.adauga(m);
				}
				// PANA AICI
				tf_rezultat.setText("");
				Polinom rezultat = new Polinom();
				rezultat = Operatii.Adunare(p1,p2);
				for(Monom z:rezultat.getPolinom())
					tf_rezultat.setText(tf_rezultat.getText() + String.valueOf(z.toString()));

			}
		});

		butonScadere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CITIM DATELE DE PE TEXTFIELD
				String pol1 = tf_polinom1.getText();
				String pol2 = tf_polinom2.getText();
				Pattern pattern = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)"); //pattern-ul monomului: !!  coeficientX^exponent   !!
				Matcher matcher1 = pattern.matcher(pol1);
				Monom m;
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				while (matcher1.find()) {
					int coef = Integer.parseInt(matcher1.group(1));
					int exp = Integer.parseInt(matcher1.group(2));
					m = new Monom(coef,exp);
					p1.adauga(m);
				}
				Matcher matcher2 = pattern.matcher(pol2);
				while (matcher2.find()) {
					int coef = Integer.parseInt(matcher2.group(1));
					int exp = Integer.parseInt(matcher2.group(2));
					m = new Monom(coef,exp);
					p2.adauga(m);
				}
				// PANA AICI
				tf_rezultat.setText("");
				Polinom rezultat = new Polinom();
				rezultat = Operatii.Scadere(p1,p2);
				for(Monom z:rezultat.getPolinom())
					tf_rezultat.setText(tf_rezultat.getText() + String.valueOf(z.toString()));

			}
		});

		butonInmultire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CITIM DATELE DE PE TEXTFIELD
				String pol1 = tf_polinom1.getText();
				String pol2 = tf_polinom2.getText();
				Pattern pattern = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)"); //pattern-ul monomului: !!  coeficientX^exponent   !!
				Matcher matcher1 = pattern.matcher(pol1);
				Monom m;
				Polinom p1 = new Polinom();
				Polinom p2 = new Polinom();
				while (matcher1.find()) {
					int coef = Integer.parseInt(matcher1.group(1));
					int exp = Integer.parseInt(matcher1.group(2));
					m = new Monom(coef,exp);
					p1.adauga(m);
				}
				Matcher matcher2 = pattern.matcher(pol2);
				while (matcher2.find()) {
					int coef = Integer.parseInt(matcher2.group(1));
					int exp = Integer.parseInt(matcher2.group(2));
					m = new Monom(coef,exp);
					p2.adauga(m);
				}
				// PANA AICI
				tf_rezultat.setText("");
				Polinom rezultat = new Polinom();
				rezultat = Operatii.Inmultire(p1,p2);
				for(Monom z:rezultat.getPolinom())
					tf_rezultat.setText(tf_rezultat.getText() + String.valueOf(z.toString()));

			}
		});



		butonDerivare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CITIM DATELE DE PE TEXTFIELD
				String pol1 = tf_polinom1.getText();
				Pattern pattern = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)"); //pattern-ul monomului: !!  coeficientX^exponent   !!
				Matcher matcher1 = pattern.matcher(pol1);
				Monom m;
				Polinom p1 = new Polinom();
				while (matcher1.find()) {
					int coef = Integer.parseInt(matcher1.group(1));
					int exp = Integer.parseInt(matcher1.group(2));
					m = new Monom(coef,exp);
					p1.adauga(m);
				}
				// PANA AICI
				tf_rezultat.setText("");
				Polinom rezultat = new Polinom();
				rezultat = Operatii.Derivare(p1);
				for(Monom z:rezultat.getPolinom())
					tf_rezultat.setText(tf_rezultat.getText() + String.valueOf(z.toString()));

			}
		});

		butonIntegrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// CITIM DATELE DE PE TEXTFIELD
				String pol1 = tf_polinom1.getText();
				Pattern pattern = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)"); //pattern-ul monomului: !!  coeficientX^exponent   !!
				Matcher matcher1 = pattern.matcher(pol1);
				Monom m;
				Polinom p1 = new Polinom();
				while (matcher1.find()) {
					int coef = Integer.parseInt(matcher1.group(1));
					int exp = Integer.parseInt(matcher1.group(2));
					m = new Monom(coef,exp);
					p1.adauga(m);
				}
				// PANA AICI
				tf_rezultat.setText("");
				StringBuilder rez;
				rez = Operatii.Integrare(p1);
				tf_rezultat.setText(rez.toString());

			}
		});
    }
}
