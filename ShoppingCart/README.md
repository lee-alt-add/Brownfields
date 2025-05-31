
---

### **Project: In-Memory Shopping Cart**

**Overview:**
This legacy implementation of a shopping cart stores items in memory using simple maps and lists. It lacks structure, uses poor encapsulation, and combines pricing logic, item management, and cart output in a single class.

---

**Key Issues to Refactor:**

* No `Product` or `CartItem` classes—just raw `Map` and `List`.
* All logic lives in one class.
* No separation of business logic and display logic.
* Hardcoded tax calculation.
* Difficult to extend or test.

---

**Legacy Code Sample:**

```java
import java.util.*;

public class ShoppingCart {

    private List items = new ArrayList();

    public void addItem(String name, double price, int quantity) {
        Map item = new HashMap();
        item.put("name", name);
        item.put("price", price);
        item.put("quantity", quantity);
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < items.size(); i++) {
            Map item = (Map) items.get(i);
            total += (Double) item.get("price") * (Integer) item.get("quantity");
        }
        return total * 1.07; // tax included
    }

    public void printReceipt() {
        for (Object o : items) {
            Map item = (Map) o;
            System.out.println(item.get("quantity") + " x " + item.get("name") + " @ " + item.get("price"));
        }
        System.out.println("Total (with tax): $" + getTotal());
    }
}
```

---

**Your Refactoring Goals:**

1. Create `Product` and `CartItem` classes.
2. Encapsulate pricing and quantity logic.
3. Extract tax logic into a separate strategy or service.
4. Split responsibilities into at least three classes: cart, item, receipt/printer.
5. Make it extensible and testable.

---