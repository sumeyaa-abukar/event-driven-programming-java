Bug Fix Documentation

Bug 1: Blocking the EDT

- Symptom: The user interface freezes when a button is clicked.
- Cause: A long-running operation was executed on the Event Dispatch Thread (EDT).
- Fix: Moved the long-running operation to a background thread so the GUI remains responsive.
-Code Change: Used a separate thread to perform the lengthy task and ensured GUI updates happen on the EDT.

 Bug 2: Missing Listener

-Symptom: Clicking the button does nothing.
Cause: No ActionListener was registered to handle the button click.
-Fix: Added an ActionListener to the button.
- Code Change:Registered an ActionListener using `addActionListener()` to respond to button clicks.

 Bug 3: Wrong Thread

- Symptom: Erratic GUI behaviour and possible thread-related errors.
- Cause: GUI components were updated directly from a background thread.
- Fix:Used `SwingUtilities.invokeLater()` to perform GUI updates on the Event Dispatch Thread.
- Code Change: Wrapped GUI update operations inside `SwingUtilities.invokeLater()`.

 Bug 4: Memory Leak

- Symptom: Memory usage can grow when buttons are repeatedly added and removed.
- Cause: References to removed buttons remained in the `createdButtons` list.
- Fix: Cleared the list when removing all buttons.
- Code Change:Added `createdButtons.clear()` to the Remove All operation after removing the buttons from the UI.

Conclusion

The four bugs demonstrate common problems in Java Swing event-driven programming. Fixing them improves GUI responsiveness, event handling, thread safety and memory management.