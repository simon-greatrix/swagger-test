package petstore.gen.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Pet
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-09-19T09:46:01.626578+01:00[Europe/London]")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "petType", visible = true )
@JsonSubTypes({
  @JsonSubTypes.Type(value = PetDog.class, name = "Pet¤Dog"),
  @JsonSubTypes.Type(value = PetHamster.class, name = "Pet¤Hamster"),
  @JsonSubTypes.Type(value = PetCat.class, name = "Pet¤Cat"),
})
public class Pet   {
  @JsonProperty("age")
  private Integer age = null;

  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  /**
   * Gets or Sets petType
   */
  public enum PetTypeEnum {
    DOG("DOG"),
    
    CAT("CAT"),
    
    HAMSTER("HAMSTER"),
    
    FELIS_CATUS("felis catus"),
    
    CANIS_LUPUS_FAMILIARIS("canis lupus familiaris"),
    
    CRICETINAE("cricetinae");

    private String value;

    PetTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static PetTypeEnum fromValue(String text) {
      for (PetTypeEnum b : PetTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonTypeId
  private PetTypeEnum petType = null;

  @JsonProperty("weight")
  private Integer weight = null;

  public Pet age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Age of pet in years
   * @return age
  **/
  @ApiModelProperty(value = "Age of pet in years")

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Pet id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Pet's unique ID
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Pet's unique ID")
  @NotNull

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Pet name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of this pet
   * @return name
  **/
  @ApiModelProperty(value = "Name of this pet")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Pet petType(PetTypeEnum petType) {
    this.petType = petType;
    return this;
  }

  /**
   * Get petType
   * @return petType
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public PetTypeEnum getPetType() {
    return petType;
  }

  public void setPetType(PetTypeEnum petType) {
    this.petType = petType;
  }

  public Pet weight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Weight of this pet in grams
   * @return weight
  **/
  @ApiModelProperty(value = "Weight of this pet in grams")

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet pet = (Pet) o;
    return Objects.equals(this.age, pet.age) &&
        Objects.equals(this.id, pet.id) &&
        Objects.equals(this.name, pet.name) &&
        Objects.equals(this.petType, pet.petType) &&
        Objects.equals(this.weight, pet.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(age, id, name, petType, weight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {\n");
    
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    petType: ").append(toIndentedString(petType)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
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
