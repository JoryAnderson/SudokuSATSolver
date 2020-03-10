import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SudokuReaderTests {

  @Test
  public void readValidPattern_NumbersDotArraysShouldMatch() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("test/validPuzzle.txt")));
    SudokuReader.readInput();
  }

  @Test
  public void readValidPattern_NumbersMultiSymbolArrayShouldMatch() {

  }

  @Test
  public void readEmptyInput_ShouldPrintUsage() {

  }

  @Test
  public void readInvalidPattern_PatternNotCubeShouldPrintUsage() {

  }

  @Test
  public void readInvalidPattern_BadSymbolsShouldPrintUsage() {

  }

  @Test
  public void readInvalidPattern_Not9By9ShouldPrintUsage() {

  }

  @Test
  public void readInvalidPattern_InvalidNumbersShouldPrintUsage() {

  }

}
