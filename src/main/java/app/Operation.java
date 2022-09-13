package app;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Operation {
    private OperationType type;
    private BigDecimal amount;
    private BigDecimal balance;
    private LocalDate date;
    public Operation(OperationType type, BigDecimal amount) {
        this.type = type;
        this.amount = amount;
        this.date = LocalDate.now();
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%-12s%-12s%-12s%12s", this.type, this.amount, this.date, this.balance);
    }
}
