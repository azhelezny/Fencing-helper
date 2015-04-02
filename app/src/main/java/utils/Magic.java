package utils;

import java.util.Random;
import java.util.Timer;

import enums.Positions;
import properties.Properties;

/**
 * Created by andrey on 3/27/15.
 */
public class Magic {
    ;

    public static Positions getNextPosition() {
        Random random = new Random();
        int number = random.nextInt(5);
        switch (number) {
            case 0:
                return Positions.forth;
            case 1:
                return Positions.sixth;
            case 2:
                return Positions.fifth;
            case 3:
                return Positions.seventh;
            case 4:
                return Positions.eighth;
        }
        throw new RuntimeException("Random is not correct, pig!");
    }

    public static int getPeriod() {
        int max = Properties.get().getLevel().getMaxSeconds();
        int min = Properties.get().getLevel().getMinSeconds();
        return Properties.get().isUseRandom() ? (new Random().nextInt(max - min) + min) : ((max + min) / 2);
    }
}
