package others;
public class PerformanceTest {
    public static void main(String[] args) {
        int iterations = 10000;

        long startTimeSB = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("AIET");
        }
        long endTimeSB = System.nanoTime();
        long durationSB = endTimeSB - startTimeSB;
        System.out.println("Time taken by StringBuffer: " + durationSB + " nanoseconds");

        long startTimeSBldr = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("AIET");
        }
        long endTimeSBldr = System.nanoTime();
        long durationSBldr = endTimeSBldr - startTimeSBldr;
        System.out.println("Time taken by StringBuilder: " + durationSBldr + " nanoseconds");

        if (durationSB > durationSBldr) {
            System.out.println("StringBuilder is faster than StringBuffer.");
        } else {
            System.out.println("StringBuffer is faster than StringBuilder.");
        }
    }
}
