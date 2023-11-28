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

    // Für die Eingabe vom Nutzer
    Scanner StaticScanner = new Scanner(System.in);

    // Konstante Variablen
    final int MINION = 10;
    final String NORBERT =  "🔴";
    final int MAX_DRAW = 3;

    // Variablen um die Position von Norbert & Aufteilung von linker & rechter Seite zu bestimmen
    int randomPosition = drawRandomNumber(MINION);
    int leftSide = randomPosition;
    int rightSide = MINION - leftSide;
    int leftDrawn = 0;
    int rightDrawn = 0;

    // Variablen für die Teamgröße und Endausgabe
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

    // Spieleinführung
    System.out.println("\nMission without Nobert " + NORBERT +  "!\n");
    System.out.println("In dem Spiel geht es darum, aus einer zufälligen zusammengestellten Reihe aus Minions und Norbert Teams zu wählen.");
    System.out.println("Dabei verlierst du, wenn du Norbert in dein Team ziehst.");
    System.out.println("Es wird immer abwechselnd bis zu 3 Minions gezogen.");
    System.out.println("Es wird zufällig ausgelost, wer anfangen darf.");
    // Ausgabe, wer beginnt
    if(beginner==0){
      System.out.println("Der Computer wurde ausgelost und darf anfangen.\n");
    }
    else{
      System.out.println("Du wurdest ausgelost und darfst anfangen.\n");
    }
    System.out.print("\nHier ist die zufällig ausgeloste Reihenfolge der Minions:\n");

    // Spielstart
    while(!userHasNorbert&&!computerHasNorbert){
      //  Ausgabe der Minions & Norbert Aufstellung
      lineupMinions(leftSide, rightSide, NORBERT, leftDrawn, rightDrawn, computerHasNorbert, userHasNorbert);
      // Zug des Computers
      if(beginner==0){
      drawRange = (int) ((Math.random()*MAX_DRAW)+1);
      drawSideComputer = drawRandomNumber(1);
      // Ausgabe für den Nutzer, was der Computer gezogen hat.
      // wir wollen, dass der Computer die Seite wechselt, wenn auf einer Seite keine Minions mehr sind.
      if ((leftSide-leftDrawn)==0) {
        drawSideComputer = 1; // wechselt auf rechts
        if(drawRange>(rightSide-rightDrawn)){ // zieht wenn weniger da sind als die zufällige Range nur noch soviele wie da sind und Norbert.
        drawRange = (rightSide-rightDrawn);
        computerHasNorbert = true;
        computerTeamSize += drawRange;
        outputComputerTurn(drawRange, drawSideComputer);
      }
      }
      else if((rightSide-rightDrawn)==0){
        drawSideComputer = 0; // wechselt auf links
        if(drawRange>(leftSide-leftDrawn)){ {// zieht wenn weniger da sind als die zufällige Range nur noch soviele wie da sind und Norbert.
        drawRange = (leftSide-leftDrawn);
        computerHasNorbert = true;
        computerTeamSize += drawRange;
        outputComputerTurn(drawRange, drawSideComputer);
      }
      }
      else if(leftDrawn+rightDrawn==MINION){ // Sobald alle übrigen Minions gezogen wurden, wird Norbert zugewiesen
        computerHasNorbert= true;
      }
      if(!computerHasNorbert){ // Solange Norbert existriert
      if (drawSideComputer==0) { // Zieht von links
        if(drawRange>(leftSide-leftDrawn)){ // zieht wenn weniger da sind als die zufällige Range nur soviele wie da sind. (Zählt für die linke Seite)
        drawRange = (leftSide-leftDrawn);}
        leftDrawn += drawRange;
      } else {
        if(drawRange>(rightSide-rightDrawn)){ // zieht wenn weniger da sind als die zufällige Range nur soviele wie da sind. (Zählt für die rechte Seite)
        drawRange = (rightSide-rightDrawn);}
        rightDrawn += drawRange;
      }
      computerTeamSize += drawRange;  // Teamgröße vom Computer wird Aktualisiert.
      outputComputerTurn(drawRange, drawSideComputer);
    }
      // falls der Computer die letzten Minions zieht, wird userHatNorbert auf true gesetzt
      if(leftDrawn+rightDrawn==MINION &&!computerHasNorbert){
        userHasNorbert= true;
      }
    }

    // Zug des Nutzers
    else{
      System.out.println("Du bist am Zug.");
      System.out.println("Stelle dein Team zusammen!");

      // Seite wählen
      System.out.println();
      System.out.println("Von welcher Seite l)inks oder r)echts möchtest du wählen?");
      drawSide = recognizeErrors(StaticScanner.next().charAt(0));
      // Anzahl wählen
      System.out.println();
      System.out.println("Wieviele Minions sollen in dein Team? Wähle eine Anzahl von 1-3");
      drawRange = recognizeErrors();
        // Wenn weniger da sind als der Nutzer ziehen will, Anzahl die gezogen wird automatisch auf Rest
        if((drawRange>(rightSide-rightDrawn))&& drawSide=='r'){
        drawRange = (rightSide-rightDrawn);
        userHasNorbert = true;
        System.out.println();
        System.out.print("🤦🏻‍♂️🤦🏿🤦🏼‍♂️ Ups, du hast extra Norbert gezogen. 🤦🏾🤦🏻‍♀️🤦🏽‍♀️\n");
      }
        else if((drawRange>(leftSide-leftDrawn))&& drawSide=='l'){
        drawRange = (leftSide-leftDrawn);
        userHasNorbert = true;
        System.out.println();
        System.out.print("🤦🏻‍♂️🤦🏿🤦🏼‍♂️ Ups, du hast extra Norbert gezogen. 🤦🏾🤦🏻‍♀️🤦🏽‍♀️\n");
 }
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
    if(computerTeamSize==1){
      System.out.println("Das Team des Computers besteht aus einem Minion.");
    }else{
      System.out.println("Das Team des Computers besteht aus : "+computerTeamSize+" Minions.");
    }
    if(computerHasNorbert){ // Ausgabe des PC von Minions mit Norbert
      for(int i=0; i<computerTeamSize-1;i++){
      System.out.print("🟡");
    }
      System.out.println(NORBERT);
    }
    else{
      for(int i=0; i<computerTeamSize;i++){ // Ausgabe des PC von Minions ohne Norbert
      System.out.print("🟡");
    }
    }
    System.out.println();
    // Nutzer
    if(userTeamSize==1){
      System.out.println();
      System.out.println("Dein Team besteht aus einem Minion und Norbert.");
    }
    else if(userTeamSize>1&&userHasNorbert){
      System.out.println();
      System.out.println("Dein Team besteht aus : "+userTeamSize+" Minions und Norbert.");
    }
    else if(userTeamSize>1&&computerHasNorbert){
      System.out.println();
      System.out.println("Dein Team besteht aus : "+userTeamSize+" Minions.");
    }
    else if(userTeamSize==0&&userHasNorbert){
      System.out.println();
      System.out.println("Dein Team besteht nur aus Norbert.");
    }
    for(int i=0; i<userTeamSize;i++){
      System.out.print("🟡");
    }
    if(userHasNorbert){
      System.out.print(NORBERT);
      }
      System.out.println();
    if (userHasNorbert) {
      System.out.println();
      System.out.println("Da du Norbert "+ NORBERT +" in dein Team gezogen hast, hast du leider verloren. 😭😭😭");
    } else if(computerHasNorbert){
      System.out.println();
      System.out.println("🎉 Der Computer hat Norbert "+ NORBERT +" in sein Team gewählt, also hast du gewonnen!! 🥳");
    }
    System.out.println();
  }

  // Hier wird eine zufällige Zahl zwischen  0 und 1 gemacht umd später zu bestimmen wer das Spiel beginnt.
  // Sollte die zufällige Zahl eine 0 sein fängt der Computer an.
  // Sollte die zufällige Zahl eine 1 sein fängt der Nutzer an.
  public static int drawRandomNumber(int b){
    return (int) (Math.random()*(b+1));
  }

  public static void lineupMinions(int leftSide, int rightSide, String NORBERT, int leftDrawn, int rightDrawn, boolean computerHasNorbert, boolean userHasNorbert){
   // Minions + Nobert aufgestellt!
    for (int i=0; i<leftDrawn; i++){ // Ausgabe der abgezogenen Minions auf der linken Seite
      System.out.print("⚫");
    }
    for (int i=leftDrawn; i<leftSide; i++){ // Ausgabe der bestehenden Minions auf der linken Seite
      System.out.print("🟡");
    }
    if(computerHasNorbert==false&&userHasNorbert==false){ //  Ausgabe von bestehenden Norbert
      System.out.print(NORBERT);
    }
    for (int i=0; i<(rightSide-rightDrawn); i++){ // Ausgabe der abgezogenen Minions auf der rechten Seite
      System.out.print("🟡");
    }
    for (int i=0; i<(rightDrawn); i++){ //s.o
      System.out.print("⚫");
    }
    System.out.println("\n");

  }
  // bei Eingabe der DrawRange Fehler abfangen
 public static int recognizeErrors(){
  // auch hier muss ein StaticScanner Objekt erzeugt werden, um die Methode zu verwenden.
    Scanner StaticScanner = new Scanner(System.in);
    boolean validInput= false;
    int drawNumber=0;
    String drawRange = StaticScanner.nextLine();

    while(validInput!= true){
      // fängt ab, falls ein falscher Datentyp eingegeben wird.
      try {
          drawNumber = Integer.parseInt(drawRange);
      } catch (NumberFormatException e) {
          System.out.println("Die Eingabe ist keine Zahl. Bitte eine Zahl zwischen 1-3 eingeben.");
      }
      // Wenn klar ist, dass es eine Zahl ist, wird geprüft, ob sie zwischen 1-3 liegt.
        if (drawNumber==1 || drawNumber ==2 || drawNumber==3) {
          validInput = true;
        }
        else{
          System.out.println("Ungültige Eingabe. Wähle eine Zahl zwischen 1-3.");
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
 public static void outputComputerTurn(int drawRange, int drawSideComputer){
        //Ausgabe für den Nutzer, wieviele Minions der Computer zieht.
      if (drawSideComputer==0) {
        if(drawRange==1){
          System.out.println("🤖: Computer zieht einen Minion von der linken Seite.");
        }
        else if(drawRange>1){
          System.out.println("🤖: Computer zieht "+drawRange+" Minions von der linken Seite.");
        }
        else if(drawRange==0){
          System.out.println("🤖: Computer zieht Norbert.");
        }
      }
      else if (drawSideComputer==1) {
          if(drawRange==1){
          System.out.println("🤖: Computer zieht einen Minion von der rechten Seite.");
          }
          else if(drawRange>1){
          System.out.println("🤖: Computer zieht "+drawRange+" Minions von der rechten Seite.");
          }
          else if(drawRange==0){
          System.out.println("🤖: Computer zieht Norbert.");
          }
      }
 }
}