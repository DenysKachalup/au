package entity;

import java.util.Objects;

public class SoldCar {
    private long id;
    private Report report;
    private Car car;

    public SoldCar(final long id, final Report report, final Car car) {
        this.id = id;
        this.report = report;
        this.car = car;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(final Report report) {
        this.report = report;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(final Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldCar)) return false;
        final SoldCar soldCar = (SoldCar) o;
        return id == soldCar.id && Objects.equals(report, soldCar.report) && Objects.equals(car, soldCar.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, report, car);
    }

    @Override
    public String toString() {
        return "SoldCar{" +
                "id=" + id +
                ", report=" + report +
                ", car=" + car +
                '}';
    }
}