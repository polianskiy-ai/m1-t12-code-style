import java.util.Scanner;

public class DepositCalculator {
    double getComplexPercent(double amount, double yearRate, int depositPeriod) {
        double sum = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return round(sum, 2);
    }

    double getSimplePercent(double amount, double yearRate, int depositPeriod) {
        double sum = amount+amount * yearRate * depositPeriod;

        return round(sum, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void doJob() {
        int amount;
        int period;
        int action;
        double finalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

            if (action == 1) {
                finalAmount = getSimplePercent(amount, 0.06, period);
            } else if (action == 2) {
                finalAmount = getComplexPercent(amount, 0.06, period);
            }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + finalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().doJob();
    }

}
