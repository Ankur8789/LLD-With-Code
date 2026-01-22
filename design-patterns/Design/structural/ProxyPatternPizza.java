// ProxyPatternPizza.java
// Single-file Java example of Proxy Pattern using Pizza analogy

interface PizzaService {
    void orderPizza(String pizzaType);
}

// Real Subject
class RealPizzaShop implements PizzaService {

    public RealPizzaShop() {
        System.out.println("Initializing real pizza shop...");
    }

    @Override
    public void orderPizza(String pizzaType) {
        System.out.println("Preparing " + pizzaType + " pizza");
        System.out.println("Baking pizza...");
        System.out.println("Pizza ready!");
    }
}

// Proxy
class PizzaShopProxy implements PizzaService {

    private RealPizzaShop realPizzaShop;
    // or
    private PizzaService realPizzaShop;

    @Override
    public void orderPizza(String pizzaType) {

        // Validation / access control
        if (pizzaType == null || pizzaType.isEmpty()) {
            System.out.println("Invalid pizza type!");
            return;
        }

        // Lazy initialization
        if (realPizzaShop == null) {
            realPizzaShop = new RealPizzaShop();
        }

        System.out.println("Order received by proxy");
        realPizzaShop.orderPizza(pizzaType);
    }
}

// Client
public class ProxyPatternPizza {
    public static void main(String[] args) {

        PizzaService pizzaService = new PizzaShopProxy();

        System.out.println("Customer places order...");
        pizzaService.orderPizza("Cheese");

        System.out.println();

        System.out.println("Customer places another order...");
        pizzaService.orderPizza("Olives");
    }
}
