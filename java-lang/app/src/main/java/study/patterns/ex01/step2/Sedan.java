package study.patterns.ex01.step2;

public class Sedan extends Car{
  boolean sunroof;
  boolean auto;


  @Override
  public String toString() {
    return "Sedan [sunroof=" + sunroof + ", auto=" + auto + ", maker=" + maker + ", model=" + model
        + ", cc=" + cc + "]";
  }

  private Sedan() {}

  // Factory Method
  public static Sedan create(String model) {
    Sedan s = new Sedan();

    switch (model) {
      case "소나타":

        Sedan s1 = new Sedan();
        s1.maker = "현대자동차";
        s1.model = "소나타";
        s1.cc = 1998;
        s1.auto = true;
        s1.sunroof = false;
        break;

      case "k7":

        Sedan s2 = new Sedan();
        s2.maker = "기아자동차";
        s2.model = "k7";
        s2.cc = 2500;
        s2.auto = true;
        s2.sunroof = true;
        break;
    }
    return s;
  }





}
