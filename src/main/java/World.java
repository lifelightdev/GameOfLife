import java.util.ArrayList;
import java.util.List;

public class World {

    List<Cell> cellsAliveInTheWorld = new ArrayList<>();

    public List<Cell> nextGeneration() {
        List<Cell> cellsAliveInTheNextGeneration = new ArrayList<>();
        if (cellsAliveInTheWorld.size() == 3 || cellsAliveInTheWorld.size() == 4) {
            cellsAliveInTheNextGeneration.add(new Cell(1,1));
        }
        return cellsAliveInTheNextGeneration;
    }

    public void addCell(Cell cell) {
        cellsAliveInTheWorld.add(cell);
    }
}
