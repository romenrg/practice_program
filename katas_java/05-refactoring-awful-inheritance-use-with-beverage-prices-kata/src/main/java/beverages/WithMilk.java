package beverages;

public class WithMilk implements Beverage {
    Beverage rawBeverage;
    public  WithMilk(Beverage beverage) {
        rawBeverage = beverage;
    }
    @Override
    public double price() {
        return rawBeverage.price() + 0.10;
    }
}
