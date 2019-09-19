package petstore.original.model;

import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.Test;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
public class PetTest {

  /**
   * Simple test that the JSON encoding is reversible and correct.
   *
   * @throws IOException
   */
  @Test
  public void testJsonEncoding() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    petstore.original.model.Pet¤Cat cat = new Pet¤Cat();
    cat.setId(500);
    cat.setFavouriteFood("Fish");
    cat.setAge(2);
    cat.setName("K!ll3r");
    cat.setWeight(3000);

    String catJson = objectMapper.writeValueAsString(cat);

    Pet pet = objectMapper.readerFor(Pet.class).readValue(catJson);
    assertEquals(cat, pet);
  }


  /**
   * JSON created by the server must be accepted by the generated code.
   * @throws IOException
   */
  @Test
  public void jsonProducedByServerMustBeAcceptedByClient() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Pet¤Cat cat = new Pet¤Cat();
    cat.setId(500);
    cat.setFavouriteFood("Fish");
    cat.setAge(2);
    cat.setName("K!ll3r");
    cat.setWeight(3000);

    String catJson = objectMapper.writeValueAsString(cat);

    petstore.gen.model.Pet genPet = objectMapper.readerFor(petstore.gen.model.Pet.class).readValue(catJson);
    String catJson2 = objectMapper.writeValueAsString(genPet);

    Pet pet = objectMapper.readerFor(Pet.class).readValue(catJson2);
    assertEquals(cat, pet);

  }
}