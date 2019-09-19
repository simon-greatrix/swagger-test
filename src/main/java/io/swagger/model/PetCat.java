package io.swagger.model;

import io.swagger.model.Pet;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PetCat extends Pet  {
  private @Valid String favouriteFood = null;

  /**
   * What is this cat&#x27;s favourite food?
   **/
  public PetCat favouriteFood(String favouriteFood) {
    this.favouriteFood = favouriteFood;
    return this;
  }

  
  @ApiModelProperty(value = "What is this cat's favourite food?")
  @JsonProperty("favouriteFood")

  public String getFavouriteFood() {
    return favouriteFood;
  }
  public void setFavouriteFood(String favouriteFood) {
    this.favouriteFood = favouriteFood;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetCat pet¤Cat = (PetCat) o;
    return Objects.equals(favouriteFood, pet¤Cat.favouriteFood);
  }

  @Override
  public int hashCode() {
    return Objects.hash(favouriteFood);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PetCat {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    favouriteFood: ").append(toIndentedString(favouriteFood)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
