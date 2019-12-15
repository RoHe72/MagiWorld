import java.util.Scanner;

public class Spielausfuehren {

	String repeat;
	
	boolean anfrage;

	static Spieler spieler1;
	
	static Spieler spieler2;

	// Damit wird den Kampf durchgeführt
	public void kampf() {
		Scanner scanner = new Scanner(System.in);

		spielerErzeugen();
		this.getBeginningPlayer().darfSpielbeginnen = true;

		if (!spieler1.darfSpielbeginnen) {
			Spieler temp = spieler1;
			spieler1 = spieler2;
			spieler2 = temp;
		}

		fightLoop();
	}
	
	private void fightLoop() {
		while (!playersTurnKilledEnemy(spieler1, spieler2) && !playersTurnKilledEnemy(spieler2, spieler1)) {
		}
	}
	
	// Spieler entscheidet welche Figur er möchte und es wird erzeugt

	private static void spielerErzeugen() {
		spieler1 = new Spieler("Spieler 1");
		spieler2 = new Spieler("Spieler 2");
	}

	// Diese Methode ist da um zu entscheiden welche Spieler als erstes angreifen
	// darf
	private static Spieler getBeginningPlayer() {
	
		Scanner scanner = new Scanner(System.in);

		System.out.println("Jetzt werden wir ein kleines Spiel spielen um zu wissen wer von euch anfängt!");
		System.out.println("Der Spieler am näheste vom Zufallszahl gewinnt!\n");
		
		Spieler winningPlayer = null;
		
		while(winningPlayer == null) {
			winningPlayer = diceBeginner();
		}
		
		return winningPlayer;
	}

	private static int getNumberFromPlayer(Spieler spieler) {
		System.out.println(spieler.getPlayerName() + " bitte tippt ein Nummer ein zwischen 0 und 100");
		return new Scanner(System.in).nextInt();
	}

	private boolean playersTurnKilledEnemy(Spieler angreifer, Spieler verteidiger) {
		System.out.println(angreifer.getPlayerName() + " du bist dran");
		angreifer.figur.angriff(angreifer, verteidiger);
		return isPlayerDead(verteidiger);
	}

	private boolean isPlayerDead(Spieler player) {
		return player.figur.leben <= 0;
	}

	private static Spieler diceBeginner() {		
		Spieler winningPlayer = null;
		
		int zufallsZahl = getRandomNumberTo(100);
		
		int zahlS1 = getNumberFromPlayer(spieler1);
		int zahlS2 = getNumberFromPlayer(spieler2);

		zahlS1 = Math.abs(zahlS1 - zufallsZahl);
		zahlS2 = Math.abs(zahlS2 - zufallsZahl);
		
		if (zahlS1 < zahlS2) {
			printCongratulations(spieler1);
			winningPlayer = spieler1;
		}
		if (zahlS1 > zahlS2) {
			printCongratulations(spieler2);
			winningPlayer = spieler2;
		}
		if (zahlS1 == zahlS2) {
			System.out.println("Unentschieden! Ihr seid Loser!\n");
		}
		
		return winningPlayer;
	}
	
	private static void printCongratulations(Spieler player) {
		String glückwunsch = " Du hast gewonnen! Du darfst anfangen!";
		System.out.println(player.getPlayerName() + glückwunsch);
	}
	
	private static int getRandomNumberTo(int maxNumber) {
		return (int) (Math.random() * maxNumber) + 1;
	}

}
