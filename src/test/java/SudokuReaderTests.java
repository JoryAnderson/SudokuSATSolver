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
  List<List<String>> validInput2 = new ArrayList<>();

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

    validInput2.add(Arrays.asList("1","6","3","8",".","5",".","7","."));
    validInput2.add(Arrays.asList(".",".","8",".","4",".",".","6","5"));
    validInput2.add(Arrays.asList(".",".","5",".",".","7",".",".","8"));
    validInput2.add(Arrays.asList("4","5",".",".","8","2",".","3","9"));
    validInput2.add(Arrays.asList("3",".","1",".",".",".",".","4","."));
    validInput2.add(Arrays.asList("7",".",".",".",".",".",".",".","."));
    validInput2.add(Arrays.asList("8","3","9",".","5",".",".",".","."));
    validInput2.add(Arrays.asList("6",".","4","2",".",".","5","9","."));
    validInput2.add(Arrays.asList(".",".",".",".","9","3",".","8","1"));
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
  public void readInput_ValidLongStringFormatShouldMatch() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test/resources/validLongStringPuzzle.txt")));
    Assert.assertEquals(validInput2, SudokuReader.readInput());
  }

  @Test(expected = PuzzleNotSupportedException.class)
  public void readEmptyInput_ShouldPrintUsage() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test//resources/invalidEmptyPuzzle.txt")));
    SudokuReader.readInput();
  }

  @Test(expected = PuzzleNotSupportedException.class)
  public void readInput_PatternNotSquareShouldPrintUsage() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test/resources/invalidNotSquarePuzzle.txt")));
    SudokuReader.readInput();
  }

  @Test (expected = PuzzleNotSupportedException.class)
  public void readInput_BadSymbolsShouldPrintUsage() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test/resources/invalidBadSymbolPuzzle.txt")));
    SudokuReader.readInput();
  }

  @Test (expected = PuzzleNotSupportedException.class)
  public void readInput_InvalidNumbersShouldPrintUsage() throws FileNotFoundException {
    System.setIn(new FileInputStream(new File("src/test/resources/invalidBadRowLengthPuzzle.txt")));
    SudokuReader.readInput();
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
