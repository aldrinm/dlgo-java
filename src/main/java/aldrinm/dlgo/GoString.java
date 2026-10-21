package aldrinm.dlgo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GoString {

  public Player getColor() {
    return color;
  }

  public Set<Point> getStones() {
    return stones;
  }

  public Set<Point> getLiberties() {
    return liberties;
  }

  private Player color;
  private Set<Point> stones;
  private Set<Point> liberties;

  public GoString(Player color, Set<Point> stones, Set<Point> liberties) {
    this.color = color;
    this.stones = stones;
    this.liberties = liberties;
  }

  void removeLiberty(Point point) {
    liberties.remove(point);
  }

  void addLiberty(Point point) {
    liberties.add(point);
  }

  GoString mergedWith(GoString other) {
    if (this.color != other.color) {
      throw new IllegalArgumentException("Cannot merge with different colors");
    }
    HashSet<Point> newStones = new HashSet<>(stones);
    newStones.addAll(other.stones);
    HashSet<Point> newLiberties = new HashSet<>(liberties);
    newLiberties.addAll(other.liberties);
    //remove all the occupied stone pieces
    newLiberties.removeAll(stones);
    return new GoString(color, newStones, newLiberties);
  }

  int numLiberties() {
    return liberties.size();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof GoString goString)) {
      return false;
    }
    return color == goString.color && Objects.equals(stones, goString.stones)
        && Objects.equals(liberties, goString.liberties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, stones, liberties);
  }
}
