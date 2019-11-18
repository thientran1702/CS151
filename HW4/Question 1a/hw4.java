

class NoSyncAcc implements Runnable {

		private Acc acct = new Acc();

		public static void main(String[] args) {

			NoSyncAcc r = new NoSyncAcc();
	
			Thread one = new Thread(r);
			Thread two = new Thread(r);
	
			one.setName("first user");
			two.setName("second user");
	
			one.start();
			two.start();
		}

		@Override

		public void run() {
			for (int num = 0; num < 5; num++) {
				makeTransfer(10);
			if (acct.showBalance() < 0) {
			System.out.println("Over limit!");
			}
		}
		}

		private void makeTransfer(int amt) {

			if (acct.showBalance() >= amt) {
	
			System.out.println(Thread.currentThread().getName() + " is going to drawn");

			try {
			Thread.sleep(100);
			} 
			catch (InterruptedException ex) {
			}
			
		acct.drawn(amt);
		System.out.println(Thread.currentThread().getName() + " withdrawal completed!");
		} 
			else {
				System.out.println("Insufficient balance for " + Thread.currentThread().getName() 
						+ " to withdrawn " + acct.showBalance());
			}

		}
		}

		class Acc {
		private int current_bal = 50;
		public int showBalance() {
			return current_bal;
		}

		public void drawn(int money) {
		current_bal = current_bal - money;
		}
}


