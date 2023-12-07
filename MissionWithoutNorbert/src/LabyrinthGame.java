import java.util.Scanner;

public class LabyrinthGame {
public static void main(String[] args) {
    Scanner StaticScanner = new Scanner(System.in);

    int[][]Labyrinth=new int[][]{{1,1,1,1,1,0,1},
                                 {1,0,0,0,1,0,1},
                                 {1,0,1,0,1,0,1},
                                 {1,0,1,0,0,0,1},
                                 {1,0,1,1,1,1,1}};

    for(int zeile=0; zeile<Labyrinth.length;zeile++){
        for(int spalte=0; spalte<Labyrinth[0].length; spalte++){
            System.out.print(Labyrinth[zeile][spalte]);
            
        }
        System.out.println();
        
    }

}

}
