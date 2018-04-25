package tictactoe.engine.Dimensions;

public class Dimensions {

    private int width;
    private int height;

    public Dimensions(int sizeOfBoard) {
        this.height = sizeOfBoard;
        this.width = sizeOfBoard;
    }

    public Dimensions(int defaultWidth, int defaultHeight) {
        this.height = defaultHeight;
        this.width = defaultWidth;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
