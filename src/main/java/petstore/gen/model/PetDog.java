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
 * PetDog
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-19T09:46:01.626578+01:00[Europe/London]")
public class PetDog extends Pet  {
  @JsonProperty("biteToBarkRatio")
  private Double biteToBarkRatio = null;

  public PetDog biteToBarkRatio(Double biteToBarkRatio) {
    this.biteToBarkRatio = biteToBarkRatio;
    return this;
  }

  /**
   * Just how much worse is the bark than the bite?
   * @return biteToBarkRatio
  **/
  @ApiModelProperty(value = "Just how much worse is the bark than the bite?")

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
    return Objects.equals(this.biteToBarkRatio, pet¤Dog.biteToBarkRatio) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(biteToBarkRatio, super.hashCode());
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
