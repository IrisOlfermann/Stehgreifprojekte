public class LabyrinthGame {
public static void main(String[] args) {
    int[][]x=new int[][]{{1,1,1,1,1,0,1},
                         {1,0,0,0,1,0,1},
                         {1,0,1,0,1,0,1},
                         {1,0,1,0,0,0,1},
                         {1,0,1,1,1,1,1}};

    for(int zeile=0; zeile<x.length;zeile++){
        for(int spalte=0; spalte<x[0].length; spalte++){
            System.out.print(x[zeile][spalte]);
            
        }
        System.out.println();
        
    }

}

}
