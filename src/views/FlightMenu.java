package views;

import models.Flight;
import shared.structures.Graph;
import views.utils.CliUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides a menu for managing flights in the system.
 * Users can add flights, select a flight for crew management, and view all
 * flights.
 */
public class FlightMenu {
  private final Graph<Flight> flightGraph;

  /**
   * Constructs a FlightMenu with an empty graph of flights.
   */
  public FlightMenu() {
    this.flightGraph = new Graph<>();
  }

  /**
   * Gets the flight graph for this menu.
   *
   * @return the flight graph
   */
  public Graph<Flight> getFlightGraph() {
    return flightGraph;
  }

  /**
   * Displays the Flight Menu and handles user interactions.
   */
  public void show() {
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
      CliUtils.clearScreen();
      System.out.println("=== Flight Management ===");
      System.out.println("1. Add Flight");
      System.out.println("2. Select Flight for Crew Management");
      System.out.println("3. Print All Flights");
      System.out.println("4. Return to Main Menu");
      System.out.print("Choose an option: ");

      option = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      CliUtils.clearScreen();

      switch (option) {
        case 1:
          addFlight(scanner);
          CliUtils.pause();
          break;
        case 2:
          selectFlight(scanner);
          break;
        case 3:
          printFlights();
          CliUtils.pause();
          break;
        case 4:
          System.out.println("Returning to Main Menu...");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          CliUtils.pause();
      }
    } while (option != 4);
  }

  /**
   * Adds a new flight to the system.
   *
   * @param scanner the scanner for user input
   */
  private void addFlight(Scanner scanner) {
    System.out.print("Enter Origin: ");
    String origin = scanner.nextLine();

    System.out.print("Enter Destination: ");
    String destination = scanner.nextLine();

    System.out.print("Enter Base Price: ");
    int basePrice = scanner.nextInt();

    System.out.print("Enter Capacity: ");
    int capacity = scanner.nextInt();

    Flight flight = new Flight(origin, destination, basePrice, capacity);
    flightGraph.addVertex(flight);

    System.out.println("Flight added successfully.");
  }

  /**
   * Allows the user to select a flight for crew management.
   *
   * @param scanner the scanner for user input
   */
  private void selectFlight(Scanner scanner) {
    System.out.println("Available Flights:");
    List<Flight> flights = new ArrayList<>(flightGraph.getVertices().keySet());
    for (int i = 0; i < flights.size(); i++) {
      System.out.println((i + 1) + ". " + flights.get(i));
    }

    System.out.print("Select a flight by number: ");
    int flightIndex = scanner.nextInt() - 1;

    if (flightIndex < 0 || flightIndex >= flights.size()) {
      System.out.println("Invalid selection. Returning to menu.");
      CliUtils.pause();
      return;
    }

    Flight selectedFlight = flights.get(flightIndex);
    CrewMenu crewMenu = new CrewMenu(selectedFlight);
    crewMenu.show();
  }

  /**
   * Prints all flights in the graph.
   */
  private void printFlights() {
    System.out.println("=== All Flights ===");
    flightGraph.printGraph();
  }
}
