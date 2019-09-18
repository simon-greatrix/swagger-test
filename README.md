# Problems using Swagger

This GIT repository holds a set of demonstrations which were encountered trying to use Swagger's tools.

Each demonstration is marked with its own GIT tag.

## First problem

**Tag** : P1

### Scenario
We have a simple data model expressed mainly using Jackson annotations. We simply want to generate the OpenAPI specification from the code
 using the gradle plug-in.
 
Allegedly all we have to do is run
 
`gradlew resolve` 
 
### Expected Result
We expected the build to succeed and a correct OpenAPI specification to be generated.
 
### Actual Result
Swagger plug in crashes with no error message, and the build fails.
 
  
### Analysis
The bug is triggered by the presence of a required field on the "Pet" class. It can be worked around by making the type property explicit and using Jackson's
 EXISTING_PROPERTY type info instead of PROPERTY.
 
## Second Problem

**Tag**: P2

### Scenario

We've worked around the crashing gradle plugin. An OpenAPI specification can now be generated via Gradle. We can then use Swagger's code-gen tool to generate
 some simple HTML documentation as a quick test.

### Expected Result
We expected the OpenAPI specification to be usable. We expected code-gen not to crash.

### Actual Result
The required "info" section was not picked up by the plugin. It was present as a package annotation. When the generated file was used with code-gen

`java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate -i ../../swagger-test/swagger/pet-shop.json  -l html -o /tmp/swagger`

The output was:

`Exception in thread "Thread-0" java.lang.NullPointerException
 	at io.swagger.codegen.v3.generators.html.StaticHtmlCodegen.preprocessOpenAPI(StaticHtmlCodegen.java:180)
 	at io.swagger.codegen.v3.DefaultGenerator.configureGeneratorProperties(DefaultGenerator.java:216)
 	at io.swagger.codegen.v3.DefaultGenerator.generate(DefaultGenerator.java:779)
 	at io.swagger.codegen.v3.cli.cmd.Generate.run(Generate.java:351)
 	at java.base/java.lang.Thread.run(Thread.java:835)`
 	
This error message was not particularly helpful in diagnosing the problem.
 
### Analysis
This bug can be worked around by associating the @OpenAPIDefinition annotation with a class, rather than a package.  

