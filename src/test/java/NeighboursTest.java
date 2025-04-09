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
}
