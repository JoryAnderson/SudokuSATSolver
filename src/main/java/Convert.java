import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {

  static List<List<String>> splitIntoLists(String[] xArr) {
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

  public static List<List<String>> toList(String[][] grid) {
    List<List<String>> newGrid = new ArrayList<>();

    for (String[] strings : grid) {
      newGrid.add(Arrays.asList(strings));
    }

    return newGrid;
  }
}
