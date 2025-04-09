import life.light.Cell;
import life.light.World;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class NextGenerationTest {
    @Test
    public void empty_world() {
        // Given
        World world = new World(3, new HashSet<>());

        // When
        HashSet<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isEmpty();
    }

    @Test
    public void a_cell_without_a_neighbor_dies_from_underpopulation() {
        // Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell = new Cell(1, 1);
        listOfAliveCell.add(cell);
        World world = new World(3, listOfAliveCell);

        // When
        HashSet<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isEmpty();
    }

    // Example of a world where 1,1 is the reference cell
    // Exemple de monde où 1,1 est la cellule de référence
    // 0,0 0,1 0,2
    // 1,0 1,1 1,2
    // 2,0 2,1 2,2

    @Test
    public void a_dead_cell_with_three_living_neighbors_born() {
        // Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell1Alive = new Cell(0, 0);
        listOfAliveCell.add(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        listOfAliveCell.add(cell2Alive);
        Cell cell3Alive = new Cell(2, 0);
        listOfAliveCell.add(cell3Alive);
        World world = new World(3, listOfAliveCell);

        // When
        HashSet<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isNotEmpty();
        Assertions.assertThat(cellsAliveInTheNextGeneration.size()).isEqualTo(1);
        Assertions.assertThat(cellsAliveInTheNextGeneration).contains(new Cell(1, 1));
    }

    // O X O
    // O X O
    // O X 0

    // O O O
    // X X X
    // O O O

    @Test
    public void cross_pattern() {

        // Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell1Alive = new Cell(0, 1);
        listOfAliveCell.add(cell1Alive);
        Cell cell2Alive = new Cell(1, 1);
        listOfAliveCell.add(cell2Alive);
        Cell cell3Alive = new Cell(2, 1);
        listOfAliveCell.add(cell3Alive);
        World world = new World(3, listOfAliveCell);

        // When
        HashSet<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isNotEmpty();
        Assertions.assertThat(cellsAliveInTheNextGeneration.size()).isEqualTo(3);
        Assertions.assertThat(cellsAliveInTheNextGeneration).contains(new Cell(1, 0));
        Assertions.assertThat(cellsAliveInTheNextGeneration).contains(new Cell(1, 1));
        Assertions.assertThat(cellsAliveInTheNextGeneration).contains(new Cell(1, 2));
    }

    // Example of a world where 2,2 is the reference cell
    // Exemple de monde où 2,2 est la cellule de référence
    // 0,0 0,1 0,2 0,3 0,4
    // 1,0 1,1 1,2 1,3 1,4
    // 2,0 2,1 2,2 2,3 2,4
    // 3,0 3,1 3,2 3,3 3,4
    // 4,0 4,1 4,2 4,3 4,4

    @Test
    public void a_living_cell_with_two_living_neighbors_survives() {
        // Given
        HashSet<Cell> listOfAliveCell = new HashSet<>();
        Cell cell1Alive = new Cell(1, 1);
        listOfAliveCell.add(cell1Alive);
        Cell cell2Alive = new Cell(3, 3);
        listOfAliveCell.add(cell2Alive);
        Cell cellAlive = new Cell(2, 2);
        listOfAliveCell.add(cellAlive);
        World world = new World(5, listOfAliveCell);

        // When
        HashSet<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isNotEmpty();
        Assertions.assertThat(cellsAliveInTheNextGeneration.size()).isEqualTo(1);
        Assertions.assertThat(cellsAliveInTheNextGeneration).contains(new Cell(2, 2));
    }

}
