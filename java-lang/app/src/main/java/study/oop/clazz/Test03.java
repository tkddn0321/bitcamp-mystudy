package study.oop.clazz;

// 연습 : 클래스 문법을 데이터 타입 정의하는 용도로 사용
public class Test03 {
  class B {} // non-static nested class
  static class C {} // static nested class
  Object obj1 = new Object() {}; // anonymous class

  void m1() {
    class D {} // local class

    Object obj = new Object() {}; // anonymous class
  }
}
// package member class
class A{

}
