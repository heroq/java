import java.sql.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class stream {
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
        stream 예1)

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

        ArrayList<stream.Apple> green = stream.filterApple(appleBox, stream::greenCheck);
        for (stream.Apple get : green){
            System.out.println(get.getColor());
        }
     */
}
