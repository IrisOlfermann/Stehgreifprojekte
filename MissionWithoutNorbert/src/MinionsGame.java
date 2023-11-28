import java.util.Scanner;
public class MinionsGame {
  /**
   * @param args
   *
   *
   */
  public static void main(String[] args) {
    // Um die Emoji‘s verwenden zu können
    System.setProperty("file.encoding", "UTF-8");

    Scanner StaticScanner = new Scanner(System.in);

    final int MINION = 10;
    final String NORBERT = "🔴";
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
    System.out.println();
    System.out.println("Mission without Nobert!");
    System.out.println();

    // Spiel start
    while(!userHasNorbert&&!computerHasNorbert){
      lineupMinions(leftSide, rightSide, NORBERT, leftDrawn, rightDrawn, computerHasNorbert, userHasNorbert);
      // Zug des Computers
      if(beginner==0){
      drawRange = (int) ((Math.random()*MAX_DRAW)+1);
      drawSideComputer = drawRandomNumber(1);
      computerTeamSize += drawRange;
      // Ausgabe für den Nutzer, was der Computer gezogen hat.
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
      else if(leftDrawn+rightDrawn==MINION){
        computerHasNorbert= true;
      }
      // zieht wenn weniger da sind als die zufällige Range nur noch soviele wie da sind und Norbert.
      //addiert die Anzahl, die der Computer gezogen hat zur Gesamtanzahl von gezogenen Links oder Rechts
      if (drawSideComputer==0) {
        leftDrawn += drawRange;
      } else {
        rightDrawn += drawRange;
      }
      // falls der Computer die letzten Minions zieht, wird userHatNorbert auf true gesetzt
      if(leftDrawn+rightDrawn==MINION &&!computerHasNorbert){
        userHasNorbert= true;
      }
      if (drawSideComputer==0) {
        System.out.println("🤖: Computer zieht "+drawRange+" Minions von der linken Seite.");
      }  else if (drawSideComputer==1) {
        System.out.println("🤖: Computer zieht "+drawRange+" Minions von der rechten Seite.");
      }
    }

    // Zug des Nutzers
    else{
      System.out.println("Du bist am Zug.");
      System.out.println("Stelle dein Team zusammen!");
      System.out.println();
      System.out.println("Tipp: Wenn du Norbert " + NORBERT + " in dein Team wählst, verlierst du.");
      System.out.println();

      // Seite wählen
      System.out.println();
      System.out.println("Von welcher Seite l)inks oder r)echts möchtest du wählen?");
      drawSide = recognizeErrors(StaticScanner.next().charAt(0));

      // Anzahl wählen
      System.out.println();
      System.out.println("Wieviele Minions sollen in dein Team? Wähle eine Anzahl von 1-3");
      drawRange = recognizeErrors();
      // wenn die linke und die rechte Seite leer sind, wird Norbert dem Team "hinzugefügt"
      if((rightSide-rightDrawn)==0 && (leftSide-leftDrawn==0)){
        userHasNorbert= true;
      }
      // Addiere die Anzahl der gezogenen Minions zur Teamgröße
      userTeamSize += drawRange;
      if (drawSide=='l') {
        leftDrawn += drawRange;
      } else if (drawSide=='r'){
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
    // Spielende/ Ausgabe der Teams
    // Computer
    System.out.println();
    System.out.println("⬇️ ⬇️ ⬇️  Das Spiel ist vorbei. ⬇️ ⬇️ ⬇️");
    System.out.println();
    System.out.println();
    System.out.println("Das Team des Computers besteht aus : "+computerTeamSize+" Minion.");
    for(int i=0; i<computerTeamSize;i++){
      System.out.print("🟡"+" ");
    }
    if(computerHasNorbert){
      System.out.println(NORBERT+" ");
    }
    System.out.println();
    // Nutzer
        System.out.println();
        System.out.println("Dein Team besteht aus : "+userTeamSize+" Minion.");
    for(int i=0; i<userTeamSize;i++){
      System.out.print("🟡"+" ");
    }
    if(userHasNorbert){
      System.out.print(NORBERT+" ");
      }
      System.out.println();
    if (userHasNorbert) {
      System.out.println();
      System.out.println("Da du Norbert 🔴 in dein Team gezogen hast, hast du leider verloren 😭");
      System.out.println();
    } else if(computerHasNorbert){
      System.out.println();
      System.out.println("🎉 Der Computer hat Norbert in sein Team gewählt, also hast du gewonnen!!! 🥳");
      System.out.println();
    }
    System.out.println();
  }

  public static int drawRandomNumber(int b){
    return (int) (Math.random()*(b+1));
  }

  public static void lineupMinions(int leftSide, int rightSide, String NORBERT, int leftDrawn, int rightDrawn, boolean computerHasNorbert, boolean userHasNorbert){
   // Minions + Nobert aufgestellt!
    for (int i=0; i<leftDrawn; i++){
      System.out.print("🕳️  ");
    }
    for (int i=leftDrawn; i<leftSide; i++){
      System.out.print("🟡"+" ");
    }
    if(computerHasNorbert==false&&userHasNorbert==false){
      System.out.print(NORBERT+" ");
    }
    else{
      System.out.print("🕳️  ");
    }
    for (int i=0; i<(rightSide-rightDrawn); i++){
      System.out.print("🟡"+" ");
    }
    for (int i=0; i<(rightDrawn); i++){
      System.out.print("🕳️  ");
    }
    System.out.println("\n");
    System.out.println();

  }
  public static int recognizeErrors(){
  // auch hier muss ein StaticScanner Objekt erzeugt werden, um die Methode zu verwenden.
    Scanner StaticScanner = new Scanner(System.in);
    boolean validInput= false;
    int drawNumber=0;
    String drawRange = StaticScanner.nextLine();
    while(validInput!= true){

      try {

          drawNumber = Integer.parseInt(drawRange);
          System.out.println();
          System.out.println("Eingegebene Zahl: " + drawNumber);
      } catch (NumberFormatException e) {
          System.out.println("Die Eingabe ist keine Zahl. Bitte eine Zahl zwischen 1-3 eingeben.");
      }

        if (drawNumber==1 || drawNumber ==2 || drawNumber==3) {
          validInput = true;
        }
        else{
          System.out.println();
          System.out.println("⛔ Ungültige Eingabe. Wähle eine Zahl zwischen 1-3.");
          drawRange =StaticScanner.nextLine();
        }
    }
  return drawNumber;
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