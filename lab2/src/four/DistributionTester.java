package four;

public class DistributionTester {

    private NumberGenerator gen;
    private PercentileCalculator cal;

    public DistributionTester(NumberGenerator gen, PercentileCalculator cal) {
        this.gen = gen;
        this.cal = cal;
    }

    public int test(int percentile){
        return cal.calculate(gen.generate(), percentile);
    }

    public static void main(String[] args) {
        NumberGenerator gen = new FibonacciNumberGenerator(10);
        PercentileCalculator cal = new InterpolPC();

//        NumberGenerator gen = new RandomNumberGenerator(50,2, 100);
//        PercentileCalculator cal = new NearestRankPC();

//        NumberGenerator gen = new ConsecutiveNumberGenerator(1,100,1);
//        PercentileCalculator cal = new InterpolPC();

        DistributionTester dt = new DistributionTester(gen, cal);
        for(int i = 10;i<=100;i+=10){
            System.out.println(dt.test(i));
        }
    }
}
