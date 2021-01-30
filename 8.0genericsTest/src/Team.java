import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Team<T>  {
    List<T> team = new ArrayList<>();
    String name;

    Team(String name){
        this.name = name;
    }

    Team(List<T> team, String name){
        this.team = team;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<T> getTeam(){
        return team;
    }

    public void addNewGamer(T gamer){
        team.add(gamer);
        System.out.println("Add gamer " + gamer);
    }

    public String play(Team<T> otherTeam){
        Random rand = new Random();
        if (rand.nextInt(2) == 0){
            return "Win team " + name;
        } else {
            return "Win team " + otherTeam.getName();
        }

    }

    /*public void sorting(){
        Collections sort(team);
    }*/


}
