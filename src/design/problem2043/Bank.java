package design.problem2043;

// Problem 2043 - Simple Bank System
// https://leetcode.com/problems/simple-bank-system/
// Level: Medium

public class Bank {
    private long[] balances;
    private int n;

    private boolean isValidAccount(int account){
        return account >= 1 && account <= n;
    }

    public Bank(long[] balances){
        this.balances = balances;
        this.n = balances.length;
    }

    public boolean transfer(int account1, int account2, long money){
        if(!isValidAccount(account1) || !isValidAccount(account2) || balances[account1 - 1] < money){
            return false;
        }
        balances[account1 - 1] -= money;
        balances[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money){
        if(!isValidAccount(account)) return false;
        balances[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money){
        if(!isValidAccount(account) || balances[account - 1] < money){
            return false;
        }
        balances[account - 1] -= money;
        return true;
    }
}
