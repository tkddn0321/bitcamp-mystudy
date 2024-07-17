package study.oop.lambda;

public class Test05 {

  interface Calculator {
    int plus(int a, int b);
  }

  static void test(Calculator c) {
    System.out.println(c.plus(100, 200));
  }

  public static void main(String[] args) {
    // 1) 일반 클래스
    class Calc implements Calculator {
      @Override
      public int plus(int a, int b) {
        return a + b;
      }
    }
    Calculator c1 = new Calc();
    test(c1);

    // 2) 익명 클래스
    Calculator c2 = new Calculator() {
      @Override
      public int plus(int a, int b) {
        return a + b;
      }
    };
    test(c2);

    //3)익명 클래스 직접 대입
    test(new Calculator() {
      @Override
      public int plus(int a, int b) {
        return a + b;
      }
    });

    // 4) 람다
    Calculator c3 = (int a, int b) -> {
      return a + b;
    };
    test(c3);

    // 5) 람다 + 중괄호 생략
    Calculator c4 = (int a, int b) -> a + b;
    test(c4);

    // 6) 람다 직접 대입
    test((int a, int b) -> a + b);
  }
}
