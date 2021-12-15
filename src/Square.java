import java.util.Objects;

public class Square implements Comparable<Square>{
    private int i;
    private int x;
    private int y;
    private int j;

    public Square(int i, int j) {
        this.i = i;
        this.x = 0;
        this.y = 0;
        this.j = j;
    }

    public Square(int i, int x, int y, int j) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.j = j;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return  i +
                " " + x +
                " " + y +
                " " + j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return i == square.i && x == square.x && y == square.y && j == square.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, x, y, j);
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Square(this.getI(), this.getX(), this.getY(), this.getJ());
        }
    }

    @Override
    public int compareTo(Square o) {
        return Integer.compare(this.getI(), o.getI());
    }
}
