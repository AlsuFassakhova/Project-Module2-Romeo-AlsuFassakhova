package Services;

import java.util.concurrent.ThreadLocalRandom;

public class RandomService {
    private RandomService() {
    }

    public static int getNumber(int min, int max){
       return ThreadLocalRandom.current().nextInt(min, max);
    }
}
