import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class sud2satextended {

  public static void main(String[] args) throws IOException {
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    List<String> outputList = new ArrayList<>();

    Sudoku sudoku = new Sudoku(SudokuReader.readInput());
    String flatPuzzle = Convert.toFlatString(sudoku.getGrid());
    int rowSize = sudoku.getRow(0).size();
    int clauses = 0;

    outputList.add("c Encoding: Extended\n\n");

    outputList.add("c Unit Clauses\n");
    int xBase = 1;
    int yBase = 1;
    for(int i = 0; i < 81; i++) {
      if(Character.isDigit(flatPuzzle.charAt(i)) && Character.getNumericValue(flatPuzzle.charAt(i)) > 0) {
        outputList.add(Convert.toBase9(xBase, yBase, Character.getNumericValue(flatPuzzle.charAt(i))) + " 0\n");
        clauses++;
      }

      yBase++;
      if(yBase == 10) {
        xBase++;
        yBase = 1;
      }

    }

    outputList.add("\nc One number in each entry\n");
    for(int x = 1; x < 10; x++) {
      for(int y = 1; y < 10; y++) {
        for(int z = 1; z < 10; z++) {
          outputList.add(Convert.toBase9(x, y, z) + " ");
        }
        outputList.add("0\n");
        clauses++;
      }
    }

    outputList.add("\nc Each number appears at most once in each row\n");
    for(int y = 1; y < 10; y++) {
      for(int z = 1; z < 10; z++) {
        for(int x = 1; x < 9; x++) {
          for(int i = x + 1; i < 10; i++) {
            outputList.add("-" + Convert.toBase9(x, y, z) + " -" + Convert.toBase9(i, y, z) + " 0\n");
            clauses++;
          }
        }
      }
    }

    outputList.add("\nc Each number appears at most once in each column\n");
    for(int x = 1; x < 10; x++) {
      for(int z = 1; z < 10; z++) {
        for(int y = 1; y < 9; y++) {
          for(int i = y + 1; i < 10; i++) {
            outputList.add("-" + Convert.toBase9(x, y, z) + " -" + Convert.toBase9(x, i, z) + " 0\n");
            clauses++;
          }
        }
      }
    }

    outputList.add("\nc Each number appears at most once in each 3x3 sub-grid\n");
    for(int z = 1; z < 10; z++) {
      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          for(int x = 1; x < 4; x++) {
            for(int y = 1; y < 4; y++) {
              for(int k = y + 1; k < 4; k++) {
                outputList.add("-" + Convert.toBase9(3*i+x, 3*j+y, z) + " -" + Convert.toBase9(3*i+x, 3*j+k, z) + " 0\n");
                clauses++;
              }
            }
          }
        }
      }
    }

    for(int z = 1; z < 10; z++) {
      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          for(int x = 1; x < 4; x++) {
            for(int y = 1; y < 4; y++) {
              for(int k = x + 1; k < 4; k++) {
                for(int l = 1; l < 4; l++) {
                  outputList.add("-" + Convert.toBase9(3*i+x, 3*j+y, z) + " -" + Convert.toBase9(3*i+k, 3*j+l, z) + " 0\n");
                  clauses++;
                }
              }
            }
          }
        }
      }
    }

    outputList.add("\nc Extended Rules\n");
    outputList.add("\nc There is at most one number in each entry\n");
    for(int x = 1; x < 10; x++) {
      for(int y = 1; y < 10; y++) {
        for(int z = 1; z < 9; z++) {
          for(int i = z + 1; i < 10; i++) {
            outputList.add("-" + Convert.toBase9(x, y, z) + " -" + Convert.toBase9(x, y, i) + " 0\n");
            clauses++;
          }
        }
      }
    }

    outputList.add("\nc Each number appears at least once in each row\n");
    for(int y = 1; y < 10; y++) {
      for(int z = 1; z < 10; z++) {
        for(int x = 1; x < 10; x++) {
          outputList.add(Convert.toBase9(x ,y, z) + " ");
        }
        outputList.add("0\n");
        clauses++;
      }
    }

    outputList.add("\nc Each number appears at least once in each column\n");
    for(int x = 1; x < 10; x++) {
      for(int z = 1; z < 10; z++) {
        for(int y = 1; y < 10; y++) {
          outputList.add(Convert.toBase9(x, y, z) + " ");
        }
        outputList.add("0\n");
        clauses++;
      }
    }

    outputList.add("\nc Each number appears at least once in each 3x3 sub-grid\n");
    for(int z = 1; z < 10; z++) {
      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          for(int x = 1; x < 4; x++) {
            for(int y = 1; y < 4; y++) {
              outputList.add(Convert.toBase9(3*i+x, 3*j+y, z) + " ");
            }
          }

          outputList.add("0\n");
          clauses++;
        }
      }
    }

    // Teardown
    outputList.add(0, "p cnf 729 " + clauses + "\n");
    for(String line: outputList) {
      output.write(line);
    }
    output.flush();
    output.close();

  }

}
