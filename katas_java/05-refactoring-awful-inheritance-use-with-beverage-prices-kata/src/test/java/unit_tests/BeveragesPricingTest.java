package unit_tests;

import beverages.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class BeveragesPricingTest {
    @Test
    public void computes_coffee_price() {
        Beverage coffee = new Coffee();
        assertThat(coffee.price(), is(closeTo(1.20, 0.001)));
    }

    @Test
    public void computes_tea_price() {
        Beverage tea = new Tea();
        assertThat(tea.price(), is(closeTo(1.50, 0.001)));
    }

    @Test
    public void computes_hot_chocolate_price() {
        Beverage hotChocolate = new HotChocolate();
        assertThat(hotChocolate.price(), is(closeTo(1.45, 0.001)));
    }

    @Test
    public void computes_tea_with_milk_price() {
        Tea teaWithMilk = new TeaWithMilk();
        assertThat(teaWithMilk.price(), is(closeTo(1.60, 0.001)));
    }

    @Test
    public void computes_coffee_with_milk_price() {
        Coffee coffeeWithMilk = new CoffeeWithMilk();
        assertThat(coffeeWithMilk.price(), is(closeTo(1.30, 0.001)));
    }

    @Test
    public void computes_coffee_with_milk_and_cream_price() {
        Coffee coffeeWithMilkAndCream = new CoffeeWithMilkAndCream();
        assertThat(coffeeWithMilkAndCream.price(), is(closeTo(1.45, 0.001)));
    }

    @Test
    public void computes_hot_chocolate_with_cream_price() {
        HotChocolateWithCream hotChocolateWithCream = new HotChocolateWithCream();
        assertThat(hotChocolateWithCream.price(),  is(closeTo(1.60, 0.001)));
    }

    // New tests for decorators
    @Test
    public void computes_tea_with_milk_price_using_decorator() {
        Beverage teaWithMilk = new WithMilk(new Tea());
        assertThat(teaWithMilk.price(), is(closeTo(1.60, 0.001)));
    }

    @Test
    public void computes_hot_chocolate_with_cream_price_using_decorator() {
        Beverage hotChocolateWithCream = new WithCream(new HotChocolate());
        assertThat(hotChocolateWithCream.price(),  is(closeTo(1.60, 0.001)));
    }

    // New tests for restrictions
    @Test
    public void can_only_add_milk_once_to_tea() {
        Beverage teaWithMilk = new WithMilk(new WithMilk(new Tea()));
        assertThat(teaWithMilk.price(), is(closeTo(1.60, 0.001)));
    }

    @Test
    public void cannot_add_cream_to_tea() {
        Beverage teaWithCream = new WithCream(new Tea());
        assertThat(teaWithCream.price(), is(closeTo(0, 0.001)));
    }
}
