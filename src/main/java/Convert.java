import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Helper functions for converting Sudoku-representative objects to varying data structures.
 *
 */
public class Convert {

  private static List<List<String>> splitIntoLists(String[] xArr) {
    List<List<String>> grid = new ArrayList<>();

    for(int i = 0; i < xArr.length; i+=9) {
        String[] row = Arrays.copyOfRange(xArr, i, i + 9);
        grid.add(Arrays.asList(row));
    }
    return grid;
  }

  public static String[][] toArray(List<List<String>> grid) {
    String[][] newGrid = new String[9][9];
    for (int i = 0; i < grid.size(); i++) {
      List<String> listRow = grid.get(i);
      String[] row = new String[listRow.size()];
      for (int j = 0; j < listRow.size(); j++) {
        row[j] = listRow.get(j);
      }

      newGrid[i] = row;
    }
    return newGrid;
  }

  public static List<List<String>> toList(String grid) {
    assert(grid.length() == 81);
    return splitIntoLists(grid.split(""));
  }


  public static List<List<String>> toList(String[][] grid) {
    List<List<String>> newGrid = new ArrayList<>();

    for (String[] strings : grid) {
      newGrid.add(Arrays.asList(strings));
    }

    return newGrid;
  }

  public static String toFlatString(List<List<String>> grid) {
    StringBuilder result = new StringBuilder();

    for(List<String> row: grid) {
      for(String cell: row) {
        result.append(cell);
      }
    }

    return result.toString();
  }


  public static List<List<Integer>> toIntList(List<List<String>> grid) {

    List<List<Integer>> result = new ArrayList<>();
    grid.forEach((List<String> x) -> result.add(x.stream().map(Integer::valueOf).collect(Collectors.toList())));

    return result;
  }

  public static int toBase9(int i, int j, int k) {
    return (81*(i - 1) + 9*(j - 1) + (k-1) + 1);
  }

  public static int fromBase9(int n) {
    return (n-1) % 9 + 1;
  }
}
