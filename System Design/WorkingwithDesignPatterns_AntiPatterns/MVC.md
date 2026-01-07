# MVC

Model View Controller

The MVC pattern divids the responsibilitys of a system that offers a user interface into those three parts.

 <img width="1735" height="796" alt="Image" src="https://github.com/user-attachments/assets/6efefe17-de2a-4d83-8e34-0c82ff1b4919" />
 <br>
<img width="1629" height="478" alt="Image" src="https://github.com/user-attachments/assets/0a5c37c7-deb5-4c47-81b5-a7cd82e8d523" />

Separation of Concerns

The MVC pattern emphasizes the separation of concerns, allowing the Model, View, and Controller to operate independently.
This separation makes the code cleaner, easier to maintain, and allows different teams to work on the front end and back end simultaneously.

# Liskov Substitution Principle (LSP)

* If B is a subtype of A, you should be able to use B anywhere you use A—and the program should still behave correctly.
* So a “child class” must not break expectations set by the “parent class” When someone reads your code and sees a type A, they assume certain behavior.If you pass an object of type B (a subclass), it must still honor those assumptions.
* If it changes the meaning, throws new errors in normal situations, or needs extra conditions like “only works if…”, it’s violating LSP.

### Simple example (classic)
Imagine:
* Bird has a method `fly()`
* You create **Penguin extends Bird**
* But penguins can’t fly.
<br>

If your program does:
```
void makeItFly(Bird b) { b.fly(); }
```
Passing a Penguin breaks the program’s expectation. So Penguin should not be a subtype of a “flying bird”.

### Better design:
* Bird (no fly method)
* FlyingBird extends Bird (has fly())
* Penguin extends Bird
* Sparrow extends FlyingBird

Now every FlyingBird truly can fly → substitution is safe

# Open/Closed Principle

Software entities (classes, modules, functions) should be open for extension but closed for modification.
So: when requirements change, you should be able to add new behavior by adding new code, not by editing old working code.

# Dependency Inversion Principle

High-level code (business logic) should not depend on low-level code (details). Both should depend on abstractions (interfaces).

And: abstractions shouldn’t depend on details; details depend on abstractions.

* High-level = “what to do” (rules, workflows, use-cases)
* Low-level = “how it’s done” (DB, HTTP clients, frameworks, SDKs)

DIP says: your “what to do” shouldn’t import/know concrete “how it’s done”.
It should talk to an interface, and the concrete stuff plugs in from outside.

<img width="863" height="325" alt="Image" src="https://github.com/user-attachments/assets/da21779d-139e-4217-8dbe-289790a6625d" />

The Dependency Inversion Principle is a means to:

* Change the referencing of concrete classes from being direct to indirect
* Generalize the behaviors of your concrete classes into abstract classes and interfaces
* Have client classes interact with your sysrem through a generalization rather than directly with concrete resources
* Put emphasis on high level dependency over low level concrete dependency

# Composing Objects Principle

- This principle states that classes should achieve code reuse through aggregation rather than inheritance.

The composite design pattern and decorator design pattern use this design principle. Both of these patterns compose concrete classes in order to build more complex objects at one time.


### Advantages
* Aggregation and delegation offer less coupling thant inheritance
* "Arms length" relationship enter image description here
* Provides your system with more flexibility
* Dynamically change the behaviod of objects at run time

### Disadvantages

- The biggest drawback of composition is that you must provide implementations for all behaviour, without the benefit of inheritance to share code. That means that you might have very similar implementation across classes.

Some good tips and questions to help you decide whether the best solution for your system is composition or inheritance include:

1. You need to examine the needs of your system in order to determine whihc design principle is appropriate
2. Do you have a set of related classes or unrelated classes?
3. What is a common behaviour between them?
4. Do you need specialized classes to handle specific cases or do you need a different implementation of the same behaviour?

# Interface Segregation Principle

- The interface segregation principle states that a class should not be forced to depend on methods it does not use. This means that any classes that implement an interface, should not have "dummy" implementation of any methods defined in the interface. Instead, you should split large interfaces into smaller generalizations.

Bad example:

<img width="1034" height="582" alt="Image" src="https://github.com/user-attachments/assets/95cedf9b-87ac-403b-a1e7-ca7e2d23e89c" />


Good exmaple:

<img width="970" height="585" alt="Image" src="https://github.com/user-attachments/assets/a0bd6ee2-e72b-432a-8ba3-877834f2b76c" />

* Sometimes it isn't always clear how to properly segregate your interface or to predict future changes in requirements that will need interfaces to be split up. Having a system with well-defined interfaces will help you to see these segregation points better.

* You should always strive to be as precise as possible when designing interfaces. Remember that they are descriptions of what parts of your system can do, and the better the description, the easier it will be to create, update and maintain your software.

# Principle of Least Knowledge

To manage complexity, one idea is that a class should be designed so that it does not need to know about and depend upon almost every other class in the system.

### Law of Demeter

The underlying idea of this law is that classes should know about and interact with as few other classes as possible. This means that any class should only communicate with it "immediate friends". These "friends" would be other classes that one class should only know about.

#### First Rule
- A method, M, in an object, O, can call on any other method within O itself.
#### Second Rule
- A method, M, can call the methods of any parameter P.
#### Third Rule
- A method, M, can call a method, N, of an object, I, if I is instantiated within M.
#### Fourth Rule
- Any method, M, in object O, can invoke methods of any type of object that is a direct component of O.

The **Law of Demeter** apperas to be a complicated and abstract concept, but all the rules come down to the principle that your should not allow a method to acces another method by "reaching through" an object. This means that a method should not invoke methods of any object that is not local.

### “Reach Through"

Returned objects must of the same type as:

* Those declared in the method parameter.
* Those declared and instantiated locally in the method.
* Those declared in instance variable of the class that encapsulates the method.

**According to this design principle, a method, M, of an object should only call other methods if they are** :
1.  Encapsulated within the same object.
2.  Encapsualted within an object that is in the parameters of M.
3.  Encapsulated within an object that is instantiated inside the M.
4.  Encapsulated within an object that is referenced in an instance variable of the class for M.

# Code Smells

## Refactoring 

- **Refactoring = improve internal code structure without changing external behavior**
- Do it in **small steps** + **test often**
- Best time to refactor: **while adding features**, not as a huge “end-of-project overhaul”

## Code Smells (Anti-patterns) mentioned

1) Comment smells
- **Too few comments** → hard to understand intent (for new devs or future you)
- **Too many / explanatory comments** → often “deodorant” for bad design and can go stale
- Good comments should focus on:
  - **API documentation**
  - **Why** a decision was made (rationale), not explaining confusing code

2) Duplicated code (DRY violation)
- Copy-paste reuse creates many places to update later
- When requirements change (new feature/bug fix), you risk missing one copy
- Goal: **one shared method/component** used everywhere

3) Long method
- Often means the method does **too much** or is overly complex
- No fixed line limit; context matters (UI setup can be long but still simple)
- Practical guideline: keep it readable and focused

4) Large class (God/Blob/Black Hole class)
- Class keeps accumulating responsibilities and grows fast
- Becomes hard to navigate and needs lots of comments
- Fix: make classes **cohesive** (clear purpose, one main responsibility)

5) Data class
- Class with mostly **fields + getters/setters** and little behavior
- Might be a weak abstraction
- Move behavior into the class when it logically belongs there (e.g., point transformations)

6) Data clumps
- Same group of values often passed together (e.g., `x, y, z`)
- Fix: introduce a **parameter object** (e.g., `Point3D`)
- Warning: don’t create a “dumb” object—give it useful behavior too

7) Long parameter list
- Hard to call correctly, often needs heavy comments, can leak internals
- Avoid “fixing” it with globals (worse)
- Fix: introduce **parameter objects** (common in graphics: stroke settings like color, width, opacity, etc.)

## Key takeaway
Refactor continuously using “code smells” as signals:
- reduce duplication
- keep methods/classes focused
- prefer meaningful objects over long parameter lists and repeated data
- keep comments for **why** and **public APIs**, not for explaining messy logic

## Code Smells When Changing Code (Quick Notes)

1) Divergent Change
- **Symptom:** You keep changing the *same class* in **many different ways** for **many different reasons**
- **Cause:** Poor **separation of concerns** (often a **God/Large class**)
- **Fix idea:** Split responsibilities into separate classes; original class **delegates**
- **Benefit:** Fixes **Large Class + Divergent Change** together

2) Shotgun Surgery
- **Symptom:** One small change forces edits in **many classes/files**
- **Risk:** You miss a spot → bugs/inconsistency
- **Sometimes unavoidable:** e.g., updating copyright/license across files
- **Fix idea:** Re-organize/move related methods so changes become **more localized**
- **Warning:** Don’t “fix” by dumping everything into one class (that creates **Large Class** again)

3) Feature Envy
- **Symptom:** A method is more interested in another class’s data/behavior than its own
- **Fix idea:** Move the method to the class it “envies” (where it naturally belongs)

4) Inappropriate Intimacy
- **Symptom:** Two classes are too tightly coupled (lots of back-and-forth calls / shared internals)
- **Fix ideas:**
  - Extract shared behavior into a **third class**
  - Make communication **one-way** if possible
- **Note:** Cycles aren’t always bad (some patterns have them), but remove if it simplifies design

 5) Message Chains (Law of Demeter risk)
- **Symptom:** Long call chains like `a.getB().getC().doSomething()`
- **Problems:** brittle design, harder testing, rigid navigation through dependencies
- **Fix idea:** Reduce chaining by adding methods that hide navigation (follow **Law of Demeter**)
- **Note:** Not every chain is bad—depends on whether it violates Demeter

6) Primitive Obsession
- **Symptom:** Overusing primitives/strings for domain concepts at high levels
- **Example:** Storing a Postal Code as a plain string everywhere
- **Fix idea:** Create domain types (e.g., `PostalCode`) with validation/behavior
- **Benefit:** Makes key concepts obvious in design (UML/classes) and safer to use

 7) Switch Statements (Type checks)
- **Symptom:** Big switch/if-else branching on type codes (e.g., animal type → “woof/meow”)
- **Fix idea:** Replace with **polymorphism** (subclasses implement behavior)

8) Speculative Generality
- **Symptom:** Adding interfaces/superclasses/extension points “for someday”
- **Problem:** Over-engineering + unused complexity
- **Fix idea:** **Just-in-time design** (Agile): build only for current iteration needs
- **Rule:** Generalize **when you actually need it**

9) Refused Bequest (Refused Request)
- **Symptom:** A subclass inherits methods/fields it doesn’t need or use
- **Fix ideas:**
  - Redesign inheritance (maybe it shouldn’t be a subclass)
  - Move behavior out of superclass, or only define it in subclasses that need it

---

## Key takeaway
Review code frequently for these smells and refactor to keep code **flexible, reusable, and maintainable**.
Recommended reference: Martin Fowler — *Refactoring: Improving the Design of Existing Code*.
