

System Name: Fitness Tracker

---

 Part 1: Event Sources

1.Add Steps Button - Generates an event when the user records additional steps.
2. Update Heart Rate Button - Generates an event when the user enters a heart rate.
3. Burn Calories Button - Generates an event when the user records calories burned.
4. Reset Button - Generates an event when the user resets the fitness statistics.
5. System Status Display - Displays updates when fitness events are processed.

---

Part 2: Events

| Event Name | Source | Description |
|---|---|---|
| StepsAdded | Add Steps Button | Triggered when the user records 100 additional steps. |
| HeartRateUpdated | Update Heart Rate Button | Triggered when the user updates their heart rate. |
| CaloriesBurned | Burn Calories Button | Triggered when the user records 50 calories burned. |
| StatisticsReset | Reset Button | Triggered when the user resets all fitness statistics. |
| StatusUpdated | System Status Display | Occurs when the application displays updated fitness information. |

---

 Part 3: Event Handlers

| Event | Handler Action |
|---|---|
| StepsAdded | Adds 100 steps to the total and updates the step count. |
| HeartRateUpdated | Updates and displays the user's heart rate. |
| CaloriesBurned | Adds 50 calories to the total and updates the calorie count. |
| StatisticsReset | Resets the step count, heart rate, and calories to zero. |
| StatusUpdated | Displays the latest activity information to the user. |

---

 Part 4: Event Flow Diagram

```text
User clicks a button
        |
        v
Button generates an event
        |
        v
ActionListener receives the event
        |
        v
Event handler processes the event
        |
        v
Fitness statistics are updated
        |
        v
GUI displays the new statistics
```

The application uses Java Swing event listeners to respond to user actions. The GUI is created using `SwingUtilities.invokeLater()` so that it runs on the Event Dispatch Thread (EDT).

---

Part 5: Potential Issues

1. Incorrect fitness data - Validate user input and allow statistics to be reset.
2. Invalid heart rate values - Accept only positive numeric values within a reasonable range.
3. Unresponsive interface - Avoid running long operations on the Event Dispatch Thread (EDT).
