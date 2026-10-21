package aldrinm.dlgo;

import java.util.List;

public record Point(int row, int col) {

  List<Point> neighbours() {
    return List.of(
        new Point(row - 1, col),
        new Point(row + 1, col),
        new Point(row, col - 1),
        new Point(row, col + 1)
    );
  }
}
