public abstract class Person implements OrderProcessing
{
    private int Id;
    private String Name;

    Person()
    {
        Id = 0;
        Name = "";
    }

    public void setPerson(int Id,String Name)
    {
        this.Id = Id;
        this.Name = Name;
    }
    public int getId()
    {
        return Id;
    }
    public String getName()
    {
        return Name;
    }


}
