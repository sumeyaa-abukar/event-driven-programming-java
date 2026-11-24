# Step 8: Self-Check — Observer Pattern

## 1. What is the role of the Subject interface?

The Subject interface defines methods for registering observers, removing observers, and notifying observers when the subject's state changes. It allows the subject to communicate with observers without depending on their specific implementations.

## 2. What happens if you call `notifyObservers()` without registering any observers?

If no observers are registered, the observers list is empty, so no objects receive notifications. The program can continue running without notifying anyone.

## 3. What is the difference between `registerObserver()` and `removeObserver()`?

`registerObserver()` adds an observer to the list so that it can receive updates. `removeObserver()` removes an observer from the list so that it no longer receives updates.

## 4. Why is the observers list stored as an instance variable?

The observers list is stored as an instance variable so that each Subject object can maintain its own list of registered observers. This allows different subject objects to manage their observers independently.