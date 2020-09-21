//package stacks_and_queues;
//
//import java.util.Iterator;
//
//public class Stack2<Item> {
// private int N;
// 
// 
// public Iterator<Item> iterator()
// { return new ReverseArrayIterator(); }
// 
// private class ReverseArrayIterator implements Iterator<Item> {
//  
//  private int i = N;
//  private Item s;
//  
//  public boolean hasNext() { return i > 0; }
//  
//  public void remove() { /* Not supported */ }
//  
//  public Item next() { return s[--i]; }
// }
//}
