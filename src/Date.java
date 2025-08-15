public class Date
{
    private int month;
    private int year;
    private int day;

    public Date()
    {
        month = 0;
       year = 0;
       day = 0;
    }


    public Date(int day,int month,int year)
    {
        this.month = month;
        this.year = year;
        this.day = day;
    }
    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //method finding valid date
    public boolean isValidDate()
    {
        if (month < 1 || month > 12 || day < 1 || day > 31 || year < 2000 || year > 2024) {
            return false;
        }
        return true;
    }

    //method comparing start and end dates
    public boolean compareDate(Date startDate, Date endDate)
    {
        //checking year
        if(this.year < startDate.year || this.year > endDate.year)
        {
            return false;
        }
        //checking months
        if (this.year == startDate.year && this.month < startDate.month) {
            return false;
        }
        if (this.year == endDate.year && this.month > endDate.month) {
            return false;
        }
        //checking date
        if (this.year == startDate.year && this.month == startDate.month && this.day < startDate.day) {
            return false;
        }
        if (this.year == endDate.year && this.month == endDate.month && this.day > endDate.day) {
            return false;
        }//if months same then compare days
        return true;
    }

}
