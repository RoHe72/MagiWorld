import java.util.Scanner;

public class Ninja extends Figur {

	public Ninja() {
		this.name = "Naruto";
		this.basisAngriff = agilitaet;
		this.spezialAngriff = agilitaet + 15;
		this.leben = 100;
		this.kraft = 0;
		this.agilitaet = 0;
		this.intelligenz = 0;
		this.kompetenzPunkte = 20;

	}

	@Override
	public void angriff(Spieler spieler, Spieler gegner) {
		int angriffWahl;
		do {
			System.out.println("Welche Angriff möchtest du nutzen?");
			System.out.println("1.Präzise Schuss\n2.Schleichangriff\n");
			Scanner scanner = new Scanner(System.in);
			angriffWahl = scanner.nextInt();
			switch (angriffWahl) {
			case 1:
				gegner.figur.leben = gegner.figur.leben - spieler.figur.getBasisAngriff();
				if (gegner.figur.leben <= 0) {
					System.out.println(
							"Headshoooooot!! " + spieler.figur.name + "hat dich zwischen die Augen getroffen! Loser!");
				} else {
					System.out.println("Naruto trifft dich am Arm");
					System.out.println(
							gegner.figur.name + ", du hast noch " + gegner.figur.leben + " Lebenspunkte\n");
				}

				break;
			case 2:
				if (countSpezAngriff > 0) {
					countSpezAngriff--;
					System.out.println(spieler.figur.name + " schleicht sich hinter " + gegner.figur.name
							+ "\nund lässt ihn bereuen nicht aufmerksamer zu sein!\n");
					gegner.figur.leben = gegner.figur.leben - (spieler.figur.getBasisAngriff() + 15);
					if (gegner.figur.leben <= 0) {
						System.out.println(
								"Tooooot!!Sei ein bisschen mehr aufmerksam nächstes mal!\nDann überrascht er dich vielleicht nicht und du behältst dein Kopf! Loser!");
					} else {
						System.out.println(
								gegner.figur.name + ", du hast noch " + gegner.figur.leben + " Lebenspunkte\n");
					}
				} else {
					System.out.println("Du hast keine Spezial Angriffe mehr\n");
					continue;
				}

			default:
				break;
			}
		} while (angriffWahl != 1 && angriffWahl != 2);
	}

	@Override
	public int getBasisAngriff() {
		// TODO Auto-generated method stub
		return agilitaet + 5;
	}

	@Override
	public int getLeben() {
		// TODO Auto-generated method stub
		return super.getLeben();
	}

	@Override
	public int getKraft() {
		// TODO Auto-generated method stub
		return super.getKraft();
	}

	@Override
	public int getAgilitaet() {
		// TODO Auto-generated method stub
		return super.getAgilitaet();
	}

	@Override
	public int getIntelligenz() {
		// TODO Auto-generated method stub
		return super.getIntelligenz();
	}

	@Override
	public int getSpezialAngriff() {
		// TODO Auto-generated method stub
		return agilitaet + 15;
	}

}
