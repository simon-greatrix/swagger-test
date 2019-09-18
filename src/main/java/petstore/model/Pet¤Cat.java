package petstore.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
public class Pet¤Cat extends Pet {

  @Schema(description = "What is this cat's favourite food?")
  private String favouriteFood;



  public String getFavouriteFood() {
    return favouriteFood;
  }


  @Override
  public PetType getPetType() {
    return PetType.CAT;
  }


  public void setFavouriteFood(String favouriteFood) {
    this.favouriteFood = favouriteFood;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pet¤Cat)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Pet¤Cat that = (Pet¤Cat) o;
    return Objects.equals(favouriteFood, that.favouriteFood);
  }


  @Override
  public int hashCode() {
    return Objects.hash(favouriteFood);
  }
}
