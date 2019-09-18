package petstore.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
public class Pet¤Dog extends Pet {

  @Schema(description = "Just how much worse is the bark than the bite?")
  private double biteToBarkRatio;


  public double getBiteToBarkRatio() {
    return biteToBarkRatio;
  }


  @Override
  public PetType getPetType() {
    return PetType.DOG;
  }


  public void setBiteToBarkRatio(double biteToBarkRatio) {
    this.biteToBarkRatio = biteToBarkRatio;
  }
}
