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
