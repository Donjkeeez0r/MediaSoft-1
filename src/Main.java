public class Main {
    public static void main(String[] args) {

        //проверка
        BankAccount account1 = new BankAccount("Artem");
        BankAccount account2 = new BankAccount("Daniil");

        //метод deposit
        System.out.println("Депозит 100 на 1 аккаунт: " + account1.deposit(100));
        System.out.println("Баланс 1 аккаунта: " + account1.balance + "\n");

        //метод withdraw
        System.out.println("Вывод 52 с 1 аккаунта: " + account1.withdraw(52));
        System.out.println("Баланс 1 аккаунта после вывода: " + account1.balance + "\n");

        //проверка вывода больше, чем есть на аккаунте
        System.out.println("Вывод больше чем доступно (должен быть false): " + account1.withdraw(100) + "\n");

        //метод transfer
        System.out.println("Перевод 10 с 1 аккаунта на 2 аккаунт: " + account1.transfer(account2, 10));
        System.out.println("Баланс 1 аккаунта после перевода: " + account1.balance);
        System.out.println("Баланс 2 аккаунта после пополнения: " + account2.balance + "\n");

        //проверка перевести больше, чем есть на аккаунте
        System.out.println("Перевод больше, чем есть на аккаунте (должен быть false): " + account1.transfer(account2, 1000) + "\n");

        //вывод информации о счете (toString)
        System.out.println(account1);
        System.out.println(account2 + "\n");

        System.out.println("Совпадает ли 1 аккаунт со 2 аккаунтом номерами счета: " + account1.equals(account2));

    }
}
