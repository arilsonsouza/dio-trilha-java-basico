package dio.gof.strategy;

public class NormalBehavior implements Behavior {

    @Override
    public void mover() {
        System.out.println("Movendo-se normalmente...");
    }

}
