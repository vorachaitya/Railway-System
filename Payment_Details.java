package railway_system;
import java.util.*;
public class Payment_Details {

//	generating an otp of 6-digit
	int get_otp()
	{
		int num=(int)Math.floor(Math.random()*900000.0)+100000;
		return num;
	}
	
//	void verify if entered otp is correct or not
	boolean check_otp(int get_otp,int entered_otp)
	{
		boolean bool=false;
		if(get_otp==entered_otp)
		{
			bool=true;
		}
		return bool;
	}
	
//	enter cvv
	int get_cvv()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter CVV (3-digit number on backside of your card) : ");
		int cvv=sc.nextInt();
		return cvv;
	}
	
//	check cvv if it is of 3-digits only
	boolean check_cvv(int cvv)
	{
		boolean bool=false;
		int digit=0;
		while(cvv>0)
		{
			digit++;
			cvv/=10;
		}
		if(digit==3)
		{
			return true;
		}
		return check_cvv(get_cvv());
	}
	
//	accepting payment via debit/credit cards
	void card_payment(double ticket_fare)
	{
		System.out.println("Payment would be done via your debit/credit card.");
		System.out.println();
		Scanner sc1=new Scanner(System.in);
		System.out.print("Enter card holder's name:");                
		String cardName=sc1.nextLine();
		System.out.print("Enter your Debit/Credit card no :");
        long cardNo=sc1.nextLong();
        System.out.print("Enter expiry month :");
        int cardDate=sc1.nextInt();
        System.out.print("Enter expiry year :");                
        int cardMonth=sc1.nextInt();
        System.out.println();
        System.out.println("Payment of INR " + ticket_fare + " would be done using your card.");
        System.out.println();
        System.out.println("Press 1 to continue payment.");
        System.out.println("Press 0 to decline the payment and exit.");
        int response=sc1.nextInt();
        System.out.println();
        if(response==1)
        {
        	
        int a= get_cvv();
        check_cvv(a);
        int otp=get_otp();
        System.out.println();
        System.out.println("OTP : " + otp);
        System.out.print("Enter above OTP to complete your payment: ");
        int get_otp=sc1.nextInt();
        if(check_otp(otp,get_otp))
        {
        	System.out.println();
        	System.out.println("Congratulations! Your ticket has been booked successfully.");
        }
        else
        {
        	System.out.println("Sorry! You entered wrong OTP.");
        	System.out.println("Your payment stands cancelled.");
        	System.out.println("Visit us again!");
        	System.exit(0);
        }
        }
        else
        {
        	System.out.println("You entered wrong input.");
        	System.out.println("Sorry! Your payment stands cancelled. ");
        	System.out.println("Visit us again!");
        	System.exit(0);
        }
	}
	
//	accepting payment via UPI id
	void upi_id(double ticket_fare)
	{
		System.out.println("Payment would be done via your UPI ID.");
		Scanner sc1=new Scanner(System.in);
		System.out.print("Enter upi id: ");
		String upi=sc1.nextLine();
		System.out.print("Enter your password: ");
		String password=sc1.nextLine();
		System.out.println("Payment of INR " + ticket_fare + " would be done using your UPI ID.");
		System.out.println("Press 1 to continue payment.");
        System.out.println("Press 0 to decline the payment and exit.");
        int response=sc1.nextInt();
        if(response==1)
        {
        	
        int otp=get_otp();
        System.out.println("OTP : " + otp);
        System.out.print("Enter above OTP to complete your payment: ");
        int get_otp=sc1.nextInt();
        if(check_otp(otp,get_otp))
        {
        	System.out.println();
        	System.out.println("Congratulations! Your ticket has been booked successfully.");
        }
        else
        {
        	System.out.println("Sorry! You entered wrong OTP.");
        	System.out.println("Your payment stands cancelled.");
        	System.out.println("Visit us again!");
        	System.exit(0);
        }
        }
        else
        {
        	System.out.println("You entered wrong input.");
        	System.out.println("Sorry! Your payment stands cancelled. ");
        	System.out.println("Visit us again!");
        	System.exit(0);
        }
	}
	
	public static void main(String[] args)
	{
		Payment_Details obj=new Payment_Details();
		Scanner sc=new Scanner(System.in);
//		int a=obj.get_otp();
//		System.out.println(a);
//		System.out.println("Enter the otp: ");
//		int b=sc.nextInt();
//		System.out.println(obj.check_otp(a,b));
//		int a=obj.get_cvv();
//		System.out.println(obj.check_cvv(a));
//		obj.card_payment();
//		obj.upi_id();
		obj.upi_id(201.5);
	}
}
