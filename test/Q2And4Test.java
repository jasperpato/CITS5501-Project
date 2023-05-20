import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.*;
import java.util.stream.*;

public class Q2And4Test {

  static Stream<Arguments> testCaseProvider() {
    return Stream.of(
      arguments(List.of("<a>", "::=", "\"a\""), 1), // single terminal
      arguments(List.of("<a>", "::=", "\"a\"", "|", "\"b\""), 2), // two terminals
      arguments(List.of("<a>", "::=", "\"a\"", "\"b\""), 2), // one terminal split into two strings
      arguments(List.of("<a>", "::=", "[5-9]", "[A-D]"), 9) // ranges
    );
  }

  @ParameterizedTest
  @MethodSource("testCaseProvider")
  final void testQ2(List<String> l, int count) {
    assertEquals(count, Q2And4.countTerminalSymbols(l));
  }

}
