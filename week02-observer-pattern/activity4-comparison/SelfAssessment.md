
# Activity 5: Final Self-Assessment

## Learning Outcome 1: Design and Implement the Observer Pattern

### 1. Draw the UML diagram of the Observer pattern.

```text
       <<interface>>
          Subject
   + addObserver()
   + removeObserver()
   + notifyObservers()
             |
             ^
             |
      ConcreteSubject
   + changeState()

             notifies
                |
                v
       <<interface>>
          Observer
       + update()
             ^
             |
      ConcreteObserver
       + update()
```

Relationship:
- ConcreteSubject implements Subject.
- ConcreteObserver implements Observer.
- ConcreteSubject keeps a list of observers and notifies them when its state changes.

### 2. Write the Java code for a Subject interface.

```java
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
```

### 3. Why does the Subject need a list of observers?

The Subject needs a list to keep track of all registered observers so it can notify them whenever its state changes.

## Learning Outcome 2: Evaluate Legacy java.util.Observer

### 4. List three problems with java.util.Observable.

1. Observable is a class, so a class extending it cannot extend another class.
2. Its notification mechanism provides limited control over what data is sent to observers.
3. Its design is outdated and less flexible than modern alternatives.

### 5. Why was this API deprecated?

It was deprecated in Java 9 because its design was limited and did not provide a sufficiently flexible event notification mechanism.

### 6. What is the pull model and why is it harder to use?

In the pull model, an observer receives a notification and then asks the Subject for the updated information. It can be harder because the observer must make extra calls to retrieve the data it needs.

## Learning Outcome 3: Create a Custom Event Notification System

### 7. What methods must a custom Subject interface provide?

It should provide:
- addObserver() to register an observer.
- removeObserver() to unregister an observer.
- notifyObservers() to notify registered observers.

### 8. How does the Subject notify all observers?

The Subject loops through its list of observers and calls the update() method on each observer.

### 9. How do you prevent a memory leak when observers are no longer needed?

Remove observers when they are no longer needed by calling removeObserver(). This prevents the Subject from unnecessarily retaining references to them.

## Learning Outcome 4: Compare Different Mechanisms

### 10. Name four event notification mechanisms in Java.

1. Custom Observer pattern.
2. java.util.Observer and Observable.
3. PropertyChangeListener.
4. JavaFX properties and bindings.

### 11. Which one is best for JavaFX?

JavaFX properties and bindings are best for JavaFX applications because they support observable values and automatic UI updates.

### 12. Which one is deprecated?

java.util.Observer and java.util.Observable were deprecated in Java 9.
