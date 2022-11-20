package entity;

import java.util.Objects;

public class SoldItem {
    private long id;
    private Report report;
    private Item item;

    public SoldItem(final long id, final Report report, final Item item) {
        this.id = id;
        this.report = report;
        this.item = item;
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

    public Item getItem() {
        return item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof SoldItem)) return false;
        final SoldItem soldItem = (SoldItem) o;
        return id == soldItem.id && Objects.equals(report, soldItem.report) && Objects.equals(item, soldItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, report, item);
    }

    @Override
    public String toString() {
        return "SoldItem{" +
                "id=" + id +
                ", report=" + report +
                ", item=" + item +
                '}';
    }
}