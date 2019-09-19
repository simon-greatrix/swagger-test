package petstore.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petstore.model.Pet;

/**
 * @author Simon Greatrix on 18/09/2019.
 */
@OpenAPIDefinition(
    info = @Info(
        title="Pet Store Demo", version = "1.0"
    )
)

@RestController
@RequestMapping(path = "/addPet")
@Path("/addPet")
public class AddPet {

  @POST
  @Produces(MediaType.APPLICATION_JSON_UTF8_VALUE)
  @Consumes(MediaType.APPLICATION_JSON_UTF8_VALUE)
  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String loadPet(@RequestBody Pet pet) {
    return "Loaded pet of type: " + pet.getClass();
  }
}
