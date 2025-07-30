# 🐦 Flappy Bird – Java Swing Edition

A fun and lightweight recreation of the classic Flappy Bird game built using **Java Swing**. This project demonstrates the use of graphics, event handling, and game loops in Java.

---

## 🎮 Features

* **Smooth game loop** using `javax.swing.Timer`
* **Bird character** that responds to keyboard input (SPACE to jump)
* **Randomly placed pipe pairs** as obstacles
* **Scrolling environment** with realistic gravity and movement
* **Simple collision logic** (expandable)
* Object-oriented structure with custom `Bird` and `Pipe` classes



## 🛠 Technologies Used

* Java (JDK 8 or higher)
* Java Swing for UI rendering
* AWT for basic graphics and image loading
* OOP principles (encapsulation, modular design)

---

## 🚀 Getting Started

### Prerequisites

* Java JDK 8 or higher
* IDE like IntelliJ / VS Code / Eclipse

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/flappy-bird-java.git
   cd flappy-bird-java
   ```

2. **Make sure the assets are correctly placed**
   Place all your game images inside:

   ```
   /src/assets/
   ├── flappybird.png
   ├── flappybirdbg.png
   ├── toppipe.png
   └── bottompipe.png
   ```

3. **Run the game**

   * Open `App.java` (your main class) and run it.
   * Make sure your project root includes `/src` in the classpath.

---

## 🕹 Controls

| Key   | Action             |
| ----- | ------------------ |
| SPACE | Make the bird jump |

---

## 🧩 Game Logic Overview

* Pipes are added every 1.5 seconds with random vertical gaps.
* Bird is affected by gravity and can jump when spacebar is pressed.
* Game runs at \~60 FPS using a `javax.swing.Timer`.



## 🙌 Credits

* Original Flappy Bird concept by Dong Nguyen

