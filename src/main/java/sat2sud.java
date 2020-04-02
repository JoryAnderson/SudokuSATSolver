import java.io.*;

public class sat2sud {

  public static void main(String[] args) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuilder parsedPuzzle = new StringBuilder();

    String x = input.readLine();
    if(x.equals("SAT")) {
      x = input.readLine();
      String[] variables = x.split(" ");
      for(String variable: variables) {
        int currentVariable = Integer.parseInt(variable);
        if(currentVariable > 0) {
          parsedPuzzle.append(Convert.fromBase9(currentVariable));
        }
      }

      String result = parsedPuzzle.toString();
      for(int i = 0; i < result.length(); i++) {
        if(i != 0 && i % 9 == 0) {
          output.write("\n");
        } else if(i != 0 && i % 3 == 0) {
          output.write(" ");
        }

        output.write(String.valueOf(result.charAt(i)));
      }
    } else {
      output.write(x);
    }

    // Teardown
    output.flush();
    output.close();
    input.close();
  }

}
