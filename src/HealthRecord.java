public class HealthRecord {
    private int height;

    private static final int MIN_PERMITTED_HEIGHT = 30;
    private static final int MAX_PERMITTED_HEIGHT = 275;
    private static final int DEFAULT_HEIGHT = 165;

    private static int tallestHeight = MIN_PERMITTED_HEIGHT;
    private static int shortestHeight = MAX_PERMITTED_HEIGHT;

    private static int counter = 0;       // number of HealthRecord objects created
    private static double averageHeight;  // running average height (cm) across all objects

    public HealthRecord(int height) {
        setHeight(height);
        counter++;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        if (height > MIN_PERMITTED_HEIGHT && height < MAX_PERMITTED_HEIGHT) {
            this.height = height;

            if (this.height > tallestHeight) {
                tallestHeight = this.height;
            }
            if (this.height < shortestHeight) {
                shortestHeight = this.height;
            }
        } else {
            this.height = DEFAULT_HEIGHT;
        }


        averageHeight = (averageHeight * counter + this.height) / (counter + 1);
    }

    public static int getTallestHeight() {
        return tallestHeight;
    }

    public static int getShortestHeight() {
        return shortestHeight;
    }

    public static double getAverageHeight() {
        return averageHeight;
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }

    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.printf("The average height (cm): %.2f%n", getAverageHeight());
    }
}

