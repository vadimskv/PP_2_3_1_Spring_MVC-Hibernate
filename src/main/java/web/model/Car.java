package web.model;

public class Car {
    private String model;
    private int count;
    private int year;

    public Car(int count, String model, int year) {
        this.model = model;
        this.count = count;
        this.year = year;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
