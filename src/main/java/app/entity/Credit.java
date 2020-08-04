package app.entity;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class Credit {
    @NotNull
    private Double amount;
    private int period;

    public Double getAmount() {
        return amount;
    }

    public void setAmount( Double amount) {
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
