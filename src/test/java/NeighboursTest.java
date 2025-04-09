import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighboursTest {
    @Test
    public void a_cell_is_alive_in_the_world(){
        //Given
        World world = new World();
        Cell cell = new Cell(1, 1);
        world.addCell(cell);

        //When
        Boolean isAlive = world.isCellAlive(cell);

        //Then
        Assertions.assertThat(isAlive).isTrue();
    }

    @Test
    public void a_cell_is_not_alive_in_the_world(){
        //Given
        World world = new World();

        //When
        Boolean isAlive = world.isCellAlive(new Cell(1, 1));

        //Then
        Assertions.assertThat(isAlive).isFalse();
    }

    @Test
    public void the_cell_has_a_living_neighbor(){
        //Given
        World world = new World();
        Cell cellAlive = new Cell(0, 0);
        world.addCell(cellAlive);

        //When
        int numberOfNeighbors = world.numberOfCellNeighbors(new Cell(1, 1));

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(1);
    }

}
