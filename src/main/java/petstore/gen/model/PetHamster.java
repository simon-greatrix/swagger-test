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
 * PetHamster
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-19T09:46:01.626578+01:00[Europe/London]")
public class PetHamster extends Pet  {
  @JsonProperty("averageWheelTime")
  private Double averageWheelTime = null;

  public PetHamster averageWheelTime(Double averageWheelTime) {
    this.averageWheelTime = averageWheelTime;
    return this;
  }

  /**
   * How long does this hamster spend on its wheel in seconds?
   * @return averageWheelTime
  **/
  @ApiModelProperty(value = "How long does this hamster spend on its wheel in seconds?")

  public Double getAverageWheelTime() {
    return averageWheelTime;
  }

  public void setAverageWheelTime(Double averageWheelTime) {
    this.averageWheelTime = averageWheelTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PetHamster pet¤Hamster = (PetHamster) o;
    return Objects.equals(this.averageWheelTime, pet¤Hamster.averageWheelTime) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(averageWheelTime, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PetHamster {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    averageWheelTime: ").append(toIndentedString(averageWheelTime)).append("\n");
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
