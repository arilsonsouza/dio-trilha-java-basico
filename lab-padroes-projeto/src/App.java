import dio.gof.SingletonEager;
import dio.gof.SingletonLazy;
import dio.gof.SingletonLazyHolder;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("SingletonLazy");
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        System.out.println("SingletonEager");
        SingletonEager lazyEager = SingletonEager.getInstance();
        System.out.println(lazyEager);
        lazyEager = SingletonEager.getInstance();
        System.out.println(lazyEager);

        System.out.println("SingletonLazyHolder");
        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);
    }
}
