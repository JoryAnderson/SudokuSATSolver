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

        x = stripSymbols(x);

        if (x.length() == 81) {
          //TODO: Remove
          System.out.println(x);
          System.out.println(x.length());

          return Convert.toList(x);
        }

        checkPuzzleSupport(validateLine(x), "Line contains either invalid characters or is not of length 9");

        //TODO: Remove
        System.out.println(x);

        sudoku.add(new ArrayList<>(Arrays.asList(x.split(""))));
      }

      checkPuzzleSupport(validateGrid(sudoku), "Grid has more than 9 rows.");

      return sudoku;
  }

  private static boolean validateLine(String str) {
    return str.equals(str.replaceAll("[^0-9?.]", "."))  && str.length() == 9;
  }

  private static boolean validateGrid(List<List<String>> grid) {
    return grid.size() == 9;
  }

  private static void checkPuzzleSupport(Boolean support, String msg) {
    if (!support) {
      printUsage();
      throw new PuzzleNotSupportedException(msg);
    }
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
