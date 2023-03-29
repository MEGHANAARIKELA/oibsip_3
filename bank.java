import java.util.*;
import java.lang.*;
class account{
	double balance;
	String name;String password;
	account(){}
	account(double a,String name,String password)
	{
		  balance=a;
		  this.name=name;
		  this.password=password;
	}
	void credit(double amount)
	{
		balance=balance+amount;
	}
	void debit(double amount)
	{
		if(balance>=amount){
		balance=balance-amount;}
		else
		{
			System.out.println("debit amount exceeded account balance");
		}
	}
	double getBalance()
	{
		return balance;
	}
	String getpassword()
	{
		return this.password;
	}
	void transfer(double amount){
		if(balance>=amount){
		balance=balance-amount;}
		else
		{
			System.out.println("transfer amount exceeded account balance");
		}
	}
}
class bank{
	public static void main(String args[])
	{
		List<account>pawd=new LinkedList<account>();
		//List<String>pawd=new LinkedList<String>();
			Scanner sc=new Scanner(System.in);
			while(true){
			System.out.println("enter your choice 1.create account 2.login 3.exit from the application");
			int r=sc.nextInt();
		//	account a2=new account();
			int ind=1;
			switch(r)
			{
				case 1:
				System.out.println("enter user ID");
				String user=sc.next();
				System.out.println("enter password");
				String pwd=sc.next();
			    account	a2=new account(0.0,user,pwd);
				pawd.add(a2);
				break;
				case 2:
					int f=0;
				List<String>Transact=new LinkedList<String>();
				System.out.println("enter user ID");
				String user2=sc.next();
				System.out.println("enter password");
				String pwd2=sc.next();
				for(int i=0;i<pawd.size();i++){
					//System.out.println(pawd.get(i).password);
				if(user2.equals(pawd.get(i).name) && pwd2.equals(pawd.get(i).password)){
					ind=i;	
				f=1;}
				}
				if(f==1)
				{
					System.out.println("Successfully logged in");
					while(f==1)
					{
						int amount;
					Date d=new Date();
					System.out.print("enter your choice \n1.deposit\n2.withdraw\n3.getbalance \n4.Tranction history \n5.exit\n6.transfer\n");
					int n=sc.nextInt(),ind2=0,f2=0;
					switch(n)
					{
						case 1:
						System.out.println("enter amount");
						amount=sc.nextInt();
						pawd.get(ind).credit(amount);
						Transact.add("your account credited by "+amount+" at"+d.toString());
						break;
						case 2:
						System.out.println("enter amount");
						amount=sc.nextInt();
						pawd.get(ind).debit(amount);
						Transact.add("your account debited by "+amount+" at"+d.toString());
						break;
						case 3:
						System.out.println(pawd.get(ind).getBalance());
						break;
						case 4:
						System.out.println("YOUR ACCOUNT TRANCTIONS");
						for(int i=0;i<Transact.size();i++){
							System.out.println(Transact.get(i));
						}
						break;
						case 5:
						f=0;
						System.out.println("your logged out");
						break;
						case 6:
						System.out.println("enter transfer account details");
						System.out.println("enter user ID");
						String user3=sc.next();
						System.out.println("enter password");
						String pwd3=sc.next();
						for(int i=0;i<pawd.size();i++){
							//System.out.println(pawd.get(i).password);
						if(user3.equals(pawd.get(i).name) && pwd3.equals(pawd.get(i).password)){
							ind2=i;	
							f2=1;
						}}
						if(f2==1)
						{
							System.out.println("enter amount");
							int amount2=sc.nextInt();
							pawd.get(ind).debit(amount2);
								pawd.get(ind2).credit(amount2);
						}
							else{
								System.out.println("account not found");
							}
							break;
						default:
						System.out.println("enter valid option");
						break;
					}
				}}
					else{
						System.out.println("Your account is not in our data if you want to create account enter create");
						break;
					}
			//	account bank=new account(0.0,user,pwd);
			break;
			case 3:
			System.exit(0);
			break;
			default:
			break;
		}
		
		}
	}
	}
			