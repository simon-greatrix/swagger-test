package petstore.model;

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
    Pet¤Cat cat = new Pet¤Cat();
    cat.setId(500);
    cat.setFavouriteFood("Fish");
    cat.setAge(2);
    cat.setName("K!ll3r");
    cat.setWeight(3000);

    String catJson = objectMapper.writeValueAsString(cat);

    Pet pet = objectMapper.readerFor(Pet.class).readValue(catJson);
    assertEquals(cat, pet);
  }
}