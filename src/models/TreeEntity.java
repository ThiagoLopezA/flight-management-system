package models;

/**
 * Represents a generic entity that can be stored in a tree structure.
 * Each entity is associated with a value.
 */
public abstract class TreeEntity {
  /**
   * The value associated with this entity.
   */
  public Integer value;

  /**
   * Returns a string representation of the tree entity.
   *
   * @return a string containing the seat number of the entity
   */
  @Override
  public String toString() {
    return "Value: " + value;
  }
}
