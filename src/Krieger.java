import java.util.Scanner;

public class Krieger extends Figur {

	public Krieger() {
		this.name = "Ragnar der Viking";
		this.leben = 100;
		this.kraft = 0;
		this.agilitaet = 0;
		this.intelligenz = 0;
		this.kompetenzPunkte = 20;
		this.basisAngriff = kraft;
		this.spezialAngriff = kraft * 3;

	}

	@Override
	public void angriff(Spieler spieler, Spieler spielerG) {
		int angriffWahl;
		do {
			System.out.println("Welche Angriff möchtest du nutzen?");
			System.out.println("1.Axtschlag\n2.Super Wutschlag");
			Scanner scanner = new Scanner(System.in);
			angriffWahl = scanner.nextInt();
			switch (angriffWahl) {
			case 1:
				System.out.println(spielerG.figur.name + " du lernst die Axt von " + spieler.figur.name + " kennen!\n");
				spielerG.figur.leben = spielerG.figur.leben - spieler.figur.getBasisAngriff();
				if (spielerG.figur.leben <= 0) {
					System.out.println(spieler.figur.name + " hat dich mit seiner Axt zerstückelt! Loser!");
				} else {
					System.out.println(
							spielerG.figur.name + ", du hast noch " + spielerG.figur.leben + " Lebenspunkte\n");
				}

				break;
			case 2:
				
				if (countSpezAngriff > 0) {
					countSpezAngriff--;
					spieler.figur.leben = spieler.figur.leben - (spieler.figur.kraft / 2);
					System.out.println(spieler.figur.name
							+ ",du schlagst mit so viel Wut, dass du dich dabei selber verletzt hast.\n");
					System.out.println("Du hast noch: " + spieler.figur.leben + " Lebenspunkte übrig!");
					spielerG.figur.leben = spielerG.figur.leben - spieler.figur.getSpezialAngriff();

					if (spielerG.figur.leben <= 0) {
						System.out
								.println(spieler.figur.name + " hat dich vor Wut mit bloße Hände zerstückelt! Loser!");
					} else {
						System.out.println(
								
								spielerG.figur.name + ", du hast noch " + spielerG.figur.leben + " Lebenspunkte\n");
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
		return kraft + 5;
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
		return basisAngriff = kraft * 3;
	}
}
