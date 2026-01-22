Prototypeclass Student implements Prototype{
  // member variables
  // By default class variables , methods are default (package private) accessed only within the same package
  int age;
  private int rollNumber;
  String name;

  // Default constructor , even if we dont write , it will be there
  Student(){};

  public Student(int age,int rNo,String name){
     this.age = age;
     this.rollNumber = rNo;
     this.name = name;
  }
  // now clones can be made successfully 
  @Override
  public Student clone(){
     return new Student(this.age,this.rollNumber,this.name);
  }
}


public static void main(String args[]){
  Student stu = new Student(0, 0, "null");
  // ineffecinet way of copying
  Student clone = new Student();
  // moving on to assigns all variables , might create issues with access modifiers
}

// now instead of doing this , we sort of add a layer in between as for prototype

public interface Prototype {
    public Student clone();
}