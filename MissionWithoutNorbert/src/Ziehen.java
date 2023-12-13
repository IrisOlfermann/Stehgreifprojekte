public class Ziehen {
  public static void main(String[] args){
    for(int i=0; i<100;i++){
      System.out.println(ziehen(3,17));
    }
  }
  public static int ziehen( int untereGrenze, int obereGrenze){
    return (int) (untereGrenze+ (Math.random()*(obereGrenze-untereGrenze+1)));
  }
}
