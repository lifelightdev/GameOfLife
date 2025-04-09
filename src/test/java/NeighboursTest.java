import life.light.Cell;
import life.light.World;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class NeighboursTest {
    @Test
    public void a_cell_is_alive_in_the_world(){
        //Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cellAlive = new Cell(1, 1);
        listOfAliveCell.add(cellAlive);
        World world = new World(3, listOfAliveCell);

        //When
        Boolean isAlive = world.isCellAlive(cellAlive);

        //Then
        Assertions.assertThat(isAlive).isTrue();
    }

    @Test
    public void a_cell_is_not_alive_in_the_world(){
        //Given
        World world = new World(3, new HashSet<>());

        //When
        Boolean isAlive = world.isCellAlive(new Cell(1, 1));

        //Then
        Assertions.assertThat(isAlive).isFalse();
    }

    @Test
    public void the_cell_has_a_living_neighbor(){
        //Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cellAlive = new Cell(0, 0);
        listOfAliveCell.add(cellAlive);
        World world = new World(3, listOfAliveCell);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(new Cell(1, 1));

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(1);
    }

    @Test
    public void the_cell_has_two_living_neighbors(){
        //Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell1Alive = new Cell(0, 0);
        listOfAliveCell.add(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        listOfAliveCell.add(cell2Alive);
        World world = new World(3,listOfAliveCell);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(new Cell(1, 1));

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(2);
    }

    @Test
    public void the_cell_has_three_living_neighbors(){
        //Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell1Alive = new Cell(0, 0);
        listOfAliveCell.add(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        listOfAliveCell.add(cell2Alive);
        Cell cell3Alive = new Cell(2, 0);
        listOfAliveCell.add(cell3Alive);
        Cell cell = new Cell(1, 1);
        listOfAliveCell.add(cell);
        World world = new World(3, listOfAliveCell);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(cell);

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(3);
    }

    @Test
    public void the_cell_has_four_living_neighbors(){
        //Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell1Alive = new Cell(0, 0);
        listOfAliveCell.add(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        listOfAliveCell.add(cell2Alive);
        Cell cell3Alive = new Cell(2, 0);
        listOfAliveCell.add(cell3Alive);
        Cell cell4Alive = new Cell(2, 2);
        listOfAliveCell.add(cell4Alive);
        Cell cell = new Cell(1, 1);
        listOfAliveCell.add(cell);
        World world = new World(3, listOfAliveCell);

        //When
        int numberOfNeighbors = world.numberOfCellAliveNeighbors(cell);

        //Then
        Assertions.assertThat(numberOfNeighbors).isEqualTo(4);
    }

}
