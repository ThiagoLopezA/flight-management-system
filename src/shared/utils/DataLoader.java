package shared.utils;

import models.CrewMember;
import models.Flight;
import shared.structures.Graph;

/**
 * Utility class to load predefined test data into the graph.
 */
public class DataLoader {
  /**
   * Loads predefined flights and crew members into the provided graph.
   *
   * @param flightGraph the graph to load test data into
   */
  public static void loadTestData(Graph<Flight> flightGraph) {
    System.out.println("Loading test data...");

    // Define flights
    Flight flight1 = new Flight("Cordoba", "Buenos Aires", 80000, 15);
    Flight flight2 = new Flight("Buenos Aires", "Bariloche", 150000, 15);
    Flight flight3 = new Flight("Cordoba", "Bariloche", 120000, 15);
    Flight flight4 = new Flight("Bariloche", "Cordoba", 100000, 15);

    // Add flights to the graph
    flightGraph.addVertex(flight1);
    flightGraph.addVertex(flight2);
    flightGraph.addVertex(flight3);
    flightGraph.addVertex(flight4);

    // Add edges with costs
    flightGraph.addEdge(flight1, flight2, flight1.getDefaultPrice());
    flightGraph.addEdge(flight1, flight3, flight3.getDefaultPrice());
    flightGraph.addEdge(flight3, flight4, flight4.getDefaultPrice());
    flightGraph.addEdge(flight2, flight4, flight4.getDefaultPrice());

    // Add crew members to flights
    flight1.addCrewMember(new CrewMember("Alice", 1));
    flight1.addCrewMember(new CrewMember("Bob", 2));
    flight1.addCrewMember(new CrewMember("Charlie", 3));
    flight1.addCrewMember(new CrewMember("Diana", 4));
    flight1.addCrewMember(new CrewMember("Eve", 5));
    flight1.addCrewMember(new CrewMember("Frank", 6));
    flight1.addCrewMember(new CrewMember("Grace", 7));
    flight1.addCrewMember(new CrewMember("Heidi", 8));
    flight1.addCrewMember(new CrewMember("Ivan", 9));
    flight1.addCrewMember(new CrewMember("Judy", 10));
    flight1.addCrewMember(new CrewMember("Ken", 11));
    flight1.addCrewMember(new CrewMember("Laura", 12));
    flight1.addCrewMember(new CrewMember("Mallory", 13));
    flight1.addCrewMember(new CrewMember("Niaj", 14));
    flight1.addCrewMember(new CrewMember("Olivia", 15));

    flight2.addCrewMember(new CrewMember("Patrick", 16));
    flight2.addCrewMember(new CrewMember("Quinn", 17));
    flight2.addCrewMember(new CrewMember("Robert", 18));
    flight2.addCrewMember(new CrewMember("Susan", 19));
    flight2.addCrewMember(new CrewMember("Trent", 20));
    flight2.addCrewMember(new CrewMember("Uma", 21));
    flight2.addCrewMember(new CrewMember("Victor", 22));
    flight2.addCrewMember(new CrewMember("Walter", 23));
    flight2.addCrewMember(new CrewMember("Xander", 24));
    flight2.addCrewMember(new CrewMember("Yvonne", 25));
    flight2.addCrewMember(new CrewMember("Zoe", 26));

    flight3.addCrewMember(new CrewMember("Arthur", 27));
    flight3.addCrewMember(new CrewMember("Betty", 28));
    flight3.addCrewMember(new CrewMember("Caleb", 29));
    flight3.addCrewMember(new CrewMember("Debra", 30));
    flight3.addCrewMember(new CrewMember("Elena", 31));
    flight3.addCrewMember(new CrewMember("Felix", 32));
    flight3.addCrewMember(new CrewMember("Gabriel", 33));
    flight3.addCrewMember(new CrewMember("Hannah", 34));
    flight3.addCrewMember(new CrewMember("Isabella", 35));
    flight3.addCrewMember(new CrewMember("Jack", 36));
    flight3.addCrewMember(new CrewMember("Karen", 37));
    flight3.addCrewMember(new CrewMember("Leo", 38));
    flight3.addCrewMember(new CrewMember("Mia", 39));
    flight3.addCrewMember(new CrewMember("Noah", 40));
    flight3.addCrewMember(new CrewMember("Olivia", 41));

    flight4.addCrewMember(new CrewMember("Paul", 42));
    flight4.addCrewMember(new CrewMember("Quincy", 43));
    flight4.addCrewMember(new CrewMember("Rita", 44));
    flight4.addCrewMember(new CrewMember("Steve", 45));
    flight4.addCrewMember(new CrewMember("Tina", 46));
    flight4.addCrewMember(new CrewMember("Ursula", 47));
    flight4.addCrewMember(new CrewMember("Victor", 48));
    flight4.addCrewMember(new CrewMember("Wendy", 49));
    flight4.addCrewMember(new CrewMember("Xavier", 50));

    System.out.println("Test data loaded successfully.");
  }
}
