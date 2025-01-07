import java.util.Scanner;

abstract class Account
{
    String customername;
    int accno;
    double balance;

    public Account(String customername, int accno, double balance)
    {
        this.customername = customername;
        this.accno = accno;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void displayBalance();

    public double getBalance()
    {
        return this.balance;
    }
}

class CurrAct extends Account
{
    double minbalance = 500;
    double servicecharge = 20;

    public CurrAct(String customername, int accno, double balance)
    {
        super(customername, accno, balance);
    }

    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited: " + amount + " Rs");
    }

    public void withdraw(double amount)
    {
        if (balance - amount >= minbalance)
        {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " Rs");
        }
        else
        {
            balance -= servicecharge;
            System.out.println("Service charge applied");
        }
    }

    public void displayBalance()
    {
        System.out.println("Current Account Balance : " + balance);
    }
}

class SavAcc extends Account
{
    double interest;

    public SavAcc(String customername, int accno, double balance, double interest)
    {
        super(customername, accno, balance);
        this.interest = interest;
    }

    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount)
    {
        if (balance - amount >= 0)
        {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
        else
        {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    public void computeAndDepositInterest()
    {
        double calculatedInterest = balance * this.interest / 100;
        balance += calculatedInterest;
        System.out.println("Interest deposited: " + calculatedInterest);
    }

    public void displayBalance()
    {
        System.out.println("Savings Account Balance: " + balance);
    }
}

public class Bank
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();
        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Choose account type (1 for Savings, 2 for Current): ");
        int accountType = sc.nextInt();
        Account account = null;

        if (accountType == 1)
        {
            System.out.print("Enter initial deposit for savings account: ");
            double initialDeposit = sc.nextDouble();
            System.out.print("Enter interest rate: ");
            double interestRate = sc.nextDouble();
            int accno = Integer.parseInt(accountNumber);
            account = new SavAcc(customerName, accno, initialDeposit, interestRate);
        }
        else
        {
            System.out.print("Enter the initial deposit: ");
            double initialDeposit = sc.nextDouble();
            int accno = Integer.parseInt(accountNumber);
            account = new CurrAct(customerName, accno, initialDeposit);
        }

        while (true)
        {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcc)
            {
                System.out.println("4. Compute and Deposit Interest");
            }
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcc)
                    {
                        ((SavAcc) account).computeAndDepositInterest();
                    }
                    else
                    {
                        System.out.println("This option is not available for Current Accounts.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
