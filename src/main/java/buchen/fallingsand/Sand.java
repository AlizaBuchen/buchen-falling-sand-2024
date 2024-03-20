package buchen.fallingsand;

import java.util.Random;
public class Sand {
    private final int[][] field;
    private final Random random;

    public Sand(int width, int height) {
        field = new int[height][width];
        this.random = new Random();
    }

    public Sand(int width, int height, Random random) {
        field = new int[height][width];
        this.random = random;
    }

    public int getHeight(){
        return field.length;
    }

    public int getWidth(){
        return field[0].length;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (int[] ints : field) {
            for (int anInt : ints) {
                builder.append(anInt);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * @return the value in field
     */
    public int get(int x, int y)
    {
        return field[y][x];
    }

    /**
     * Sets the value in field to be 1
     */
    public void put(int x, int y)
    {
        field[y][x] = 1;
    }

    public void fall() {
        //moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1) {
                    if (field[y + 1][x] == 0) {
                        // does the sand fall straight down?
                        field[y][x] = 0;
                        put(x, y + 1);
                        continue;
                    }

                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;

                    if (x + direction1 > -1 && x + direction1 < field[0].length
                            && field[y + 1][x + direction1] == 0) {
                        field[y][x] = 0;
                        put(x + direction1, y + 1);
                    } else if (x + direction2 > -1 && x + direction2 < field[0].length
                            && field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        put(x + direction2, y + 1);
                    }
                }
            }
        }
    }

    public void randomSand(int n) {
        for (int i = 0; i < n; i++) {
            put(random.nextInt(field[0].length), random.nextInt(field.length));
        }
    }
}
