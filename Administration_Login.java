package railway_system;

import java.util.Scanner;

import railway_system.Train_details.Node;

public class Administration_Login extends User_Details{

	//deleting a train by making it's head as null
	Train_details[]  delete_train(long PNR_NO)
	{
		Train_details[] arr=forward_journey();
		for(int i=0;i<arr.length;i++)
		{
			if(PNR_NO==arr[i].head.PNR_NO)
			{
				arr[i].head=null;
				return arr;
			}
		}
		return arr;
       }
       
//	checking at which position should the train be inserted in array by checking which head corresponds to null
	int place_at_which_newtrain_is_inserted(Train_details[] train)
	{
		int i=0;
		while(train[i].head!=null)
		{
			i++;
		}
		return i;
	}
		
		
//	create a new train and returning its head
//	also searching at which position should the train be inserted in array by checking which head corresponds to null
	Node new_train(int no_of_stations)
	{
		Train_details[] train=forward_journey();
		int i=place_at_which_newtrain_is_inserted(train);
		Scanner sc=new Scanner(System.in);
		int j=1;
		System.out.print("Enter PNR Number of train:");
		long PNR_NO=sc.nextLong();
		System.out.print("Enter the name of the train:");
		String train_name=sc.next();
		while(j<=no_of_stations)
		{
		    System.out.print("Enter the name of the station:");
		    String station_name=sc.next();
		    System.out.print("Enter the arrival time of train:");
		    String arrival_time=sc.next();
		    System.out.print("Enter the departure time of the train:");
		    String departure_time=sc.next();
		    System.out.print("Enter the distance of current station from the source station:");
		    double distance=sc.nextDouble();
			train[i].insert_last(PNR_NO,train_name,station_name,arrival_time,departure_time,distance);
			System.out.println();
			j++;
		}
		return train[i].head;
	}
	
//	adding an extra coach to a train(max:2)
//	80 seats will be added
	void add_coach(long PNR_NO)
	{
		int no_of_coaches=no_of_coaches();
		Train_details[] train=forward_journey();
		int i=0;
		while(i<train.length)
		{
		if(train[i].head.PNR_NO==PNR_NO)
		{
			train[i].head.no_of_seats+=(80*no_of_coaches);
			System.out.println(80*no_of_coaches + " seats were added to train.");
			System.out.println("Total number of seats : " + train[i].head.no_of_seats);
			return;
		}
		i++;
		}
	}
	
	int no_of_coaches()//accepting no_of_coaches for addition/deletion of coach(max:2)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("You can update maximum 2 coaches in a train.");
		System.out.println("Each coach contains 80 seats.");
		System.out.print("Enter the number of coaches:");
		int no_of_coaches=sc.nextInt();
		if(no_of_coaches>0 && no_of_coaches<=2)
		{
			System.out.println("You want to update " + no_of_coaches +" coaches");
			return no_of_coaches;
		}
		return no_of_coaches();
	}
	
//	deleting a coach from the train(max:2)
//	80 seats will be deleted per coach
	void delete_coach(long PNR_NO)
	{
		int no_of_coaches=no_of_coaches();
		Train_details[] train=forward_journey();
		int i=0;
		while(i<train.length)
		{
		if(train[i].head.PNR_NO==PNR_NO)
		{
			train[i].head.no_of_seats-=(80*no_of_coaches);
			System.out.println(80*no_of_coaches + " seats were removed from the train.");
			System.out.println("Total number of seats : " + train[i].head.no_of_seats);
			return;
		}
		i++;
		}
	}
	public static void main(String[] args)
	{
		Administration_Login obj=new Administration_Login();
		Train_details t_obj=new Train_details();
		Train_details[] arr=forward_journey();
		obj.delete_coach(12935);
		//obj.no_of_coaches();
		//for(int i=0;i<6;i++)
//		{
//			obj.show(arr[i].head);
//			System.out.println();
//		}
		//Train_details[] arr1=obj.delete_train(12261);
//		obj.show(arr[0].head);
//		for(int i=0;i<6;i++)
//		{
//			obj.show(arr1[i].head);
//			System.out.println();
//		}
//		obj.show(obj.new_train(1));
//		obj.delete_coach(12935,1);
//		obj.add_coach(12935,2);

	}
}
