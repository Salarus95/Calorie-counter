public class StepTracker {
    int[][] days = new int[12][30];
    Converter converter = new Converter();

    public void saveSteps(int month, int day, int steps) {
        days[month - 1][day - 1] = steps;
    }
    void getSteps(int month) { //Выводит шаги по дням
        for (int i = 0; i < days[month - 1].length; i++) {
            System.out.println((i + 1) +" день: " + days[month - 1][i] + " шагов. ");
        }
    }
    int allSteps (int month) { //Выводит общее количество шагов
        int sumStep = 0;
        for (int i = 0; i < days[month-1].length; i++) {
            sumStep = sumStep + days[month - 1][i];
        }
        return sumStep;
    }
    int maxSteps(int month) { //Выводит максимальное количестко щагов
        int maxSteps = 0;
        for (int i = 0; i < days[month-1].length; i++) {
            if (days[month - 1][i] > maxSteps) {
                maxSteps = days[month - 1][i];
            }
        }
        return maxSteps;
    }
    void distance (int month) {
        double distance = (allSteps(month) * converter.setDistance()) / 10000;
        System.out.println("Пройденная дистанция:"+ distance +" км.");
    }
    void calories (int month) {
        double calories = (allSteps(month) * converter.setCalories()) / 1000;
        System.out.println("Количество сожжённых килокалорий: "+ calories +" кКал.");
    }
    void bestSeries (int month, int goalStep) {
        int bestSeries = 0;
        for (int i = 0; i < days[month - 1].length; i++) {
            if (days[month - 1][i] >= goalStep) {
                bestSeries = bestSeries + 1;
            } else if (days[month - 1][i] < goalStep) {
                bestSeries = bestSeries;
            }
        }
        System.out.println("Лучшая серия: "+ bestSeries);
    }
}