package entity;


import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String surname;
    private String number;

    public User() {
    }

    public User(long id, String name, String surname, String number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getNumber(), user.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getNumber());
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number='" + number  +

                '}';
    }
}
