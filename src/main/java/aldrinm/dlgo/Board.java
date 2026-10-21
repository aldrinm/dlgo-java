package aldrinm.dlgo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

  private int numRows;
  private int numCols;
//  private Player[][] grid;
  private Map<Point, GoString> grid;

  public Board(int numRows, int numCols) {
    this.numRows = numRows;
    this.numCols = numCols;
//    this.grid = new Player[numRows][numCols];
    this.grid = new HashMap<>();
  }

  public void placeStone(Player player, Point point) {
    if (!isOnGrid(point)) {
      throw new IllegalArgumentException("Invalid position " + point + " for grid");
    }
    if (get(point) != null) {
      throw new IllegalArgumentException(point + " is already occupied!");
    }

    Set<Point> liberties = new HashSet<>();
    Set<GoString> adjacentSameColor = new HashSet<>();
    Set<GoString> adjacentOppositeColor = new HashSet<>();
    for (Point neighbour : point.neighbours()) {
      if (isOnGrid(neighbour)) {
        var neighbourString = grid.get(neighbour);
        if (neighbourString == null) {
          //empty
          liberties.add(neighbour);
        } else if (neighbourString.getColor() == player) {
          //this players stone
          adjacentSameColor.add(neighbourString);
        } else {
          //opponents stone
          adjacentOppositeColor.add(neighbourString);
        }
      }
    }
    GoString newString = new GoString(player, Set.of(point), liberties);

    for (GoString sameColorString : adjacentSameColor) {
      newString = newString.mergedWith(sameColorString);
    }
    for (Point stone : newString.getStones()) {
      grid.put(stone, newString);
    }
    for (GoString otherColorString : adjacentOppositeColor) {
      otherColorString.removeLiberty(point);
    }
    for (GoString otherColorString : adjacentOppositeColor) {
      if (otherColorString.numLiberties() == 0) {
        removeString(otherColorString);
      }
    }

  }

  private void removeString(GoString goString) {
    for (Point stone : goString.getStones()) {
      for (Point neighbour : stone.neighbours()) {
        GoString neighbourString = grid.get(neighbour);
        if (neighbourString != null) {
          if (!neighbourString.equals(goString)) {
            neighbourString.addLiberty(stone);
          }
          grid.remove(stone);
        }
      }
    }
  }

  private GoString getGoString(Point point) {
    return grid.get(point);
  }

  private Player get(Point point) {
    GoString goString = grid.get(point);
    if (goString == null) {
      return null;
    }
    return goString.getColor();
  }

  private boolean isOnGrid(Point point) {
    return point.row() < numRows && point.col() < numCols && point.row() >= 0 && point.col() >= 0;
  }
}
