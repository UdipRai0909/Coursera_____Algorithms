package week_2.stacks_and_queues;

public class FixedCapacityStack<Item> {
 private Item[] s;
 private int N = 0;
 
 public FixedCapacityStack(int capacity) {
//  s = new Item[capacity]; 
  // @#$*! generic array creation not allowed
 }
 
 public boolean isEmpty() {
  return N == 0;
 }
 
 public void push(Item item) {
  s[N++] = item;
 }
 
 public Item pop() {
  return s[--N];
 }
}
