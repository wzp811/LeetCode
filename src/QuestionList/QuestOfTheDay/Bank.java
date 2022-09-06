package QuestionList.QuestOfTheDay;

public class Bank {
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = new long[balance.length];
        for (int i = 0; i < balance.length; i++) this.balance[i] = balance[i];
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!(account1 > 0 && account1 <= balance.length && account2 > 0 && account2 <= balance.length) ||
                balance[account1 - 1] < money) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account <= 0 || account > balance.length) return false;
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account <= 0 || account > balance.length || money > balance[account - 1]) return false;
        balance[account - 1] -= money;
        return true;
    }
}
