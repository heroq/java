import java.sql.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Stream {
    static class Apple{
        String color;
        public void setColor(String color){this.color = color;}
        public String getColor(){return color;}
    }

    static public boolean greenCheck(Apple apple){
        return "GREEN".equals(apple.getColor());
    }
    static public ArrayList<Apple> filterApple(ArrayList<Apple> apple, Predicate<Apple> p){
        ArrayList<Apple> result = new ArrayList<>();
        for(Apple get : apple){
            if(p.test(get)){
                result.add(get);
            }
        }
        return result;
    }    
    /*
        // stream 예제

        ArrayList<stream.Apple> appleBox = new ArrayList<>();
        stream.Apple apple = new stream.Apple();
        apple.setColor("blue");
        appleBox.add(apple);
        apple = new stream.Apple();
        apple.setColor("red");
        appleBox.add(apple);
        apple = new stream.Apple();
        apple.setColor("green");
        appleBox.add(apple);
        apple = new stream.Apple();
        apple.setColor("GREEN");
        appleBox.add(apple);

        // 메소드 참조
        ArrayList<stream.Apple> green = stream.filterApple(appleBox, stream::greenCheck);
        for (stream.Apple get : green){
            System.out.println(get.getColor());
        }

        // 익명 함수
        ArrayList<stream.Apple> green2 = stream.filterApple(appleBox, (stream.Apple a) -> "GREEN".equals(a.getColor()));
        for (stream.Apple get : green) System.out.println(get.getColor());

        // 내장 filter
        List<stream.Apple> green3 = appleBox.stream().filter((stream.Apple a) -> "GREEN".equals(a.getColor())).collect(toList());
        for (stream.Apple get : green3) System.out.println(get.getColor());

        // 병렬 처리
        List<stream.Apple> green4 = appleBox.parallelStream().filter((stream.Apple a) -> "GREEN".equals(a.getColor())).collect(toList());
        for (stream.Apple get : green4) System.out.println(get.getColor());


     */
}
