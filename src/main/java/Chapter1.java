import java.util.Arrays;
import java.util.List;

/**
 * User: adahotre
 * Date: 8/14/13
 */
public class Chapter1 {
  public static void main(String[] args) {
    final List<Integer> prices = Arrays.asList(10, 30, 17, 20, 15, 18, 45, 12);

    //Old way
    double totalOfDiscountedPrices = 0.0;
    for(int price : prices) {
      if(price > 20) totalOfDiscountedPrices += price * 0.9;
    }
    System.out.println("totalOfDiscountedPrices = " + totalOfDiscountedPrices);

    //New Way
    totalOfDiscountedPrices = prices.stream()
        .filter(price -> price > 20)
        .mapToDouble(price -> price * 0.9)
        .sum();
    System.out.println("totalOfDiscountedPrices = " + totalOfDiscountedPrices);
  }
}
