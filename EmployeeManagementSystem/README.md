
---

### **Project: Employee Management System (Legacy Edition)**

**Overview:**
A small Java application for managing employee records in a company. The code was written in an older Java style (Java 5–6 era), lacks proper encapsulation, uses raw types, and is tightly coupled.

---

**Key Issues to Refactor:**

* Use of raw `List` and `Map` types.
* No use of interfaces or dependency injection.
* Long methods with multiple responsibilities.
* Manual string parsing instead of using proper date or object handling.
* Repetitive boilerplate code for data access.

---

**Legacy Code Sample:**

```java
import java.util.*;

public class EmployeeManager {

    private List employees = new ArrayList();

    public void addEmployee(String name, int age, String dept) {
        Map emp = new HashMap();
        emp.put("name", name);
        emp.put("age", age);
        emp.put("dept", dept);
        employees.add(emp);
    }

    public void printAll() {
        for (int i = 0; i < employees.size(); i++) {
            Map emp = (Map) employees.get(i);
            System.out.println("Name: " + emp.get("name") + ", Age: " + emp.get("age") + ", Department: " + emp.get("dept"));
        }
    }

    public void removeByName(String name) {
        for (Iterator it = employees.iterator(); it.hasNext(); ) {
            Map emp = (Map) it.next();
            if (name.equals(emp.get("name"))) {
                it.remove();
            }
        }
    }
}
```

---

**Your Refactoring Goals:**

1. Replace raw types with generics.
2. Introduce a proper `Employee` class.
3. Separate concerns (e.g., data handling vs. printing).
4. Improve naming and encapsulation.
5. Make it testable.

---
