package views.utils;

public class CliUtils {
  /**
   * Clears the console screen by printing multiple new lines.
   */
  public static void clearScreen() {
    for (int i = 0; i < 50; i++) {
      System.out.println();
    }
  }

  /**
   * Pauses the CLI until the user presses Enter.
   */
  public static void pause() {
    System.out.println("Press Enter to continue...");
    try {
      System.in.read();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
