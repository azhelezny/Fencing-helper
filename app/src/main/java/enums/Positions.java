package enums;

/**
 * Created by andrey on 3/26/15.
 */
public enum Positions {

    forth("4", 0),
    sixth("6", 1),
    fifth("5", 2),
    seventh("7", 3),
    eighth("8", 4);

    private final String position;
    private final int number;

    Positions(String position, int number) {
        this.position = position;
        this.number = number;
    }

    public String toString() {
        return this.position;
    }

    public int getNumber() {
        return this.number;
    }
}
