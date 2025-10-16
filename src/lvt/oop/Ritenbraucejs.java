package lvt.oop;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;



public class Ritenbraucejs {
	
	public static void main(String[] args) {
	String izvele; 
	int izvelesID;
	String[] darbibas = {"Jauns ritenis", "Noņemt riteni", "Riteņu saraksts", "Kārtot pēc cenas", "Izsaukt metodi",
			"Aizvērt programmu"};
	String[] veidi = {"Velosipēds", "Kalnu velosipēds", "Bērnu velosipēds"};
	String[] atbilde = {"Jā", "Nē"};		
	ArrayList<Object> riteni = new ArrayList<>();
	
	do {
		izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēlne", JOptionPane.INFORMATION_MESSAGE, null, darbibas, darbibas[0]);
		if(izvele == null)
		break;
		
		izvelesID = Arrays.asList(darbibas).indexOf(izvele);
		
		switch(izvelesID) {
		case 0:
			izvele = (String)JOptionPane.showInputDialog(null, "Izvēlies riteņa veidu", "Izvēlne", JOptionPane.QUESTION_MESSAGE, null, veidi, veidi[0]);
			if(izvele == null)
				break;
			
			izvelesID = Arrays.asList(veidi).indexOf(izvele);
			String razotajs =  Metodes.virknesParbaude("Norādi riteņa ražotāju", "Rockmachine");
			double cena = Metodes.skaitlaParbaude("Cik maksā ritenis?", 1.00, 9999.99, "100");
			double diametrs = Metodes.skaitlaParbaude("Kāds ir riteņa diametrs?", 12, 26, "16");
			
			int sedPoz = Metodes.iestatitSedekli();
			
			if(izvelesID == 0) {
				riteni.add(new Velosipeds((int) diametrs, sedPoz, cena, razotajs));
				JOptionPane.showMessageDialog(null, "Veiksmīgi izveidots jauns ritenis!", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);	
			} else if(izvelesID == 1) {
				int iestatAtr = Metodes.iestatitAtrumu();
				
				izvele = (String) JOptionPane.showInputDialog(null, "Vai ritenim ir papildus amortizācija?", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
				
				if(izvele == null)
					break;
				
				izvelesID = Arrays.asList(atbilde).indexOf(izvele);
				boolean atsperes = (izvelesID == 0)? true : false;
				
				riteni.add(new KalnuRitenis(iestatAtr, atsperes, (int) diametrs, sedPoz, cena, razotajs));
				JOptionPane.showMessageDialog(null, "Veiskmīgi izveidots kalnu ritenis.", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			}else if(izvelesID == 2) {
				izvele = (String) JOptionPane.showInputDialog(null, "Vai ritenim ir palīgriteņi?", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
				
				if(izvele == null)
					break;
				
				izvelesID = Arrays.asList(atbilde).indexOf(izvele);
				boolean paligRit = (izvelesID == 0)? true : false;
				
				izvele = (String) JOptionPane.showInputDialog(null, "Vai ritenim ir zvaniņš?", "Izvēle", JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
				
				if(izvele == null)
					break;
				
				izvelesID = Arrays.asList(atbilde).indexOf(izvele);
				boolean zvanins = (izvelesID == 0)? true : false;
				
				
				riteni.add(new BernuRitenis(paligRit, zvanins, (int) diametrs, sedPoz, cena, razotajs));
				JOptionPane.showMessageDialog(null, "Veiskmīgi izveidots kalnu ritenis.", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
			}
			break;
			//Riteņa noņemšana
			
		case 1 :
			if(riteni.size() > 0) {
				int ritId = Metodes.ritenaIzvele(riteni);
				riteni.remove(ritId);
				
				JOptionPane.showMessageDialog(null, "Ritenis ir veiksmīgi dzests!", "Paziņojums", JOptionPane.QUESTION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Sarakstā nav neviena riteņa", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			}
			break;
		}
	}while(izvelesID!= 5);
	
	}
}