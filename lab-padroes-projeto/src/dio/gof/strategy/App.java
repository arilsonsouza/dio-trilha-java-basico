package dio.gof.strategy;

public class App {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.setBehavior(new NormalBehavior());
        robot.mover();

        robot.setBehavior(new DefensiveBehavior());
        robot.mover();

        robot.setBehavior(new AggressiveBehavior());
        robot.mover();
    }
}
