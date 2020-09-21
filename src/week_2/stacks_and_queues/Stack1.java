package week_2.stacks_and_queues;

import java.util.Iterator;

public class Stack1<Item> implements Iterable<Item> {
 
 private Node first = null;
 
 private class Node {
  Item item;
  Node next;
 }
 public Iterator<Item> iterator() 
 { return new ListIterator(); }
 
 private class ListIterator implements Iterator<Item> {
  
  private Node current = first;
  
  public boolean hasNext() { return current != null; }
  
  public void remove() { /* not supported */ }
  
  public Item next() {
   Item item = current.item;
   current = current.next;
   return item;
  }
 }
}
