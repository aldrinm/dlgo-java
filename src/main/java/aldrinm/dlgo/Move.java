package aldrinm.dlgo;

public final class Move {

  private Point point;
  private boolean isPlay;
  private boolean isResign;
  private boolean isPass;

  private Move() {
  }

  static Move play(Point point) {
    Move move = new Move();
    move.point = point;
    move.isPlay = true;
    return move;
  }

  static Move resign() {
    Move move = new Move();
    move.isResign = true;
    return move;
  }

  static Move pass() {
    Move move = new Move();
    move.isPass = true;
    return move;
  }
}
