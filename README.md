# Problems using Swagger

This GIT repository holds a set of demonstrations which were encountered trying to use Swagger's tools.

Each demonstration is marked with its own GIT tag.

## First problem : Plugin crashes

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
 
## Second Problem : Code-gen crashes

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

```
Exception in thread "Thread-0" java.lang.NullPointerException
 	at io.swagger.codegen.v3.generators.html.StaticHtmlCodegen.preprocessOpenAPI(StaticHtmlCodegen.java:180)
 	at io.swagger.codegen.v3.DefaultGenerator.configureGeneratorProperties(DefaultGenerator.java:216)
 	at io.swagger.codegen.v3.DefaultGenerator.generate(DefaultGenerator.java:779)
 	at io.swagger.codegen.v3.cli.cmd.Generate.run(Generate.java:351)
 	at java.base/java.lang.Thread.run(Thread.java:835)
```
 	
This error message was not particularly helpful in diagnosing the problem.
 
### Analysis
This bug can be worked around by associating the @OpenAPIDefinition annotation with a class, rather than a package. 


## Third Problem : Pet type is incorrectly defined

**Tag**: P3

### Scenario

By experimentation we've discovered that although the @OpenAPIDefinition can be applied to packages, it doesn't work if you do that, so we applied it to a
 class. We try generating the simple HTML documentation again. We got documentation but the way the "petType" field was described was clearly wrong.
 
* The field is a discriminator, but was flagged as optional. The OpenAPI specification says discriminators must be required fields.
* The values of the discriminator had not been picked up. We added an explicit discriminator mapping, and a explicit set of allowed values.

We generated the HTML again expecting the issue to be resolved.

### Expected Result

We expected the discriminator mapping to be correct now it was explicitly specified through Swagger annotations.

### Actual Result

The explicit list of allowed values was added to the list of incorrect values, rather than over-riding it.

The sub-classes must have the correct value for the discriminator, but are defined as having any value.

### Analysis

There does not appear to be any way to fix this. Swagger is ignoring its own annotations and adding incorrect values to the enumeration. We resolve to hand
-edit the file after each re-generation.



## Fourth Problem : Generated client code does not compile

**Tag**: P4

### Scenario

Having hand-edited the OpenAPI definition, we attempt to generate code from it.

```
java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i ../../swagger-test/swagger/pet-shop.json \
    -o ~/tmp/swagger \
    --api-package petstore.gen.api \
    --model-package petstore.gen.model \
    --invoker-package petstore.gen \
    -l java
```

### Expected Result

We expected the generated code to compile.

### Actual Result

The code failed to compile:

```
~/tmp/swagger/src/main/java/petstore/gen/model/Pet.java:17: error: package com.fasterxml.jackson.annotation does not exist
 import com.fasterxml.jackson.annotation.JsonTypeId;
                                        ^
 ~/tmp/swagger/src/main/java/petstore/gen/JSON.java:74: error: cannot find symbol
                       discriminatorValueByClass.put(Pet¤Cat.class, "felis catus");
                                                     ^
   symbol: class Pet¤Cat
 ~/tmp/swagger/src/main/java/petstore/gen/JSON.java:75: error: cannot find symbol
                       discriminatorValueByClass.put(Pet¤Dog.class, "canis lupus familiaris");
                                                     ^
   symbol: class Pet¤Dog
 ~/tmp/swagger/src/main/java/petstore/gen/JSON.java:76: error: cannot find symbol
                       discriminatorValueByClass.put(Pet¤Hamster.class, "cricetinae");
                                                     ^
   symbol: class Pet¤Hamster
 ~/tmp/swagger/src/main/java/petstore/gen/JSON.java:57: error: cannot find symbol
                     classByDiscriminatorValue.put("felis catus".toUpperCase(), Pet¤Cat.class);
                                                                                ^
   symbol: class Pet¤Cat
 ~/tmp/swagger/src/main/java/petstore/gen/JSON.java:58: error: cannot find symbol
                     classByDiscriminatorValue.put("canis lupus familiaris".toUpperCase(), Pet¤Dog.class);
                                                                                           ^
   symbol: class Pet¤Dog
 ~/tmp/swagger/src/main/java/petstore/gen/JSON.java:59: error: cannot find symbol
                     classByDiscriminatorValue.put("cricetinae".toUpperCase(), Pet¤Hamster.class);
                                                                               ^
   symbol: class Pet¤Hamster
 ~/tmp/swagger/src/main/java/petstore/gen/model/Pet.java:90: error: incompatible types: String cannot be converted to PetTypeEnum
     this.petType = this.getClass().getSimpleName();
                                                 ^
 8 errors
```

### Analysis

If we manually correct the generated specification, we can also manually correct the generated code. The code will compile if we correct the class names and
 fix the "incompatible type" error.
 


## Fifth Problem : After fixing compile problems, does the generated code imply the same specification?

**Tag**: P5

### Scenario

We fixed the compile problems and refactored the code to separate the original and generated code. We could then resolve both sets of code and compare the
 results.
 
### Expected results

The generated code would generate an equivalent OpenAPI specification.

### Actual result

The generated code produces an empty OpenAPI specification.


## Sixth Problem : Testing "Spring" generated code

### Scenario

We used the code generator to create the "spring" flavour code:

```
java -jar modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate \
    -i ../../swagger-test/swagger/pet-shop.json \
    -o ~/tmp/swagger \
    --api-package petstore.gen.api \
    --model-package petstore.gen.model \
    --invoker-package petstore.gen \
    -l spring
```

### Expected result

We expected the generated code to compile

### Actual result

The generated code failed to compile.

```
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] /Users/simongreatrix/tmp/swagger/src/main/java/petstore/gen/api/ApiResponseMessage.java:[3,33] package javax.xml.bind.annotation does not exist
[ERROR] /Users/simongreatrix/tmp/swagger/src/main/java/petstore/gen/api/ApiResponseMessage.java:[6,27] package javax.xml.bind.annotation does not exist
[ERROR] /Users/simongreatrix/tmp/swagger/src/main/java/petstore/gen/api/ApiResponseMessage.java:[45,6] cannot find symbol
  symbol:   class XmlTransient
  location: class petstore.gen.api.ApiResponseMessage
[INFO] 3 errors
```

The generated code uses annotations for a previous major release, not the version 3 annotations.

The generated code does not correctly use the discriminator property
```
@JsonSubTypes({
  @JsonSubTypes.Type(value = PetDog.class, name = "Pet¤Dog"),
  @JsonSubTypes.Type(value = PetHamster.class, name = "Pet¤Hamster"),
  @JsonSubTypes.Type(value = PetCat.class, name = "Pet¤Cat"),
})
``` 

### Analysis

The generated code can be fixed by hand. The name mappings can be corrected.


