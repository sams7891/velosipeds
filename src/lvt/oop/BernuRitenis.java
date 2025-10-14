package lvt.oop;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class BernuRitenis extends Velosipeds{
	//Atribūti
	
	private boolean paligriteni, zvanins;
	
	public BernuRitenis(boolean paligRiteni, boolean zvanins, int iestatAtrums, boolean atsperes, int ritenaD, int sedeklaPoz, double cena, String razotajs, boolean paligriteni) {
		super(ritenaD, sedeklaPoz, cena, razotajs);
		this.paligriteni = paligriteni;
		this.zvanins = zvanins;
	}
	
	//Metodes
	public void darbArPaligrit(boolean darbiba) {
		if(darbiba && paligriteni == false) {
			paligriteni = true;
			JOptionPane.showMessageDialog(null, "Palīgriteņi tikai piestiprināti", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		} else if(darbiba == false && paligriteni) {
			paligriteni = false;
			JOptionPane.showMessageDialog(null, "Palīgriteņi tikai noņemti", "Paziņojums", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Darbība nav iespējama", "Paziņojums", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void zvanitZvaninu() throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(zvanins) {
			File f = new File(".//audio//" + "ring.waw");
			AudioInputStream ais = AudioSystem.getAudioInputStream(f.toURI().toURL());
			Clip c = AudioSystem.getClip();
            c.open(ais);
            c.start();
		}else {
			JOptionPane.showMessageDialog(null, "Nav uzstādīts zvaniņš", "Paziņojums", JOptionPane.ERROR_MESSAGE);
		}
	}
}
