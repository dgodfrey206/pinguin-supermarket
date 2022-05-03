class Main {
  public void test1() {
    FishyProduct fp = new FishyProduct("Micro Mac with Soft Fish", 1254);
    PenguinCustomer pc = new
PenguinCustomer("Tux", 1337);

  }
  public static void main(String[] args) {
    LinkedQueue<String> ls = new LinkedQueue<String>();
    ls.enqueue("ABC");
    ls.enqueue("DEF");
    System.out.println(ls.dequeue());
    ls.enqueue("XYZ");
    System.out.println(ls.dequeue());
    System.out.println(ls.dequeue());
    ls.enqueue("HHH");
    System.out.println(ls.dequeue());
  }
}