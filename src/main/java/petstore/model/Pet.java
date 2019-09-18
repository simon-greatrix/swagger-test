package petstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "petType")
@JsonPropertyOrder(alphabetic = true)
@JsonSubTypes({
    @Type(name = LatinNames.CAT, value = Pet¤Cat.class),
    @Type(name = LatinNames.DOG, value = Pet¤Dog.class),
    @Type(name = LatinNames.HAMSTER, value = Pet¤Cat.class)
})
abstract public class Pet {

  @Schema(description = "Age of pet in years")
  private int age;

  @Schema(description = "Pet's unique ID", required=true)
  private int id;

  @Schema(description = "Name of this pet")
  private String name;

  @Schema(description = "Weight of this pet in grams")
  private int weight;


  public int getAge() {
    return age;
  }


  public int getId() {
    return id;
  }


  public String getName() {
    return name;
  }


  // This property is set to be ignored, as Jackson adds it.
  @JsonIgnore
  abstract public PetType getPetType();


  public int getWeight() {
    return weight;
  }


  public void setAge(int age) {
    this.age = age;
  }


  public void setId(int id) {
    this.id = id;
  }


  public void setName(String name) {
    this.name = name;
  }


  public void setWeight(int weight) {
    this.weight = weight;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pet)) {
      return false;
    }
    Pet pet = (Pet) o;
    return age == pet.age &&
        id == pet.id &&
        weight == pet.weight &&
        Objects.equals(name, pet.name);
  }


  @Override
  public int hashCode() {
    return Objects.hash(age, id, name, weight);
  }
}
