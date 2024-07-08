package study.patterns.ex01.step3;

public class K7Factory extends CarFactory {
  public Car create() {
    Sedan s = new Sedan();
    s.maker = "기아자동차";
    s.model = "k7";
    s.cc = 2500;
    s.auto = true;
    s.sunroof = true;
  }
}
