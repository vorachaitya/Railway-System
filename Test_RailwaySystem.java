package railway_system;
import java.util.*;
public class Test_RailwaySystem extends User_Details{

	int accept_login()//asks user for which type of login does he want to opt for
	{
		System.out.println("Choose from following numbers to access corresponding login: ");
		System.out.println();
		System.out.println("1.Administration Login");
		System.out.println("2.User Login");
		System.out.println("3.Agent Login");
		System.out.println("4.Exit");
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your choice:");
		int accept=sc.nextInt();
		if(accept>0 && accept<=4)
		{
			return accept;
		}
		return accept_login();
	}
	
	int accept_administrator_choice()//asks administrator to enter which operation he/she wants to performs
	{
		System.out.println("Choose from following numbers to perform corresponding operation: ");
		System.out.println();
		System.out.println("1.Add coach to a train");
		System.out.println("2.Delete coach from a train");
		System.out.println("3.Add a new train to railway system");
		System.out.println("4.Delete a  train from railway system");
		System.out.println("5.Exit");
		System.out.println();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your choice:");
		int accept=sc.nextInt();
		if(accept>0 && accept<=5)
		{
			return accept;
		}
		return accept_administrator_choice();
	}
	
	int accept_payment_choice()//asks for payment method
	{
		System.out.println("Choose from following payment options and enter corresponding number: ");
		System.out.println();
		System.out.println("1.Debit/Credit Cards.");
		System.out.println("2.UPI ID.");
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter your choice:");
		int accept=sc.nextInt();
		if(accept>0 && accept<=2)
		{
			return accept;
		}
		return accept_payment_choice();
	}
	
	void payment(double ticket_fare)
	{
		Test_RailwaySystem trs_obj=new Test_RailwaySystem();//object of Test_RailwaySystem
		Payment_Details p_obj=new Payment_Details();
		int choice=trs_obj.accept_payment_choice();
		System.out.println();
		switch(choice)
		{
		case 1:p_obj.card_payment(ticket_fare);
		break;
		case 2:p_obj.upi_id(ticket_fare);
		break;
		}
	}
	
	void administration()//all operations to be performed by administrator
	{
		Test_RailwaySystem trs_obj=new Test_RailwaySystem();//object of Test_RailwaySystem
		User_Details u_obj=new User_Details();//object of User_Details
		Train_details t_obj=new Train_details();//object of Train_details
		Administration_Login adm_obj=new Administration_Login();//object of Administration_Login
		Agent_Login a_login=new Agent_Login();//object of Agent_Login
		Payment_Details p_obj=new Payment_Details();
		Train_details[] arr=t_obj.forward_journey();//original list of trains
		Scanner sc=new Scanner(System.in);
		
		u_obj.get_captcha();
		System.out.println();
		System.out.println("You have access to Administration Login");
	System.out.println();
	int choice=trs_obj.accept_administrator_choice();
	switch(choice)//switch loop based on operations performed by administrator
	{
	
	case 1:System.out.println("You want to add coach to a train");//adding a coach
	System.out.println();
	System.out.println("Following is list of trains:");//displaying trains before addition of coach
	for(int i=0;i<arr.length-1;i++)
	{
		System.out.print(arr[i].head.PNR_NO + "\t");
		t_obj.show(arr[i].head);
		System.out.println();
	}
	System.out.println();
	System.out.print("Enter Train Number into which you want to add the coach:");
	long add_coach=sc.nextLong();
	System.out.println();
	u_obj.make_bst(arr, add_coach);
	int otp=p_obj.get_otp();
    System.out.println("OTP : " + otp);
    System.out.print("Enter above OTP to proceed: ");
    int get_otp=sc.nextInt();
    System.out.println();
    if(!p_obj.check_otp(otp,get_otp))
    {
    	System.out.println("Sorry! You entered incorrect OTP.");
    	System.out.println("Coach could not be added.");
    	System.out.println("-----Exit-----");
    	System.exit(0);
    }
	System.out.println("Original number of seats in Train Number " + add_coach + " is " + arr[0].head.no_of_seats);
	System.out.println();
	adm_obj.add_coach(add_coach);
	System.out.println();
	System.out.println("Congratulations! New coach has been added successfully.");
	break;//end of addition of coach
	
	case 2:System.out.println("You want to delete coach from a train");//deleting a coach
	System.out.println();
	System.out.println("Following is list of trains:");//displaying trains before deletion of coach
	for(int i=0;i<arr.length-1;i++)
	{
		System.out.print(arr[i].head.PNR_NO + "\t");
		t_obj.show(arr[i].head);
		System.out.println();
	}
	System.out.println();
	System.out.print("Enter Train Number from which you want to delete the coach:");
	long del_coach=sc.nextLong();
	System.out.println();
	u_obj.make_bst(arr, del_coach);
	int otp1=p_obj.get_otp();
    System.out.println("OTP : " + otp1);
    System.out.print("Enter above OTP to proceed: ");
    int get_otp1=sc.nextInt();
    System.out.println();
    if(!p_obj.check_otp(otp1,get_otp1))
    {
    	System.out.println("Sorry! You entered incorrect OTP.");
    	System.out.println("Coach could not be deleted.");
    	System.out.println("-----Exit-----");
    	System.exit(0);
    }
	System.out.println("Original number of seats in Train Number " + del_coach + " is " + arr[0].head.no_of_seats);
	adm_obj.delete_coach(del_coach);
	System.out.println();
	System.out.println("Congratulations! Coach has been deleted successfully.");
	break;//end of deletion of coach
	
	case 3:System.out.println("You want to add a new  train to railway system");//adding a new train
	int otp2=p_obj.get_otp();
    System.out.println("OTP : " + otp2);
    System.out.print("Enter above OTP to proceed: ");
    int get_otp2=sc.nextInt();
    System.out.println();
    if(!p_obj.check_otp(otp2,get_otp2))
    {
    	System.out.println("Sorry! You entered incorrect OTP.");
    	System.out.println("New Train could not be added.");
    	System.out.println("-----Exit-----");
    	System.exit(0);
    }
	System.out.println("Enter the following details of new train.");
	System.out.println();
	System.out.print("Enter the total number of stations where train will have halts in its entire journey:");
	int station=sc.nextInt();
	System.out.println();
	Node newtrain=adm_obj.new_train(station);
	System.out.println();
	System.out.println("Details of new train are as follows: ");
	System.out.println();
	t_obj.show_train_details(newtrain);
	System.out.println();
	System.out.println("Following is updated list of trains after addition of new train:");
	System.out.print(newtrain.PNR_NO + "\t");
	t_obj.show(newtrain);//printing new train
	System.out.println();
	for(int i=0;i<arr.length-1;i++)//printing already existing trains
	{
		System.out.print(arr[i].head.PNR_NO + "\t");
		t_obj.show(arr[i].head);
		System.out.println();
	}
	System.out.println();
	System.out.println("Congratulations! New train has been added successfully.");
	System.out.println();
	System.out.println();
	break;//end of addition of new train
	
	case 4:System.out.println("You want to delete a train from railway system");//deleting a train
	System.out.println();
	System.out.println("Following is list of trains:");//displaying trains before deletion
	System.out.println();
	
	for(int i=0;i<arr.length-1;i++)
	{
		System.out.print(arr[i].head.PNR_NO + "\t");
		t_obj.show(arr[i].head);
		System.out.println();
	}
	System.out.println();
	System.out.print("Enter Train Number of the train that u want to delete:");
	long del_train=sc.nextLong();
	System.out.println();
	u_obj.make_bst(arr, del_train);
	int otp3=p_obj.get_otp();
    System.out.println("OTP : " + otp3);
    System.out.print("Enter above OTP to proceed: ");
    int get_otp3=sc.nextInt();
    System.out.println();
    if(!p_obj.check_otp(otp3,get_otp3))
    {
    	System.out.println("Sorry! You entered incorrect OTP.");
    	System.out.println("Train could not be added.");
    	System.out.println("-----Exit-----");
    	System.exit(0);
    }
	System.out.println();
	Train_details[] arr1=adm_obj.delete_train(del_train);
	System.out.println("Following is updated list of trains after deletion:");//displaying trains after deletion
	for(int i=0;i<arr1.length-1;i++)
	{
		System.out.print(arr[i].head.PNR_NO + "\t");
		t_obj.show(arr1[i].head);
		System.out.println();
	}
	System.out.println();
	System.out.println("Congratulations! Train has been deleted successfully.");
	break;//end of deletion of train
	
	case 5:System.out.println("You have chosen to exit");//choosen to exit
	System.out.println("Thank you......");
	System.exit(0);
	break;//end of exit
	}
		
	}
	
	
	void user() //access to user login
	{
		Test_RailwaySystem trs_obj=new Test_RailwaySystem();//object of Test_RailwaySystem
		User_Details u_obj=new User_Details();//object of User_Details
		Train_details t_obj=new Train_details();//object of Train_details
		Administration_Login adm_obj=new Administration_Login();//object of Administration_Login
		Agent_Login a_login=new Agent_Login();//object of Agent_Login
		Payment_Details p_obj=new Payment_Details();
		Train_details[] arr=t_obj.forward_journey();//original list of trains
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		u_obj.get_captcha();
		System.out.println();
		System.out.println("You have access to User Login");
		System.out.println();
		System.out.println("Following is list of trains:");//displaying list of trains 
		for(int i=0;i<arr.length-1;i++)
		{
			System.out.print(arr[i].head.PNR_NO + "\t");
			t_obj.show(arr[i].head);
			System.out.println();
		}
		System.out.println();
		System.out.print("Enter from where you want to board the train: ");
		String source=sc.nextLine();
		System.out.print("Enter your destination: ");
		String destination=sc.nextLine();
		System.out.println();
		System.out.println("Available trains are: ");
		ArrayList<Train_details> valid_arr=u_obj.check_source_destination(source, destination);
		u_obj.valid_trains(valid_arr);
		System.out.println();
		System.out.print("Enter Train Number in which you want to travel: ");
		long book_train=sc.nextLong();
		u_obj.make_bst(valid_arr, book_train);
		int j=0;
		for(int i=0;i<valid_arr.size();i++)
		{
			if(valid_arr.get(i).head.PNR_NO==book_train);
			{
				j=i;
				break;
			}
		}
		System.out.println();
		System.out.println("You have chosen the following train: ");
		System.out.print(valid_arr.get(j).head.PNR_NO + "\t");
		u_obj.show(valid_arr.get(j).head);
		System.out.println();
		System.out.println();
		int no_of_tickets=u_obj.no_of_tickets();
		System.out.println();
		User_Details[] user_arr=u_obj.user_details(no_of_tickets);
		System.out.println();
		System.out.println("Following are passenger details entered and their corresponding ticket fares.");
		System.out.println("Full Name   " + "\t" +"Gender" + "\t" + "Age" + "\t" + "Quota" + "\t" + "Coach" + "\t" + "Fare");
		double total_fare=0;
		for(int i=0;i<user_arr.length;i++)
		{
			user_arr[i].user_head.gender=u_obj.gender(user_arr[i].user_head.gender);
			user_arr[i].user_head.quota=u_obj.quota(user_arr[i].user_head.quota);
			user_arr[i].user_head.coach_type=u_obj.coach_type(user_arr[i].user_head.coach_type);
			double fare=u_obj.ticket_fare(user_arr[i].user_head,u_obj.ticket_fare(valid_arr.get(j).head, source, destination, user_arr[i].user_head.quota));
			u_obj.show(user_arr[i].user_head);
			System.out.print(fare);
			System.out.println();
			total_fare+=fare;
		}
		total_fare=Math.round(total_fare*100)/100.0;//rounding off total fare to two decimal places
		System.out.println();
		System.out.println("Total fare to be paid is : " + total_fare);	
		System.out.println("Lets proceed to payment.");
		System.out.println();
		trs_obj.payment(total_fare);
		System.out.println();
		System.out.println("Find your ticket details below.");
		System.out.println();
		System.out.println("Full Name   " + "\t" +"Gender" + "\t" + "Age" + "\t" + "Quota" + "\t" + "Coach" + "\t" + "Fare");
		for(int i=0;i<user_arr.length;i++)
		{
			user_arr[i].user_head.gender=u_obj.gender(user_arr[i].user_head.gender);
			user_arr[i].user_head.quota=u_obj.quota(user_arr[i].user_head.quota);
			user_arr[i].user_head.coach_type=u_obj.coach_type(user_arr[i].user_head.coach_type);
			double fare=u_obj.ticket_fare(user_arr[i].user_head,u_obj.ticket_fare(valid_arr.get(j).head, source, destination, user_arr[i].user_head.quota));
			u_obj.show(user_arr[i].user_head);
			System.out.print(fare);
			System.out.println();
		}
		System.out.println();
		System.out.println("Total payment done of INR " + total_fare);
		System.out.println();
		System.out.println("Your train details are as follows: ");
		System.out.println();
		System.out.println("Boarding from : " + source);
		System.out.println("Destination : " + destination);
		t_obj.show_train_details(valid_arr.get(j).head);
		System.out.println();
		System.out.println("Have a Safe and Happy Journey.");
	}//end of user login
	
	void agent()//agent login
	{
		Test_RailwaySystem trs_obj=new Test_RailwaySystem();//object of Test_RailwaySystem
		User_Details u_obj=new User_Details();//object of User_Details
		Train_details t_obj=new Train_details();//object of Train_details
		Administration_Login adm_obj=new Administration_Login();//object of Administration_Login
		Agent_Login a_login=new Agent_Login();//object of Agent_Login
		
		Train_details[] arr=t_obj.forward_journey();//original list of trains
		Scanner sc=new Scanner(System.in);
		
		System.out.println();
		u_obj.get_captcha();
		System.out.println();
		System.out.println("You have access to Agent Login");
		System.out.println();
		System.out.println("You can book upto 12 tickets at a time.");
		System.out.println("10% extra charges will be applicable on each ticket.");
		System.out.println();
		System.out.println("Following is list of trains:");//displaying list of trains 
		for(int i=0;i<arr.length-1;i++)
		{
			System.out.print(arr[i].head.PNR_NO + "\t");
			t_obj.show(arr[i].head);
			System.out.println();
		}
		System.out.println();
		System.out.print("Enter from where you want to board the train: ");
		String source=sc.nextLine();
		System.out.print("Enter your destination: ");
		String destination=sc.nextLine();
		System.out.println();
		System.out.println("Available trains are: ");
		ArrayList<Train_details> valid_arr=u_obj.check_source_destination(source, destination);
		u_obj.valid_trains(valid_arr);
		System.out.println();
		System.out.print("Enter Train Number in which you want to travel: ");
		long book_train=sc.nextLong();
		u_obj.make_bst(valid_arr, book_train);
		int j=0;
		for(int i=0;i<valid_arr.size();i++)
		{
			if(valid_arr.get(i).head.PNR_NO==book_train);
			{
				j=i;
				break;
			}
		}
		System.out.println();
		System.out.println("You have chosen the following train: ");
		System.out.print(valid_arr.get(j).head.PNR_NO + "\t");
		u_obj.show(valid_arr.get(j).head);
		System.out.println();
		System.out.println();
		int no_of_tickets=a_login.no_of_tickets();
		System.out.println();
		User_Details[] user_arr=u_obj.user_details(no_of_tickets);
		System.out.println();
		System.out.println("Following are passenger details entered and their corresponding ticket fares.");
		System.out.println("Full Name   " + "\t" +"Gender" + "\t" + "Age" + "\t" + "Quota" + "\t" + "Coach" + "\t" + "Fare");
		double total_fare=0;
		for(int i=0;i<user_arr.length;i++)
		{
			user_arr[i].user_head.gender=u_obj.gender(user_arr[i].user_head.gender);
			user_arr[i].user_head.quota=u_obj.quota(user_arr[i].user_head.quota);
			user_arr[i].user_head.coach_type=u_obj.coach_type(user_arr[i].user_head.coach_type);
			double fare=u_obj.ticket_fare(user_arr[i].user_head,u_obj.ticket_fare(valid_arr.get(1).head, source, destination, user_arr[i].user_head.quota));
			u_obj.show(user_arr[i].user_head);
			System.out.print(fare);
			System.out.println();
			total_fare+=fare;
		}
		System.out.println();
		System.out.println("Actual fare is: " + total_fare);
		double extra_fare=0.1*total_fare;
		System.out.println("10% of Actual fare is(Extra charges) : " + Math.round(extra_fare*100)/100.0);
		total_fare=a_login.extra_charges(total_fare);
		total_fare=Math.round(total_fare*100)/100.0;//rounding off total fare to two decimal places
		System.out.println("Total fare to be paid is : " + total_fare);	
		System.out.println("Lets proceed to payment.");
		System.out.println();
		trs_obj.payment(total_fare);
		System.out.println("Find your ticket details below.");
		System.out.println("Full Name   " + "\t" +"Gender" + "\t" + "Age" + "\t" + "Quota" + "\t" + "Coach" + "\t" + "Fare");
		for(int i=0;i<user_arr.length;i++)
		{
			user_arr[i].user_head.gender=u_obj.gender(user_arr[i].user_head.gender);
			user_arr[i].user_head.quota=u_obj.quota(user_arr[i].user_head.quota);
			user_arr[i].user_head.coach_type=u_obj.coach_type(user_arr[i].user_head.coach_type);
			double fare=u_obj.ticket_fare(user_arr[i].user_head,u_obj.ticket_fare(valid_arr.get(j).head, source, destination, user_arr[i].user_head.quota));
			u_obj.show(user_arr[i].user_head);
			System.out.print(fare);
			System.out.println();
		}
		System.out.println();
		System.out.println("Total payment done of INR " + total_fare);
		System.out.println();
		System.out.println("Your train details are as follows: ");
		System.out.println();
		System.out.println("Boarding from : " + source);
		System.out.println("Destination : " + destination);
		t_obj.show_train_details(valid_arr.get(j).head);
		System.out.println();
		System.out.println("Have a Safe and Happy Journey.");
	}//end of agent login
	
	public static void main(String[] args)
	{
		Test_RailwaySystem trs_obj=new Test_RailwaySystem();//object of Test_RailwaySystem
		User_Details u_obj=new User_Details();//object of User_Details
		Train_details t_obj=new Train_details();//object of Train_details
		Administration_Login adm_obj=new Administration_Login();//object of Administration_Login
		Agent_Login a_login=new Agent_Login();//object of Agent_Login
		int login_type=trs_obj.accept_login();
		Train_details[] arr=t_obj.forward_journey();//original list of trains
		Scanner sc=new Scanner(System.in);
		switch(login_type)//switch loop based on login_type
		{
		
		case 1:trs_obj.administration();//administration login
		break;//end of administration login
		
		case 2:
			trs_obj.user();//user login
		break;//end of user login
		
		case 3:trs_obj.agent();//agent login
		break;//end of agent login
		
		case 4:System.out.println("You have chosen to exit");
		System.out.println("......Thank you......");
		System.exit(0);
		break;
		}
	}
}
