package views;

import java.util.Scanner;

import shared.utils.DataLoader;
import views.utils.CliUtils;

/**
 * The main menu for the application.
 * Users can navigate to flight management, load test data, or run automated
 * tests.
 */
public class MainMenu {
  private final FlightMenu flightMenu;

  /**
   * Constructs a MainMenu instance with a FlightMenu.
   */
  public MainMenu() {
    this.flightMenu = new FlightMenu();
  }

  /**
   * Displays the main menu and handles user interactions.
   */
  public void show() {
    Scanner scanner = new Scanner(System.in);
    int option;

    do {
      CliUtils.clearScreen();
      System.out.println("=== Main Menu ===");
      System.out.println("1. Manage Flights");
      System.out.println("2. Load Test Data");
      System.out.println("3. Run Automated Tests");
      System.out.println("4. Exit");
      System.out.print("Choose an option: ");

      option = scanner.nextInt();

      CliUtils.clearScreen();

      switch (option) {
        case 1:
          flightMenu.show();
          break;
        case 2:
          DataLoader.loadTestData(flightMenu.getFlightGraph());
          CliUtils.pause();
          break;
        case 3:
          AutomatedTestRunner.runTests(flightMenu.getFlightGraph());
          CliUtils.pause();
          break;
        case 4:
          System.out.println("Exiting application. Goodbye!");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          CliUtils.pause();
      }
    } while (option != 4);

    scanner.close();
  }
}
