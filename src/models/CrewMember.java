package models;

/*
 * Represents a crew member in the system
 * A crew member is associated with a unique value and has a name
 */
public class CrewMember extends TreeEntity {
  private String name;

  /**
   * @param name  the name of the crew member
   * @param value the unique seat number assigned to the crew member
   */
  public CrewMember(String name, Integer seatNumber) {
    this.name = name;
    this.value = seatNumber;
  }

  /**
   * @return a string containing the name and seat numebr of the crew member
   */
  @Override
  public String toString() {
    return "CrewMember{" +
        "name='" + name + '\'' +
        ", value=" + value +
        '}';
  }

  /**
   * Gets the name of the crew member.
   * 
   * @return the name of the crew member
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the crew member.
   *
   * @param name the new name of the crew member
   */
  public void setName(String name) {
    this.name = name;
  }
}