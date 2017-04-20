package com.model;
import javax.persistence.*;


@Entity
@Table(name = "spending")
public class Spending {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "amount")
    private int amount;

    @Column(name = "types")
    private String types;


    public Spending() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spending spending = (Spending) o;

        if (id != spending.id) return false;
        if (amount != spending.amount) return false;
        if (address != null ? !address.equals(spending.address) : spending.address != null) return false;
        return types != null ? types.equals(spending.types) : spending.types == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (types != null ? types.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Spending{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", types='" + types + '\'' +
                '}';
    }
}
