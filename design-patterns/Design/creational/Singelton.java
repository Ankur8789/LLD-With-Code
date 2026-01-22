
/* 1 - Eager initialzition */

/* 
    🔍 Why Is This Called Eager Initialization?

    Instance is created immediately when the class is loaded

    Happens even if getInstance() is never called

    JVM guarantees thread safety during class loading 
*/

public class SingeltonEager {
    // no recursion happens as remember , when the class loads , the constructor is instantiated , so 
    // when the call happens , everything happens smoothly
    private static SingeltonEager db = new SingeltonEager();
    // making the constructor pvt , so no one can create classes
    private SingeltonEager(){

    }
    public static SingeltonEager getInstance(){
        return db;
    }
}


public static void main(String args[]){
    // since it is static member variable , we can directly call the class value
  SingeltonEager sg = SingeltonEager.getInstance();
}

/*Lazy initialization  

- instead of making it at compile time , ie at start 
  we do it when required explicitly
*/


public class SingeltonLazy {
    // We dont instantiate the Db Connection right now 
    private static SingeltonLazy db;
    private SingeltonLazy(){

    }
    public static SingeltonLazy getInstance(){
        if(db == null){
            db = new SingeltonLazy();
        }
        return db;
    }
}

/* Improvement with Synchronized method */

public class SingletonSync {
    // We dont instantiate the Db Connection right now 
    private static SingletonSync db;
    private SingletonSync(){

    }
    // added a sync. keyword for thread safety , but this lock , unlock is very expensive
    // if the load is too much , this was improved using Double locking 
    synchronized public static SingletonSync getInstance(){
        if(db == null){
            db = new SingletonSync();
        }
        return db;
    }
}



/* Sync Double locking industry standara */

public class SingletonDL {
    // We dont instantiate the Db Connection right now 
    private static SingletonDL db;
    private SingletonDL(){

    }
    // added a sync. keyword for thread safety , but this lock , unlock is very expensive
    // if the load is too much , this was improved using Double locking 
    public static SingletonDL getInstance(){
        // first check to ensure thready safety for the first time
        if(db == null){
            // second lock to check if this is done or not , if yes , then good 
            synchronized(SingletonDL.class){
                if(db == null){
                    db = new SingletonDL();
                }
            }
        }
        return db;
    }
}


