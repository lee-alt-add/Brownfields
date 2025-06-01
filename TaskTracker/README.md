
---

### **Project: File-Based Task Tracker**

**Overview:**
This legacy console-based application keeps track of tasks by reading and writing to a plain text file. It was built with minimal structure, hardcoded file paths, and minimal error handling.

---

**Key Issues to Refactor:**

* Hardcoded file paths and magic strings.
* No separation of concerns (file I/O and task logic mixed together).
* No use of exceptions for error reporting.
* String parsing and formatting done manually.
* No unit testability.

---

**Legacy Code Sample:**

```java
import java.io.*;
import java.util.*;

public class TaskTracker {

    private static final String FILE = "tasks.txt";

    public void addTask(String task) throws IOException {
        FileWriter fw = new FileWriter(FILE, true);
        fw.write(task + "\n");
        fw.close();
    }

    public void listTasks() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("- " + line);
        }
        br.close();
    }

    public void removeTask(String taskToRemove) throws IOException {
        List<String> tasks = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.equals(taskToRemove)) {
                tasks.add(line);
            }
        }
        br.close();
        FileWriter fw = new FileWriter(FILE);
        for (String task : tasks) {
            fw.write(task + "\n");
        }
        fw.close();
    }
}
```

---

**Your Refactoring Goals:**

1. Introduce a `Task` class to encapsulate task data.
2. Extract file I/O into a repository or DAO class.
3. Use dependency injection for the file path.
4. Add proper error handling.
5. Make the system testable and modular.

---

