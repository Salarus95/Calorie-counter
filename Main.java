import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        int goalStep = 10000; //Цель на каждый день
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (userInput != 0) { // обработка разных случаев
            if (userInput == 1) {
                System.out.println("За какой месяц вы хотите ввести шаги?");
                int month = scanner.nextInt(); {
                    while (true) {
                        if (month > 12 || month < 1) {
                            System.out.println("Номер месяца не может быть меньше 1 и больше 12.");
                            month = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                }
                System.out.println("За какой день вы хотите ввести шаги?");
                int day = scanner.nextInt(); {
                    while (true) {
                        if (day > 30 || day < 1) {
                            System.out.println("Номер дня не может быть меньше 1 и больше 30.");
                            day = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                }
                System.out.println("Введите количество шагов:");
                int steps = scanner.nextInt(); {
                    while (true) {
                        if (steps >= goalStep) {
                            System.out.println("Прекрасный результат, продолжайте в том же духе!");
                            break;
                        } else if (steps < 0) {
                        System.out.println("Количество шагов не может быть отрицательным значением.");
                        steps = scanner.nextInt();
                        } else {
                            int result = goalStep - steps;
                            System.out.println("Для выполнения дневной цели не хватило:" + result + " шагов.");
                            break;
                        }
                    }
                }
                stepTracker.saveSteps(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("За какой месяц напечатать статистику?");
                int month = scanner.nextInt(); {
                    while (true) {
                        if (month > 12 || month < 1) {
                            System.out.println("Номер месяца не может быть меньше 1 и больше 12.");
                            month = scanner.nextInt();
                        } else {
                            break;
                        }
                    }
                }
                stepTracker.getSteps(month);
                System.out.println("Общее количество шагов за месяц:"+ stepTracker.allSteps(month));
                System.out.println("Максимальное пройденное количество шагов в месяце:" + stepTracker.maxSteps(month));
                System.out.println("Среднее пройденное количество шагов в месяце:" + (stepTracker.allSteps(month)) / 2);
                stepTracker.distance(month);
                stepTracker.calories(month);
                stepTracker.bestSeries(month, goalStep);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель:");
                int newDayGoal = scanner.nextInt();
                while (true) {
                    if (newDayGoal > 0) {
                        goalStep = newDayGoal;
                        System.out.println("Новая цель:" + goalStep + " шагов в день.");
                        break;
                    } else {
                        System.out.println("Некорректный ввод.");
                        newDayGoal = scanner.nextInt();
                    }
                }
            } else if (userInput == 4) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
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