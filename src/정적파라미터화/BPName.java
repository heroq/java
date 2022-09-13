package 정적파라미터화;

public class BPName implements BPPredicate{
    @Override
    public boolean test(BehaviorParameterization.Car car) {
        return "BMW".equals(car.getName());
    }
}
