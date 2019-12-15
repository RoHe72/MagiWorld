  import java.util.Scanner;

public class Magier extends Figur {

	public Magier() {
		this.name = "Harry Potter";

		this.basisAngriff = intelligenz;

		this.leben = 100;
		this.kraft = 0;
		this.agilitaet = 0;
		this.intelligenz = 0;
		this.kompetenzPunkte = 20;
		this.countSpezAngriff = 2;
	} 

	@Override
	public void angriff(Spieler spieler, Spieler spielerG) {

		int angriffWahl;
		do {
			System.out.println("Welche Angriff möchtest du nutzen?");
			System.out.println("1.Feuerball\n2.Heilen");
			Scanner scanner = new Scanner(System.in);

			angriffWahl = scanner.nextInt();

			switch (angriffWahl) {

			case 1:
				spielerG.figur.leben = spielerG.figur.leben - spieler.figur.getBasisAngriff();
				
				System.out.println(
						spielerG.figur.name + " spürt grad die Wärme von " + spieler.figur.name + "s Feuerball!\n");

				if (spielerG.figur.leben <= 0) {
					System.out.println(spieler.figur.name + " hat aus dir gegrillte Würste gemacht!");
				} else {
					System.out.println(
							spielerG.figur.name + ", du hast noch " + spielerG.figur.leben + " Lebenspunkte\n");
				}

				break;

			case 2:

				if (countSpezAngriff > 0) {
					countSpezAngriff--;
					spieler.figur.leben = 100;
					System.out.println("Du bist wieder Fit mit voller Lebenspunkten!\n");

					System.out.println("Du hast nur noch " + countSpezAngriff + " Spezial Angriff!\n");
					break;
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
		return intelligenz;
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
		return leben + (100 - leben);
	}

}
