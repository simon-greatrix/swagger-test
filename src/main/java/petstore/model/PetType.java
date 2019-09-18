package petstore.model;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
public enum PetType {
  DOG(LatinNames.DOG),
  CAT(LatinNames.CAT),
  HAMSTER(LatinNames.HAMSTER);

  private final String latinName;


  PetType(String latinName) {
    this.latinName = latinName;
  }


  @JsonValue
  public String getLatinName() {
    return latinName;
  }

}
