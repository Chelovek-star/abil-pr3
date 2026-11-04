public class TransferService {

    public void transfer(
            BankAccount from,
            BankAccount to,
            double amount
    ) throws InsufficientFundsException {

        // Проверяем существование счетов
        if (from == null || to == null) {
            throw new IllegalArgumentException("Счета не должны быть пустыми");
        }

        // Проверяем, что счета разные
        if (from == to) {
            throw new IllegalArgumentException(
                    "Нельзя переводить деньги на тот же счёт"
            );
        }

        // Проверяем сумму перевода
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("Некорректная сумма перевода");
        }

        // Проверяем возможность зачисления
        if (!Double.isFinite(to.getBalance() + amount)) {
            throw new IllegalArgumentException("Слишком большая сумма перевода");
        }

        // Списываем деньги у отправителя
        from.withdraw(amount);

        // Зачисляем деньги получателю
        to.deposit(amount);

        System.out.println("Перевод успешно выполнен!");
        System.out.println("Отправитель: " + from.getOwner());
        System.out.println("Получатель: " + to.getOwner());
        System.out.println("Сумма перевода: " + amount);
    }
}