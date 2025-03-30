import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WorldTest {

    @Test
    void emptyWorld() {
        List<Cell> world = new ArrayList<>();
        Assertions.assertThat(world).isEmpty();
    }

}
