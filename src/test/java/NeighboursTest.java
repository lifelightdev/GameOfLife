import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighboursTest {
    @Test
    public void a_cell_is_alive_in_the_world(){
        //Given
        World world = new World(3);
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
        World world = new World(3);

        //When
        Boolean isAlive = world.isCellAlive(new Cell(1, 1));

        //Then
        Assertions.assertThat(isAlive).isFalse();
    }

    @Test
    public void the_cell_has_a_living_neighbor(){
        //Given
        World world = new World(3);
        Cell cellAlive = new Cell(0, 0);
        world.addCell(cellAlive);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(new Cell(1, 1));

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(1);
    }

    @Test
    public void the_cell_has_two_living_neighbors(){
        //Given
        World world = new World(3);
        Cell cell1Alive = new Cell(0, 0);
        world.addCell(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        world.addCell(cell2Alive);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(new Cell(1, 1));

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(2);
    }

    @Test
    public void the_cell_has_three_living_neighbors(){
        //Given
        World world = new World(3);
        Cell cell1Alive = new Cell(0, 0);
        world.addCell(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        world.addCell(cell2Alive);
        Cell cell3Alive = new Cell(2, 0);
        world.addCell(cell3Alive);
        Cell cell = new Cell(1, 1);
        world.addCell(cell);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(cell);

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(3);
    }

    @Test
    public void the_cell_has_four_living_neighbors(){
        //Given
        World world = new World(3);
        Cell cell1Alive = new Cell(0, 0);
        world.addCell(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        world.addCell(cell2Alive);
        Cell cell3Alive = new Cell(2, 0);
        world.addCell(cell3Alive);
        Cell cell4Alive = new Cell(2, 2);
        world.addCell(cell4Alive);
        Cell cell = new Cell(1, 1);
        world.addCell(cell);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(cell);

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(4);
    }

}
