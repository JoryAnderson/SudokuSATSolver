import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuReaderTests {


  List<List<String>> validInput1 = new ArrayList<>();

  @Before
  public void setUp() {
    validInput1.add(Arrays.asList(".",".",".","1",".","5",".",".","."));
    validInput1.add(Arrays.asList("1","4",".",".",".",".","6","7","."));
    validInput1.add(Arrays.asList(".","8",".",".",".","2","4",".","."));
    validInput1.add(Arrays.asList(".","6","3",".","7",".",".","1","."));
    validInput1.add(Arrays.asList("9",".",".",".",".",".",".",".","3"));
    validInput1.add(Arrays.asList(".","1",".",".","9",".","5","2","."));
    validInput1.add(Arrays.asList(".",".","7","2",".",".",".","8","."));
    validInput1.add(Arrays.asList(".","2","6",".",".",".",".","3","5"));
    validInput1.add(Arrays.asList(".",".",".","4",".","9",".",".","."));
  }

  @Test
  public void readInput_NumbersDotArraysShouldMatch() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test/resources/validPuzzle.txt")));
    Assert.assertEquals(validInput1, SudokuReader.readInput());
  }

  @Test
  public void readInput_NumbersMultiSymbolArrayShouldMatch() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test/resources/validMultiSymbolPuzzle.txt")));
    Assert.assertEquals(validInput1, SudokuReader.readInput());
  }

  @Test
  public void readInput_ValidLongStringFormatShouldMatch() {

  }

  @Test(expected = PuzzleNotSupportedException.class)
  public void readEmptyInput_ShouldPrintUsage() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test//resources/invalidEmptyPuzzle.txt")));
    SudokuReader.readInput();
  }

  @Test
  public void readInput_PatternNotCubeShouldPrintUsage() {

  }

  @Test
  public void readInput_BadSymbolsShouldPrintUsage() {

  }

  @Test
  public void readInput_Not9By9ShouldPrintUsage() {

  }

  @Test
  public void readInput_InvalidNumbersShouldPrintUsage() {

  }

  @Test
  public void stripSymbols_ShouldStandardizeSymbols() {
    String input = "13*5420?7";
    String expectedOutput = "13.542..7";
    Assert.assertEquals(expectedOutput, SudokuReader.stripSymbols(input));
  }

  @Test
  public void stripSymbols_HappyPath() {
    String expectedOutput = "13.542..7";
    Assert.assertEquals(expectedOutput, SudokuReader.stripSymbols(expectedOutput));
  }

}
