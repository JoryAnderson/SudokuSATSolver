import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertTests {

  String[][] validInputArr1 = new String[9][9];
  List<List<String>> validInput1 = new ArrayList<>();

  @Before
  public void setUp() {
    validInputArr1[0] = new String[]{".",".",".","1",".","5",".",".","."};
    validInputArr1[1] = new String[]{"1","4",".",".",".",".","6","7","."};
    validInputArr1[2] = new String[]{".","8",".",".",".","2","4",".","."};
    validInputArr1[3] = new String[]{".","6","3",".","7",".",".","1","."};
    validInputArr1[4] = new String[]{"9",".",".",".",".",".",".",".","3"};
    validInputArr1[5] = new String[]{".","1",".",".","9",".","5","2","."};
    validInputArr1[6] = new String[]{".",".","7","2",".",".",".","8","."};
    validInputArr1[7] = new String[]{".","2","6",".",".",".",".","3","5"};
    validInputArr1[8] = new String[]{".",".",".","4",".","9",".",".","."};

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
  public void toArray_validPatternShouldBeFine() {
    Assert.assertArrayEquals(validInputArr1, Convert.toArray(validInput1));
  }

  @Test
  public void toList_validPatternShouldBeFine() {
    Assert.assertEquals(validInput1, Convert.toList(validInputArr1));
  }
}
