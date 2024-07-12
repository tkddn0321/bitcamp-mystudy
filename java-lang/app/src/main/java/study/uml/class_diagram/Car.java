package study.uml.class_diagram;

public class Car {
  Insurance insurance;
  Nevigation nevigation;
  Engine engine;



  public Car(Engine engine) {
    this.engine = engine;
  }

  public Insurance getInsurance() {
    return insurance;
  }

  public void setInsurance(Insurance insurance) {
    this.insurance = insurance;
  }

  public Nevigation getNevigation() {
    return nevigation;
  }

  public void setNevigation(Nevigation nevigation) {
    this.nevigation = nevigation;
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  public void fuelUp(GasStation gasStation) {
    gasStation.inject();
  }

}
