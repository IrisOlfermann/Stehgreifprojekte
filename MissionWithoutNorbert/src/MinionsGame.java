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
    int randomPosition = drawRandomNumber(MINION);
    int leftSide = randomPosition;
    int rightSide = MINION - leftSide;

    // Variablen für die Teamgröße und Endausgabe?
    int computerTeamSize =0;
    int userTeamSize=0;


    // Benutzer Optionen
    char drawSide;
    int drawRange;

    // Zufallszahl wer beginnt. 0 für Computer, 1 für Nutzer
    int beginner = drawRandomNumber(1);
    // o ist links, 1 ist rechts
    int drawSideComputer;

    System.out.println("Mission without Nobert!");
    lineupMinions(leftSide, rightSide, NORBERT);
    if(beginner==0){
      System.out.print("Der Computer zieht jetzt eine zufällige Anzahl von Minions.");
      drawRange = drawRandomNumber(MAX_DRAW);
      drawSideComputer = drawRandomNumber(1);
      computerTeamSize += drawRange;
      if (drawSideComputer==0) {
        leftSide -= drawRange;
      } else {
        rightSide -= drawRange;
      }
    }
    else{
      System.out.println("Wählen Sie ihre stärkste Mannschaft!");
      System.out.println("Tipp: Nobert (O) ist am schwächsten");
      System.out.println("Es dürfen maximal 3 Minions pro Runde ziehen");
      System.out.println("Du bist am zug. Von welcher Seite möchtest du wählen?");
      drawSide = StaticScanner.next().charAt(0);
      System.out.println("Wie viele Minions möchten Sie ziehen?");
      drawRange =StaticScanner.nextInt();
      userTeamSize += drawRange;
      if (drawSide=='l'||drawSide=='L') {
        leftSide -= drawRange;
      } else if (drawSide=='r'||drawSide=='R'){
        rightSide -= drawRange;
      }
    }
    lineupMinions(leftSide, rightSide, NORBERT);
  }

  public static int drawRandomNumber(int b){
    return (int) (Math.random()*(b+1));
  }

  public static void lineupMinions(int leftSide, int rightSide, char NORBERT){
   // Minions + Nobert aufgestellt!
    for (int i=0; i<leftSide; i++){
      System.out.print('X'+" ");
    }
    System.out.print(NORBERT+" ");
    for (int i=0; i<rightSide; i++){
      System.out.print('X'+" ");
    }
    System.out.println();
    
  }

}