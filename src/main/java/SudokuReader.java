import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuReader {

  public static List<List<String>> readInput() {
      List<List<String>> sudoku = new ArrayList<>();
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

      while(true) {
        String x = null;
        try{
          x = f.readLine();
          if ( x == null ) {break;}
        }
        catch (IOException e) {e.printStackTrace();}
        assert(x != null);

        if (x.length() == 81) {
          return Convert.splitIntoLists(stripSymbols(x).split(""));
        }

        x = stripSymbols(x);
        if (!validateLine(x)) {
          printUsage();
          throw new PuzzleNotSupportedException("Line contains either invalid characters or is not of length 9");
        }

        sudoku.add(new ArrayList<>(Arrays.asList(x.split(""))));

        //TODO: Remove
        System.out.println(x);
      }

      if (!validateGrid(sudoku)) {
        printUsage();
        throw new PuzzleNotSupportedException("Grid has more than 9 rows.");
      }

      return sudoku;
  }

  private static boolean validateLine(String str) {
    return str.equals(str.replaceAll("[^0-9?.]", "."))  && str.length() == 9;
  }

  private static boolean validateGrid(List<List<String>> grid) {
    return grid.size() == 9;
  }

  public static String stripSymbols(String line) {
    return line.replaceAll("[0.*?]", ".");
  }

  public static void printUsage() {
    System.out.println("\nUsage: java [sud2sat|sat2sud] < puzzle.txt\n" +
            "Pass a .txt file containing the incomplete sudoku puzzle.\n" +
            "Available characters are 0-9 and [., *, 0, ?] which designate empty cells.\n");
  }

}
