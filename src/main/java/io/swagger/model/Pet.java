package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.constraints.*;
import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Pet   {
  private @Valid Integer age = null;
  private @Valid Integer id = null;
  private @Valid String name = null;
public enum PetTypeEnum {

    DOG(String.valueOf("DOG")), CAT(String.valueOf("CAT")), HAMSTER(String.valueOf("HAMSTER")), FELIS_CATUS(String.valueOf("felis catus")), CANIS_LUPUS_FAMILIARIS(String.valueOf("canis lupus familiaris")), CRICETINAE(String.valueOf("cricetinae"));


    private String value;

    PetTypeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static PetTypeEnum fromValue(String v) {
        for (PetTypeEnum b : PetTypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}
  private @Valid PetTypeEnum petType = null;
  private @Valid Integer weight = null;

  /**
   * Age of pet in years
   **/
  public Pet age(Integer age) {
    this.age = age;
    return this;
  }

  
  @ApiModelProperty(value = "Age of pet in years")
  @JsonProperty("age")

  public Integer getAge() {
    return age;
  }
  public void setAge(Integer age) {
    this.age = age;
  }

  /**
   * Pet&#x27;s unique ID
   **/
  public Pet id(Integer id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "Pet's unique ID")
  @JsonProperty("id")
  @NotNull

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * Name of this pet
   **/
  public Pet name(String name) {
    this.name = name;
    return this;
  }

  
  @ApiModelProperty(value = "Name of this pet")
  @JsonProperty("name")

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  /**
   **/
  public Pet petType(PetTypeEnum petType) {
    this.petType = petType;
    return this;
  }

  
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("petType")
  @NotNull

  public PetTypeEnum getPetType() {
    return petType;
  }
  public void setPetType(PetTypeEnum petType) {
    this.petType = petType;
  }

  /**
   * Weight of this pet in grams
   **/
  public Pet weight(Integer weight) {
    this.weight = weight;
    return this;
  }

  
  @ApiModelProperty(value = "Weight of this pet in grams")
  @JsonProperty("weight")

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
    return Objects.equals(age, pet.age) &&
        Objects.equals(id, pet.id) &&
        Objects.equals(name, pet.name) &&
        Objects.equals(petType, pet.petType) &&
        Objects.equals(weight, pet.weight);
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
