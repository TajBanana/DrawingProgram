# READ ME

To run the program:
1. Build the program by running  `mvn clean install` on your terminal
2. Run the program by `mvn spring-boot:run`
3. To check code for coverage run `mvn test` followed by `mvn jacoco:report`.
   Look for the jacoco report file under `target/site/jacoco/index.html` 
   directory.

# Design
The program is written using Spring for better dependency management and 
testability. The dependencies are managed by spring thus improving 
testability of the code.


### Dependencies
The dependencies are listed from top to bottom 
- SpringApp > Program > InputProcessor > InputExcecutor > Command > Canvas

There are a list of helper/util classes that include:
1. validators
2. factories
3. mappers

Exceptions that are handled:
1. Empty Canvas
2. Invalid command params
3. Negative/Float numbers
4. Out of bounds
