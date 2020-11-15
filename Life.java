
public class Life implements ILife {

  public int[][] board;

  public static void main(String[] args) {
    /*
     * Life l = new Life(new String[] { "     ", "     ", " *** ", "     ", "     "
     * }); l = (Life) l.nextGeneration();
     */
  }

  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this.board = new int[4][4];
    /*
     * for (int y = 0; y < setup.length; y++) for (int x = 0; x < setup[y].length();
     * x++) if (setup[y].charAt(x) != ' ') setAlive(x, y);
     */
  }

  @Override
  public void nukeAll() {
    // set all dead = 0
    for (int x = 0; x < board.length; x++)
      for (int y = 0; y < board.length; y++)
        board[x][y] = 0;

  }

  @Override
  public void setAlive(int x, int y) {
    // x,y Array = 1
    board[x][y] = 1;

  }

  @Override
  public void setDead(int x, int y) {
    // x,y = 0
    board[x][y] = 0;

  }

  @Override
  public boolean isAlive(int x, int y) {
    // if x,y = 1 -> return true
    if (board[x][y] == 1)
      return true;
    else
      return false;
  }

  @Override
  public ILife nextGeneration() {
    int[][] temp = new int[4][4];
    for (int x = 0; x < temp.length; x++) {
      for (int y = 0; y < temp.length; y++) {

        // destroyLonelyCell
        if (isAlive(x, y) == true && (aliveNeighbours(x, y) < 2 || aliveNeighbours(x, y) > 3))
          board[x][y] = 0;

        // createNewCell
        if (isAlive(x, y) == false && (aliveNeighbours(x, y) == 3))
          board[x][y] = 1;

        // else if (checkAlive(x,y) == true && (CellCount(x,y) < 2 || CellCount(x,y) >
        // 3)){
        // tempBoard[x][y] = 0;

        // keepAliveCell
        if (isAlive(x, y) == true && (aliveNeighbours(x, y) == 2 || aliveNeighbours(x, y) == 3))
          board[x][y] = 1;

      }
    }

    board = temp;

    return null;

  }

  public int aliveNeighbours(int i, int j) {
    int counter = 0;
    if (isAlive(i - 1, j - 1))
      counter++;
    if (isAlive(i - 1, j))
      counter++;
    if (isAlive(i - 1, j + 1))
      counter++;
    if (isAlive(i, j - 1))
      counter++;
    if (isAlive(i, j + 1))
      counter++;
    if (isAlive(i + 1, j - 1))
      counter++;
    if (isAlive(i + 1, j))
      counter++;
    if (isAlive(i + 1, j + 1))
      counter++;
    return counter;
  }
}