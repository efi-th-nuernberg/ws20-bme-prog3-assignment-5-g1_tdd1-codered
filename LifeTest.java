import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {

  @Test
  public void createNewCell() {

    // Arrange: drei lebende Zellen
    Life l = new Life(4, 4);
    l.setAlive(0, 0);
    l.setAlive(0, 1);
    l.setAlive(0, 2);

    System.out.println("createNewCell - Test");

    printLife(l);

    // Act: Berechnung der Folgegeneration
    ILife nextGen = l.nextGeneration();

    printLife(l);

    // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
    assertTrue(nextGen.isAlive(1, 1));
  }

  @Test
  public void destroyLonelyCell() {

    // Arrange: eine lebende Zelle
    Life l = new Life(4, 4);
    l.setAlive(1, 1);
    l.setAlive(2, 1);

    System.out.println("destroyLonelyCell Test");

    printLife(l);

    // Act: Berechnung der Folgegeneration
    ILife nextGen = l.nextGeneration();

    printLife(l);

    // Assert: Rasterpunkt mit weniger als 2 Nachbarn sollte jetzt tot sein
    assertFalse(nextGen.isAlive(1, 1));
  }

  @Test
  public void keepAliveCell() {

    // Arrange: Zelle mit 2 Nachbarn
    Life l = new Life(4, 4);
    l.setAlive(1, 1);
    l.setAlive(1, 2);
    l.setAlive(2, 1);

    System.out.println("KeepAliveCell - 2N - Test");

    printLife(l);

    // Act: Berechnung der Folgegeneration
    ILife nextGen = l.nextGeneration();

    printLife(l);

    // Assert: Rasterpunkt mit 2 Nachbarn sollte jetzt leben
    assertTrue(nextGen.isAlive(1, 1));

    // Arrange: Zelle mit 3 Nachbarn
    Life l2 = new Life(4, 4);
    l2.setAlive(1, 1);
    l2.setAlive(1, 2);
    l2.setAlive(2, 1);
    l2.setAlive(0, 1);

    System.out.println("KeepAliveCell - 3N - Test");

    printLife(l2);

    // Act: Berechnung der Folgegeneration
    ILife nextGen2 = l2.nextGeneration();

    printLife(l2);

    // Assert: Rasterpunkt mit 3 Nachbarn sollte jetzt leben
    assertTrue(nextGen2.isAlive(1, 1));
  }

  @Test
  public void destroyCrowdedCell() {

    // Arrange: Zelle mit mehr als 3 Nachbarn
    Life l = new Life(4, 4);
    l.setAlive(1, 1);
    l.setAlive(1, 2);
    l.setAlive(2, 1);
    l.setAlive(0, 0);
    l.setAlive(0, 1);

    System.out.println("destroyCrowdedCell - Test");

    printLife(l);

    // Act: Berechnung der Folgegeneration
    ILife nextGen = l.nextGeneration();

    printLife(l);

    // Assert: Rasterpunkt mit mehr als 3 Nachbarn sollte jetzt tot sein
    assertFalse(nextGen.isAlive(1, 1));
  }

  public void printLife(Life l) {
    String gen = "";
    for (int y = 0; y < 4; y++) // l.dim_y;
    {
      System.out.print(" Zeile" + y + " || ");
      for (int x = 0; x < 4; x++) // l.dim_x;
      {
        if (l.isAlive(x, y))
          gen = "X";
        else
          gen = "O";
        System.out.print(gen + " ");
      }
      System.out.println("\n");
    }
  }

}
