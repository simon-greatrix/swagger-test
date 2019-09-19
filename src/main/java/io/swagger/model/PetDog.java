package io.swagger.model;

import io.swagger.model.Pet;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PetDog extends Pet  {
  private @Valid Double biteToBarkRatio = null;

  /**
   * Just how much worse is the bark than the bite?
   **/
  public PetDog biteToBarkRatio(Double biteToBarkRatio) {
    this.biteToBarkRatio = biteToBarkRatio;
    return this;
  }

  
  @ApiModelProperty(value = "Just how much worse is the bark than the bite?")
  @JsonProperty("biteToBarkRatio")

  public Double getBiteToBarkRatio() {
    return biteToBarkRatio;
  }
  public void setBiteToBarkRatio(Double biteToBarkRatio) {
    this.biteToBarkRatio = biteToBarkRatio;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetDog pet¤Dog = (PetDog) o;
    return Objects.equals(biteToBarkRatio, pet¤Dog.biteToBarkRatio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(biteToBarkRatio);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PetDog {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    biteToBarkRatio: ").append(toIndentedString(biteToBarkRatio)).append("\n");
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
