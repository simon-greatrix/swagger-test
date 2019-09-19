package petstore.gen.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import petstore.gen.model.Pet;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PetCat
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-19T09:46:01.626578+01:00[Europe/London]")
public class PetCat extends Pet  {
  @JsonProperty("favouriteFood")
  private String favouriteFood = null;

  public PetCat favouriteFood(String favouriteFood) {
    this.favouriteFood = favouriteFood;
    return this;
  }

  /**
   * What is this cat's favourite food?
   * @return favouriteFood
  **/
  @ApiModelProperty(value = "What is this cat's favourite food?")

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
    return Objects.equals(this.favouriteFood, pet¤Cat.favouriteFood) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(favouriteFood, super.hashCode());
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
