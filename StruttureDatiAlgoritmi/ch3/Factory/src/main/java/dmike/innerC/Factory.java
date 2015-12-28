package dmike.innerC;

/**
 * Created by andrea on 28/12/15.
 * @author dmike
 */

interface  Service{
    void method1();
    void method2();
}

@FunctionalInterface
interface ServiceFactory{
    Service getService();
}

class Implementation1 implements Service{
    public static ServiceFactory factory = Implementation1::new;
    /*() -> {
        return new Implementation1();
    };*/
    /*new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation1();
        }
    };*/
    @Override
    public void method1() {
        System.out.println("Implementation1 Method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation1 Method2");
    }

    private Implementation1(){}
}

class Implementation2 implements Service{
    public static ServiceFactory factory = Implementation2::new;
    /* ()->{
      return new Implementation2();
    };*/
    /*new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };*/
    @Override
    public void method1() {
        System.out.println("Implementation2 Method1");
    }

    @Override
    public void method2() {
        System.out.println("Implementation2 Method2");
    }

    private Implementation2(){}
}

public class Factory {
    public static void serviceCConsumer(ServiceFactory fact){
        Service s = fact.getService();

        s.method1();
        s.method2();
    }
    public static void main(String[] args){
        serviceCConsumer(Implementation1.factory);
        serviceCConsumer(Implementation2.factory);
    }
}
