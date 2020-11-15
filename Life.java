public class Life implements ILife {
  
  public static void main(String[] args) {
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();
  }


  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != ' ')
          setAlive(x, y);
  }


  @Override
  public void nukeAll() { 
    // set all dead = 0

  }

  @Override
  public void setAlive(int x, int y) {
    // x,y Array = 1

  }

  @Override
  public void setDead(int x, int y) {
    // x,y = 0

  }

  @Override
  public boolean isAlive(int x, int y) {
    // if x,y = 1 -> return true
    return false;
  }

  @Override
  public ILife nextGeneration() {
    //geht Testfälle durch mit aliveNeighbours 
    //int count = 0;
    //count += isAlive(x-1,y-1); usw. -> Nachbarfelder
    return null;
  }
}