public abstract class Gamers implements Comparable<Gamers> {
    private String name;
    private int age;

    Gamers(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return getName() + " " + getAge();
    }

    @Override
    public int compareTo(Gamers otherGamers) {
        return age - otherGamers.getAge();
    }

}
