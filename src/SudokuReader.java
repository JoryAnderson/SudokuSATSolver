import java.io.*;

public class SudokuReader {

  // TODO: Change return type to String[][]
  public static void readInput() {
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      while(true)
      {
        String x = null;
        try{
          x = f.readLine();
          if ( x == null ) {break;}
        }
        catch (IOException e) {e.printStackTrace();}

        // TODO: Validate each line (x) (correct symbols, 1 <= x[i] <= 9, x.length == 9, puzzle is a 9x9). Print usage and throw if not good
        // TODO: Read line in array[9], each symbol its own index
        // TODO: Add array[9] to array[9][9]
        // TODO: Parse 2d array, replace symbols with '.' or -1
        System.out.println(x);
      }
  }

  public static void validateLine() {
    // TODO:
  }

  private static void printUsage() {
    // TODO:
  }





}
