package cz.muni.fi.pa165.pneuservis.backend.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author Martin Zilak, 433372@mail.muni.cz
 */
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime date;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal priceTotal;

    @NotNull
    @ManyToOne
    private Customer customer;

    @NotNull
    @OneToMany
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(LocalDateTime date, BigDecimal priceTotal, Customer customer, List<OrderItem> orderItems) {
        this.date = date;
        this.priceTotal = priceTotal;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(date, order.date) &&
                Objects.equals(priceTotal, order.priceTotal) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(orderItems, order.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, priceTotal, customer, orderItems);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("date", date)
                .add("priceTotal", priceTotal)
                .add("customer", customer)
                .add("orderItems", orderItems)
                .toString();
    }
}
