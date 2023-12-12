import java.util.Scanner;
public class LabyrinthGame {
    public static void main(String[] args){


    }
            char[][] userSelection(){
    // Für die Eingabe vom Nutzer
    Scanner StaticScanner = new Scanner(System.in);
    
    char[][] labyrinth_1 = new char[][]{
        {'╔', '═', '═', '═', '═', '═', '═', '═', '╗'},
        {'║', '×', '×', '×', '×', '×', '×', '×', '║'},
        {'║', '×', '║', '═', '║', '×', '║', '×', '║'},
        {'║', '×', '×', '×', '║', '×', '║', '×', '║'},
        {'║', '×', '╔', '×', '║', '×', '║', '×', 'A'},
        {'╚', 'B', '╩', '=', '╩', '═', '╩', '═', '╝'}
        };
        

    char[][] labyrinth_2 = new char[][]{
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
        char labyrinth_3[][]= new char[1][1];
        
        int selectedLabyrinth;

        System.out.println("Welches Labyrinth 1,2 oder 3 soll BB2 durchlaufen?");
        // Fehlererkennung bei der Nutzereingabe
        selectedLabyrinth = recognizeErrors();
        // Zurückgabe des ausgewählten Labyrinths
        switch (selectedLabyrinth) {
            case 1:
                return labyrinth_1;
            case 2:
                return labyrinth_2;
            case 3:
                return labyrinth_3;
                // nochmal angucken
            default:
            return labyrinth_1;
        }
        }
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
}
