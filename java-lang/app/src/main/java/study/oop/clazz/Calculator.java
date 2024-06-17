package study.oop.clazz;

public class Calculator {
  int result;
  static int plus(int a, int b) {
    return a + b;
  }

  void minus(int a) {
    this.result -= a;
  }

  void multiple(int a) {
    this.result *= a;
  }

  void divide(int a) {
    this.result /= a;
  }

  int getResult() {
    return this.result;
  }
}
