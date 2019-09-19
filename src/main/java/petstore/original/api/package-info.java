/**
 * @author Simon Greatrix on 18/09/2019.
 */

// This annotation is ignored. What is the point of having this as a package level annotation if it is ignored?

@OpenAPIDefinition(
    info = @Info(
      title="Pet Store Demo", version = "1.0"
    )
)
package petstore.original.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;