import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //input Scanner
        Scanner input = new Scanner(System.in);
        //variables
        int Id = 0, Qty = 0, Price = 0, Cost = 0, num = 0, editId = 0, Balance = 0, AccountNum = 0 , editOpt2 = 0, bill = 0 ;
        int Experience = 0, eid = 0, cid = 0, numItem = 0, orderReg = 0, orderId = 0, viewOrderOpt = 0, durationOption = 0;
        int  starCustId = 0, starEmpId = 0, salary = 0, Stock = 0, orderQty = 0,updatedQty = 0,hotSell = 0;
        int day = 0, year = 0, month = 0, CategoryOpt = 0 , totalProfit = 0, orderedQty = 0;
        boolean star = false, validEmployee = false, validCustomer = false, ratingMethod = false;
        String Name = "", editOpt = "", Designation = "", Category = "";
        final int threshold = 10;
        boolean ItemFound = false;
        Date startDate = null,endDate = null;

        //objects
        Order order = null;
        Items item = null;
        Employee emp = null;
        Customer cust= null ;
        Date date = null;
        //arrays
        Items[] selectedItems = null;
        Items[] itemCounterArray = null;
        Order[] orderArray = new Order[50];//max orders can be 50
        Items[] itemArray = new Items[100];
        Employee[] employeeArray = new Employee[10];
        Customer[] customerArray = new Customer[10];
        //counters
        int oCounter = 0, iCounter = 0, eCounter = 0, cCounter = 0, selectedIndex = 0, highSelling = 0;
        //menu
        int opt1 = 1, opt2 = 1;
        while (opt1 != 0) {
            System.out.println("""
                    ******* Welcome to Online Grocery Store *******
                            Press 1 to Manage Items
                            Press 2 to Manage Employee
                            Press 3 to Manage Customer
                            Press 4 to Manage Order
                            Enter 0 to Exit
                            Enter your Choice:
                    """);
            opt1 = input.nextInt();
            switch (opt1) {
                case 1:
                    //Item Case
                    System.out.println("""
                            ******* Manage Items *******
                            Press 1 to Add Items
                            Press 2 to Edit Items
                            Press 3 to Delete Items
                            Press 4 to View Items
                            Press 0 to go Back
                            Enter your Choice;
                            """);

                    opt2 = input.nextInt();
                    switch (opt2) {
                        case 1:
                            //Item input
                            System.out.println("*** Add Items ***");
                            System.out.println("Id");
                            Id = input.nextInt();
                            System.out.println("Product Name:");
                            Name = input.next();
                            input.nextLine();
                            System.out.println("Price:");
                            Price = input.nextInt();
                            System.out.println("Cost:");
                            Cost = input.nextInt();
                            System.out.println("Stock:");
                            Stock = input.nextInt();
                            System.out.println("""
                                    Category:
                                    1.Fruits
                                    2.Vegetables
                                    3.Dairy
                                    4.Bakery
                                    5.Beverages
                                    Enter your choice:
                                    """);
                            CategoryOpt = input.nextInt();
                            if (CategoryOpt == 1) {
                                Category = "Fruits";
                            } else if (CategoryOpt == 2) {
                                Category = "Vegetables";
                            } else if (CategoryOpt == 3) {
                                Category = "Dairy";
                            } else if (CategoryOpt == 4) {
                                Category = "Bakery";
                            } else if (CategoryOpt == 5) {
                                Category = "Beverages";
                            }
                            item = new Items();
                            item.addItem(Id, Name, Price, Cost);
                            item.setCategory(Category);
                            item.setQty(Stock);
                            itemArray[iCounter] = item;
                            iCounter++;
                            System.out.println("Item Info Added Successfully....");
                            break;
                        case 2:
                            //Edit Item
                            System.out.println("*** Edit Items ***");
                            System.out.println("Which item do you want to edit, enter Id:");
                            editId = input.nextInt();
                            for (int i = 0; i < iCounter; i++) {
                                if (editId == itemArray[i].getId()) {
                                    System.out.println("What would you like to change");
                                    System.out.println("Price: " + itemArray[i].getPrice());
                                    System.out.println("Cost: " + itemArray[i].getCost());
                                    System.out.println("Stock: " + itemArray[i].getQty());
                                    System.out.println("Category: " + itemArray[i].getCategory());
                                    System.out.println("""
                                            -Price
                                            -Cost
                                            -Stock
                                            -Category
                                            """);
                                    editOpt = input.next();
                                    input.nextLine();
                                    if (editOpt.equalsIgnoreCase("Cost")) {
                                        System.out.println("Enter new cost:");
                                        Cost = input.nextInt();
                                        input.nextLine();
                                        item.setCost(Cost);
                                    } else if (editOpt.equalsIgnoreCase("Price")) {
                                        System.out.println("Enter new price:");
                                        Price = input.nextInt();
                                        item.setPrice(Price);
                                    } else if (editOpt.equalsIgnoreCase("Stock")) {
                                        System.out.println("Enter new Stock:");
                                        Stock = input.nextInt();
                                        item.setQty(Stock);
                                    } else if (editOpt.equalsIgnoreCase("Category")) {
                                        System.out.println("""
                                                    Enter new Category
                                                    1.Fruits
                                                    2.Vegetables
                                                    3.Dairy
                                                    4.Bakery
                                                    5.Beverages
                                                    Enter your choice:
                                                """);
                                        CategoryOpt = input.nextInt();
                                        if (CategoryOpt == 1) {
                                            Category = "Fruits";
                                        } else if (CategoryOpt == 2) {
                                            Category = "Vegetables";
                                        } else if (CategoryOpt == 3) {
                                            Category = "Dairy";
                                        } else if (CategoryOpt == 4) {
                                            Category = "Bakery";
                                        } else if (CategoryOpt == 5) {
                                            Category = "Beverages";
                                        }
                                        item.setCategory(Category);
                                    }
                                }
                                break;
                            }
                            break;
                        case 3:
                            //Delete item
                            System.out.println("*** Delete Items ***");
                            System.out.println("Enter id of item you want to delete:");
                            Id = input.nextInt();
                            for (int i = 0; i < iCounter; i++) {
                                if (Id == itemArray[i].getId()) {
                                    for (int j = i; j < iCounter - 1; j++) {
                                        itemArray[j] = itemArray[j + 1];
                                    }
                                    iCounter--;
                                }
                                break;
                            }
                            System.out.println("Successfully deleted....");
                            break;
                        case 4:
                            //View Item
                            System.out.println("*** View Items ***");
                            for (int i = 0; i < iCounter; i++)
                            {
                                System.out.println("Id: " + itemArray[i].getId());
                                System.out.println("Name: " + itemArray[i].getName());
                                System.out.println("Price: Rs." + itemArray[i].getPrice());
                                System.out.println("Cost: Rs." + itemArray[i].getCost());
                                System.out.println("Stock: " + itemArray[i].getQty());
                                System.out.println("Category: " + itemArray[i].getCategory());
                                System.out.println();
                            }
                            break;
                        case 0:
                            System.out.println("Back to Main Menu");
                            break;
                        default:
                            System.out.println("Error");
                    }
                    break;
                //employee case
                case 2:
                    System.out.println("""
                            ******* Manage Employee *******
                            Press 1 to Add Employee
                            Press 2 to Edit Employee
                            Press 3 to Delete Employee
                            Press 4 to View Employee
                            Press 5 for Star Employee Detials
                            Press 0 to go Back
                            Enter your Choice;
                            """);

                    opt2 = input.nextInt();
                    switch (opt2) {
                        case 1:
                            //add employee
                            System.out.println("*** Add Employee ***");
                            System.out.println("Id");
                            Id = input.nextInt();
                            System.out.println("Name:");
                            Name = input.next();
                            input.nextLine();
                            System.out.println("Designation:");
                            Designation = input.next();
                            input.nextLine();
                            System.out.println("Salary:");
                            salary = input.nextInt();
                            emp = new Employee();
                            emp.setPerson(Id, Name);
                            emp.setDesignation(Designation);
                            emp.setSalary(salary);
                            employeeArray[eCounter++] = emp;
                            System.out.println("Employee Info Added Successfully....");
                            break;
                        case 2:
                            //edit employee
                            System.out.println("*** Edit Employee ***");
                            System.out.println("Which Employee do you want to edit, enter Id:");
                            editId = input.nextInt();
                            for (int i = 0; i < eCounter; i++)
                            {
                                if (editId == employeeArray[i].getId())
                                {
                                    System.out.println("What would you like to change");
                                    System.out.println("Designation: " + employeeArray[i].getDesignation());
                                    System.out.println("Salary: " + employeeArray[i].getSalary());
                                    System.out.println("""
                                            -Designation
                                            -Salary
                                            """);
                                    editOpt = input.next();
                                    input.nextLine();
                                    if (editOpt.equalsIgnoreCase("Salary"))
                                    {
                                        System.out.println("Enter new salary:");
                                        salary = input.nextInt();
                                        emp.setSalary(salary);
                                    }
                                    else if (editOpt.equalsIgnoreCase("Designation"))
                                    {
                                        System.out.println("Enter new designation:");
                                        Designation = input.next();
                                        input.nextLine();
                                        emp.setDesignation(Designation);
                                    }
                                }
                                break;
                            }
                            break;
                        case 3:
                            //delete employee
                            System.out.println("*** Delete Employee ***");
                            System.out.print("Enter of employee you want to delete:");
                            Id = input.nextInt();
                            for (int i = 0; i < eCounter; i++) {
                                if (Id == employeeArray[i].getId()) {
                                    for (int j = i; j < eCounter - 1; j++) {
                                        employeeArray[j] = employeeArray[j + 1];
                                    }
                                }
                                eCounter--;
                                break;
                            }
                            System.out.println("Successfully Deleted...");
                            break;
                        case 4:
                            //view employee
                            System.out.println("*** View Employee ***");
                            for (int i = 0; i < eCounter; i++)
                            {
                                System.out.println("Id:" + employeeArray[i].getId());
                                System.out.println("Name:" + employeeArray[i].getName());
                                System.out.println("Designation:" + employeeArray[i].getDesignation());
                                System.out.println("Salary:Rs." + employeeArray[i].getSalary());
                            }
                            break;
                        case 5:
                            //star employee
                            System.out.println("*** Star Employee ***");
                            starEmpId = emp.computeOrder(orderArray, oCounter);
                            for (int i = 0; i < eCounter; i++)
                            {
                                if (starEmpId == employeeArray[i].getId())
                                {
                                    System.out.println("Id: " + employeeArray[i].getId());
                                    System.out.println("Name: " + employeeArray[i].getName());
                                    System.out.println("Designation: " + employeeArray[i].getDesignation());
                                    System.out.println("Salary:Rs.: " + employeeArray[i].getSalary());
                                    break;
                                }
                                else if (starEmpId == -1)
                                {
                                    System.out.println("No Star Customer Found!");
                                }
                            }
                            System.out.println();
                            break;
                        case 0:
                            System.out.println("Back to Main Menu");
                            break;
                        default:
                            System.out.println("Error");
                    }
                    break;
                //customer case
                case 3:
                    System.out.println("""
                            ******* Manage Customer *******
                            Press 1 to Add Customer
                            Press 2 to Edit Customer
                            Press 3 to Delete Customer
                            Press 4 t View Customer
                            Press 5 for Star Customer Detials
                            Press 0 to go Back
                            Enter your Choice;
                            """);

                    opt2 = input.nextInt();
                    switch (opt2) {
                        case 1:
                            //add customer
                            System.out.println("*** Add Customer ***");
                            System.out.println("Id:");
                            Id = input.nextInt();
                            System.out.println("Name:");
                            Name = input.next();
                            input.nextLine();
                            System.out.println("Account Number:");
                            AccountNum = input.nextInt();
                            System.out.println("Balance:");
                            Balance = input.nextInt();
                            cust = new Customer();
                            cust.setPerson(Id, Name);
                            cust.setCustomerInfo(AccountNum, Balance);
                            customerArray[cCounter++] = cust;
                            System.out.println("Customer Info Added Successfully....");
                            break;
                        case 2:
                            //edit customer
                            System.out.println("*** Edit Customer ***");
                            editId = input.nextInt();
                            for (int i = 0; i < cCounter; i++) {
                                if (editId == customerArray[i].getId()) {
                                    System.out.println("What would you like to change");
                                    System.out.println("Name: " + customerArray[i].getName());
                                    System.out.println("Account Number: " + customerArray[i].getAccountNumber());
                                    System.out.println("Balance: " + customerArray[i].getBalance());
                                    System.out.println("""
                                            -AccountNum
                                            -Balance
                                            """);
                                    editOpt = input.next();
                                    input.nextLine();
                                    if (editOpt.equalsIgnoreCase("AccountNum")) {
                                        System.out.println("Enter new Account Number:");
                                        AccountNum = input.nextInt();
                                        cust.setAccountNumber(AccountNum);
                                    } else if (editOpt.equalsIgnoreCase("Balance")) {
                                        System.out.println("Enter new Balance:");
                                        Balance = input.nextInt();
                                        cust.setBalance(Balance);
                                    }
                                }
                                break;
                            }
                            break;
                        case 3:
                            //delete customer
                            System.out.println("*** Delete Customer ***");
                            System.out.print("Enter Id of customer you want to delete:");
                            Id = input.nextInt();
                            for (int i = 0; i < cCounter; i++) {
                                if (Id == customerArray[i].getId()) {
                                    for (int j = i; j < cCounter - 1; j++) {
                                        customerArray[j] = customerArray[j + 1];
                                    }
                                }
                                cCounter--;
                                break;
                            }
                            System.out.println("Successfully Deleted...");
                            break;
                        case 4:
                            //view customer
                            System.out.println("*** View Customer ***");
                            for (int i = 0; i < cCounter; i++) {
                                System.out.println("Id:" + customerArray[i].getId());
                                System.out.println("Name:" + customerArray[i].getName());
                                System.out.println("Account Number:" + customerArray[i].getAccountNumber());
                                System.out.println("Balance:" + customerArray[i].getBalance());
                            }
                            break;
                        case 5:
                            //star customer
                            System.out.println("*** Star Customer ***");
                            starCustId = cust.computeOrder(orderArray, oCounter);
                            for (int i = 0; i < cCounter; i++)
                            {
                                if (starCustId == customerArray[i].getId())
                                {
                                    System.out.println("Id: " + customerArray[i].getId());
                                    System.out.println("Name: " + customerArray[i].getName());
                                    System.out.println("Account Balance: " + customerArray[i].getBalance());
                                    System.out.println("Account Number: " + customerArray[i].getAccountNumber());
                                }
                                else if (starCustId == -1)
                                {
                                    System.out.println("No Star Customer Found!");
                                }
                            }
                            System.out.println();
                            break;
                        case 0:
                            System.out.println("Back to Main Menu");
                            break;
                        default:
                            System.out.println("Error");
                    }
                    break;
                    //order case
                case 4:
                    System.out.println("""
                            ******* Manage Orders *******
                            Press 1 to Add Orders
                            Press 2 to Edit Orders
                            Press 3 to Delete Orders
                            Press 4 to View Orders
                            Press 5 to View Total Sale in Duration
                            Press 6 to View Hot Selling Item
                            Press 7 to View Total Profit in Duration
                            Press 0 to go Back
                            Enter your Choice;
                            """);

                    opt2 = input.nextInt();
                    switch (opt2) {
                        case 1:
                            //add order
                            System.out.println("*** Add Orders ***");
                            //get order id
                            System.out.println("Enter Order Id:");
                            orderId = input.nextInt();
                            //get employee id
                            System.out.println("Enter the employee Id who's taking order:");
                            eid = input.nextInt();
                            validEmployee = false;
                            for (int i = 0; i < eCounter; i++)
                            {
                                if (eid == employeeArray[i].getId())
                                {
                                    validEmployee = true;
                                    break;
                                }
                            }
                            if (!validEmployee) {
                                System.out.println("Invalid Employee Id");
                                break;
                            }
                            //get customer id
                            System.out.println("Enter the customer Id who's placing order:");
                            cid = input.nextInt();
                            for (int i = 0; i < cCounter; i++) {
                                if (cid == customerArray[i].getId()) {
                                    validCustomer = true;
                                    break;
                                }
                            }
                            if (!validCustomer) {
                                System.out.println("Invalid Customer Id");
                            }
                            //get order date
                            System.out.println("Enter ordered date:(DD-MM-YYYY)");
                            System.out.print("Day:");
                            day = input.nextInt();
                            System.out.print("Month:");
                            month = input.nextInt();
                            System.out.print("Year:");
                            year = input.nextInt();
                            date = new Date(day, month, year);
                            if (!date.isValidDate())
                            {
                                System.out.println("Invalid Date! Please enter a valid date.");
                                break;
                            }
                            //get items in order
                            System.out.println("Enter number of items you want to order:");
                            numItem = input.nextInt();
                            selectedItems = new Items[numItem];
                            //available items in cart
                            System.out.println("**** Items Available ***");
                            for (int i = 0; i < iCounter; i++)
                            {
                                System.out.print("Id:" + itemArray[i].getId());
                                System.out.print("   Name:" + itemArray[i].getName());
                                System.out.print("   Stock:" + itemArray[i].getQty());
                                System.out.print("   Category:" + itemArray[i].getCategory());
                                System.out.println();
                            }
                            //order items
                            for (int i = 0; i < numItem; i++) {
                                System.out.println("Enter Id of items you want to order:");
                                Id = input.nextInt();
                                for (int j = 0; j < iCounter; j++) {
                                    if (Id == itemArray[j].getId()) {
                                        ItemFound = true;
                                        //get quantity of items ordered
                                        System.out.println("Quantity of " + itemArray[j].getName() + ":");
                                        orderedQty = input.nextInt();
                                        if (Qty <= itemArray[j].getQty())
                                        {
                                            selectedItems[i] = itemArray[j];
                                            //updating qty of stock
                                            updatedQty = itemArray[j].getQty() - orderedQty;
                                            itemArray[j].setQty(updatedQty);
                                            itemArray[j].setOrderedQty(orderedQty);
                                            //low selling item check
                                            lowSellingAlert(itemArray[j], threshold);
                                        } else {
                                            System.out.println("Not Sufficient Stock");
                                            break;
                                        }
                                        break;
                                    }
                                }

                                if (!ItemFound) {
                                    System.out.println("Invalid Id,Item not Found");
                                    break;
                                }

                            }
                            order = new Order();
                            order.setCustId(cid);
                            order.setEmpId(eid);
                            order.setOrderId(orderId);
                            order.setItems(selectedItems,numItem);
                            order.setDate(date);
                            orderArray[oCounter++] = order;
                            break;
                        case 2:
                            //edit order
                            System.out.println("*** Edit Order ***");
                            Items[] editedItems = new Items[numItem];
                            System.out.println("Enter Order Id to be edited:");
                            editId = input.nextInt();
                            for (int i = 0; i < oCounter; i++) {
                                if (editId == orderArray[i].getOrderId()) {
                                    editedItems = orderArray[i].getItems();
                                    System.out.println("What would you like to change");
                                    System.out.println("Order Date  : " + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                                    System.out.println("Number of Items ordered : " + editedItems.length);
                                    System.out.println("-----Items Ordered-----");
                                    for (int j = 0; j < editedItems.length; j++) {
                                        System.out.println("Item Id: " + editedItems[j].getId() + "  Name: " + editedItems[j].getName() + "  Quantity: " + editedItems[j].getQty());
                                    }
                                    System.out.println("""
                                            \n What would you like to change:
                                             -NumItems
                                             -Date
                                             -Items
                                            """);
                                    editOpt = input.next();
                                    input.nextLine();
                                    if (editOpt.equalsIgnoreCase("NumItems")) {
                                        System.out.println("Enter new Number of Items:");
                                        Qty = input.nextInt();
                                        orderArray[i].setQty(Qty);
                                        System.out.println("Items Number updated Successfully...");
                                    } else if (editOpt.equalsIgnoreCase("Date")) {
                                        System.out.println("Enter new Order Date :(DDMMYYYY)");
                                        System.out.println("Day:");
                                        day = input.nextInt();
                                        System.out.println("Month:");
                                        month = input.nextInt();
                                        System.out.println("Year:");
                                        year = input.nextInt();
                                        if (!date.isValidDate()) {
                                            System.out.println("Invalid Date! Please enter a valid date.");
                                            break;
                                        }
                                        date = new Date(day, month, year);
                                        System.out.println("Order Date updated Successfully...");
                                    } else if (editOpt.equalsIgnoreCase("Items")) {
                                        System.out.println("""
                                                1.Add New Item
                                                2.Remove Existing Item
                                                """);
                                        editOpt2 = input.nextInt();
                                        if (editOpt2 == 1) {
                                            System.out.println("----Add New Item---");
                                            System.out.println("Item Id To Be Added: ");
                                            Id = input.nextInt();
                                            for (int j = 0; j < iCounter; j++) {
                                                if (Id == itemArray[j].getId()) {
                                                    System.out.println("Quantity of " + itemArray[j].getName() + ":");
                                                    Qty = input.nextInt();
                                                    Items[] updatedItems = new Items[editedItems.length + 1];
                                                    for (int k = 0; k < editedItems.length; k++) {
                                                        updatedItems[k] = editedItems[k];
                                                    }
                                                    updatedItems[updatedItems.length - 1] = new Items(itemArray[j].getId(), itemArray[j].getName(), Qty);
                                                    orderArray[i].setItems(updatedItems,updatedItems.length);
                                                }
                                                System.out.println("Item added successfully.");
                                                break;
                                            }
                                        } else if (editOpt2 == 2) {
                                            System.out.println("----Remove Existing Item---");
                                            System.out.println("Enter id of item you want to delete:");
                                            Id = input.nextInt();
                                            for (int j = 0; j < editedItems.length; j++) {
                                                if (Id == editedItems[j].getId()) {
                                                    for (int k = 0; k < editedItems.length - 1; k++) {
                                                        editedItems[k] = editedItems[k + 1];
                                                    }
                                                    editedItems[editedItems.length - 1] = null;
                                                    orderArray[i].setItems(editedItems,editedItems.length);
                                                    break;
                                                }
                                            }
                                            System.out.println("Successfully deleted....");
                                            break;
                                        }
                                        else
                                        {
                                            System.out.println("Order number not found");
                                        }
                                    }
                                    break;
                                }//end of oCounter loop
                                break;
                            }
                            break;
                        case 3:
                            //delete order
                            System.out.println("*** Delete Order ***");
                            System.out.print("Enter Id of order you want to delete:");
                            Id = input.nextInt();
                            for (int i = 0; i < oCounter; i++) {
                                if (Id == orderArray[i].getOrderId()) {
                                    for (int j = i; j < oCounter - 1; j++) {
                                        orderArray[j] = orderArray[j + 1];
                                    }
                                    oCounter--;
                                    break;
                                }
                            }
                            System.out.println("Successfully Deleted...");
                            break;
                        case 4:
                            //order report
                            System.out.println("*************** Order Report ****************");
                            System.out.println("""
                                    You want to view order of:
                                    1.Employee
                                    2.Customer
                                    """);
                            viewOrderOpt = input.nextInt();
                            //order by employee
                            if (viewOrderOpt == 1)
                            {
                                System.out.println("Order taken by Employee,Enter Employee Id:");
                                eid = input.nextInt();
                                for (int i = 0; i < oCounter; i++) {
                                    if (eid == orderArray[i].getEmpId()) {
                                        System.out.println("Order Id        :" + orderArray[i].getOrderId());
                                        System.out.println("Customer Id     :" + orderArray[i].getCustId());
                                        System.out.println("Order Date      :" + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());

                                        System.out.println("Items Ordered:");
                                        for (int j = 0; j < orderArray[i].getCounter(); j++) {
                                            System.out.println("-----Item Number " + (j + 1) + "-----");
                                            System.out.println("Item Id:" + orderArray[i].getItems()[j].getId());
                                            System.out.println("Name   :" + orderArray[i].getItems()[j].getName());
                                            System.out.println("Price  :" + orderArray[i].getItems()[j].getPrice());
                                            System.out.println("Quantity  :" + orderArray[i].getItems()[j].getOrderedQty());
                                            System.out.println("Category  :" + orderArray[i].getItems()[j].getCategory());
                                        }
                                        //total bill of order
                                        bill = order.calculateSingleBill(orderArray[i], itemArray, iCounter);
                                        System.out.println("Bill:" + bill);
                                        orderArray[i].setBill(bill);

                                    }
                                }
                                //order by customer
                            } else if (viewOrderOpt == 2) {
                                System.out.println("Order placed by Customer,Enter Customer Id:");
                                cid = input.nextInt();
                                for (int i = 0; i < oCounter; i++) {
                                    if (cid == orderArray[i].getCustId()) {
                                        System.out.println("Order Id     :" + orderArray[i].getOrderId());
                                        System.out.println("Customer Id  :" + orderArray[i].getCustId());
                                        System.out.println("Order Date      :" + date.getDay() + "-" + date.getMonth() + "-" + date.getYear());
                                        System.out.println("Items Ordered:");
                                        for (int j = 0; j < orderArray[i].getCounter(); j++) {
                                            System.out.println("-----Item Number " + (j + 1) + "-----");
                                            System.out.println("Item Id:" + orderArray[i].getItems()[j].getId());
                                            System.out.println("Name   :" + orderArray[i].getItems()[j].getName());
                                            System.out.println("Price  :Rs." + orderArray[i].getItems()[j].getPrice());
                                            System.out.println("Quantity  :" + orderArray[i].getItems()[j].getQty());
                                            System.out.println("Category  :" + orderArray[i].getItems()[j].getCategory());
                                        }
                                        //total bill of order
                                        bill = order.calculateSingleBill(orderArray[i], itemArray, iCounter);
                                        System.out.println("Bill:Rs." + bill);
                                        orderArray[i].setBill(bill);
                                    }
                                }
                            } else {
                                System.out.println("Id not found");
                            }
                            break;
                        case 5:
                            //total sale in  duration
                            System.out.println("----Total Sale in Duration----");
                            //start of evaluation date
                            System.out.println("Enter starting date of sales evaluation:");
                            System.out.println("Day: ");
                            day = input.nextInt();
                            System.out.println("Month: ");
                            month = input.nextInt();
                            System.out.println("Year: ");
                            year = input.nextInt();
                            startDate = new Date(day, month, year);

                            if (!startDate.isValidDate()) {
                                System.out.println("Invalid Start Date!");
                                break;
                            }
                            //end of evaluation date
                            System.out.println("Enter ending date of sales evaluation::");
                            System.out.println("Day: ");
                            day = input.nextInt();
                            System.out.println("Month: ");
                            month = input.nextInt();
                            System.out.println("Year: ");
                            year = input.nextInt();
                            endDate = new Date(day, month, year);

                            if (!endDate.isValidDate()) {
                                System.out.println("Invalid End Date!");
                                break;
                            }
                            int totalSale = 0;
                            boolean isInRange = false;
                            //calculating total sale
                            for (int i = 0; i < oCounter; i++)
                            {
                                isInRange = orderArray[i].getDate().compareDate(startDate, endDate);

                                if (isInRange)
                                {
                                    totalSale += orderArray[i].calculateBill(orderArray, oCounter, iCounter);
                                }

                            }
                            System.out.println("Sales between " + startDate.getDay() + "-" + startDate.getMonth() + "-" + startDate.getYear()
                                    + " to " + endDate.getDay() + "-" + endDate.getMonth() + "-" + endDate.getYear() + ":"+totalSale);
                            break;
                        case 6:
                            //hot selling item
                            System.out.println("------Hot Selling Item-------");
                            hotSell = order.highSellingItem(orderArray, oCounter, itemArray, iCounter);//return hotselling items index
                            if (hotSell != -1) {
                                System.out.println("Item ID   : " + itemArray[hotSell].getId());
                                System.out.println("Name      : " + itemArray[hotSell].getName());
                                System.out.println("Category  :" + itemArray[hotSell].getCategory());
                                System.out.println("Price     :" + itemArray[hotSell].getPrice());
                            } else {
                                System.out.println("No items have been sold yet.");
                            }
                            break;
                        case 7:
                            //total profit in duration calculation
                            System.out.println("------Total Profit in Duration-------");
                            //starting date of evaluation
                            System.out.println("Enter starting date of profit evaluation:");
                            System.out.println("Day: ");
                            day = input.nextInt();
                            System.out.println("Month: ");
                            month = input.nextInt();
                            System.out.println("Year: ");
                            year = input.nextInt();
                            startDate = new Date(day, month, year);

                            if (!startDate.isValidDate()) {
                                System.out.println("Invalid Start Date!");
                                break;
                            }
                            //ending date of evaluation
                            System.out.println("Enter ending date of profit evaluation::");
                            System.out.println("Day: ");
                            day = input.nextInt();
                            System.out.println("Month: ");
                            month = input.nextInt();
                            System.out.println("Year: ");
                            year = input.nextInt();
                            endDate = new Date(day, month, year);

                            if (!endDate.isValidDate()) {
                                System.out.println("Invalid End Date!");
                                break;
                            }
                            //total profit calculation
                            for (int i = 0; i < oCounter; i++)
                            {
                                isInRange = orderArray[i].getDate().compareDate(startDate, endDate);
                                if (isInRange) {
                                    totalProfit = orderArray[i].calculateProfit(orderArray, oCounter, iCounter, itemArray);

                                }
                            }

                            System.out.println("Total Profit in Duration: " + totalProfit);
                            break;
                        case 0:
                            System.out.println("Back to Main Menu");
                            break;
                        default:
                            System.out.println("Error");
                    }
                    break;
                case 5:
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Error");
            }

        }
    }
        //low selling alert
    public static void lowSellingAlert(Items items ,int threshold)
    {
        if(items.getQty() < threshold)
        {
            System.out.println("ALERT :");
            System.out.println("Item "+items.getName()+" is running low!");
            System.out.println("Current Stock: "+ items.getQty());

        }
    }



}

