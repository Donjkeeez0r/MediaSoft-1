import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;


public class BankAccount {

    //поля класса
    String owners_name;
    int balance;
    LocalDateTime opening_date;
    boolean balance_blocked;
    String number;

    //конструктор
    BankAccount (String owners_name) {
        this.owners_name = owners_name;
        this.balance = 0;
        this.opening_date = LocalDateTime.now();
        this.balance_blocked = false;
        this.number = generateNumber();
    }

    //методы
    //метод для генерации номера счета
    public String generateNumber() {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }



    public boolean deposit (int amount) {
        if (amount > 0 && !balance_blocked) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw (int amount) {
        if (amount > 0 && balance >= amount && !balance_blocked) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer (BankAccount otherAccount, int amount) {
        if (amount > 0 && !balance_blocked && balance >= amount && !otherAccount.balance_blocked) {
            balance -= amount;
            otherAccount.balance += amount;
            return true;
        }
        return false;
    }

    //метод ToString
    @Override
    public String toString() {
        return "BankAccount (Информация о счете): {Имя владельца: " + owners_name + ", " +
                "Баланс счета: " + balance + ", " +
                "Дата открытия счета: " + opening_date + ", " +
                "Заблокирован ли счет: " + balance_blocked + " " +
                "Номер счета: " + number + "}";
    }

    //метод equals, сравнивает с номером счета
    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof BankAccount) {
            BankAccount other = (BankAccount) obj;
            return this.number.equals(other.number);
        } else {
            return false;
        }
    }





}
