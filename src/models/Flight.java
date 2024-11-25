package models;

import shared.structures.AVLTree;

/**
 * Represents a flight in the system.
 * A flight has an origin, destination, a base price, capacity, and manages its
 * crew members using an AVL tree. The class supports equality and hash
 * operations,
 * making it suitable for use in data structures such as graphs and hash maps.
 */
public class Flight {
  private final String origin;
  private final String destination;
  private final int defaultPrice;
  private final int capacity;
  private int occupiedSeats;
  private final AVLTree<CrewMember> crewTree;

  /**
   * Constructs a Flight with the specified parameters.
   *
   * @param origin       the origin city of the flight
   * @param destination  the destination city of the flight
   * @param defaultPrice the base price of the flight
   * @param capacity     the maximum number of seats available on the flight
   */
  public Flight(String origin, String destination, int defaultPrice, int capacity) {
    this.origin = origin;
    this.destination = destination;
    this.defaultPrice = defaultPrice;
    this.capacity = capacity;
    this.occupiedSeats = 0;
    this.crewTree = new AVLTree<>();
  }

  /**
   * Adds a crew member to the flight.
   * The crew member is assigned to a specific seat based on their seat number.
   * If the flight is fully booked, the operation will fail.
   *
   * @param crewMember the crew member to add
   * @return true if the crew member was successfully added, false otherwise
   */
  public boolean addCrewMember(CrewMember crewMember) {
    if (occupiedSeats >= capacity) {
      System.out.println("Flight is fully booked.");
      return false;
    }
    crewTree.insert(crewMember);
    occupiedSeats++;
    return true;
  }

  /**
   * Calculates the current price of the flight based on the number of occupied
   * seats.
   * Discounts are applied as follows:
   * - 10% discount if the flight is 50% occupied.
   * - 20% discount if the flight is 70% occupied.
   * - 40% discount if the flight is fully occupied.
   *
   * @return the dynamically adjusted price of the flight
   */
  public int calculatePrice() {
    if (occupiedSeats == capacity) {
      return defaultPrice * 60 / 100; // 40% discount
    } else if (occupiedSeats >= capacity * 0.7) {
      return defaultPrice * 80 / 100; // 20% discount
    } else if (occupiedSeats >= capacity * 0.5) {
      return defaultPrice * 90 / 100; // 10% discount
    } else {
      return defaultPrice;
    }
  }

  /**
   * Prints detailed information about the flight, including its price, capacity,
   * and crew members.
   */
  public void printDetails() {
    System.out.println("Flight from " + origin + " to " + destination);
    System.out.println("Base Price: " + defaultPrice);
    System.out.println("Current Price: " + calculatePrice());
    System.out.println("Occupied Seats: " + occupiedSeats + "/" + capacity);
    System.out.println("Crew Members (In-Order):");
    crewTree.inOrder();
  }

  /**
   * Gets the origin city of the flight.
   *
   * @return the origin city of the flight
   */
  public String getOrigin() {
    return origin;
  }

  /**
   * Gets the destination city of the flight.
   *
   * @return the destination city of the flight
   */
  public String getDestination() {
    return destination;
  }

  /**
   * Gets the base price of the flight.
   *
   * @return the base price of the flight
   */
  public int getDefaultPrice() {
    return defaultPrice;
  }

  /**
   * Gets the number of seats currently occupied on the flight.
   *
   * @return the number of occupied seats
   */
  public int getOccupiedSeats() {
    return occupiedSeats;
  }

  /**
   * Gets the total capacity of the flight.
   *
   * @return the total capacity of the flight
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Determines whether this flight is equal to another object.
   * Two flights are considered equal if they have the same origin and
   * destination.
   *
   * @param obj the object to compare with this flight
   * @return true if the specified object is equal to this flight, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Flight flight = (Flight) obj;
    return origin.equals(flight.origin) && destination.equals(flight.destination);
  }

  /**
   * Returns the hash code for this flight.
   * The hash code is computed based on the origin and destination.
   *
   * @return the hash code for this flight
   */
  @Override
  public int hashCode() {
    return origin.hashCode() * 31 + destination.hashCode();
  }

  /**
   * Returns a string representation of this flight.
   * The string contains the origin, destination, base price, and capacity.
   *
   * @return a string representation of this flight
   */
  @Override
  public String toString() {
    return "Flight{" +
        "origin='" + origin + '\'' +
        ", destination='" + destination + '\'' +
        ", defaultPrice=" + defaultPrice +
        ", capacity=" + capacity +
        '}';
  }

  /**
   * Gets the AVL tree containing the crew members for this flight.
   *
   * @return the AVL tree of crew members
   */
  public AVLTree<CrewMember> getCrewTree() {
    return crewTree;
  }

}
