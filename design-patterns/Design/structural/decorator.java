# Decorator Pattern in Java (Pizza Example – Single File)

Below is a **complete working example in one Java file** that demonstrates the **Decorator Pattern** using a pizza and toppings analogy.

---

## Idea Recap
- **Pizza** → base interface  
- **PlainPizza** → concrete implementation  
- **ToppingDecorator** → abstract decorator  
- **Cheese / Olives** → concrete decorators  
- Each topping **wraps** a Pizza object and adds extra behavior.

---

## Java Code (Single File)

```java
// DecoratorPatternPizza.java

interface Pizza {
    String getDescription();
    int getCost();
}

// Concrete Component
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public int getCost() {
        return 100;
    }
}

// Abstract Decorator
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete Decorator - Cheese
class Cheese extends ToppingDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 20;
    }
}

// Concrete Decorator - Olives
class Olives extends ToppingDecorator {

    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 15;
    }
}

// Client
public class DecoratorPatternPizza {
    public static void main(String[] args) {

        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);

        System.out.println(pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());
    }
}
