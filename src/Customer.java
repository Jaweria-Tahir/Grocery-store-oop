public class Customer extends Person
{
    private int accountNumber;
    private int Balance;

    Customer()
    {
        accountNumber = 0;
        Balance = 0;
    }

    public void setCustomerInfo(int accountNumber, int balance)
    {
        this.accountNumber = accountNumber;
        this.Balance = Balance;
    }

    public void setAccountNumber(int accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public void setBalance(int balance)
    {
        this.Balance = Balance;
    }

    public int getBalance()
    {
        return Balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }
    //method finding star customer
    @Override
    public int computeOrder(Order[] order, int oCounter)
    {
        int customerOrderCount;
        int maxOrderCount = 0;
        int maxCustId = 0;
        int totalBill;
        int currentCustId;
        for(int i = 0; i < oCounter ; i++)
        {
            customerOrderCount = 0;
            currentCustId = order[i].getCustId();
            //resetting order count for each customer
            for (int j = 0; j < oCounter; j++) {
                if (order[i].getCustId() == getId()) {
                    customerOrderCount++;
                }
                if (maxOrderCount < customerOrderCount) {
                    maxOrderCount = customerOrderCount;
                    maxCustId = currentCustId;
                }
            }
        }

        totalBill = 0;
        if(maxOrderCount >= 5)
        {
            for (int i = 0; i < oCounter ; i++)
            {
                if(order[i].getCustId() == maxCustId)
                {
                    for(int j = 0; j < order[i].getCounter();j++)
                    {
                        totalBill += (order[i].getItems()[j].getPrice() * order[i].getItems()[j].getOrderedQty());
                    }
                }
            }
        }
        if( totalBill >= 10000)
        {
            return maxCustId;
        }
        return -1;
    }


}