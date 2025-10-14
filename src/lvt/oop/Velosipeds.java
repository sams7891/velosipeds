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
	
	public double kustibasAtr() {
		return atrumsMS;
	}
	public String izvadit() {
		return "Riteņa ražotājs: " + noteiktRaz()
			   + "\nRiteņa cena: " + noteiktCenu() + "EUR"
			   + "Riteņa lielums collās: " + noteiktRitenaD()
			   + "\nIestatītais sēdekļa augstums: " + noteiktSedeklaPoz()
			   + "\nKustības ātrums: " + kustibasAtr() + "m/s";
	}
	
}
