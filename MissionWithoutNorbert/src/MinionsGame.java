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
    boolean computerHasNorbert =false;
    boolean userHasNorbert=false;


    // Benutzer Optionen
    char drawSide='l';
    int drawRange=0;

    // Zufallszahl wer beginnt. 0 für Computer, 1 für Nutzer
    int beginner = drawRandomNumber(1);
    // o ist links, 1 ist rechts
    int drawSideComputer;

    System.out.println("Mission without Nobert!");

    // Spiel start
    while(!userHasNorbert&&!computerHasNorbert){
      lineupMinions(leftSide, rightSide, NORBERT, leftDrawn, rightDrawn, computerHasNorbert, userHasNorbert);
      // Zug des Computers
      if(beginner==0){
      System.out.println("Der Computer zieht jetzt eine zufällige Anzahl von Minions.");
      drawRange = (int) ((Math.random()*MAX_DRAW)+1);
      drawSideComputer = drawRandomNumber(1);
      computerTeamSize += drawRange;
      System.out.println("Computer hat "+drawRange+" gezogen, von der "+drawSideComputer);
      // wir wollen, dass der Computer die Seite wechselt, wenn auf einer Seite keine Minions mehr sind.
      if ((leftSide-leftDrawn)==0) {
        drawSideComputer = 1; // wechselt auf rechts
        if(drawRange>(rightSide-rightDrawn)){
        drawRange = (rightSide-rightDrawn);
        computerHasNorbert = true;
      }
      }
      else if((rightSide-rightDrawn)==0){
        drawSideComputer = 0; // wechselt auf links
        if(drawRange>(leftSide-leftDrawn)){
        drawRange = (leftSide-leftDrawn);
        computerHasNorbert = true;
      }

      }
      // zieht wenn weniger da sind als die zufällige Range nur noch soviele wie da sind und Norbert.
      //addiert die Anzahl, die der Computer gezogen hat zur Gesamtanzahl von gezogenen Links oder Rechts
      if (drawSideComputer==0) {
        leftDrawn += drawRange;
      } else {
        rightDrawn += drawRange;
      }
    }
    // Zug des Nutzers
    else{
      System.out.println("Du bist am Zug.");
      System.out.println("Stelle dein Team zusammen!");
      System.out.println("Tipp: Wenn du Norbert in dein Team wählst, verlierst du.");

      // Seite wählen
      System.out.println("Von welcher Seite l)inks oder r)echts möchtest du wählen?");
      drawSide = recognizeErrors(StaticScanner.next().charAt(0));

      // Anzahl wählen
      System.out.println("Wieviele Minions sollen in dein Team? Wähle eine Anzahl von 1-3");
      drawRange = recognizeErrors(StaticScanner.nextInt());

      // Addiere die Anzahl der gezogenen Minions zur Teamgröße
      userTeamSize += drawRange;
      if (drawSide=='l') {
        leftDrawn += drawRange;
      } else if (drawSide=='r'){
        rightDrawn += drawRange;
      }
      if((rightSide-rightDrawn)==0 && (leftSide-leftDrawn==0)){
        userHasNorbert= true;
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
    // Ausgabe der Team am Ende, funktioniert noch nicht, da wir HasNorbert noch einführen müssen.
    // Computer
    System.out.println("Das Team des Computers besteht aus : "+computerTeamSize+" Minions.");
    for(int i=0; i<computerTeamSize;i++){
      System.out.print("X ");
    }
    if(computerHasNorbert){
      System.out.println("O ");
    }
     System.out.println();
    // Nutzer
        System.out.println("Dein Team besteht aus : "+userTeamSize+" Minions.");
    for(int i=0; i<userTeamSize;i++){
      System.out.print("X ");
    }
    if(userHasNorbert){
      System.out.print("O ");
      }
      System.out.println();
    if (userHasNorbert) {
      System.out.println("Da du Norbert in dein Team gezogen hast, hast du leider verloren.");
    } else if(computerHasNorbert){
      System.out.println("Der Computer hat Norbert in sein Team gewählt, also hast du gewonnen :)");
    }
    System.out.println();
  }

  public static int drawRandomNumber(int b){
    return (int) (Math.random()*(b+1));
  }

  public static void lineupMinions(int leftSide, int rightSide, char NORBERT, int leftDrawn, int rightDrawn, boolean computerHasNorbert, boolean userHasNorbert){
   // Minions + Nobert aufgestellt!
    for (int i=0; i<leftDrawn; i++){
      System.out.print('-'+" ");
    }
    for (int i=leftDrawn; i<leftSide; i++){
      System.out.print('X'+" ");
    }
    if(computerHasNorbert==false&&userHasNorbert==false){
      System.out.print(NORBERT+" ");
    }
    else{
      System.out.print("X");
    }
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
 // Methode recognizeErrors überladen für Datentyp Char
  public static char recognizeErrors(char drawSide){
  // auch hier muss ein StaticScanner Objekt erzeugt werden, um die Methode zu verwenden.
    Scanner StaticScanner = new Scanner(System.in);
    boolean validInput= false;
    while(validInput!= true){
        if (drawSide=='l' || drawSide =='r') {
          validInput = true;
        }
        else{
          System.out.println("Ungültige Eingabe. Bitte gib entweder ein l für links oder ein r für rechts ein.");
          drawSide =StaticScanner.next().charAt(0);
        }
    }
  return drawSide;
 }
}