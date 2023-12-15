import java.util.Scanner;
public class Labyrinth {
      /**
   * @param args
   * @authors Aya Akutsu, Dominik Kulak, Iris Olfermann
   */
    public static void main(String[] args){
        // Für die Eingabe vom Nutzer
        Scanner StaticScanner = new Scanner(System.in);

        final char START ='B';
        final char END = 'A';
        final char STRAIGHT = '>';
        final char BACK = '<';
        final char LEFT = '^';
        final char RIGHT = 'v';
        final char EMPTY = '×';
        // damit können wir dann überprüfen, ob wir vor einer Wand stehen
        //String walls = "╔═╗║╚╝╩╦╠╣";
        //(walls.indexOf(labyrinth[bb8X][bb8Y]))!=-1
        // überprüft, ob der Buchstabe A in Walls drinne ist, kann genutzt werden, um zu checken, ob vor uns eine Mauer ist.

        char[][] labyrinth = labyrinthSelection();

        final int xLength = labyrinth.length;
        final int yLength = labyrinth[0].length;

        char[][] route = copyLabyrinth(labyrinth);
        char direction = '>';

        int[] startPos = findPosition(labyrinth, START);
        int[] endPos = findPosition(labyrinth, END);
        int stepCounter = 0;
        int bb8X = startPos[0];
        int bb8Y = startPos[1];

        printLabyrinth(labyrinth);
        while(!(bb8X==endPos[0] && bb8Y==endPos[1])){
            switch (direction) {
                case STRAIGHT:
                if ((bb8X+1<xLength)&&(labyrinth[bb8X+1][bb8Y]==EMPTY ||(labyrinth[bb8X+1][bb8Y]=='A'))){ // nach rechts laufen
                    direction = RIGHT;
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8X = bb8X+1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                else if((bb8Y+1<yLength)&&(labyrinth[bb8X][bb8Y+1]==EMPTY ||(labyrinth[bb8X][bb8Y+1]=='A'))){  // geradeaus laufen
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8Y = bb8Y+1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                else if((bb8X-1>0)&&(labyrinth[bb8X-1][bb8Y]==EMPTY ||(labyrinth[bb8X-1][bb8Y]=='A'))){ // links laufen
                    direction = LEFT;
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8X = bb8X-1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                else{ // rückwärts laufen
                    direction = BACK;
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8X = bb8X-1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case LEFT:
                    if((bb8Y+1<yLength)&&(labyrinth[bb8X][bb8Y+1]==EMPTY ||(labyrinth[bb8X][bb8Y+1]=='A'))){  // rechts laufen
                        direction = STRAIGHT;
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8Y = bb8Y+1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    else if((bb8X-1>0)&&(labyrinth[bb8X-1][bb8Y]==EMPTY ||(labyrinth[bb8X-1][bb8Y]=='A'))){ // geradeaus/ nach oben laufen
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8X = bb8X-1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    else if((bb8Y-1>0)&&(labyrinth[bb8X][bb8Y-1]==EMPTY ||(labyrinth[bb8X][bb8Y-1]=='A'))){ // nach links laufen
                        direction = BACK;
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8Y = bb8Y-1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    else{
                        direction = RIGHT;
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8X = bb8X+1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                case BACK:
                if ((bb8X-1>0)&&(labyrinth[bb8X-1][bb8Y]==EMPTY ||(labyrinth[bb8X-1][bb8Y]=='A'))){ // nach rechts laufen
                    direction = LEFT;
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8X = bb8X-1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    break;
                }
                else if((bb8Y-1<yLength)&&(labyrinth[bb8X][bb8Y-1]==EMPTY ||(labyrinth[bb8X][bb8Y-1]=='A'))){  // geradeaus laufen
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8Y = bb8Y-1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    break;
                }
                else if((bb8X+1<xLength)&&(labyrinth[bb8X+1][bb8Y]==EMPTY ||(labyrinth[bb8X+1][bb8Y]=='A'))){ // links laufen
                    direction = RIGHT;
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8X = bb8X-1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    break;
                }
                else{ // rückwärts laufen
                    direction = STRAIGHT;
                    labyrinth[bb8X][bb8Y]=EMPTY;
                    bb8Y = bb8Y+1;
                    labyrinth[bb8X][bb8Y]=direction;
                    printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    break;
                }
                case RIGHT:
                    if((bb8Y-1>0)&&(labyrinth[bb8X][bb8Y-1]==EMPTY ||(labyrinth[bb8X][bb8Y-1]=='A'))){  // rechts laufen
                        direction = BACK;
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8Y = bb8Y+1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    else if((bb8X-1>0)&&(labyrinth[bb8X+1][bb8Y]==EMPTY ||(labyrinth[bb8X+1][bb8Y]=='A'))){ // geradeaus/ nach unten laufen
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8X = bb8X+1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    else if((bb8Y+1<yLength)&&(labyrinth[bb8X][bb8Y+1]==EMPTY || (labyrinth[bb8X][bb8Y+1]=='A'))){ // nach links laufen
                        direction = STRAIGHT;
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8Y = bb8Y+1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    else{
                        direction = LEFT;
                        labyrinth[bb8X][bb8Y]=EMPTY;
                        bb8X = bb8X-1;
                        labyrinth[bb8X][bb8Y]=direction;
                        printLabyrinth(labyrinth);
                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
        }
    }

    }
    public static char[][]step(){
         char[][] labyrinth = new char[0][1];
         return labyrinth;

    }
    // Nutzerauswahl des Labyrinths
    public static char[][] labyrinthSelection(){
        char[][] labyrinth1 = new char[][]{
        {'╔', '═', '═', '═', '═', '═', '═', '═', '╗'},
        {'║', '×', '×', '×', '×', '×', '×', '×', '║'},
        {'║', '×', '║', '═', '║', '×', '║', '×', '║'},
        {'║', '×', '×', '×', '║', '×', '║', '×', '║'},
        {'║', '×', '╔', '×', '║', '×', '║', '×', 'A'},
        {'╚', 'B', '╩', '═', '╩', '═', '╩', '═', '╝'}
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
      public static char[][] copyLabyrinth(char[][]labyrinth){
         char[][] copy =new char[labyrinth.length][labyrinth[0].length];
        // kopiert das Labyrinth in den route-Array, in dem der Weg gespeichert wird.
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                copy[i][j]=labyrinth[i][j];
            }
        }
        return copy;
      }
      public static int[] findPosition(char[][] labyrinth, char searchedChar){
        int[] position = new int[2];
                for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if(labyrinth[i][j]== searchedChar){
                    position[0]=i;
                    position[1]=j;
                    return position;
                }
            }
        }
        return position;
      }
    //   public static void wait(){
    //     try {
    //         Thread.sleep(250);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    //   }
}