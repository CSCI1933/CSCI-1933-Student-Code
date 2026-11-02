package CSCI1933P3;
/**
 * Updated by Adam Kvant for Fall 2024 in May 2024.
 *
 * @param <T> Generic type for the list interface.
 */
public interface List<T extends Comparable<T>> {



  /**
   * Add an element to end of the list. If element is null,
   * it will NOT add it and return false.  Otherwise, it
   * will add it and return true. Updates isSorted to false if
   * the element added breaks sorted order.
   *
   * @param element element to be added to the list.
   * @return if the addition was successful.
   */
  boolean add(T element);



  /**
   * Add an element at specific index. This method should
   * also shift the element currently at that position (if
   * any) and any subsequent elements to the right (adds
   * one to their indices). If element is null, or if index
   * index is out-of-bounds (index < 0 or index >= size_of_list),
   * it will NOT add it and return false. Otherwise it will
   * add it and return true. See size() for the definition
   * of size of list. Also updates isSorted variable to false if the
   * element added breaks the current sorted order.
   *
   * @param index index at which to add the element.
   * @param element element to be added to the list.
   * @return if the addition was successful.
   */
  boolean add(int index, T element);



  /**
   * Remove all elements from the list and updates isSorted accordingly.
   */
  void clear();



  /**
   * Return the element at given index. If index is
   * out-of-bounds, it will return null.
   *
   * @param index index to obtain from the list.
   * @return the element at the given index.
   */
  T get(int index);



  /**
   * Return the first index of element in the list. If element
   * is null or not found in the list, return -1. 
   * 
   * If isSorted is true, uses the ordering of the list to increase the efficiency
   * of the search.
   *
   *
   * @param element element to be found in the list.
   * @return first index of the element in the list.
   */
  int indexOf(T element);



  /**
   * Return true if the list is empty and false otherwise.
   *
   * @return if the list is empty.
   */
  boolean isEmpty();



  /**
   * size() return the number of elements in the list. Be careful
   * not to confuse this for the length of a list like for an ArrayList.
   * For example, if 4 elements are added to a list, size will return
   * 4, while the last index in the list will be 3. Another example
   * is that an ArrayList like [5, 2, 3, null, null] would have a size
   * of 3 for an ArrayList.
   * ArrayList and LinkedList hint: create a class variable in both ArrayList
   * and LinkedList to keep track of the sizes of the respective lists.
   *
   * @return size of the list.
   */
  int size();



  /**
   * Sort the elements of the list in ascending order using one of the following sort algorithms: Selection, Bubble, Insertion
   * 
   * If isSorted is true, increase the efficiency of the sort method
   * 
   * Hint: Since T extends Comparable, you will find it useful
   * to use the public int compareTo(T other) method.
   * Updates isSorted accordingly.
   */
  void sort();



  /**
   * Remove whatever is at index 'index' in the list and return
   * it. If index is out-of-bounds, return null. For the ArrayList,
   * elements to the right of index should be shifted over to maintain
   * contiguous storage. Must check to see if the list is sorted after removal
   * of the element at the given index and updates isSorted accordingly.
   *
   * @param index position to remove from the list.
   * @return the removed element.
   */
  T remove(int index);



  /**
   * Reverses the list IN PLACE. Any use of intermediate data structures will yield
   * your solution invalid.
   */
  void reverse();



  /**
   * Remove all duplicate elements from the list.
   * The removal must be done in a stable manner,
   * or in other words the first occurrence of an element must keep its relative order
   * to the first occurrences of other elements.
   * Example A,B,A,C,B,A,D -> A,B,C,D
   */
  void removeDuplicates();



  /**
   * The current list should be updated to contain all elements that are in
   * the current list or the other list, but NOT in both of the lists. As an
   * example, if list1 contains (A,B,C) and list2 contains (B,C,D), then
   * list1.exclusiveOr(list2) should contain (A,D).
   *
   * If otherList is null, do not make any modifications.
   *
   * The final result should be sorted and all duplicates should be removed.
   * Consider calling sort() and removeDuplicates() on both of the lists
   * before computing the exclusive or.
   * Note, you will have to cast otherList from a List<T> type to a ArrayList<T>
   * type or LinkedList<T>.
   *
   * After checking for possible errors, you're first few lines of code should be:
   * LinkedList<T> other = (LinkedList<T>) otherList; or ArrayList<T> other =
   * (Arraylist<T>) otherList;
   * this.sort();
   * this.removeDuplicates();
   * other.sort();
   * other.removeDuplicates();
   *
   * @param otherList the other list that this operation is being performed on.
   */
  public void exclusiveOr(List<T> otherList);



/**
   * Rotate this list to the right by n positions. This rotation must be done IN
   * PLACE. Any use of
   * intermediate data structures will yield your solution invalid. If
   * n is less than or equal to 0 OR the list length is less than or equal to 1,
   * return false without rotating.
   * Returns true otherwise after completing the rotation. Updates isSorted
   * accordingly.
   *
   * @param n the number of rotations to make in the array.
   * @return boolean if the rotations were successful.
   */
  public boolean rotate(int n);



  /**
   * Returns the minimum value of the List
   * If the list is empty, return NULL.
   * Note, consider how sorting can affect runtime or optimize this solution
   */
  T getMin();



  /**
   * Returns the maximum value of the List
   * 
   * If isSorted is true, make a case where this method is optimized.
   * Hint: Use a tail pointer for your LinkedList implementation.
   */
  T getMax();



  /**
   * Note that this method exists for debugging purposes.
   * It calls the toString method of the underlying elements in
   * the list in order to create a String representation of the list.
   * The format of the toString should appear as follows:
   * Element_1
   * Element_2
   * .
   * .
   * .
   * Element_n
   * Watch out for extra spaces or carriage returns. Each element
   * should be printed on its own line.
   *
   * @return String representation of the list.
   */
  String toString();


  
  /**
   * Simply returns the isSorted attribute.
   *
   * @return isSorted boolean attribute.
   */
  boolean isSorted();
}
