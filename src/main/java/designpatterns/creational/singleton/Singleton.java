package designpatterns.creational.singleton;

/**
 * @author Kapil Negi
 */




//Expensive resource
class Resource{
    Resource(){

    }
}

final class NotThreadSingleton {
    private static NotThreadSingleton instance;
    public String value;

    private NotThreadSingleton(String value) {
        this.value = value;
    }

    public static NotThreadSingleton getInstance(String value) {
        if (instance == null) {
            instance = new NotThreadSingleton(value);
        }
        return instance;
    }
}

class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;
    public String value;

    private ThreadSafeSingleton(String value) {
        this.value = value;
    }

    public static ThreadSafeSingleton getInstance(String value) {
                     // no synchronized "this" because static method is synchronized on class instance not on
        // the object

//        not efficient as every thread has to check synchronized block and hence slow down the initialization, so add
        // a null check outside synchronized block;

        //This is called double check locking, checking twice locking once
        if(instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton(value);
                }
            }
        }
        return instance;
    }
}



/*Problem with above impl:
*  instance = new ThreadSafeSingletonPerfect();
* this initialization is a 3 seprate instructions
*   1. Construct empty  ThreadSafeSingletonPerfect()
*   2. assign to instance
*   3. call the constructor
* This instructions can be executed in any order, due to reordering by JVM. Now if suppose empty resouce is assigned first and
* before the actual constructor code of the resource is executed, another thread checks the null condition which returns false
* and return the resource which is not fully constructed. To fix this we need to apply volatile keyword to the reource.
* THis instructs JVM not to reorder the instructions*/
class ThreadSafeSingletonPerfect{
    private static volatile ThreadSafeSingletonPerfect instance = null;
    public String value;

    private ThreadSafeSingletonPerfect(String value) {
        this.value = value;
    }
    public static ThreadSafeSingletonPerfect getInstance(String value) {
        if(instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonPerfect(value);
                }
            }
        }
        return instance;
    }
}

/*Better simple way of above impl, provides same functionality*/
class ThreadSafeSingletonStaticPerfect{
    private static class Holder {
        //lazy initialization
         static final ThreadSafeSingletonStaticPerfect instance = new ThreadSafeSingletonStaticPerfect();
    }
    public static ThreadSafeSingletonStaticPerfect getInstance(String value) {
      return Holder.instance;
    }
}

//using ENUMs
enum ThreadSafeSingletonEnum{
    INSTANCE;
    ThreadSafeSingletonEnum(){
        System.out.println("hello");
    }
}
/*An enum type is a special type of class.

Your enum will actually be compiled to something like
public final class MySingleton {
    public final static MySingleton INSTANCE = new MySingleton();
    private MySingleton(){}
}
When your code first accesses INSTANCE, the class MySingleton will be loaded and initialized by the JVM.
 This process initializes the static field above once (lazily).*/


class NotThreadSafeEagerSingleton{
    Resource rs = rs = new Resource();

    public Resource getExpensiveResource(){
        return rs;
    }
}


/*Caution: These 3 patterns are for lazy loading an object. It should be used only when object is very expensive to
create and it may or may not be actually called during lifetime of the application.
In practical scenarios we rarely need lazy load. It can impact performance when first time the method is called.
Instead just eagerly create the singleton. In this case application will take some time to start, but the users/threads will not have any impact when calling the method once application is up.*/
public class Singleton {
    public static void main(String[] args) {
        System.out.println("start");
        System.out.println(ThreadSafeSingletonEnum.INSTANCE);
    }
}
