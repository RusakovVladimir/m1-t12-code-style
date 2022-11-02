import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double initialAmount,
                                   double percentagePerYear, int years) {
        double pay = initialAmount * Math.pow((1 + percentagePerYear / 12), 12 * years);
        return roundedPercent(pay, 2);
    }
    double calculateSimplePercent(double amount,double yearRate, int years) {
        return roundedPercent(amount + amount * yearRate * years, 2);
    }
    double roundedPercent(double value, int precision) {
        double scale = Math.pow (10, precision);
        return Math.round(value * scale) / scale;
    }

    void calculateContribution() {
        int depositTerm;
        int action;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        depositTerm = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double investmentResult = 0;

        if (action == 1) {
            investmentResult = calculateSimplePercent(amount, 0.06, depositTerm);
        } else if (action == 2) {
            investmentResult = calculateComplexPercent(amount, 0.06, depositTerm);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositTerm + " лет превратятся в " + investmentResult);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateContribution();
    }
}
