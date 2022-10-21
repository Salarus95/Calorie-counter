import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goalStep = 2; //Цель на каждый день
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter(0.00075, 0.05);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            // обработка разных случаев
            if (userInput == 1) {
                while (true) {
                    int month;
                    System.out.println("За какой месяц хотите ввести шаги?");
                    month = scanner.nextInt();
                    if (month > 11 || month < 0) {
                        System.out.println("Ввод месяца осуществляется от 0 до 11.");
                        continue;
                    }
                    int day;
                    System.out.println("За какой день хотите ввести шаги?");
                    day = scanner.nextInt();
                    if (day > 30 || day < 1) {
                        System.out.println("Номер дня не может быть меньше 1 и больше 30.");
                        continue;
                    }
                    System.out.println("Введите количество шагов:");
                    int steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Количество шагов не может быть отрицательным значением.");
                        continue;
                    } else if (steps >= goalStep) {
                        System.out.println("Прекрасный результат, продолжайте в том же духе!");
                    } else {
                        int result = goalStep - steps;
                        System.out.println("Для выполнения дневной цели не хватило:" + result + " шагов.");
                    }
                    stepTracker.saveSteps(month, day, steps);
                    System.out.println("Данные сохранены!");
                    break;
                }
            } else if (userInput == 2) {
                System.out.println("За какой месяц напечатать статистику?");
                int month = scanner.nextInt();
                if (month > 11 || month < 0) {
                    System.out.println("Ввод месяца осуществляется от 0 до 11.");
                    continue;
                }
                stepTracker.getSteps(month);
                System.out.println("Общее количество шагов за месяц: "+ stepTracker.allSteps(month));
                System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.maxSteps(month));
                System.out.println("Среднее пройденное количество шагов в месяце: " + (stepTracker.allSteps(month)) / 30);
                converter.convert(stepTracker.allSteps(month));
                stepTracker.bestSeries(month, goalStep);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель: ");
                int newDayGoal = scanner.nextInt();
                if (newDayGoal > 0) {
                    goalStep = newDayGoal;
                    System.out.println("Новая цель: " + goalStep + " шагов в день.");
                } else {
                    System.out.println("Некорректный ввод.");
                }
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выйти из приложения.");
    }
}