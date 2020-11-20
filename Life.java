
public class Life implements ILife {

  public int[][] board;

  public static void main(String[] args) {

    Life l = new Life(new String[] { "     ", "     ", " *** ", "     ", "     " });
    l = (Life) l.nextGeneration();

  }

  public Life(int dim_x, int dim_y) {
    this.board = new int[dim_x][dim_y];
    nukeAll();
  }

  public Life(String[] setup) {
    this(setup[0].length(), setup.length);

    for (int y = 0; y < board.dim_y; y++)
      for (int x = 0; x < board.dim_x; x++)
        if (setup[y].charAt(x) == '*')
          setAlive(x, y);

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
    ILife newGeneration = new Life(getDim_x(), getDim_y());
    for (int x = 0; x < temp.length; x++) {
      for (int y = 0; y < temp.length; y++) {

        // destroyLonelyCell
        if (isAlive(x, y) == true && (aliveNeighbours(x, y) < 2 || aliveNeighbours(x, y) > 3))
          //board[x][y] = 0;
          newGeneration.setAlive(x,y);

        // createNewCell
        if (isAlive(x, y) == false && (aliveNeighbours(x, y) == 3))
          //board[x][y] = 1;
          newGeneration.setAlive(x,y);

        // else if (checkAlive(x,y) == true && (CellCount(x,y) < 2 || CellCount(x,y) >
        // 3)){
        // tempBoard[x][y] = 0;

        // keepAliveCell
        if (isAlive(x, y) == true && (aliveNeighbours(x, y) == 2 || aliveNeighbours(x, y) == 3))
          //board[x][y] = 1;
          newGeneration.setAlive(x,y);

      }
    }

    board = temp;

    return this;

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