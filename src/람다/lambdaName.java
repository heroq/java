package 람다;

import java.util.function.Predicate;

public class lambdaName implements Predicate {
    @Override
    public boolean test(Object o) {
        Game g = (Game)o;
        return "황영웅".equals(g.getName());
    }
}
