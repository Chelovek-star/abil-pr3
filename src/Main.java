import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Создаём два банковских счёта
        BankAccount account1 =
                new BankAccount("ACC001", "Aida", 50000);

        BankAccount account2 =
                new BankAccount("ACC002", "Dana", 10000);

        // Создаём сервис переводов
        TransferService transferService = new TransferService();

        System.out.println("=== СИСТЕМА БАНКОВСКИХ ПЕРЕВОДОВ ===");

        System.out.println("Счёт отправителя: " + account1.getOwner());
        System.out.println("Баланс: " + account1.getBalance());

        System.out.println("Счёт получателя: " + account2.getOwner());
        System.out.println("Баланс: " + account2.getBalance());

        System.out.print("\nВведите сумму перевода: ");

        try {

            // Получаем текст от пользователя
            String input = scanner.nextLine();

            // Преобразуем текст в число
            double amount = Double.parseDouble(input);

            // Выполняем перевод
            transferService.transfer(account1, account2, amount);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Ошибка ввода числа! Введите числовое значение."
            );

        } catch (InsufficientFundsException e) {

            System.out.println("Ошибка: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Ошибка: " + e.getMessage());

        } finally {

            System.out.println("\nОперация перевода завершена.");
        }

        // Показываем итоговые балансы
        System.out.println("\n=== ИТОГОВЫЕ БАЛАНСЫ ===");

        System.out.println(
                account1.getOwner() + ": " + account1.getBalance()
        );

        System.out.println(
                account2.getOwner() + ": " + account2.getBalance()
        );

        scanner.close();
    }
}