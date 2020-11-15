import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {

      // Arrange: eine lebende Zelle
        Life l = new Life();
        l.setAlive(1, 1);
        l.setAlive(1, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit weniger als 2 Nachbarn sollte jetzt tot sein
        assertFalse(nextGen.isAlive(1, 1));
    }


    @Test
    public void keepAliveCell() {

      // Arrange: Zelle mit 2 Nachbarn
      Life l = new Life();
      l.setAlive(1,1);
      l.setAlive(1,2);
      l.setAlive(2,1);

      // Act: Berechnung der Folgegeneration
      ILife nextGen = l.nextGeneration();

      // Assert: Rasterpunkt mit 2 Nachbarn sollte jetzt leben
      assertEquals(nextGen.isAlive(1, 1));

      // Arrange: Zelle mit 3 Nachbarn
      Life l2 = new Life();
      l2.setAlive(1,1);
      l2.setAlive(1,2);
      l2.setAlive(2,1);
      l2.setAlive(0,1);

      // Act: Berechnung der Folgegeneration
      ILife nextGen2 = l2.nextGeneration();

      // Assert: Rasterpunkt mit 3 Nachbarn sollte jetzt leben
      assertTrue(nextGen2.isAlive(1, 1));
    }


    @Test
    public void destroyCrowdedCell() {

      // Arrange: Zelle mit mehr als 3 Nachbarn
        Life l = new Life();
        l.setAlive(1,1);
        l.setAlive(1,2);
        l.setAlive(2,1);
        l.setAlive(0,0);
        l.setAlive(0,1);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit mehr als 3 Nachbarn sollte jetzt tot sein
        assertFalse(nextGen.isAlive(1, 1));
    }


}
