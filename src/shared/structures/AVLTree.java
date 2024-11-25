package shared.structures;

import models.TreeEntity;

/**
 * A generic implementation of an AVL Tree, a self-balancing binary search tree.
 * This tree is used to store entities that extend the TreeEntity class,
 * ensuring efficient insertion, retrieval, and traversal operations while
 * maintaining balance.
 *
 * @param <T> the type of elements stored in the tree, which must extend
 *            TreeEntity
 */
public class AVLTree<T extends TreeEntity> {
  /**
   * Represents a node in the AVL Tree.
   *
   * @param <T> the type of entity stored in the node
   */
  @SuppressWarnings("hiding")
  class Node<T> {
    T entity;
    int key, height;
    Node<T> left, right;

    Node(T entity) {
      this.entity = entity;
      this.height = 1;
    }
  }

  private Node<T> root;

  /**
   * Returns the height of a given node.
   *
   * @param node the node whose height is to be determined
   * @return the height of the node, or 0 if the node is null
   */
  int height(Node<T> node) {
    return node == null ? 0 : node.height;
  }

  /**
   * Calculates the balance factor of a given node.
   * The balance factor is the difference in height between the left and right
   * subtrees.
   *
   * @param node the node whose balance factor is to be calculated
   * @return the balance factor of the node, or 0 if the node is null
   */
  int getBalanceFactor(Node<T> node) {
    return node == null ? 0 : height(node.left) - height(node.right);
  }

  /**
   * Performs a right rotation on a subtree rooted at the given node.
   *
   * @param y the root of the subtree to be rotated
   * @return the new root of the rotated subtree
   */
  Node<T> rightRotate(Node<T> y) {
    Node<T> x = y.left;
    Node<T> temp = x.right;

    x.right = y;
    y.left = temp;

    y.height = Math.max(height(y.left), height(y.right)) + 1;
    x.height = Math.max(height(x.left), height(x.right)) + 1;

    return x;
  }

  /**
   * Performs a left rotation on a subtree rooted at the given node.
   *
   * @param x the root of the subtree to be rotated
   * @return the new root of the rotated subtree
   */
  Node<T> leftRotate(Node<T> x) {
    Node<T> y = x.right;
    Node<T> temp = y.left;

    y.left = x;
    x.right = temp;

    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    return y;
  }

  /**
   * Recursively inserts an entity into the AVL tree and rebalances the tree if
   * necessary.
   *
   * @param node   the current node in the recursion
   * @param entity the entity to be inserted
   * @return the new root of the subtree after insertion and balancing
   */
  Node<T> insert(Node<T> node, T entity) {
    if (node == null) {
      return new Node<T>(entity);
    }

    if (entity.value < node.entity.value) {
      node.left = insert(node.right, entity);
    } else if (entity.value > node.entity.value) {
      node.right = insert(node.right, entity);
    } else {
      return node;
    }

    node.height = 1 + Math.max(height(node.left), height(node.right));
    Integer balance = getBalanceFactor(node);

    if (balance > 1 && entity.value < node.left.entity.value) {
      return rightRotate(node);
    }
    if (balance < -1 && entity.value > node.right.entity.value) {
      return leftRotate(node);
    }
    if (balance > 1 && entity.value > node.left.entity.value) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }
    if (balance < -1 && entity.value < node.right.entity.value) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }

    return node;
  }

  /**
   * Inserts an entity into the AVL tree.
   *
   * @param entity the entity to be inserted
   */
  public void insert(T entity) {
    this.root = insert(this.root, entity);
  }

  /**
   * Performs an in-order traversal of the AVL tree, starting from a specified
   * node.
   * This traversal visits nodes in ascending order of their values.
   *
   * @param node the starting node for the traversal
   */
  public void inOrder(Node<T> node) {
    if (node == null) {
      return;
    }

    inOrder(node.left);
    System.out.println(node.key + " ");
    inOrder(node.right);
  }

  /**
   * Performs an in-order traversal of the entire AVL tree.
   * Prints the entities stored in the tree in ascending order of their values.
   */
  public void inOrder() {
    inOrder(this.root);
  }

  /**
   * Prints the tree in a graphical format.
   */
  public void printTree() {
    printTreeRecursive(root, "", true);
  }

  private void printTreeRecursive(Node<T> node, String prefix, boolean isRight) {
    if (node != null) {
      System.out.println(prefix + (isRight ? "└── " : "├── ") + node.entity);

      printTreeRecursive(node.left, prefix + (isRight ? "    " : "│   "), false);
      printTreeRecursive(node.right, prefix + (isRight ? "    " : "│   "), true);
    }
  }

}
