import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput==1){
                stepTracker.changeGoal();
            }else {
                if (userInput==2){
                    stepTracker.enterSteps();
                } else {
                    if (userInput==3){
                        stepTracker.showResults();
                    } else {
                        System.out.println ("Такой команды нет, поторите ввод команды.");
                    }
                }
            }

            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Привет, выбери команду:"+
                "\n1 - поставить цель на день." +
                "\n2 - ввести количество шагов за день."+
                "\n3 - показать статистику."+
                "\n0 -закончить работу приложения.");
    }
}