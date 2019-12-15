import java.util.Scanner;

public class Spieler {

	public boolean darfSpielbeginnen;
	public Figur figur;
	private String playerName;

	

	// Spieler wählt sein Karakter und weist die Punkte zu
	public Spieler(String playerName) {
		this.playerName = playerName;

		int figWahl;

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Mit welchem Figuren möchtest du spielen?");
			System.out.println("1.Der Magier\n2.Der Krieger\n3.Der Ninja");
			figWahl = scanner.nextInt();
			if (figWahl == 1) {
				figur = new Magier();



			} else if (figWahl == 2) {
				figur = new Krieger();

				
				
			} else if (figWahl == 3) {
				figur = new Ninja();


				
			} else {
				System.out.println("Du hast ein Quatsch reingetippt!");
				continue;
				
			}
			System.out.println("Du spielst mit " + figur.name);
			System.out.println(" ");
			werteZuweisen();

		} while (figWahl != 1 && figWahl != 2 && figWahl != 3);
		

		

	}

	/*
	 * Der Spieler bekommt 20 Kompetenzpunkte für seinen Karakter und die werden mit
	 * dieser Methode zugewiesen
	 */

	private void werteZuweisen() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Du hast 20 Kompetenz Punkte\nDie kannst du beliebig verteilen zwischen Agilität,Kraft und Intelligenz ");

		do {
			System.out.println("Wie viele Punkte willst du an Kraft zuweisen?");
			figur.kraft = scanner.nextInt();

			if (figur.kraft > 20) {
				System.out.println("Du hast nur 20 Punkte! Bitte weise die Punkte nochmal");
			}
		} while (figur.kraft > 20);
		figur.kompetenzPunkte = figur.kompetenzPunkte - figur.kraft;
		/*
		 * Es wird geprüft mit einer If Schleife ob es noch Punkte zu vergeben gibt
		 * 
		 */
		if (figur.kompetenzPunkte == 0) {
			System.out.println("Du hast alle Punkte zugewiesen!");
		} else {
			System.out.println("Du hast noch " + figur.kompetenzPunkte + " Kompetenz Punkte");
			do {
				System.out.println("Wie viele Punkte willst du an Intelligenz zuweisen?");
				figur.intelligenz = scanner.nextInt();
				if (figur.intelligenz > figur.kompetenzPunkte) {
					System.out
							.println("Du hast nur noch " + figur.kompetenzPunkte + "! Bitte weise die Punkte nochmal");
				}
			} while (figur.intelligenz > figur.kompetenzPunkte);
			figur.kompetenzPunkte = figur.kompetenzPunkte - figur.intelligenz;
			/*
			 * Es wird geprüft mit einer If Schleife ob es noch Punkte zu vergeben gibt
			 * 
			 */
			if (figur.kompetenzPunkte == 0) {
				System.out.println("Du hast alle Punkte zugewiesen!");
			} else {
				System.out.println("Du hast noch " + figur.kompetenzPunkte + " Kompetenz Punkte");

				do {
					System.out.println("Wie viele Punkte willst du an Agilität zuweisen?");

					figur.agilitaet = scanner.nextInt();
					if (figur.agilitaet > figur.kompetenzPunkte) {
						System.out.println(
								"Du hast nur noch " + figur.kompetenzPunkte + "! Bitte weise die Punkte nochmal");
					}
				} while (figur.agilitaet > figur.kompetenzPunkte);

				figur.kompetenzPunkte = figur.kompetenzPunkte - figur.agilitaet;

			}

		}
		System.out.println("Du hast alle Punkte wie folgt zugewiesen:");
		System.out.println("Kraft: " + figur.kraft);
		System.out.println("Intelligenz:" + figur.intelligenz);
		System.out.println("Agilität: " + figur.agilitaet);

	}
	
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
}
