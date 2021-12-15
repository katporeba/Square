import java.util.ArrayList;

public class Editor {
    private final ArrayList<Square> squares;

    public Editor() {
        this.squares = new ArrayList<>();
    }

    public void createSquare(int i, int j) {
        int index = returnIndexOfI(i);
        if (index != -1) squares.set(index, new Square(i,j));
        else squares.add(new Square(i,j));
    }

    public void moveSquare(int i, int j, int k) {
        int index = returnIndexOfI(i);
        if (index != -1) {
            Square squareTmp = squares.get(index);
            squareTmp.setX(squareTmp.getX()+j);
            squareTmp.setY(squareTmp.getY()+k);
        }
    }

    public void scaleSquare(int i, int j) {
        int index = returnIndexOfI(i);
        if (index != -1) squares.get(index).setJ(squares.get(index).getJ()*j);
    }

    public void printSquares() {
        Object[] sortedSquares = squares.stream().sorted(Square::compareTo).toArray();
        for (Object square : sortedSquares) System.out.println(square);
    }

    public int returnIndexOfI(int i) {
        for (Square square : squares) if (square.getI()==i) return squares.indexOf(square);
        return -1;
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public Square setSquare(Object square) {
        if(square == null) return squares.remove(squares.size()-1);
        else {
            Square tmp = (Square) square;
            int index = returnIndexOfI(tmp.getI());
            if (index == -1) {
                squares.add(tmp);
                return null;
            }
            else {
                Square returnSquare = (Square) squares.get(index).clone();
                squares.set(index, tmp);
                return returnSquare;
            }
        }
    }
}
