import java.util.ArrayList;

public class Customer 
{
   
    // instance variables
    private String name;
    private int ID; // national ID
    private ArrayList<Account> accounts;

    // constructor
    public Customer(String customerName, int customerID)
    {
        this.name = customerName;
        this.ID = customerID;
        this.accounts = new ArrayList<Account>();
    }

    // getters
    public String getName()
    {
        return this.name;
    }
    public int getID()
    {
        return this.ID;
    }
    public double getBalance()
    {
        double total = 0.0;
        for (Account account : this.accounts)
        {
            total += account.getBalance();
        }
        return total;
    }
    public String toString()
    {
        String result = this.name + " has " + this.accounts.size() + " accounts as follows:\n";
        for (Account account : this.accounts)
        {
            result += account.toString() + "\n";
        }
        return result;
    }

    // other methods
    public Account openCheckingAccount()
    {
        Account newAccount = new Account(this);
        this.accounts.add(newAccount);
        return newAccount;
    }
    public Account openSavingsAccount(double rate)
    {
        Account newAccount = new Account(this, rate);
        this.accounts.add(newAccount);
        return newAccount;
    }
    public boolean closeAccount(int ID)
    {
        for (int i = 0; i < this.accounts.size(); i++)
        {
            Account account = this.accounts.get(i);
            if (account.getID() == ID)
            {
                if (account.getBalance() == 0.0)
                {
                    this.accounts.remove(i);
                    return true;
                }
                else
                {
                    // report non-zero balance
                    return false;
                }
            }
        }
        return false;
    } 
}
