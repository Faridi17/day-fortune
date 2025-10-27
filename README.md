# ☀️ Day Fortune

**Day Fortune** is a simple **Java Socket + Swing GUI** application that predicts your daily fortune.
It demonstrates basic **client–server communication** using sockets in Java.

The project consists of two parts:

* **Seer (Server):** Generates and sends a random fortune message.
* **Customer (Client):** Displays the received message through a user-friendly Swing interface.

When you click **“Ramal Nasibku” (Predict My Fortune)**, the client connects to the server, retrieves a random fortune, and shows it on the GUI.

---

## ⚙️ How to Run

### 1️⃣ Clone the Repository

Clone this project to your local machine:

```bash
git clone https://github.com/yourusername/day-fortune.git
cd day-fortune
```

### 2️⃣ Run the Server

Open `Seer.java` in your code editor (e.g., IntelliJ IDEA, VS Code, or Eclipse).
Run the file — it will start the server and display:

```
Server berjalan di port 49750...
```

### 3️⃣ Run the Client

Next, open and run `Customer.java` in the same code editor.
A window titled **Day Fortune** will appear.

Click the **“Ramal Nasibku”** button — the client will connect to the server and display your random fortune.

---

## 🧠 Notes

* Make sure the server is running before starting the client.
* Both can run on the same machine using **localhost**.
* To use across different devices on a local network, change this line in `Customer.java`:

  ```java
  new Socket("localhost", 49750);
  ```

  to your server’s IP address, for example:

  ```java
  new Socket("192.168.1.10", 49750);
  ```
