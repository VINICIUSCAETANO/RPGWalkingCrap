package local.util;

import java.util.Random;

public class Util {

    public static int random(int min, int max){
        Random r = new Random();
        return min+r.nextInt(max-min);
    }
}
