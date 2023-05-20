import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SegmentSubcommandTest {

  /**
   * Test case 1 (from Q6 of project)
   * Tests normal execution of
   * {@link SegmentSubcommand#SegmentSubcommand(java.lang.String, java.lang.String, java.lang.String, java.time.LocalDate, CabinType, int)}.
   * Satisfies all base choices of the characteristics listed in Q6 of project.
   * Should not raise an exception. Should store all parameters as instance variables.
   */
  @Test
  void testSegmentSubcommand1() {
    String origin = "AAA";
    String destination = "AAB";
    String flightNumber = "AA1";
    java.time.LocalDate departureDate = java.time.LocalDate.now().plusDays(5); // 5 days after today
    CabinType cabinType = CabinType.PremiumFirstClass;
    int numPeople = 5;

    // Assert no exception thrown
    SegmentSubcommand command = assertDoesNotThrow(() -> {
      return new SegmentSubcommand(origin, destination, flightNumber, departureDate, cabinType, numPeople);
    });

    // Assert all parameters stored as instance variables
    assertEquals(origin, command.getOrigin());
    assertEquals(destination, command.getDestination());
    assertEquals(flightNumber, command.getFlightNumber());
    assertEquals(departureDate, command.getDepartureDate());
    assertEquals(cabinType, command.getCabinType());
    assertEquals(numPeople, command.getNumPeople());
  }

  /**
   * Test case 2 (from Q6 of project)
   * Testing characteristic 1 from Q6 of project, for
   * {@link SegmentSubcommand#SegmentSubcommand(java.lang.String, java.lang.String, java.lang.String, java.time.LocalDate, CabinType, int)}.
   * origin parameter is syntactically invalid, expected to throw a SynacticError.
   */
  @Test
  void testSegmentSubcommand2() {
    String origin = "AA"; // syntactically invalid
    String destination = "AAB";
    String flightNumber = "AA1";
    java.time.LocalDate departureDate = java.time.LocalDate.now().plusDays(5); // 5 days after today
    CabinType cabinType = CabinType.PremiumFirstClass;
    int numPeople = 5;

    assertThrows(SyntacticError.class, () -> {
      new SegmentSubcommand(origin, destination, flightNumber, departureDate, cabinType, numPeople);
    });
  }

  /**
   * Test case 3 (from Q6 of project)
   * Testing characteristic 3 from Q6 of project, for
   * {@link SegmentSubcommand#SegmentSubcommand(java.lang.String, java.lang.String, java.lang.String, java.time.LocalDate, CabinType, int)}.
   * origin is equal to destination, expected to throw a SemanticError.
   */
  @Test
  void testSegmentSubcommand3() {
    String origin = "AAA";
    String destination = "AAA";
    String flightNumber = "AA1";
    java.time.LocalDate departureDate = java.time.LocalDate.now().plusDays(5); // 5 days after today
    CabinType cabinType = CabinType.PremiumFirstClass;
    int numPeople = 5;

    assertThrows(SemanticError.class, () -> {
      new SegmentSubcommand(origin, destination, flightNumber, departureDate, cabinType, numPeople);
    });
  }

}
