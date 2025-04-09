import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class World {

    List<Cell> cellsAliveInTheWorld = new ArrayList<>();
    int size;

    public World(int size) {
        this.size = size;
    }

    public HashSet<Object> nextGeneration() {
        HashSet<Object> cellsAliveInTheNextGeneration = new HashSet<>();
        for (Cell cell : cellsAliveInTheWorld) {
            if (numberOfCellAliveNeighbors(cell) == 2 || numberOfCellAliveNeighbors(cell) == 3) {
                cellsAliveInTheNextGeneration.add(cell);
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                Cell cell = new Cell(x, y);
                if (numberOfCellAliveNeighbors(cell) ==  3) {
                    cellsAliveInTheNextGeneration.add(cell);
                }
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
                if (isNotReferenceCell(cell, neighboringCell)) {
                    if (isCellAlive(neighboringCell)) {
                        numberOfNeighborsAlive++;
                    }
                }
            }
        }

        return numberOfNeighborsAlive;
    }

    private static boolean isNotReferenceCell(Cell cell, Cell neighboringCell) {
        return neighboringCell.x() != cell.x() || neighboringCell.y() != cell.y();
    }
}
