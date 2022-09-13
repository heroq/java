package 람다;

public class Game {
    String name;
    int level;
    String job;

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", job='" + job + '\'' +
                '}';
    }

    public Game(String name, int level, String job) {
        this.name = name;
        this.level = level;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
