package views;

import models.CrewMember;
import models.Flight;
import shared.structures.Graph;
import views.utils.CliUtils;

/**
 * Runs automated tests to validate the business logic and features of the
 * system.
 * Each test provides detailed data and explanations for verification.
 */
public class AutomatedTestRunner {

  /**
   * Executes all automated tests and displays the results.
   *
   * @param flightGraph the graph to use for testing
   */
  public static void runTests(Graph<Flight> flightGraph) {
    System.out.println("=== Starting Automated Tests ===\n");

    // Clear any existing data
    flightGraph.getVertices().clear();

    // Run each test with detailed outputs
    testAddFlights(flightGraph);
    testAddEdges(flightGraph);
    testAddCrewMembers(flightGraph);
    testGraphPrinting(flightGraph);
    testCrewTreePrinting(flightGraph);
    testPricingLogic(flightGraph);

    System.out.println("\n=== Automated Tests Completed Successfully ===");
  }

  /**
   * Introduces and executes Test 1: Adding Flights.
   *
   * @param flightGraph the graph to use for testing
   */
  private static void testAddFlights(Graph<Flight> flightGraph) {
    printTestIntro(1, "Adding Flights", "This test adds three flights to the graph and verifies their addition.");

    Flight flight1 = new Flight("Cordoba", "Buenos Aires", 80000, 15);
    Flight flight2 = new Flight("Buenos Aires", "Bariloche", 150000, 15);
    Flight flight3 = new Flight("Cordoba", "Bariloche", 120000, 15);

    flightGraph.addVertex(flight1);
    flightGraph.addVertex(flight2);
    flightGraph.addVertex(flight3);

    System.out.println("Flights added:");
    System.out.println(flight1);
    System.out.println(flight2);
    System.out.println(flight3);

    pauseForUser(); // Single pause after test output
  }

  /**
   * Introduces and executes Test 2: Adding Connections (Edges).
   *
   * @param flightGraph the graph to use for testing
   */
  private static void testAddEdges(Graph<Flight> flightGraph) {
    printTestIntro(2, "Adding Connections", "This test creates connections between flights with associated costs.");

    Flight flight1 = findFlight(flightGraph, "Cordoba", "Buenos Aires");
    Flight flight2 = findFlight(flightGraph, "Buenos Aires", "Bariloche");
    Flight flight3 = findFlight(flightGraph, "Cordoba", "Bariloche");

    flightGraph.addEdge(flight1, flight2, flight1.getDefaultPrice());
    flightGraph.addEdge(flight1, flight3, flight3.getDefaultPrice());

    System.out.println("Connections added:");
    System.out.println(flight1 + " -> " + flight2 + " (Cost: " + flight1.getDefaultPrice() + ")");
    System.out.println(flight1 + " -> " + flight3 + " (Cost: " + flight3.getDefaultPrice() + ")");

    pauseForUser();
  }

  /**
   * Introduces and executes Test 3: Adding Crew Members to One Flight.
   *
   * @param flightGraph the graph to use for testing
   */
  private static void testAddCrewMembers(Graph<Flight> flightGraph) {
    printTestIntro(3, "Adding Crew Members to a Flight",
        "This test adds crew members to one flight and displays tree balancing.");

    Flight flight1 = findFlight(flightGraph, "Cordoba", "Buenos Aires");

    System.out.println("Adding crew members to " + flight1.getOrigin() + " -> " + flight1.getDestination() + ":");
    for (int i = 1; i <= flight1.getCapacity(); i++) {
      flight1.addCrewMember(new CrewMember("Crew " + i, i));
      displayTreeProgress(flight1);
    }
    System.out.println("Crew members added.");

    pauseForUser();
  }

  /**
   * Introduces and executes Test 4: Printing the Flight Graph.
   *
   * @param flightGraph the graph to use for testing
   */
  private static void testGraphPrinting(Graph<Flight> flightGraph) {
    printTestIntro(4, "Printing Flight Graph",
        "This test displays the graph structure with flights and their connections.");

    System.out.println("Flight Graph:");
    flightGraph.printGraph();

    pauseForUser();
  }

  /**
   * Introduces and executes Test 5: Printing the Crew AVL Tree for One Flight.
   *
   * @param flightGraph the graph to use for testing
   */
  private static void testCrewTreePrinting(Graph<Flight> flightGraph) {
    printTestIntro(5, "Printing Crew AVL Tree",
        "This test prints the crew members as a balanced AVL tree for one flight.");

    Flight flight1 = findFlight(flightGraph, "Cordoba", "Buenos Aires");
    System.out.println("Crew tree for flight " + flight1.getOrigin() + " -> " + flight1.getDestination() + ":");
    flight1.getCrewTree().printTree();
    System.out.println();

    pauseForUser();
  }

  /**
   * Introduces and executes Test 6: Validating Pricing Logic.
   *
   * @param flightGraph the graph to use for testing
   */
  private static void testPricingLogic(Graph<Flight> flightGraph) {
    printTestIntro(6, "Validating Pricing Logic",
        "This test verifies pricing adjustments based on flight occupancy levels.");

    Flight flight1 = findFlight(flightGraph, "Cordoba", "Buenos Aires");

    System.out.println("Flight details:");
    System.out.println("Base Price: " + flight1.getDefaultPrice());
    System.out.println("Capacity: " + flight1.getCapacity());

    System.out.println("\nCalculating price at different occupancy levels...");
    System.out.println("Initial price (0% occupancy): " + flight1.calculatePrice());

    for (int i = 1; i <= flight1.getCapacity() * 0.5; i++) {
      flight1.addCrewMember(new CrewMember("Extra Crew " + i, i));
    }
    System.out.println("Price after 50% occupancy: " + flight1.calculatePrice());

    for (int i = (int) (flight1.getCapacity() * 0.5) + 1; i <= flight1.getCapacity(); i++) {
      flight1.addCrewMember(new CrewMember("Extra Crew " + i, i));
    }
    System.out.println("Price after 100% occupancy: " + flight1.calculatePrice());

    pauseForUser();
  }

  /**
   * Prints the introduction for a test.
   *
   * @param testNumber  the test number
   * @param title       the title of the test
   * @param description a brief description of the test
   */
  private static void printTestIntro(int testNumber, String title, String description) {
    System.out.println("\n=== Test " + testNumber + ": " + title + " ===");
    System.out.println(description);
    System.out.println();
  }

  /**
   * Pauses the execution to let the user read the output.
   */
  private static void pauseForUser() {
    CliUtils.pause();
  }

  /**
   * Displays the progress of AVL tree balancing for a flight's crew tree.
   *
   * @param flight the flight whose crew tree is being updated
   */
  private static void displayTreeProgress(Flight flight) {
    System.out.println("Updated Crew Tree for " + flight.getOrigin() + " -> " + flight.getDestination() + ":");
    flight.getCrewTree().printTree();
    System.out.println();
  }

  /**
   * Finds a flight in the graph by origin and destination.
   *
   * @param flightGraph the graph containing flights
   * @param origin      the origin of the flight
   * @param destination the destination of the flight
   * @return the flight if found, or null
   */
  private static Flight findFlight(Graph<Flight> flightGraph, String origin, String destination) {
    return flightGraph.getVertices().keySet().stream()
        .filter(f -> f.getOrigin().equals(origin) && f.getDestination().equals(destination))
        .findFirst().orElse(null);
  }
}
