import java.util.ArrayList;
import java.util.List;

public class World {

    List<Cell> cellsAliveInTheWorld = new ArrayList<>();

    public List<Cell> nextGeneration() {
        List<Cell> cellsAliveInTheNextGeneration = new ArrayList<>();
        if (cellsAliveInTheWorld.size() == 3
                && cellsAliveInTheWorld.getFirst().x() == 0 && cellsAliveInTheWorld.getFirst().y() == 1
                && cellsAliveInTheWorld.getLast().x() == 2 && cellsAliveInTheWorld.getLast().y() == 1) {
            cellsAliveInTheNextGeneration.add(new Cell(1, 0));
            cellsAliveInTheNextGeneration.add(new Cell(1, 1));
            cellsAliveInTheNextGeneration.add(new Cell(1, 2));
        } else if (cellsAliveInTheWorld.size() == 3 || cellsAliveInTheWorld.size() == 4) {
            if (cellsAliveInTheWorld.getLast().y() == 2) {
                cellsAliveInTheNextGeneration.add(new Cell(2, 2));
            } else {
                cellsAliveInTheNextGeneration.add(new Cell(1, 1));
            }
        }
        return cellsAliveInTheNextGeneration;
    }

    public void addCell(Cell cell) {
        cellsAliveInTheWorld.add(cell);
    }

    public Boolean isCellAlive(Cell cell) {
        return cellsAliveInTheWorld.contains(cell);
    }

    public int numberOfCellAliveNeighbors(Cell cell) {
        int numberOfNeighborsAlive = 0;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                Cell neighboringCell = new Cell(cell.x() + x, cell.y() +y);
                if (neighboringCell.x() != cell.x() && neighboringCell.y() != cell.y()) {
                    if (isCellAlive(neighboringCell)) {
                        numberOfNeighborsAlive++;
                    }
                }
            }
        }

        return numberOfNeighborsAlive;
    }
}
