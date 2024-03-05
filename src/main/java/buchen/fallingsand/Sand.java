package buchen.fallingsand;

public class Sand {
    private final int[][] field = new int[3][3];

    public String toString ()
    {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                builder.append(field[y][x]);
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * @return the value in field
     */
    public int get (int x, int y)
    {
        return field[y][x];
    }

    /**
     * Sets the value in field to be 1
     */
    public void put (int x, int y)
    {
        field[y][x] = 1;
    }

    public void fall() {
        //moves all sand down one square
        //if sand at bottom level doesn't go down
        //if sand falls and sand below it cant go down
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (field [y][x] == 1 && y < 2 && field [y + 1][x] == 0) {
                    put(x, y + 1);
                    field [y][x] = 0;
                }
            }
            break;
        }

    }
}
