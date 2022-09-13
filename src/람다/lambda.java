package 람다;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

;
public class lambda {
    public ArrayList<Game> lambda() {
        ArrayList<Game> setGame = new ArrayList<>();
        setGame.add(new Game("김덕배", 10, "전사"));
        setGame.add(new Game("정단비", 20, "대학생"));
        setGame.add(new Game("황영웅", 30, "직장인"));
        setGame.add(new Game("황만득", 40, "백수"));
        return setGame;
    }

    public <T> List<T> filter(List<T> t, Predicate<T> p){
        List<T> temp = new ArrayList<T>();
        for(T get : t){
            if(p.test(get)){
                temp.add(get);
            }
        }
        return temp;
    }

    public void start(){
        람다.lambda list = new 람다.lambda();
        ArrayList<Game> games = list.lambda();

        // 1.   stream의 filter의 Predicate 람다식
        //      Predicate를 바로 생성한것
        games = (ArrayList<Game>) games.stream().filter((Game g) -> g.getLevel() <= 10).collect(Collectors.toList());
        for(Game a : games) System.out.println(a.toString());

        // 2.   Predicate는 test, or, and로 되어있음
        //      boolean으로 판별해서 filter에서 Predicate로 값을 골라줌
        Predicate<Game> p = (Game g) -> g.getLevel() <= 10;
        Game game = new Game("TEST", 10, "TEST2");
        boolean get = p.test(game);
        System.out.println(get);

        // 3.   collect로 toList화
        //      interface에 arraylist가 있으니깐 변환 후 받아옴
        //      애초에 List로 받으면 캐스팅 안함
        //      Predicate를 위에서 선언하고 가져와서 사용했음
        List<Game> games2 = list.lambda();
        games2 = games2.stream().filter(p).collect(Collectors.toList());
        for(Game g : games2) System.out.println(g.toString());

        // 4.   filter 제네릭 메소드 추가
        //      전략 디자인 패턴 방식
        //      lambdaName의 메소드를 넘겨주는방식
        List<Game> games3 = list.lambda();
        games3 = filter(games3, new lambdaName());
        for(Game g : games3) System.out.println(g.toString());
    }
}