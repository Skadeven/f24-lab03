package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList extends SortedIntList{
    // Write your implementation below with API documentation
    private final SortedIntList sortedList;
    private int totalAdded;
    // Write your implementation below with API documentation
    /**
     * Adds the specified int to the list.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */

    public DelegationSortedIntList() {
        sortedList = new SortedIntList(); 
        this.totalAdded = 0;
    }

    @Override
    public boolean add(int num){
        totalAdded++; 
        return sortedList.add(num);
    }

    /**
     * Adds all of the elements of the IntegerList to the list.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list){
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (add(list.get(i))) { // Use add method for each element
                result = true;
            }
        }
        return result;
    }


    // Return the total number of added elements
    public int getTotalAdded() {
    return totalAdded;
    }

    // Delegate the get method to SortedIntList
    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    // Delegate the remove method to SortedIntList
    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    // Implement the removeAll method using IntegerList for delegation
    @Override
    public boolean removeAll(IntegerList list) {
        boolean modified = false;
        for (int i = 0; i < list.size(); i++) {
            if (remove(list.get(i))) { // Use remove method for each element
                modified = true;
            }
        }
        return modified;
    }

    // Delegate the size method to SortedIntList
    @Override
    public int size() {
        return sortedList.size();
    }

}