import java.util.Scanner;

public abstract class Figur {
	
	protected int leben = 100;
	protected int kraft = 0;
	protected int agilitaet = 0;
	protected int intelligenz = 0;
	protected int kompetenzPunkte = 20;
	protected int basisAngriff;
	protected int spezialAngriff;
	protected int countSpezAngriff=2;
	String name;

	public int getBasisAngriff() {
		return basisAngriff;
	}

	public int getLeben() {
		return leben;
	}

	public int getKraft() {
		return kraft;
	}

	public int getAgilitaet() {
		return agilitaet;
	}

	public int getIntelligenz() {
		return intelligenz;
	}

	public int getSpezialAngriff() {
		return spezialAngriff;
	}

	public void angriff(Spieler spieler, Spieler spielerG) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
