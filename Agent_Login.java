package railway_system;
//A railway agent can book upto 12 tickets at once
//10% charges would be applied to every ticket booked by agent

import java.util.Scanner;

public class Agent_Login extends User_Details{
	
	//applying 10% extra charges on bookings done by agent
	double extra_charges(double ticket_fare)
	{
		ticket_fare+=0.1*ticket_fare;
		return ticket_fare;
	}
	
//	accepting number of tickets to be booked(max:12)
	int no_of_tickets()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of tickets to be booked: ");
		int number=sc.nextInt();
		if(number>0 && number<=12)
		{
			return number;
		}
		return no_of_tickets();
	}
	
	public static void main(String[] args)
	{
		Agent_Login obj=new Agent_Login();
		System.out.println(obj.extra_charges(500.0));
		obj.no_of_tickets();
	}
}
