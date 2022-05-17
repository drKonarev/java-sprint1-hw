import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput==1){
                stepTracker.enterSteps();
            }else {
                if (userInput==2){
                    stepTracker.showResults();
                } else {
                    if (userInput==3){
                        stepTracker.changeGoal();
                    } else {
                        System.out.println ("Такой команды нет, поторите ввод команды.");
                    }
                }
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        scanner.close();
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Привет, выбери команду:"+
                "\n1 - ввести количество шагов за день." +
                "\n2 - показать статистику."+
                "\n3 - изменить цель по количеству шагов в день."+
                "\n0 -закончить работу приложения.");
    }
}