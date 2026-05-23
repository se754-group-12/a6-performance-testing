package com.code67.quizfeedback;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuizStore {

    private final Map<String, Question> questions = new HashMap<>();

    @PostConstruct
    void seed() {
        add(new Question(
                "q1",
                "What OOP principle describes bundling data and the methods that operate on it inside a single unit?",
                "encapsulation",
                "encapsulation",
                "Encapsulation hides internal state behind methods so that callers interact through a controlled interface.",
                "Think about the principle that keeps fields private and exposes behaviour through methods."
        ));
        add(new Question(
                "q2",
                "Which Java keyword is used by a subclass to invoke a constructor of its parent class?",
                "super",
                "inheritance",
                "The 'super' keyword calls the parent class constructor and must be the first statement in the child constructor if used.",
                "It is a five-letter keyword that refers to the parent class."
        ));
        add(new Question(
                "q3",
                "What is the term for the ability of a single method name to behave differently based on the object that invokes it?",
                "polymorphism",
                "polymorphism",
                "Polymorphism lets subclasses provide their own implementation of a method declared in a parent class, so the same call site behaves differently at runtime.",
                "The word comes from Greek and means 'many forms'."
        ));
        add(new Question(
                "q4",
                "In Java, which keyword prevents a class from being extended?",
                "final",
                "inheritance",
                "Marking a class 'final' tells the compiler no other class can extend it. String is a well-known example.",
                "The same keyword is also used to make a variable a constant."
        ));
        add(new Question(
                "q5",
                "What do we call a class that cannot be instantiated and is intended to be extended by subclasses?",
                "abstract",
                "abstraction",
                "An abstract class can hold both implemented and unimplemented methods, and you cannot create instances of it directly.",
                "The keyword starts with 'a' and is the opposite of 'concrete'."
        ));
        add(new Question(
                "q6",
                "Which OOP relationship is described by the phrase 'a Car has-a Engine'?",
                "composition",
                "composition",
                "Composition models a 'has-a' relationship where one object is built from other objects, as opposed to 'is-a' which is inheritance.",
                "It is not inheritance. Think about how objects are assembled from other objects."
        ));
        add(new Question(
                "q7",
                "What is the name of the method that is automatically called when a new object is created in Java?",
                "constructor",
                "classes",
                "A constructor has the same name as the class, has no return type, and runs once when 'new' is used to create the object.",
                "It shares its name with the class and runs when you use 'new'."
        ));
        add(new Question(
                "q8",
                "Which access modifier makes a field visible only within the class that declares it?",
                "private",
                "encapsulation",
                "The 'private' modifier restricts access to the declaring class only, which is the default choice for fields supporting encapsulation.",
                "It is the most restrictive of the four access modifiers."
        ));
        add(new Question(
                "q9",
                "What construct in Java defines a contract of methods that implementing classes must provide?",
                "interface",
                "abstraction",
                "An interface declares method signatures without bodies (by default) and a class promises to provide those methods by using 'implements'.",
                "A class uses 'implements' rather than 'extends' to take it on."
        ));
        add(new Question(
                "q10",
                "What is it called when a subclass provides its own version of a method that is already defined in its parent class?",
                "overriding",
                "polymorphism",
                "Method overriding lets a subclass replace the parent's implementation while keeping the same signature, and is the runtime mechanism behind polymorphism.",
                "It is not 'overloading'. Think about replacing the parent's behaviour."
        ));
        add(new Question(
                "q11",
                "What do we call multiple methods in the same class that share a name but differ in parameters?",
                "overloading",
                "polymorphism",
                "Method overloading is resolved at compile time based on the argument types and counts, and is sometimes called compile-time polymorphism.",
                "It is not 'overriding'. Think about same name, different parameter lists."
        ));
        add(new Question(
                "q12",
                "Which class in Java is the implicit parent of every other class?",
                "object",
                "inheritance",
                "Every Java class extends java.lang.Object either directly or transitively, which is why methods like toString and equals are always available.",
                "Its name is also the general term for an instance of a class."
        ));

        // Generics
        add(new Question(
                "q13",
                "What Java language feature allows a class or method to operate on objects of various types while providing compile-time type safety?",
                "generics",
                "generics",
                "Generics let you parameterise types so that a single List<T> class works for any T, and the compiler catches type mismatches before the program runs.",
                "The feature was introduced in Java 5 and uses angle brackets such as <T>."
        ));
        add(new Question(
                "q14",
                "What Java mechanism removes generic type information at compile time, replacing type parameters with Object or their upper bound?",
                "type erasure",
                "generics",
                "Type erasure means generic type parameters exist only at compile time; at runtime a List<String> and a List<Integer> are both just List, which is why you cannot do instanceof checks on parameterised types.",
                "The word 'erasure' is a clue — the type information is wiped out before the bytecode is produced."
        ));
        add(new Question(
                "q15",
                "In Java generics, what is the construct <T extends Number> called, where T must be a subtype of Number?",
                "bounded type parameter",
                "generics",
                "A bounded type parameter restricts the types that can be substituted for T, allowing you to call methods defined on the bound (e.g., Number methods) inside the generic class or method.",
                "The word 'bounded' is in the name — think of it as putting a boundary on what T can be."
        ));
        add(new Question(
                "q16",
                "What symbol is used in Java generics to represent an unknown type, as in List<?>?",
                "wildcard",
                "generics",
                "The wildcard ? stands for an unknown type and is used when the exact type does not matter or is flexible, such as in utility methods that read from a collection of any type.",
                "The symbol itself looks like a question mark, which hints at its meaning of 'unknown'."
        ));
        add(new Question(
                "q17",
                "Which Java interface must a class implement to define its natural ordering so that instances can be sorted by Collections.sort()?",
                "comparable",
                "generics",
                "Implementing Comparable<T> requires overriding compareTo(T o), which Collections.sort() uses to determine the natural order of objects.",
                "Its name suggests the ability to be compared; it is in java.lang and is different from Comparator."
        ));

        // Interfaces vs Abstract Classes
        add(new Question(
                "q18",
                "Can a Java class implement more than one interface at the same time?",
                "yes",
                "interfaces vs abstract classes",
                "Java permits a class to implement multiple interfaces simultaneously, which is the primary way to achieve a form of multiple inheritance of type in Java.",
                "Java does not allow a class to extend more than one class, but the rule is different for interfaces."
        ));
        add(new Question(
                "q19",
                "In Java 8 and later, what keyword allows an interface to provide a method with a concrete implementation?",
                "default",
                "interfaces vs abstract classes",
                "Default methods let interface authors add new methods without breaking existing implementations, because the default body is used by any class that does not override it.",
                "The keyword is the same one used in a switch statement's catch-all case."
        ));
        add(new Question(
                "q20",
                "What is the term for an interface that declares exactly one abstract method, enabling the use of lambda expressions?",
                "functional interface",
                "interfaces vs abstract classes",
                "A functional interface has a single abstract method (SAM), and any lambda expression is syntactic sugar for an anonymous class implementing that one method. Runnable and Comparator are common examples.",
                "The annotation @FunctionalInterface marks it. Think about interfaces designed for use with lambdas."
        ));
        add(new Question(
                "q21",
                "Unlike interfaces, abstract classes can hold what kind of member that carries state specific to each object instance?",
                "instance variables",
                "interfaces vs abstract classes",
                "Abstract classes can declare instance variables (fields) that each subclass instance owns separately, whereas interface fields are implicitly public static final constants.",
                "Think about what holds per-object state in any class — it is not methods."
        ));
        add(new Question(
                "q22",
                "When you want to model a shared 'is-a' identity with common state and partial implementation, should you use an interface or an abstract class?",
                "abstract class",
                "interfaces vs abstract classes",
                "An abstract class is the right choice when related classes share code and state, because it supports instance variables and partial implementation. Interfaces model capabilities that unrelated classes can share.",
                "An interface says 'can do'; this construct says 'is a kind of'."
        ));
        add(new Question(
                "q23",
                "What Java keyword in an interface method signature indicates that the method must be implemented by the interface itself and cannot be overridden by implementing classes?",
                "static",
                "interfaces vs abstract classes",
                "Static interface methods belong to the interface itself, not to implementing classes. They are called on the interface name directly, like Collections.sort(), and are not inherited by implementors.",
                "The same keyword is used for class-level methods and fields."
        ));

        // Design Patterns
        add(new Question(
                "q24",
                "Which creational design pattern ensures that a class has only one instance and provides a global access point to it?",
                "singleton",
                "design patterns",
                "The Singleton pattern typically uses a private constructor and a static method (often getInstance()) that creates the instance on first call and returns the same object thereafter.",
                "Think about a pattern whose name implies one and only one — like a single copy."
        ));
        add(new Question(
                "q25",
                "Which creational design pattern defines an interface for creating an object but lets subclasses decide which concrete class to instantiate?",
                "factory method",
                "design patterns",
                "The Factory Method pattern delegates the creation decision to subclasses, so the calling code depends only on the abstract product interface rather than on concrete classes.",
                "It is a creational pattern whose name combines the concept of a manufacturing facility with a design-pattern term."
        ));
        add(new Question(
                "q26",
                "Which creational design pattern separates the step-by-step construction of a complex object from its final representation?",
                "builder",
                "design patterns",
                "The Builder pattern uses a separate Builder object with chained methods (e.g., setName().setAge().build()) so the same construction process can produce different representations.",
                "Think of this pattern as constructing something piece by piece before assembling the whole."
        ));
        add(new Question(
                "q27",
                "Which creational pattern provides an interface for creating families of related objects without specifying their concrete classes?",
                "abstract factory",
                "design patterns",
                "The Abstract Factory pattern groups a set of related factory methods, ensuring that products created together are compatible. A UI toolkit factory might produce buttons and checkboxes that all share the same look and feel.",
                "It is like the factory method pattern, but operates at the level of a whole product family rather than a single product."
        ));
        add(new Question(
                "q28",
                "Which behavioral design pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable at runtime?",
                "strategy",
                "design patterns",
                "The Strategy pattern extracts algorithms into separate classes that share a common interface, so the calling context can switch between them without changing its own code.",
                "Think of it as a game plan that you can swap out before or during play."
        ));
        add(new Question(
                "q29",
                "Which behavioral design pattern allows objects to subscribe to and be automatically notified of state changes in another object?",
                "observer",
                "design patterns",
                "The Observer pattern defines a one-to-many dependency so that when the subject changes state, all registered observers are notified automatically. Event listeners in Java are a common example.",
                "Think of subscribers to a newsletter — they watch for updates from a publisher."
        ));
        add(new Question(
                "q30",
                "Which behavioral design pattern encapsulates a request as a standalone object, allowing it to be queued, logged, or undone?",
                "command",
                "design patterns",
                "The Command pattern turns a request into an object containing all information about the request, decoupling the sender from the receiver and enabling features like undo/redo.",
                "Think about how a remote control button encapsulates the action it triggers."
        ));
        add(new Question(
                "q31",
                "Which behavioral design pattern defines the skeleton of an algorithm in a base class and lets subclasses override specific steps without changing the overall structure?",
                "template method",
                "design patterns",
                "The Template Method pattern puts invariant algorithm steps in a base class and marks the varying steps as abstract or hook methods that subclasses fill in.",
                "The word 'template' is a strong hint — a fixed structure with blank slots for subclasses to fill."
        ));
        add(new Question(
                "q32",
                "Which structural design pattern converts the interface of one class into an interface that a client expects?",
                "adapter",
                "design patterns",
                "The Adapter pattern wraps an existing class and translates calls to its interface into calls the client understands, like a power plug adapter that lets a device from one country work in another country's socket.",
                "Think of a physical adapter that bridges two incompatible formats."
        ));
        add(new Question(
                "q33",
                "Which structural design pattern attaches additional responsibilities to an object dynamically without subclassing?",
                "decorator",
                "design patterns",
                "The Decorator pattern wraps an object in one or more decorator objects that add behaviour before or after delegating to the wrapped object, enabling flexible combinations at runtime.",
                "Think of adding toppings to a coffee — each topping wraps the previous drink and adds something new."
        ));
        add(new Question(
                "q34",
                "Which structural design pattern provides a unified, simplified interface to a complex subsystem?",
                "facade",
                "design patterns",
                "The Facade pattern hides the complexity of a subsystem behind a single class with a simple interface, reducing the number of objects clients must interact with.",
                "The word comes from architecture — the front face of a building that presents a clean appearance regardless of what is behind it."
        ));
        add(new Question(
                "q35",
                "Which structural design pattern provides a surrogate object that controls access to another object?",
                "proxy",
                "design patterns",
                "A Proxy stands in for the real object and can add cross-cutting concerns such as lazy initialisation, access control, logging, or remote communication without the client knowing.",
                "Think of a stand-in or representative who acts on behalf of someone else."
        ));
        add(new Question(
                "q36",
                "In the Model-View-Controller architectural pattern, which component is responsible for receiving user input and updating the model?",
                "controller",
                "design patterns",
                "The Controller sits between the View and the Model: it interprets user actions from the View, calls the appropriate Model operations, and decides which View to render next.",
                "Think of the three roles — one stores data, one displays it, and one routes input. The last one is your answer."
        ));
        add(new Question(
                "q37",
                "Which design pattern is often criticised for introducing hidden global state and making unit testing difficult?",
                "singleton",
                "design patterns",
                "Because the Singleton pattern provides a single global instance, tests that depend on it can interfere with each other, and it becomes hard to substitute a mock or stub without modifying the class itself.",
                "It is the same creational pattern that restricts instantiation to one object."
        ));

        // Exception Handling
        add(new Question(
                "q38",
                "What is the root class of all exceptions and errors in Java's exception hierarchy?",
                "throwable",
                "exception handling",
                "Throwable is the superclass of both Exception (recoverable conditions) and Error (serious problems like OutOfMemoryError that programs usually should not catch).",
                "Its name is a hint — it is the thing you can 'throw'. It sits above both Exception and Error."
        ));
        add(new Question(
                "q39",
                "Which keyword is used to explicitly raise an exception in Java?",
                "throw",
                "exception handling",
                "The 'throw' keyword is followed by an instance of a Throwable subclass. It transfers control immediately to the nearest matching catch block up the call stack.",
                "It is a single word and not the same keyword used in the method signature to declare exceptions."
        ));
        add(new Question(
                "q40",
                "Which keyword in a method signature declares that the method may propagate a checked exception to its caller?",
                "throws",
                "exception handling",
                "The 'throws' clause lists the checked exceptions a method can propagate, forcing callers to either catch them or declare them in their own throws clause.",
                "It is the plural or declarative form of the keyword used to raise exceptions."
        ));
        add(new Question(
                "q41",
                "Which block of code in a try-catch construct is guaranteed to execute whether or not an exception is thrown?",
                "finally",
                "exception handling",
                "The finally block runs after the try (and any catch) block completes, even if an exception was thrown or a return statement was executed. It is commonly used to release resources.",
                "Think of it as the 'always runs' block — it comes after try and catch."
        ));
        add(new Question(
                "q42",
                "What is the parent class of all unchecked exceptions in Java, whose subclasses the compiler does not require you to catch or declare?",
                "RuntimeException",
                "exception handling",
                "RuntimeException and its subclasses (e.g., NullPointerException, IllegalArgumentException) represent programming errors. The compiler does not enforce handling them because they typically indicate bugs rather than recoverable conditions.",
                "Its name combines the time at which it occurs — during execution — with the word 'Exception'."
        ));
        add(new Question(
                "q43",
                "Which exception is thrown when a program attempts to dereference a null reference?",
                "NullPointerException",
                "exception handling",
                "NullPointerException (NPE) occurs when code calls a method or accesses a field on a variable that holds null. It is one of the most common runtime errors in Java.",
                "The exception name describes exactly what caused it: following a pointer (reference) that points to nothing (null)."
        ));
        add(new Question(
                "q44",
                "Which exception is thrown when Java code attempts to cast an object to an incompatible type at runtime?",
                "ClassCastException",
                "exception handling",
                "ClassCastException occurs when you use an explicit cast — e.g., (Dog) animal — but the object's actual runtime type is not compatible with the target type.",
                "The name of the exception describes the operation that fails: casting between classes."
        ));
        add(new Question(
                "q45",
                "What Java 7 feature automatically closes resources that implement AutoCloseable at the end of a try block, without a finally clause?",
                "try-with-resources",
                "exception handling",
                "Try-with-resources declares resources inside the try(...) parentheses; the JVM calls close() on each one in reverse order when the block exits, whether normally or through an exception.",
                "The feature's name describes what it does: a try block that manages resources for you."
        ));
        add(new Question(
                "q46",
                "What is the technique called when you catch an exception and re-throw it wrapped inside a new exception, preserving the original as the cause?",
                "exception chaining",
                "exception handling",
                "Exception chaining lets you translate low-level exceptions into higher-level ones without losing diagnostic information. The original exception is accessible via getCause() on the wrapping exception.",
                "Think of linking exceptions together like links in a chain, with the original at the end."
        ));
        add(new Question(
                "q47",
                "Which exception is thrown when an integer or long is divided by zero in Java?",
                "ArithmeticException",
                "exception handling",
                "ArithmeticException is an unchecked exception thrown for illegal arithmetic operations, the most common being integer division by zero. Note that floating-point division by zero produces Infinity, not an exception.",
                "The exception relates to a mathematical operation — its name is derived from the branch of mathematics it concerns."
        ));

        // SOLID Principles
        add(new Question(
                "q48",
                "Which SOLID principle states that a class should have only one reason to change?",
                "single responsibility principle",
                "solid principles",
                "The Single Responsibility Principle (SRP) says each class should encapsulate one concern. When a class has multiple responsibilities, a change to one responsibility risks breaking the other, increasing fragility.",
                "The word 'single' is in the principle's name. Think about minimising the reasons a class might need to be edited."
        ));
        add(new Question(
                "q49",
                "Which SOLID principle states that software entities should be open for extension but closed for modification?",
                "open/closed principle",
                "solid principles",
                "The Open/Closed Principle (OCP) means you should be able to add new behaviour by adding new code (extension) rather than by changing existing, tested code (modification), typically achieved through abstraction and polymorphism.",
                "Its name contains two opposite words: open and closed."
        ));
        add(new Question(
                "q50",
                "Which SOLID principle states that objects of a subclass should be substitutable for objects of the superclass without altering the correctness of the program?",
                "Liskov substitution principle",
                "solid principles",
                "The Liskov Substitution Principle (LSP) means subclasses must honour the contracts established by their parent class — they should not throw unexpected exceptions, weaken preconditions, or strengthen postconditions.",
                "It is named after Barbara Liskov, who formulated it. Think about whether a subclass truly 'is-a' its parent in all respects."
        ));
        add(new Question(
                "q51",
                "Which SOLID principle states that no client should be forced to depend on methods it does not use?",
                "interface segregation principle",
                "solid principles",
                "The Interface Segregation Principle (ISP) prefers many small, focused interfaces over one large general-purpose interface, so that implementing classes only need to be concerned with the methods relevant to them.",
                "The principle involves splitting or 'segregating' large interfaces into smaller ones."
        ));
        add(new Question(
                "q52",
                "Which SOLID principle states that high-level modules should not depend on low-level modules; both should depend on abstractions?",
                "dependency inversion principle",
                "solid principles",
                "The Dependency Inversion Principle (DIP) decouples high-level policy from low-level implementation details by making both depend on an abstraction (interface), enabling you to substitute implementations without touching higher-level code.",
                "The principle 'inverts' the typical dependency direction — higher-level code dictates the interface, and lower-level code conforms to it."
        ));

        // Cohesion, Coupling, and OOP Metrics
        add(new Question(
                "q53",
                "What OOP quality term describes the degree to which the elements inside a module belong together and focus on a single purpose?",
                "cohesion",
                "oop principles",
                "High cohesion means a class or module does one thing well and all its members contribute to that purpose. Low cohesion indicates a class is doing too many unrelated things and should be split.",
                "High is good for this quality. Its opposite is a class that does too many unrelated things."
        ));
        add(new Question(
                "q54",
                "What OOP quality term describes the degree of interdependence between software modules, where a lower value is generally preferred?",
                "coupling",
                "oop principles",
                "Low coupling means modules know little about each other's internals, making them easier to change independently. High coupling leads to fragile designs where changing one module forces changes in many others.",
                "Low is good for this quality. Think about how tightly two modules are 'bound' to each other."
        ));
    }

    private void add(Question question) {
        questions.put(question.getId(), question);
    }

    public Question findById(String id) {
        if (id == null) {
            return null;
        }
        return questions.get(id);
    }
}
