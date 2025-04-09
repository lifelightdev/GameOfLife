import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NextGenerationTest {
    @Test
    public void emptyWorld () {
        // Given
        World world = new World();

        // When
        World newWorld = world.nextGeneration();

        // Then
        Assertions.assertThat(newWorld).isNull();
    }


}
