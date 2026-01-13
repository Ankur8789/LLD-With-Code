Factoryinterface Shape {
    public void area();
}

public class Square implements Shape{
    @Override
    public void area(){
        System.out.println("Sq");
    }
}

public class Circle implements Shape{
    @Override
    public void area(){
        System.out.println("Cr");
    }
}

public class Factory {
    // remember just how you did in MVC Structure , we just instantitate the interface not the implementing classes
    public Shape getShapeInst(String req){
        if(req.equals("Square"))return new Square();
        else return new Circle();
    }
    // if we want to change stuff in the instantiation , we can change here.
}

public static void main(String args[]){
    // now we just call the factory 
    Factory fac = new Factory();
    Shape crobj = fac.getShapeInst("Circle");
}




