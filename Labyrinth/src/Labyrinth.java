import java.util.Scanner;
public class Labyrinth {
      /**
   * @param args
   * @authors Aya Akutsu, Dominik Kulak, Iris Olfermann
   */
    public static void main(String[] args){
        //Die Erklärung des Spiels wird ausgeben.
        gameExplanation();

        // Für die Eingabe vom Nutzer
        Scanner StaticScanner = new Scanner(System.in);
        char[][] labyrinth = labyrinthSelection();
        char[][] route = new char[labyrinth.length][labyrinth[0].length];
        // kopiert das Labyrinth in den route-Array, in dem der Weg gespeichert wird.
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                route[i][j]=labyrinth[i][j];
            }
        }
        
        printLabyrinth(labyrinth);
    }

    // Nutzerauswahl des Labyrinths
    public static char[][] labyrinthSelection(){
        char[][] labyrinth1 = new char[][]{
        {'╔', '═', '═', '═', '═', '═', '═', '═', '╗'},
        {'║', '×', '×', '×', '×', '×', '×', '×', '║'},
        {'║', '×', '║', '═', '║', '×', '║', '×', '║'},
        {'║', '×', '×', '×', '║', '×', '║', '×', '║'},
        {'║', '×', '╔', '×', '║', '×', '║', '×', 'A'},
        {'╚', 'B', '╩', '=', '╩', '═', '╩', '═', '╝'}
        };
        char labyrinth2[][]= new char[][]{
        {'╔','═','═','═','═','╦','═','═','╗'},
        {'║','×','×','×','×','║','×','×','A'},
        {'║','×','║','║','×','×','×','×','║'},
        {'║','×','×','╠','═','═','═','═','╣'},
        {'B','×','×','║','×','×','×','×','║'},
        {'║','║','×','║','×','║','×','║','║'},
        {'║','×','×','×','×','║','×','×','║'},
        {'║','×','×','×','×','×','×','×','║'},
        {'╚','═','═','═','═','═','═','═','╝'}
        };
        char[][] labyrinth3 = new char[][]{
        {'╔', '═', '═', '═', '╦', '═', '═', '═', '═', '═', '╗'},
        {'║', '×', '×', '×', '║', '×', '×', '×', '×', '×', '║'},
        {'║', '═', '×', '╔', '╝', '×', '║', '×', '║', '×', '║'},
        {'║', '×', '×', '║', '×', '×', '║', '×', '║', '×', '║'},
        {'║', '×', '×', '×', '×', '×', '║', '×', '║', '×', 'A'},
        {'║', '×', '╔', '×', '║', '×', '║', '×', '×', '×', '║'},
        {'║', '×', '║', '×', '╚', '═', '╣', '×', '║', '×', '║'},
        {'║', '×', '║', '×', '×', '×', '║', '×', '║', '×', '║'},
        {'B', '×', '╠', '═', '═', '×', '║', '×', '×', '×', '║'},
        {'╚', '═', '╩', '/', '═', '═', '╩', '═', '═', '═', '╝'}
        };
        int selectedLabyrinth;

        System.out.println("Welches Labyrinth 1,2 oder 3 soll BB2 durchlaufen?");
        // Fehlererkennung bei der Nutzereingabe
        selectedLabyrinth = recognizeErrors();
        // Zurückgabe des ausgewählten Labyrinths
        switch (selectedLabyrinth) {
            case 1:
                return labyrinth1;
            case 2:
                return labyrinth2;
            case 3:
                return labyrinth3;
                // nochmal angucken
            default:
            return labyrinth1;
        }
    }

    /**
     * überprüft eine Eingabe des Nutzersn auf Fehler
     * @return eine Ganzzahl
     *
     */
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
      public static void printLabyrinth(char[][]labyrinth){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                System.out.print(labyrinth[i][j]);
            }
            System.out.println();
        }
      }

      // Die Methode gameExplanation gibt die Erklärung des Spiels aus.
      public static void gameExplanation(){
        System.out.println("");
        System.out.println("BB-8 möchte gerne nach Hause kommen muss aber jedoch durch eins der drei Labyrinthe durch.");
        System.out.println("Um das zu schaffen verwentet er die Rechte-Hand-Regel.");
        System.err.println("BB-8 wird nach dieser Strategie Schritt für Schritt gehen, so dass man seine Suche nachvollziehen kann.");
        System.out.println("Sobald BB-8 das Ziel erreicht hat, zeigt er uns sein Weg in die Freiheit.");
        System.out.println("");
      }
}