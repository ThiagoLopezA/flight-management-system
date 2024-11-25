package views;

import models.CrewMember;
import models.Flight;
import shared.structures.AVLTree;
import views.utils.CliUtils;

import java.util.Scanner;

/**
 * Provides a menu for managing the crew members of a selected flight.
 * Users can print the crew tree, add crew members, and observe AVL tree
 * rotations.
 */
public class CrewMenu {
  private final Flight flight;

  /**
   * Constructs a CrewMenu for managing the crew of a specific flight.
   *
   * @param flight the flight whose crew members will be managed
   */
  public CrewMenu(Flight flight) {
    this.flight = flight;
  }

  /**
   * Displays the Crew Menu and handles user interactions.
   */
  public void show() {
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
      CliUtils.clearScreen();
      System.out
          .println("=== Crew Management for Flight " + flight.getOrigin() + " -> " + flight.getDestination() + " ===");
      System.out.println("1. Print Crew Members (Tree Graph)");
      System.out.println("2. Add Crew Member");
      System.out.println("3. Return to Flight Menu");
      System.out.print("Choose an option: ");

      option = scanner.nextInt();
      scanner.nextLine(); // Consume newline

      CliUtils.clearScreen();

      switch (option) {
        case 1:
          printCrewTree();
          CliUtils.pause();
          break;
        case 2:
          addCrewMember(scanner);
          CliUtils.pause();
          break;
        case 3:
          System.out.println("Returning to Flight Menu...");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          CliUtils.pause();
      }
    } while (option != 3);
  }

  /**
   * Prints the crew members of the flight in a tree graph format.
   */
  private void printCrewTree() {
    System.out.println("Crew Members (Tree Graph):");
    AVLTree<CrewMember> crewTree = flight.getCrewTree();
    crewTree.printTree(); // Assume AVLTree has a printTree() method for graphical representation
  }

  /**
   * Adds a new crew member to the flight.
   *
   * @param scanner the scanner for user input
   */
  private void addCrewMember(Scanner scanner) {
    System.out.print("Enter Crew Member Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Seat Number: ");
    int seatNumber = scanner.nextInt();

    CrewMember crewMember = new CrewMember(name, seatNumber);
    if (flight.addCrewMember(crewMember)) {
      System.out.println("Crew member added successfully.");
    } else {
      System.out.println("Failed to add crew member (flight may be full).");
    }
  }
}
