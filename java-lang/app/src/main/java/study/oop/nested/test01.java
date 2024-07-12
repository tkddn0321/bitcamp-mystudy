package study.oop.nested;

public class test01 {
  interface Printer{
    void print();
  }

  public static void main(String[] args) {

    Printer obj;
    obj = () -> {System.out.println("Hello!");};


  }

}
