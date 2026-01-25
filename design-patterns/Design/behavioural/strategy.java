/*
STRATEGY DESIGN PATTERN – SINGLE FILE EXPLANATION

Scenario:
A payment system supports multiple payment methods.
The payment method can be changed at runtime.
*/

//////////////////// STRATEGY ////////////////////
/*
Strategy interface.
All payment methods must implement this.
*/
interface PaymentStrategy {
    void pay(int amount);
}

////////////////// CONCRETE STRATEGIES //////////////////
/*
Different algorithms / behaviors.
*/
class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("💳 Paid ₹" + amount + " using Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("📱 Paid ₹" + amount + " using UPI");
    }
}

class CashPayment implements PaymentStrategy {

    @Override
    public void pay(int amount) {
        System.out.println("💵 Paid ₹" + amount + " using Cash");
    }
}

//////////////////// CONTEXT ////////////////////
/*
Context holds a reference to a strategy.
It does NOT know the concrete implementation.
*/
class PaymentContext {

    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set!");
        }
        strategy.pay(amount);
    }
}

//////////////////// CLIENT ////////////////////
/*
Client decides which strategy to use.
*/
public class StrategyPatternDemo {

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment());
        context.checkout(1000);

        // Switch strategy at runtime
        context.setPaymentStrategy(new UpiPayment());
        context.checkout(500);

        // Another strategy
        context.setPaymentStrategy(new CashPayment());
        context.checkout(200);
    }
}
