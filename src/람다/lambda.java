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


    public void start(){
        람다.lambda list = new 람다.lambda();
        ArrayList<Game> games = list.lambda();

        // stream의 filter의 Predicate 람다식
        games = (ArrayList<Game>) games.stream().filter((Game g) -> g.getLevel() <= 10).collect(Collectors.toList());
        for(Game a : games) System.out.println(a.toString());

        // Predicate는 test, or, and로 되어있음
        // boolean으로 판별해서 filter에서 Predicate로 값을 골라주네
        Predicate<Game> p = (Game g) -> g.getLevel() <= 10;
        Game game = new Game("TEST", 10, "TEST2");
        boolean get = p.test(game);
        System.out.println(get);

        List<Game> games2 = list.lambda();
        // collect로 toList화
        // interface에 arraylist가 있으니깐 변환 후 받아옴
        games = (ArrayList<Game>) games2.stream().filter(p).collect(Collectors.toList());
        for(Game g : games) System.out.println(g.toString());
    }
}