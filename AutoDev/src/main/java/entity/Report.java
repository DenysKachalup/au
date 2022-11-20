package entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Report {
    private long id;
    private List<Item> items;
    private List<Car> cars;
    private Employee employee;
    private User user;
    private Timestamp dateSell;
    private int totalPrice;

    public Report(final long id, final List<Item> items, final List<Car> cars, final Employee employee, final User user, final Timestamp dateSell, final int totalPrice) {
        this.id = id;
        this.items = items;
        this.cars = cars;
        this.employee = employee;
        this.user = user;
        this.dateSell = dateSell;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(final List<Item> items) {
        this.items = items;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(final List<Car> cars) {
        this.cars = cars;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Timestamp getDateSell() {
        return dateSell;
    }

    public void setDateSell(final Timestamp dateSell) {
        this.dateSell = dateSell;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(final int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        final Report report = (Report) o;
        return id == report.id && totalPrice == report.totalPrice && Objects.equals(items, report.items) && Objects.equals(cars, report.cars) && Objects.equals(employee, report.employee) && Objects.equals(user, report.user) && Objects.equals(dateSell, report.dateSell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, cars, employee, user, dateSell, totalPrice);
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", items=" + items +
                ", cars=" + cars +
                ", employee=" + employee +
                ", user=" + user +
                ", dateSell=" + dateSell +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
