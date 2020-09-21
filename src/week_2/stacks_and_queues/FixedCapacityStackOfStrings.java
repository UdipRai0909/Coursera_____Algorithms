package week_2.stacks_and_queues;

public class FixedCapacityStackOfStrings {
 private String[] s;
 private int N = 0;
 
 public FixedCapacityStackOfStrings(int capacity) {
  s = new String[capacity];
 }
 
 public Boolean isEmpty() { 
  return N == 0;
 }
 
 public void push(String item) {
  s[N++] = item;
 }
 
 public String pop() {
  return s[--N];
 }
}
