// FlyweightPatternTree.java
// Single-file Java example of Flyweight Pattern using Tree / Game analogy

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface TreeType {
    void draw(int x, int y);
}

// Concrete Flyweight (shared object)
class TreeTypeImpl implements TreeType {

    private String name;
    private String color;
    private String texture;

    public TreeTypeImpl(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println(
            "Drawing " + name +
            " tree at (" + x + "," + y + ")" +
            " with color " + color +
            " and texture " + texture
        );
    }
}

// Flyweight Factory
class TreeFactory {

    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + color + texture;

        if (!treeTypes.containsKey(key)) {
            treeTypes.put(key, new TreeTypeImpl(name, color, texture));
            System.out.println("Creating new TreeType: " + key);
        }

        return treeTypes.get(key);
    }
}

// Context (extrinsic state)
class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}

// Client
public class flyweight {
    public static void main(String[] args) {

        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineType = TreeFactory.getTreeType("Pine", "Dark Green", "Smooth");

        // Many trees share same TreeType objects
        Tree t1 = new Tree(10, 20, oakType);
        Tree t2 = new Tree(30, 40, oakType);
        Tree t3 = new Tree(50, 60, pineType);
        Tree t4 = new Tree(70, 80, pineType);

        t1.draw();
        t2.draw();
        t3.draw();
        t4.draw();
    }
}
