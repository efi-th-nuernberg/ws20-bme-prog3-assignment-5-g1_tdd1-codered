
public class Life implements ILife {

  public int[][] board;
  public int dim_x;
  public int dim_y;

  public static void main(String[] args) {

    Life l = new Life(new String[] { "     ", "     ", " *** ", "     " });

    l = (Life) l.nextGeneration();

  }

  public Life(int dim_x, int dim_y) {
    this.board = new int[dim_x][dim_y];
    nukeAll();
  }

  public int getDim_x() {
    return dim_x;
  }

  public int getDim_y() {
    return dim_y;
  }

  public Life(String[] setup) {
    this(setup[0].length(), setup.length);

    for (int y = 0; y < getDim_y(); y++)
      for (int x = 0; x < getDim_x(); x++)
        if (setup[y].charAt(x) == '*')
          setAlive(x, y);

  }

  @Override
  public void nukeAll() {

    for (int x = 0; x < getDim_x(); x++)
      for (int y = 0; y < getDim_y(); y++)
        board[x][y] = 0;

  }

  @Override
  public void setAlive(int x, int y) {
    board[x][y] = 1;

  }

  @Override
  public void setDead(int x, int y) {
    board[x][y] = 0;

  }

  @Override
  public boolean isAlive(int x, int y) {
    if (board[x][y] == 1)
      return true;
    else
      return false;
  }

  @Override
  public ILife nextGeneration() {
    ILife newGeneration = new Life(getDim_x(), getDim_y());
    for (int x = 0; x < getDim_x(); x++) {
      for (int y = 0; y < getDim_y(); y++) {

        // destroyLonelyCell & destroyCrowdedCell
        if (isAlive(x, y) == true && (aliveNeighbours(x, y) < 2 || aliveNeighbours(x, y) > 3))
          // board[x][y] = 0;
          newGeneration.setDead(x, y);

        // createNewCell
        if (isAlive(x, y) == false && (aliveNeighbours(x, y) == 3))
          // board[x][y] = 1;
          newGeneration.setAlive(x, y);

        // keepAliveCell
        if (isAlive(x, y) == true && (aliveNeighbours(x, y) == 2 || aliveNeighbours(x, y) == 3))
          // board[x][y] = 1;
          newGeneration.setAlive(x, y);

      }
    }

    return newGeneration;

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