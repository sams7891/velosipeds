package lvt.oop;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;


public class Ritenbraucejs {
		
	public static int skaitlaParbaude(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(null, zinojums, "Datu ievade", JOptionPane.INFORMATION_MESSAGE);
			
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null, "Norādīts nederīgs intervāls", "Nekorekti dati", JOptionPane.WARNING_MESSAGE);
					continue;
					
				}
				return skaitlis;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Netika ievadīts vesels skaitlis\n" + e, "Kļūda", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void main(String[] args) {
		String izvele;
		int izvelesID;
		String[] darbibas = {"Jauns ritenis", "Noņemt riteni", "Riteņu saraksts", "Kārtot pēc cenas", "Izsaukt meodi", "Aizvērt programmu"};
		String[] veidi = {"Velospēds", "Kalnu velosipēds", "Bērnu velospiēds"};
		String[] atbilde = {"Jā", "Nē"};
		
		ArrayList<Object> riteni = new ArrayList<>();
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "LVT riteņi", JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			
			if(izvele == null)
				break;
			
			izvelesID = Arrays.asList(darbibas).indexOf(izvele);
			
			switch(izvelesID) {
			case 0 :
				String ritenaVeids = (String)JOptionPane.showInputDialog(null, "Kādu riteņa veidu vēlēsieties", "LVT riteņi", JOptionPane.QUESTION_MESSAGE, null, veidi, veidi[0]);
				
				if(ritenaVeids == null)
					break;
				
				int diametrs = skaitlaParbaude("Kāds būs riteņa dieametrs\nMin 12, Max 29", 12, 29);
				
				int pozicija = skaitlaParbaude("Kāda būs riteņa pozīcija\nMin 1, Max 10", 12, 10);
				
				int cena = skaitlaParbaude("Kāds būs riteņa cena\nMin 0, Max 10000", 0, 10000);
				
				String razotajs = JOptionPane.showInputDialog(null, "Kāds ir riteņa ražotājs", "LVT riteņi", JOptionPane.QUESTION_MESSAGE);
				
				
				if(ritenaVeids.equals("Velosipeds")) {
					ritenis = new Velosipeds(diametrs, pozicija, cena, razotajs);
				}
				
				

				
				
				break;
			}
			
		}while(izvelesID != 5);
	}
}
