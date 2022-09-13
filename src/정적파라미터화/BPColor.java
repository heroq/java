package 정적파라미터화;

public class BPColor implements BPPredicate{
    @Override
    public boolean test(BehaviorParameterization.Car car) {
        return "RED".equals(car.getColor());
    }
}