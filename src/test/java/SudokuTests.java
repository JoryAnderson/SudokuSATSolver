import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuTests {

  private List<List<String>> validInput1 = new ArrayList<>();
  private List<List<String>> validSquare1 = new ArrayList<>();
  private List<List<String>> validSquare2 = new ArrayList<>();
  private List<List<String>> validSquare3 = new ArrayList<>();
  private List<String> validRow;
  private List<String> validColumn;

  private Sudoku grid;


  @Before
  public void setUp() {
    validInput1.add(Arrays.asList(".", ".", ".", "1", ".", "5", ".", ".", "."));
    validInput1.add(Arrays.asList("1", "4", ".", ".", ".", ".", "6", "7", "."));
    validInput1.add(Arrays.asList(".", "8", ".", ".", ".", "2", "4", ".", "."));
    validInput1.add(Arrays.asList(".", "6", "3", ".", "7", ".", ".", "1", "."));
    validInput1.add(Arrays.asList("9", ".", ".", ".", ".", ".", ".", ".", "3"));
    validInput1.add(Arrays.asList(".", "1", ".", ".", "9", ".", "5", "2", "."));
    validInput1.add(Arrays.asList(".", ".", "7", "2", ".", ".", ".", "8", "."));
    validInput1.add(Arrays.asList(".", "2", "6", ".", ".", ".", ".", "3", "5"));
    validInput1.add(Arrays.asList(".", ".", ".", "4", ".", "9", ".", ".", "."));

    validRow = Arrays.asList(".", ".", ".", "1", ".", "5", ".", ".", ".");
    validColumn = Arrays.asList(".", "1", ".", ".", "9", ".", ".", ".", ".");

    validSquare1.add(Arrays.asList(".",".","."));
    validSquare1.add(Arrays.asList("1","4","."));
    validSquare1.add(Arrays.asList(".","8","."));

    validSquare2.add(Arrays.asList(".","6","3"));
    validSquare2.add(Arrays.asList("9",".","."));
    validSquare2.add(Arrays.asList(".","1","."));

    validSquare3.add(Arrays.asList(".","8","."));
    validSquare3.add(Arrays.asList(".","3","5"));
    validSquare3.add(Arrays.asList(".",".","."));

    grid = new Sudoku(validInput1);
  }

  @Test
  public void getGrid_ShouldReturnGrid() {
    Sudoku puzzle = new Sudoku(validInput1);
    Assert.assertEquals(validInput1, puzzle.getGrid());
  }

  @Test
  public void getSquare_ShouldReturnSquare() {
    Assert.assertEquals(validSquare1, grid.getSquare(0));
    Assert.assertEquals(validSquare2, grid.getSquare(3));
    Assert.assertEquals(validSquare3, grid.getSquare(8));
  }

  @Test
  public void getRow_ShouldReturnRow() {
    Assert.assertEquals(validRow, grid.getRow(0));
    Assert.assertEquals(validInput1.get(4), grid.getRow(4));
  }

  @Test
  public void getColumn_ShouldReturnColumn() {
    Assert.assertEquals(validColumn, grid.getColumn(0));
  }

  @Test
  public void getCell_ShouldReturnCell() {
    Assert.assertEquals(validInput1.get(2).get(4), grid.getCell(2,4));
  }
}
