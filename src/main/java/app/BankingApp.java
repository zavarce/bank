package app;

public class BankingApp {

    public static void main(String[] args) {
        Client client = new Client("1", "Jesus", "Zavarce");
        Account account = new Account(client);

        account.deposit("100.50");
        account.deposit("200.50");
        account.withdrawal("50.45");

        System.out.println(account.getBankStatements());

    }
}

