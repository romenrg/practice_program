package beverages;

public class WithCream implements Beverage {
    Beverage rawBeverage;
    public WithCream(Beverage beverage) {
        rawBeverage = beverage;
    }
    @Override
    public double price() {
        return rawBeverage.price() + 0.15;
    }
}
