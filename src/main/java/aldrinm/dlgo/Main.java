package aldrinm.dlgo;

public class Main {

  static void main() {
    Board board = new Board(6, 7);

    board.placeStone(Player.WHITE, new Point(1, 2));
    board.placeStone(Player.WHITE, new Point(1, 3));

    board.placeStone(Player.WHITE, new Point(2, 1));
    board.placeStone(Player.BLACK, new Point(2, 2));
    board.placeStone(Player.BLACK, new Point(2, 3));
    board.placeStone(Player.WHITE, new Point(2, 4));
    board.placeStone(Player.BLACK, new Point(2, 5));

    board.placeStone(Player.WHITE, new Point(3, 1));
    board.placeStone(Player.BLACK, new Point(3, 2));
    board.placeStone(Player.WHITE, new Point(3, 3));
    board.placeStone(Player.BLACK, new Point(3, 4));
    board.placeStone(Player.BLACK, new Point(3, 5));

    board.placeStone(Player.BLACK, new Point(4, 3));


  }

}
