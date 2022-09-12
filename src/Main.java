import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BehaviorParameterization.Car> car = new ArrayList<>();
        car.add(new BehaviorParameterization.Car("A", "B"));
        car.add(new BehaviorParameterization.Car("BMW", "QQQ"));
        car.add(new BehaviorParameterization.Car("DDD", "RED"));
        car.add(new BehaviorParameterization.Car("BBQ", "C"));

        for(BehaviorParameterization.Car a : car){
            System.out.println(a.getName()+", "+a.getColor());
        }

        BehaviorParameterization BP = new BehaviorParameterization();
        ArrayList<BehaviorParameterization.Car> car2 = BP.BPfilter(car, new BPColor());
        System.out.println("==Color==");
        for(BehaviorParameterization.Car a : car2) System.out.println(a.getName()+", "+a.getColor());

        ArrayList<BehaviorParameterization.Car> car3 = BP.BPfilter(car, new BPName());
        System.out.println("==Name==");
        for(BehaviorParameterization.Car a : car3) System.out.println(a.getName()+", "+a.getColor());


    }
}