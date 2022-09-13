package app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Client client;
    public BigDecimal balance = BigDecimal.ZERO;
    private List<Operation> operations = new ArrayList<>();
    public Account(Client client) {
        this.client = client;
    }
    public void deposit(String amount) {
        Operation operation = new Operation(OperationType.DEPOSIT, new BigDecimal(amount));
        balance = balance.add(operation.getAmount());
        operation.setBalance(balance);
        operations.add(operation);
    }

    public void withdrawal(String amount) {
        Operation operation = new Operation(OperationType.WITHDRAWAL, new BigDecimal(amount).negate());
        balance = balance.add(operation.getAmount());
        operation.setBalance(balance);
        operations.add(operation);
    }
    public String getBankStatements() {
        StringBuilder stb = new StringBuilder();
        stb.append(String.format("%-12s%-12s%-12s%12s", "OPERATION", "AMOUNT", "DATE", "BALANCE\n"));

        operations.forEach(op -> stb.append(op).append("\n"));
        stb.append("\nTotal Balance : ").append(this.balance);

        return stb.toString();
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
