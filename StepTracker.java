public class StepTracker {
    int[][] days = new int[12][30];
    Converter converter = new Converter();

    public void saveSteps(int month, int day, int steps) {
        days[month][day - 1] = steps;
    }
    void getSteps(int month) { //Выводит шаги по дням
        for (int i = 0; i < days[month].length; i++) {
            System.out.print((i + 1) +" день: " + days[month][i] + " шагов, ");
        }
    }
    int allSteps (int month) { //Выводит общее количество шагов
        int sumStep = 0;
        for (int i = 0; i < days[month].length; i++) {
            sumStep = sumStep + days[month][i];
        }
        return sumStep;
    }
    int maxSteps(int month) { //Выводит максимальное количестко щагов
        int maxSteps = 0;
        for (int i = 0; i < days[month].length; i++) {
            if (days[month][i] > maxSteps) {
                maxSteps = days[month][i];
            }
        }
        return maxSteps;
    }
    void distance (int month) {
        double distance = allSteps(month) * converter.setDistance();
        System.out.println("Пройденная дистанция:"+ distance +" км.");
    }
    void calories (int month) {
        double calories = allSteps(month) * converter.setCalories();
        System.out.println("Количество сожжённых килокалорий: "+ calories +" кКал.");
    }
    void bestSeries (int month, int goalStep) {
        int bestSeries = 0;
        int series = 0;
        for (int i = 0; i < days[month].length; i++) {
            if (days[month][i] >= goalStep) {
                series = series + 1;
            } else if (days[month][i] < goalStep) {
                if (series > bestSeries) {
                    bestSeries = series;
                    series = 0;
                }
            }
        }
        System.out.println("Лучшая серия: "+ bestSeries);
    }
}