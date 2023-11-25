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
    int leftDrawn = 0;
    int rightDrawn = 0;

    // Variablen für die Teamgröße und Endausgabe?
    int computerTeamSize =0;
    int userTeamSize=0;


    // Benutzer Optionen
    char drawSide='l';
    int drawRange=0;

    // Zufallszahl wer beginnt. 0 für Computer, 1 für Nutzer
    int beginner = drawRandomNumber(1);
    // o ist links, 1 ist rechts
    int drawSideComputer;

    System.out.println("Mission without Nobert!");

    // Spiel start
    while(leftDrawn+rightDrawn <= MINION){
      lineupMinions(leftSide, rightSide, NORBERT, leftDrawn, rightDrawn);
      // Zug des Computers
      if(beginner==0){
      System.out.println("Der Computer zieht jetzt eine zufällige Anzahl von Minions.");
      drawRange = (int) ((Math.random()*3)+1);
      drawSideComputer = drawRandomNumber(1);
      computerTeamSize += drawRange;
      System.out.println("Computer hat"+drawRange+"gezogen, von der"+drawSideComputer);
      if (drawSideComputer==0) {
        leftDrawn += drawRange;
      } else {
        rightDrawn += drawRange;
      }
    }
    // Zug des Nutzers
    else{
      System.out.println("Du bist am Zug.");
      System.out.println("Wählen deine stärkste Mannschaft!");
      System.out.println("Tipp: Nobert (O) ist am schwächsten");
      // Seite wählen
      System.out.println("Von welcher Seite l)inks oder r)echts möchtest du wählen?");
      drawSide = StaticScanner.next().charAt(0);

      // Anzahl wählen
      System.out.println("Wieviele Minions sollen in dein Team? Wähle eine Anzahl von 1-3");
      drawRange = recognizeErrors(StaticScanner.nextInt());

      // Addiere die Anzahl der gezogenen Minions zur Teamgröße
      userTeamSize += drawRange;
      if (drawSide=='l'||drawSide=='L') {
        leftDrawn += drawRange;
      } else if (drawSide=='r'||drawSide=='R'){
        rightDrawn += drawRange;
      }
    }
    //Spieler wechsel
    if(beginner==0){
      beginner = 1;
    }
    else{
      beginner = 0;
    }
    }
  }

  public static int drawRandomNumber(int b){
    return (int) (Math.random()*(b+1));
  }

  public static void lineupMinions(int leftSide, int rightSide, char NORBERT, int leftDrawn, int rightDrawn){
   // Minions + Nobert aufgestellt!
    for (int i=0; i<leftDrawn; i++){
      System.out.print('-'+" ");
    }
    for (int i=leftDrawn; i<leftSide; i++){
      System.out.print('X'+" ");
    }
    System.out.print(NORBERT+" ");
    for (int i=0; i<(rightSide-rightDrawn); i++){
      System.out.print('X'+" ");
    }
    for (int i=0; i<(rightDrawn); i++){
      System.out.print('-'+" ");
    }
    System.out.println();

  }
 public static int recognizeErrors(int drawRange){
  // auch hier muss ein StaticScanner Objekt erzeugt werden, um die Methode zu verwenden.
    Scanner StaticScanner = new Scanner(System.in);
    boolean validInput= false;
    while(validInput!= true){
        if (drawRange==1 || drawRange ==2 || drawRange==3) {
          validInput = true;
        }
        else{
          System.out.println("Ungültige Eingabe. Wähle eine Zahl zwischen 1-3.");
          drawRange =StaticScanner.nextInt();
        }
    }
  return drawRange;
 }
}