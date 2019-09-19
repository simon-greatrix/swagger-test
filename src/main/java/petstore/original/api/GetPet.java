package petstore.original.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petstore.original.model.Pet;
import petstore.original.model.Pet¤Cat;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
@RestController
@RequestMapping(path = "/getPet")
@Path("/getPet")
public class GetPet {

  @GET
  @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
  @Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
  @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Pet getPet(@QueryParam("id") int id) {
    Pet¤Cat cat = new Pet¤Cat();
    cat.setId(500);
    cat.setFavouriteFood("Fish");
    cat.setAge(2);
    cat.setName("K!ll3r");
    cat.setWeight(3000);
    return cat;
  }
}
