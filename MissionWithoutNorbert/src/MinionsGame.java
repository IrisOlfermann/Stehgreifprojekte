import java.util.Scanner;

public class MinionsGame {
  /**
   * @param args
   * param steht für Parameter und args für Argumente.
   * Katze miau
   */
  public static void main(String[] args) {
    Scanner StaticScanner = new Scanner(System.in);

    final int MINION = 10;
    final char NORBERT = 'O';
    final int MAX_DRAW = 3;

    // Variablen um die Position zu bestimmen
    int randomPosition = (int) (Math.random() * 10);
    int leftSide = randomPosition;
    int rightSide = MINION - leftSide;

    // Variablen für die Teamgröße und Endausgabe?
    int computerTeamSize;
    int userTeamSize;

    // Benutzer Optionen
    char drawSide;
    int drawRange;
    

    System.out.println("Mission without Nobert!");

    // Minions + Nobert aufgestellt!
    for (int i=0; i<leftSide; i++){
      System.out.print('X'+" ");
    }
    System.out.print(NORBERT+" ");
    for (int i=0; i<rightSide; i++){
      System.out.print('X'+" ");
    }
    System.out.println();

    System.out.println("Wählen Sie ihre stärkste Mannschaft!");
    System.out.println("Tipp: Nobert (O) ist am schwächsten");
    System.out.println("Es dürfen maximal 3 Minions pro Runde ziehen");
    System.out.println("Du bist am zug. Von welcher Seite möchtest du wählen?");

    drawSide = StaticScanner.next().charAt(0);
    System.out.println("Wie viele Minions möchten Sie ziehen?");
    drawRange =StaticScanner.nextInt(); 

    



  }
}