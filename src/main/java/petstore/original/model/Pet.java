package petstore.original.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.swagger.v3.oas.annotations.media.DiscriminatorMapping;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
@Schema(
    discriminatorMapping = {
        @DiscriminatorMapping(value=LatinNames.CAT, schema=Pet¤Cat.class),
        @DiscriminatorMapping(value=LatinNames.DOG, schema=Pet¤Dog.class),
        @DiscriminatorMapping(value=LatinNames.HAMSTER, schema=Pet¤Hamster.class),
    }
)
@JsonTypeInfo(use = Id.NAME, include = As.EXISTING_PROPERTY, property = "petType")
@JsonPropertyOrder(alphabetic = true)
@JsonSubTypes({
    @Type(name = LatinNames.CAT, value = Pet¤Cat.class),
    @Type(name = LatinNames.DOG, value = Pet¤Dog.class),
    @Type(name = LatinNames.HAMSTER, value = Pet¤Hamster.class)
})
abstract public class Pet {

  @Schema(description = "Age of pet in years")
  private int age;

  @Schema(description = "Pet's unique ID", required = true)
  private int id;

  @Schema(description = "Name of this pet")
  private String name;

  @Schema(description = "Weight of this pet in grams")
  private int weight;


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


  public int getAge() {
    return age;
  }


  public int getId() {
    return id;
  }


  public String getName() {
    return name;
  }


  @Schema(
      required = true,
      allowableValues = {
        LatinNames.CAT,
        LatinNames.DOG,
        LatinNames.HAMSTER
      }
  )
  abstract public PetType getPetType();


  public int getWeight() {
    return weight;
  }


  @Override
  public int hashCode() {
    return Objects.hash(age, id, name, weight);
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
}
