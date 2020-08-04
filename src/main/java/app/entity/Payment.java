package app.entity;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private Integer id;
    private double monthlyAmount;
    private String date;
    private int delay;
    private double paidAmount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private double maxAmountToPay;

    public double getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(double monthly_amount) {
        this.monthlyAmount = monthly_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paid_amount) {
        this.paidAmount = paid_amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getMaxAmountToPay() {
        return maxAmountToPay;
    }

    public void setMaxAmountToPay(double maxAmountToPay) {
        this.maxAmountToPay = maxAmountToPay;
    }
}
