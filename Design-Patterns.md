What is a Design pattern?

A design pattern in software development is a general, reusable solution to a commonly occurring problem within a given context in software design. It is not a finished design that can be transformed directly into code, but rather a template or guideline that can be adapted to solve specific design issues.

Key Characteristics:
* Proven Solutions: Design patterns are based on best practices and have been tested in real-world applications.
* Categories: They are typically categorized into three types:
  * Creational Patterns: Deal with object creation mechanisms (e.g., Singleton, Factory).
  * Structural Patterns: Focus on how objects and classes are composed to form larger structures (e.g., Adapter, Composite).
  * Behavioral Patterns: Concerned with the interaction and responsibility between objects (e.g., Observer, Strategy).
Using design patterns helps developers create more maintainable, flexible, and scalable software systems.


## Singleton Pattern
`This is a creational pattern that ensures a class has only one instance and provides a global point of access to it.`

Singleton Design Pattern

* The Singleton pattern restricts a class to a single instance, which is crucial for scenarios like user preferences in applications to avoid conflicts.
* It is implemented by using a private constructor to prevent external instantiation and a public method (often named `getInstance`) to control access to the instance.

Implementation Details

* A private class variable (e.g., `uniqueInstance`) holds the single instance, and the `getInstance` method checks if this variable is null before creating a new instance.
* This method ensures that if an instance already exists, it returns that instance, thus maintaining the Singleton property.
Advantages and Considerations

The Singleton pattern allows for lazy creation, meaning the instance is created only when needed, which can improve efficiency.
However, it may introduce issues in multi-threaded environments where multiple threads might attempt to access the Singleton instance simultaneously.
Overall, the Singleton pattern is useful in scenarios where a single point of control is necessary, such as managing application settings, logging, or coordinating access to shared resources.

For eg.

```
 public class Logger {
 
     private static Logger instance;
 
     private Logger() {}
 
     public static Logger getInstance() {
         if (instance == null) {
             instance = new Logger();
         }
         return instance;
     }
 
     public void log(String message) {
         System.out.println("LOG: " + message);
     }
 }
```

