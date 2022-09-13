package 정적파라미터화;// 동작 파라미터화

import java.util.ArrayList;

/*
    동작 파라미터화는 전략 디자인 패턴
    1. pridicateApple의 interface를 생성
    2. pridicateApple의 interface implement할 class 생성
    3. 그리고 필터를 거칠 함수를 클래스마다 생성함
    4. 필터를 사용할 생성한 메소드의 매개변수에 pridicateApple을 추가
*/

/*
    // Main에서 예제
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

        ArrayList<BehaviorParameterization.Car> car4 = BP.BPfilter(car, (BehaviorParameterization.Car a) -> "BMW".equals(a.getName()));
        System.out.println("==Name2 람다==");
        for(BehaviorParameterization.Car a : car4) System.out.println(a.getName()+", "+a.getColor());
 */
public class BehaviorParameterization {
    static public class Car{
        String name;
        String color;
        public Car(String name, String color) {
            this.name = name;
            this.color = color;
        }
        public void setName(String name){ this.name = name; }
        public String getName() { return this.name; }

        public void setColor(String color){ this.color = color; }
        public String getColor() { return this.color; }
    }

    public ArrayList<Car> BPfilter(ArrayList<Car> carArrayList, BPPredicate p){
        ArrayList<Car> filterArray = new ArrayList<>();
        for(Car get : carArrayList){
            if(p.test(get)){
                filterArray.add(get);
            }
        }
        return filterArray;
    }
}
