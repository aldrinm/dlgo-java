package aldrinm.dlgo;

public enum Player {
  BLACK, WHITE;

  Player other() {
    return this == WHITE ? BLACK : WHITE;
  }
}
