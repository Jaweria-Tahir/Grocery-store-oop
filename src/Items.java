public class Items
{
    private int Id;
    private String Name;
    private int Qty;
    private int Cost;
    private int Price;
    private String Category;
    private int orderedQty;
    Items()
    {
        Id= 0;
        Name= "";
        Qty= 0;
        Cost= 0;
        Price= 0;
        Category = "";
        orderedQty = 0;
    }

    public Items(int Id, String Name, int Qty)
    {
        this.Id= Id;
        this.Name= Name;
        this.Qty= Qty;
    }

    //addItem1
    public void addItem(int Id,String Name,int Price,int Cost)
    {
        this.Id = Id;
        this.Name = Name;
        this.Price=Price;
        this.Cost = Cost;
    }

    void setCategory(String Category)
    {
        this.Category = Category;
    }
    String getCategory()
    {
        return Category;
    }

    public int getId(){
        return Id;
    }

    public int getPrice() {
        return Price;
    }

    public int getQty() {
        return Qty;
    }

    public int getCost() {
        return Cost;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public void setOrderedQty(int orderedQty)
    {
        this.orderedQty = orderedQty;
    }

    public int getOrderedQty() {
        return orderedQty;
    }


}
