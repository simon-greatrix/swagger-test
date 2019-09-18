package petstore.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
public class Pet¤Hamster extends Pet {

  @Schema(description = "How long does this hamster spend on its wheel in seconds?")
  private double averageWheelTime;


  public double getAverageWheelTime() {
    return averageWheelTime;
  }


  @Override
  public PetType getPetType() {
    return PetType.HAMSTER;
  }


  public void setAverageWheelTime(double averageWheelTime) {
    this.averageWheelTime = averageWheelTime;
  }
}
