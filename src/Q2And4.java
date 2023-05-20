
import java.util.List;
import java.lang.Math;

class Q2And4 {

  /**
   * @param l List<String> that makes up an EBNF grammar. Assumes grammar is valid (will compile on https://bnfplayground.pauliankline.com/).
   * @return int number of terminal symbols in provided grammar.
   */
  static int countTerminalSymbols(List<String> l) {
    int count = 0;
    for (String s : l) {
      if (s.contains("\"")) ++count;
      else if (s.contains("[")) {
        char start = s.charAt(1);
        char end = s.charAt(3);
        count += (int) end - (int) start + 1;
      }
    }
    return count;
  }

  /**
   * @param l List<String> that makes up an EBNF grammar. Assumes grammar is valid (will compile on https://bnfplayground.pauliankline.com/).
   * @return int number of productions in provided grammar.
   */
  static int countProductions(List<String> l) {
    int count = 0;
    for (String s : l) {
      if (s.equals("::=") || s.equals("|")) ++count;
      else if (s.contains("[")) {
        char start = s.charAt(1);
        char end = s.charAt(3);
        count += (int) end - (int) start;
      }
    }
    return count;
  }

  static void countDerivations() {
    List<Character> airport = List.of('A', 'B', 'C', 'D');
    for (List<Character> l : Itertools.product(airport, airport, airport, airport)) {
      System.out.println(l);
    }
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    
    countDerivations();

    long endTime = System.currentTimeMillis();
    System.out.printf("That took %.2f seconds\n", (endTime - startTime)/1000);
  }

}