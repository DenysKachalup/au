package entity;

import java.util.Objects;

public class Car {
    private long id;
    private String brand;
    private String model;
    private int price;
    private int yearOfTheVehicle;

    public Car(long id, String brand, String carModel, int price, int yearOfTheVehicle) {
        this.id = id;
        this.brand = brand;
        this.model = carModel;
        this.price = price;
        this.yearOfTheVehicle = yearOfTheVehicle;
    }

    public Car(long id, Car car, Report report) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearOfTheVehicle() {
        return yearOfTheVehicle;
    }

    public void setYearOfTheVehicle(int yearOfTheVehicle) {
        this.yearOfTheVehicle = yearOfTheVehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId() == car.getId() && getPrice() == car.getPrice() && getYearOfTheVehicle() == car.getYearOfTheVehicle() && Objects.equals(getBrand(), car.getBrand()) && Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModel(), getPrice(), getYearOfTheVehicle());
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", carModel='" + model + '\'' +
                ", price=" + price +
                ", yearOfTheVehicle=" + yearOfTheVehicle +
                '}';
    }
}
