import java.util.Objects;

public class CarOwner {
    int id;
    String name;
    String surname;

    public CarOwner(int id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CarOwner owner = (CarOwner) object;
        return id == owner.id &&
                Objects.equals(name, owner.name) &&
                Objects.equals(surname, owner.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
