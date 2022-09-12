// 동작 파라미터화

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
    동작 파라미터화는 전략 디자인 패턴
    1. pridicateApple의 interface를 생성
    2. pridicateApple의 interface implement할 class 생성
    3. 그리고 필터를 거칠 함수를 클래스마다 생성함
    4. 필터를 사용할 생성한 메소드의 매개변수에 pridicateApple을 추가
*/
public class BehaviorParameterization {
    static class Car{
        String name;
        String color;
        Car(String name, String color) {
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
