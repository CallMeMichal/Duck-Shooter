package GAME;

public class Score {

   private static int value =0;

   public static int getValue(){
       return value;
   }

   public static void increment(int x){
       value = value +x;
   }

   public static void reset(){
       value = 0;
   }

    public static void setValue(int value) {
        Score.value = value;
    }
}
