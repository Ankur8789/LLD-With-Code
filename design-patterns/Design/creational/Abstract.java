// Abstract Factory Pattern - Single File Example

// ---------- Abstract Products ----------
interface Button {
    void render();
}

interface Checkbox {
    void check();
}

// ---------- Concrete Products (Windows) ----------
class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Windows Checkbox");
    }
}

// ---------- Concrete Products (Mac) ----------
class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void check() {
        System.out.println("Checking Mac Checkbox");
    }
}

// ---------- Abstract Factory ----------
interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// ---------- Concrete Factories ----------
class WindowsFactory implements UIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements UIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// ---------- Client ----------
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(UIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.render();
        checkbox.check();
    }
}

// ---------- Main ----------
public class Abstract {
    public static void main(String[] args) {

        UIFactory factory = new WindowsFactory(); // switch to MacFactory
        Application app = new Application(factory);

        app.renderUI();
    }
}
