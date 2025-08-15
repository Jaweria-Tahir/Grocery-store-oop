public class Employee extends Person
{
    private String designation;
    private int salary;

    Employee()
    {
        designation = "";
        salary = 0;
    }
    Employee(String designation, int salary)
    {
        this.designation = designation;
        this.salary = salary;
    }
    public void setDesignation(String designation) {
        this.designation=designation;
    }

    public String getDesignation() {
        return designation;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    //method finding star employee
    @Override
    public int computeOrder(Order[] order, int oCounter)
    {
        int maxEmpBill = 0;
        int maxEmpId = -1;
        for(int i = 0; i < oCounter ; i++)
        {
            int totalBill = 0;
            //reset bill to 0 for each customer
                if (order[i].getEmpId() == getId())
                {
                    for(int j = 0; j < order[i].getCounter();j++)
                    {
                        totalBill += (order[i].getItems()[j].getPrice() * order[i].getItems()[j].getOrderedQty());
                    }
                }
            if (maxEmpBill < totalBill) {
                maxEmpBill = totalBill;
                maxEmpId = getId();
            }
        }
            if (maxEmpBill >= 1000000)
            {
                return maxEmpId;
            }
        return -1;
    }
}

