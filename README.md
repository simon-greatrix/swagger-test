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
 
  
  