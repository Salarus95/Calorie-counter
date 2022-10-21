public class Converter {
    double rateDistance;
    double rateCalories;

    Converter (double distance, double calories) {
        rateDistance = distance;
        rateCalories = calories;
    }
    void convert(double allSteps) {
        System.out.println("Пройденная дистанция: "+ (allSteps * rateDistance) +" км.");
        System.out.println("Количество сожжённых килокалорий: "+ (allSteps * rateCalories) +" кКал.");
    }
}
