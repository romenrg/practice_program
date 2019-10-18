package beverages;

public class WithCream extends BeverageDecorator implements Beverage {
    public WithCream(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double price() {
        return rawBeverage.price() + 0.15;
    }
}
