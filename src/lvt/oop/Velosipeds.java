package lvt.oop;

import java.util.Random;

public class Velosipeds {
	//Atribūti
	
	private int ritenaD, sedeklaPoz;
	private double atrumsMS, cena;
	private String razotajs;
	
	//Konstruktors
	public Velosipeds(int ritenaD, int sedeklaPoz, double cena, String razotajs) {
		this.ritenaD = ritenaD;
		this.sedeklaPoz = sedeklaPoz;
		atrumsMS = kustiba();
		this.cena = cena;
		this.razotajs = razotajs;
	}
	
	//Metodes
	
	public int noteiktRitenaD() {
		return ritenaD;
	}
	public int noteiktSedeklaPoz() {
		return sedeklaPoz;
	}
	public String noteiktRaz() {
		return razotajs;
	}
	public double noteiktCenu() {
		return cena;
	}
	public double kustiba() {
		double celsM, laiksS;
		Random rand = new Random();
		
		celsM = rand.nextDouble()*(1000 - 1) + 1;
		laiksS = rand.nextDouble()*(60 - 10) + 10;
		
		return Math.round(celsM / laiksS);
	}
	
	public double noteiktAtr() {
		return atrumsMS;
	}
	
	public String izvadit() {
		return "Riteņa ražotājs: " + noteiktRaz()
			   + "\nRiteņa cena: " + noteiktCenu() + "EUR"
			   + "Riteņa lielums collās: " + noteiktRitenaD()
			   + "\nIestatītais sēdekļa augstums: " + noteiktSedeklaPoz()
			   + "\nKustības ātrums: " + noteiktAtr() + "m/s";
	}
	
	public void iestatitSedeklaPoz(int pozicija) {
		sedeklaPoz = pozicija;
	}
	
	public void mities(int minienuSk) {
		atrumsMS += noteiktAtr() + (0.15 * minienuSk);
	}
	
	public void bremzet(int berze) {
		if(noteiktAtr() > 0) {
			atrumsMS -= (noteiktAtr() * 0.55) * berze;
			
			if(atrumsMS < 0)
				atrumsMS = 0;
		}
	}
	
}
