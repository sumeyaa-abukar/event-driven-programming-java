# Limitations of java.util.Observer and java.util.Observable

## Limitation 1: Single Inheritance

**Explain: Why is it a problem that Observable is a CLASS, not an INTERFACE?**


`Observable` is a class, so a class that extends it cannot extend another class because Java supports only single inheritance for classes. This limits flexibility and makes it difficult to reuse other classes when implementing the Observer Pattern.

## Limitation 2: Cannot Change the Notification Order

**Explain: In what order are observers notified? Can you control this?**



Observers are notified in an unspecified order. This means we cannot predict which observer will receive an update first. The `Observable` API does not provide a built-in method to control the notification order.

## Limitation 3: setChanged() is Confusing

**Explain: Why must you call setChanged() before notifyObservers()?**



The `setChanged()` method marks the Observable object as changed. The `notifyObservers()` method only sends notifications when the object has been marked as changed. If we forget to call `setChanged()`, the observers will not receive updates, and no error is necessarily displayed.

## Limitation 4: Pull Model by Default

**Explain: How does the observer get the data? Is this efficient?**



The observer receives a reference to the Observable object and uses getter methods to retrieve the information it needs. This is called the pull model. It may be less efficient because the observer must make additional method calls to obtain the data instead of receiving the updated values directly.

## Limitation 5: Deprecated Since Java 9

**Explain: Why did Java deprecate these classes?**


Java deprecated `Observable` and `Observer` in Java 9 because their design has several limitations. These include single inheritance, unspecified notification order, the need to call `setChanged()` manually, limited extensibility, and insufficient thread-safety guarantees. Modern alternatives, such as custom observer interfaces, provide more flexibility and control.