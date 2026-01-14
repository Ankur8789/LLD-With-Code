# SOLID Design Principles – Low Level Design (LLD)

This document covers **only the SOLID principles**, which are the most important **object-oriented design principles** for Low Level Design (LLD). These principles help in building **scalable, maintainable, testable, and extensible systems** and are frequently asked in **LLD interviews**.

---

## 🔹 What is SOLID?

SOLID is an acronym representing five design principles:

* **S** – Single Responsibility Principle
* **O** – Open/Closed Principle
* **L** – Liskov Substitution Principle
* **I** – Interface Segregation Principle
* **D** – Dependency Inversion Principle

---

## 1️⃣ Single Responsibility Principle (SRP)

> **A class should have only one reason to change.**

### ❌ Bad Design

```java
class Invoice {
    void calculateTotal() {}
    void printInvoice() {}
    void saveToDB() {}
}
```

❌ Multiple responsibilities:

* Business logic
* Presentation
* Persistence

### ✅ Good Design

```java
class InvoiceCalculator {
    void calculateTotal() {}
}

class InvoicePrinter {
    void print() {}
}

class InvoiceRepository {
    void save() {}
}
```

### ✅ Why SRP?

* Easier to maintain
* Easier to test
* Reduced side effects

---

## 2️⃣ Open/Closed Principle (OCP)

> **Software entities should be open for extension but closed for modification.**

### ❌ Bad Design

```java
if (type.equals("CAR")) {}
else if (type.equals("BIKE")) {}
```

### ✅ Good Design

```java
interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    public void drive() {}
}

class Bike implements Vehicle {
    public void drive() {}
}
```

### ✅ Why OCP?

* Add new behavior without modifying existing code
* Prevents regression bugs

---

## 3️⃣ Liskov Substitution Principle (LSP)

> **Objects of a superclass should be replaceable with objects of its subclasses without breaking correctness.**

### ❌ Bad Design

```java
class Bird {
    void fly() {}
}

class Ostrich extends Bird {
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

❌ Child breaks parent behavior

### ✅ Good Design

```java
interface Bird {}

interface FlyingBird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void fly() {}
}

class Ostrich implements Bird {}
```

### ✅ Key Rule

If a subclass cannot fully support the parent behavior, inheritance is wrong.

---

## 4️⃣ Interface Segregation Principle (ISP)

> **Clients should not be forced to depend on interfaces they do not use.**

### ❌ Bad Design

```java
interface Machine {
    void print();
    void scan();
    void fax();
}
```

### ✅ Good Design

```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}
```

### ✅ Why ISP?

* Smaller, cleaner interfaces
* No unnecessary method implementations

---

## 5️⃣ Dependency Inversion Principle (DIP)

> **High-level modules should not depend on low-level modules. Both should depend on abstractions.**

### ❌ Bad Design

```java
class Car {
    private PetrolEngine engine = new PetrolEngine();
}
```

### ✅ Good Design (Constructor-Based DI)

```java
interface Engine {
    void start();
}

class PetrolEngine implements Engine {
    public void start() {}
}

class Car {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

### ✅ Why DIP?

* Loose coupling
* Easy testing and mocking
* Flexible implementations

---

## 🎯 SOLID – Interview Summary

| Principle | Core Idea                    |
| --------- | ---------------------------- |
| SRP       | One reason to change         |
| OCP       | Extend, don’t modify         |
| LSP       | Child replaces parent safely |
| ISP       | Small, focused interfaces    |
| DIP       | Depend on abstractions       |

---

## ⭐ Final Takeaway

> **SOLID principles form the backbone of Low Level Design and help build systems that are clean, extensible, and maintainable.**
