import java.util.ArrayList;
import java.util.List;

public class Sudoku {

  private List<List<String>> grid;

  public Sudoku(List<List<String>> grid) {
    this.grid = grid;
  }

  public List<List<String>> getGrid() { return grid; }

  /**
   * @param pos The index of the 3x3 square from left-to-right, top-to-bottom within
   *            the 9x9 sudoku game.
   * @return A list of lists corresponding to the 3x3 square.
   */
  public List<List<String>> getSquare(int pos) {
    assert(pos < 9);

    List<List<String>> result = new ArrayList<>();
    int loopsRemaining = 3;
    for(int row = pos / 3 * 3; loopsRemaining >= 1; row++) {
      int col = pos % 3 * 3;
      result.add(grid.get(row).subList(col, col+3));
      loopsRemaining--;
    }

    return result;
  }

  public List<String> getRow(int row) {
    return grid.get(row);
  }

  public List<String> getColumn(int column) {
    return transpose(grid).get(column);
  }

  public String getCell(int row, int column) {
    return grid.get(row).get(column);
  }

  private List<List<String>> transpose(List<List<String>> grid) {
    List<List<String>> result = new ArrayList<>();

    for(int i = 0; i < grid.get(0).size(); i++) {
      List<String> column = new ArrayList<>();
      for(List<String> row: grid) {
        column.add(row.get(i));
      }
      result.add(column);
    }

    return result;
  }
}
