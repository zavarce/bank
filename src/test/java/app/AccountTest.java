package app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void givenAmountWhenDepositThenIncreaseBalance() {
        Account account = new Account(new Client("1", "Jesus", "Zavarce"));
        String depositAmount = "100.50";
        account.deposit(depositAmount);
        Assertions.assertEquals(new BigDecimal(depositAmount), account.getBalance());
    }

    @Test
    public void givenAmountWhenManyDepositThenIncreaseBalance() {
        Account account = new Account(new Client("1", "Jesus", "Zavarce"));
        String depositAmountOne = "200";
        String depositAmountTwo = "300";
        BigDecimal expected = account.getBalance().add(new BigDecimal(depositAmountOne).add(new BigDecimal(depositAmountTwo)));

        account.deposit(depositAmountOne);
        account.deposit(depositAmountTwo);

        Assertions.assertEquals(expected, account.getBalance());
    }

    @Test
    public void givenAmountWhenWithdrawalThenDecreaseBalance() {
        Account account = new Account(new Client("1", "Jesus", "Zavarce"));
        String withdrawalAmount = "100";
        account.withdrawal(withdrawalAmount);
        Assertions.assertEquals(new BigDecimal(withdrawalAmount).negate(), account.getBalance());
    }

    @Test
    public void printHistory() {
        Account account = new Account(new Client("1", "Jesus", "Zavarce"));
        String depositAmountOne = "200";
        String withdrawalAmountOne = "100.50";
        String depositAmountTwo = "300.50";
        String withdrawalAmountTwo = "100.50";

        account.deposit(depositAmountOne);
        account.withdrawal(withdrawalAmountOne);
        account.deposit(depositAmountTwo);
        account.withdrawal(withdrawalAmountTwo);



        String expected =  """
        OPERATION   AMOUNT      DATE            BALANCE
        DEPOSIT     200         2022-09-13           200
        WITHDRAWAL  -100.50     2022-09-13         99.50
        DEPOSIT     300.50      2022-09-13        400.00
        WITHDRAWAL  -100.50     2022-09-13        299.50
        
        Total Balance : 299.50""";

        Assertions.assertEquals(expected, account.getBankStatements());
    }
}
