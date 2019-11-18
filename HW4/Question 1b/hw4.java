class SyncAcc implements Runnable {

private Account acct = new Account();

public static void main(String[] args) {

SyncAcc r = new SyncAcc();

Thread one = new Thread(r);

Thread two = new Thread(r);

one.setName("first-user");

two.setName("second-user");

one.start();

two.start();

}

@Override

public void run() {

for (int num = 0; num < 5; num++) {

makeTransfer(10);

if (acct.showBalance() < 0) {

System.out.println("overdrawn!");

}

}

}

private synchronized void makeTransfer(int amt) {

if (acct.showBalance() >= amt) {

System.out.println(Thread.currentThread().getName() + " is going to drawn");

try {

Thread.sleep(100);

} catch (InterruptedException ex) {

}

acct.drawn(amt);

System.out.println(Thread.currentThread().getName() + " completes the drawnal");

} else {

System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to drawn " + acct.showBalance());

}

}

}

class Account {

private int balance = 50;

public int showBalance() {

return balance;

}

public void drawn(int amount) {

balance = balance - amount;

}

}

