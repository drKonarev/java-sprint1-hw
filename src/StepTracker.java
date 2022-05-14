import java.util.Scanner;

public class StepTracker{
    int goal = 10000;
    Scanner scanner = new Scanner(System.in);


    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12]; // 2. изменить длины конкретных месяцев? почитать про длины массивов
        for (int i = 0; i<monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData  { // stepTracker.monthToData[mounth].tepsPerDay[day] вот так обращаться ко дню
        int [] stepsPerDay = new int[30]; // класс представляет собой массив из дней (то есть - месяц)
    }                   // 1. убрать в скобках 30, оставить пустыми
    void changeGoal(){
        System.out.println("Сейчас Ваша цель - " + goal + " шагов в день." +
                "\n Введите новую цель:");
        goal = scanner.nextInt();
        if (goal<0){
            System.out.println("Количество шагов не может быть отрицательным!");
        } else {
            System.out.println("Сейчас Ваша цель - " + goal + " шагов в день");
        }
    }

    void showResults () {
        System.out.println("За какой месяц нужна статистика?" +
                "\n 1 - январь." +
                "\n 2 - февраль." +
                "\n 3 - март." +
                "\n 4 - апрель." +
                "\n 5 - май." +
                "\n 6 - июнь." +
                "\n 7 - июль." +
                "\n 8 - август." +
                "\n 9 - сентябрь." +
                "\n 10 - октябрь." +
                "\n 11 - ноябрь." +
                "\n 12 - декабрь.");
        int month = scanner.nextInt();
        printChoise();
        int command = scanner.nextInt();
        if (command == 1) {
            stepPerDay(month);
        } else {
            if (command == 2) {
                summSteps(month);
            } else {
                if (command == 3) {
                    maxStep(month);
                } else {
                    if (command == 4) {
                        medSteps(month);
                    } else {
                        if (command == 5) {
                            distance(month);
                        } else {
                            if (command == 6) {
                                kkal(month);
                            } else {
                                if (command == 7) {
                                    sequence(month);
                                } else {
                                    System.out.println("Такой функции нет!");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    void stepPerDay(int month){
        for (int i =0;i<30; i++){
            System.out.println("День "+ i+1+ ":" +monthToData[month-1].stepsPerDay[i] );
        }
    }
    void summSteps(int month){
        int summStepsMonth = 0;
        for (int i =0;i<30; i++){
            summStepsMonth = monthToData[month-1].stepsPerDay[i]+summStepsMonth;
        }
        System.out.println("В выбранный месяц вы прошли " +summStepsMonth+ " шагов.");
    }
    void maxStep(int month){
        int max = 0;
        for (int i =0;i<30; i++){
            if (monthToData[month-1].stepsPerDay[i]>max){
                max = monthToData[month-1].stepsPerDay[i];
            }
        }
        System.out.println("Максимум вы прошли " +max+ " шагов.");
    }
    void medSteps(int month){
        int summStepsMonth = 0;
        for (int i =0;i<30; i++){
            summStepsMonth = monthToData[month-1].stepsPerDay[i]+summStepsMonth;
        }
        System.out.println("Среднее значение пройденных шагов: "+ (summStepsMonth/30));
    }
    void distance( int month){
        int summStepsMonth = 0;
        for (int i =0;i<30; i++){
            summStepsMonth = monthToData[month-1].stepsPerDay[i]+summStepsMonth;
        }
        double distance = summStepsMonth*0.00075;
        System.out.println("За выбранный месяц вы прошли "+ distance+ " километров.");
    }
    void kkal (int month){
        int summStepsMonth = 0;
        for (int i =0;i<30; i++){
            summStepsMonth = monthToData[month-1].stepsPerDay[i]+summStepsMonth;
        }
        System.out.println("За выбранный месяц вы сожгли "+ summStepsMonth*0.05+ " килокалорий.");
    }
    void sequence (int month){
        int seq = 0;
        int max = 0;
        for (int i =0;i<30; i++){
            if (monthToData[month-1].stepsPerDay[i]!=0){
                seq = seq+1;
                if (seq>max){
                    max = seq;
                } /*else {
                max =max;
            }*/

            } else {  seq = 0;
            }
        }
        System.out.println("Лучшая серия составила "+max+" дней!");
    }
    void printChoise (){
        System.out.println("Какие данные Вам нужны?"+
                "\n 1 - количество шагов по дням."+
                "\n 2 - общее количество шагов в месяц."+
                "\n 3 - максимальное пройденное количество шагов в месяц."+
                "\n 4 - среднее количество шагов за месяц."+
                "\n 5 - пройденная дистанция в км."+
                "\n 6 - количество потраченных килокалорий."+
                "\n 7 - лучшая серия дней.");
    }


    void enterSteps (){ // возможно, будет не void
        System.out.println("Выберите месяц:"+
                "\n 1 - январь."+
                "\n 2 - февраль."+
                "\n 3 - март."+
                "\n 4 - апрель."+
                "\n 5 - май."+
                "\n 6 - июнь."+
                "\n 7 - июль."+
                "\n 8 - август."+
                "\n 9 - сентябрь."+
                "\n 10 - октябрь."+
                "\n 11 - ноябрь."+
                "\n 12 - декабрь.");
        int month  = scanner.nextInt();
        System.out.println("Выберите день (всего дней - 30):");
        int day = scanner.nextInt();
        System.out.println("Введите количество пройденных шагов:");
        int steps = scanner.nextInt();
        monthToData[month-1].stepsPerDay[day-1] = steps;
    }
}