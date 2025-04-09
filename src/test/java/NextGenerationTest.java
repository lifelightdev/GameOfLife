import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NextGenerationTest {
    @Test
    public void empty_world() {
        // Given
        World world = new World();

        // When
        List<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isEmpty();
    }

    @Test
    public void a_cell_without_a_neighbor_dies_from_underpopulation() {
        // Given
        World world = new World();
        Cell cell = new Cell(1, 1);
        world.addCell(cell);

        // When
        List<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

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
        World world = new World();
        Cell cell1Alive = new Cell(0, 0);
        world.addCell(cell1Alive);
        Cell cell2Alive = new Cell(0, 2);
        world.addCell(cell2Alive);
        Cell cell3Alive = new Cell(2, 0);
        world.addCell(cell3Alive);

        // When
        List<Cell> cellsAliveInTheNextGeneration = world.nextGeneration();

        // Then
        Assertions.assertThat(cellsAliveInTheNextGeneration).isNotEmpty();
        Assertions.assertThat(cellsAliveInTheNextGeneration.size()).isEqualTo(1);
        Assertions.assertThat(cellsAliveInTheNextGeneration.getFirst().x()).isEqualTo(1);
        Assertions.assertThat(cellsAliveInTheNextGeneration.getFirst().y()).isEqualTo(1);
    }
}
