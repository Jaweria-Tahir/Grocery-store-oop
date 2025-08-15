public class Order
{
    private int EmpId;
    private int CustId;
    private int Id;
    private Items[] items;//composition
    private int quantity;
    private int bill;
    Date date;//composition
    int Counter;

    Order()
    {
        items=new Items[50];
        EmpId=0;
        CustId=0;
        quantity = 0;
        bill = 0;
        date= new Date();
        Counter = 0;
    }

    public void setBill(int bill)
    {
        this.bill = bill;
    }
    public int getBill()
    {
        return bill;
    }
    public void setCounter(int counter)
    {
        this.Counter = Counter;
    }
    public int getCounter()
    {
        return Counter;
    }
    public Date getDate()
    {
        return date;
    }
    public void setDate(Date date)
    {
        this.date = date;
    }
    public int getEmpId()
    {
        return EmpId;
    }
    public int getCustId()
    {
        return CustId;
    }
    public int getOrderId()
    {
        return Id;
    }
    public void setQty(int quantity)
    {
        this.quantity = quantity;
    }
    public Items[] getItems()
    {
        return items;
    }
    public Items getSingleItems(int i)
    {
            return items[i];
    }
    public void setCustId(int custId)
    {
        CustId = custId;
    }
    public void setEmpId(int empId)
    {
        EmpId = empId;
    }
    public void setOrderId(int Id)
    {
        this.Id = Id;
    }
    public void setItems(Items[] items,int Counter)
    {
        this.items = items;
        this.Counter = Counter;
    }
    //high selling item
    public int highSellingItem(Order[] order, int oCounter,Items[] items, int iCounter)
    {
        int[] totalQty = new int[iCounter];
        int maxQty = 0;
        int maxQtyIndex = -1;
                //find total Qty of items
        for(int i = 0 ; i < oCounter ; i++)
        {
            Items[] itemsOrdered = order[i].getItems();;
            for(int j = 0 ; j < itemsOrdered.length ; j++)
            {
                for (int k = 0; k < iCounter; k++)
                {
                    if(itemsOrdered[j].getId() == items[k].getId())
                    {
                        totalQty[k] += itemsOrdered[j].getQty();
                    }//end of if(itemsOrdered[j].getId() == items[k].getId())
                }//end of item counter loop
            }//end of ordered items counter loop
        }//end of order array counter loop

        //find max qty item index
        for(int i = 0 ; i < iCounter ; i++)
        {
            if(totalQty[i] > maxQty)
            {
                maxQty = totalQty[i];
                maxQtyIndex = i;
            }
        }
        //get index of item in max quantity
        return maxQtyIndex;
    }

    //calculate total bill
    public int calculateBill(Order[] order, int oCounter, int iCounter)
    {
        int totalBill = 0;
        for(int i = 0 ; i < oCounter ; i++)
        {
            Items[] itemsOrdered = order[i].getItems();
            for(int j = 0 ; j < itemsOrdered.length ; j++)
            {
                for (int k = 0; k < iCounter; k++)
                {
                    if(itemsOrdered[j].getId() == items[k].getId())
                    {
                        totalBill += (itemsOrdered[j].getPrice() * itemsOrdered[j].getOrderedQty());
                    }//end of item Id validation condition
                }//end of item counter loop
            }//end of ordered items counter loop
        }//end of order array counter loop
        return totalBill;
    }

    //calculate total profit
    public int calculateProfit(Order[] order,int oCounter,int iCounter,Items[] itemArray)
    {
        int totalProfit = 0;
        for(int i = 0 ; i < oCounter ; i++)
        {
            Items[] itemsOrdered = order[i].getItems();
            for (int j = 0; j < itemsOrdered.length; j++)
            {
                int itemId = itemsOrdered[j].getId();
                int quantitySold = itemsOrdered[j].getOrderedQty();
            for (int k = 0; k < iCounter; k++)
            {
                if (itemArray[k].getId() == itemId)
                {
                    totalProfit += ((itemArray[k].getPrice() - itemArray[k].getCost()) * quantitySold);
                    break;
                }//end of condition validating id of item
            }//end of item counter
            }//end of ordered item counter
        }//end of order array counter
          return totalProfit;
    }

    public int calculateSingleBill(Order order, Items[] items, int iCounter) {
        int totalBill = 0;

        Items[] itemsOrdered = order.getItems();

        for (int j = 0; j < itemsOrdered.length; j++) {
            for (int k = 0; k < iCounter; k++) {
                if (itemsOrdered[j].getId() == items[k].getId()) {
                    totalBill += (itemsOrdered[j].getPrice() * itemsOrdered[j].getOrderedQty());
                    break;
                }
            }
        }

        return totalBill;
    }

}
