public class StepTracker {
    int[][] days = new int[12][30];

    public void saveSteps(int month, int day, int steps) {
        days[month][day-1] = steps;
    }
    void getSteps(int month) { //Возвращает шаги по дням
        for (int i = 0; i < 29; i++) {
            System.out.print((i + 1) +" день: " + days[month][i] + " шагов, ");
        }
        System.out.println("30 день: " + days[month][29] + " шагов. ");
    }
    int allSteps (int month) { //Возвращает общее количество шагов
        int sumStep = 0;
        for (int i = 0; i < 30; i++) {
            sumStep = sumStep + days[month][i];
        }
        return sumStep;
    }
    int maxSteps(int month) { //Возвращает максимальное количестко щагов
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (days[month][i] > maxSteps) {
                maxSteps = days[month][i];
            }
        }
        return maxSteps;
    }
    void bestSeries (int month, int goalStep) {
        int bestSeries = 0;
        int series = 0;
        for (int i = 0; i < 30; i++) {
            if (days[month][i] >= goalStep) {
                series = series + 1;
            } else {
                bestSeries = series;
            }
        }
        if (series > bestSeries) {
            bestSeries = series;
            series = 0;
        }
        System.out.println("Лучшая серия: "+ bestSeries);
    }
}