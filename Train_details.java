package railway_system;

//routes of train
//12935--->Bandra--->Andheri--->Borivali--->Virar--->Boisar--->Vapi--->Valsad--->Bilimora--->Navsari--->Surat
//12951--->Mumbai Central--->Borivali--->Surat--->Vadodara--->Ratlam--->Kota--->New Delhi
//12261--->CST--->Bhusaval--->Nagpur--->Raipur--->Bilaspur--->Tatanagar--->Howrah
//12009--->Mumbai Central---> Borivali--->Vapi--->Surat--->Bharuch--->Vadodara--->Anand--->Nadiad--->Ahmedabad
//12649--->Banglore--->Dharmavaram--->Kurnool--->Kacheguda--->Nagpur--->Bhopal--->Jhansi--->New Delhi 
//12878--->New Delhi--->Kanpur--->Prayagraj--->Bhabua--->Sasaram--->Dehri On Son--->Japla--->Garwa-->Latehar--->Tori--->Muri--->Ranchi
//22913--->Bandra--->Vapi--->Valsad--->Bhestan--->Nandurbar--->Bhusaval--->Itarsi--->Jabalpur--->Satna--->Upadhyaya--->Patna
//12949--->Porbandar--->Rajkot--->Viramgaam--->Ahmedabad--->Anand--->Vadodara--->Bharuch--->Surat--->Nandurbar--->Jalgaon--->Bhusaval--->Akola--->Nagpur
//12971-->Bandra--->Andheri--->Borivali--->Vapi--->Valsad--->Navsari--->Surat--->Vadodara--->Anand--->Nadiad--->Ahmedabad--->Viramgam--->Surendranagar--->Jorawarnagar--->Botad--->Songadh--->Sihor--->Bhavnagar
//12921--->Mumbai Central--->Andheri--->Borivali--->Palghar--->Dahanu Road--->Vapi--->Valsad--->Bilimora--->Navsari--->Maroli--->Sachin--->Udhna--->Surat

//creating a class to store train details
import java.util.*;
public class Train_details {

	//	creating a node class
	Node head;
	static class Node
	{
		Node next;
	long PNR_NO;
	double distance;
	String station_name;
	String train_name;
	String arrival_time;
	String departure_time;
	int no_of_seats;
	Node(long PNR_NO,String train_name,String station_name,String arrival_time,String departure_time,double distance)
	{
		this.PNR_NO=PNR_NO;
		this.train_name=train_name;
		this.station_name=station_name;
		this.distance=distance;
		this.arrival_time=arrival_time;
		this.departure_time=departure_time;
		this.next=null;
		this.no_of_seats=1000;
	}
	}
	
//	adding nodes to last of linked list
	void insert_last(long PNR_NO,String train_name,String station_name,String arrival_time,String departure_time,double distance)
	{
		Node newnode=new Node(PNR_NO,train_name,station_name,arrival_time,departure_time,distance);
		if(head==null)
		{
			head=newnode;
			return;
		}
		Node current=head;
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=newnode;
	}
	
//	creating object at index of array
	Train_details[] create_train_object()
	{
		Train_details[] train=new Train_details[11];
		for(int i=0;i<11;i++)
		{
			train[i]=new Train_details();
			train[i].head=null;
		}
		return train;
	}
	

	
	
//	function to add route for forward journey
	static Train_details[] forward_journey()
	{
		Train_details obj=new Train_details();
		Train_details[] train=obj.create_train_object();
		
		
//		adding details of first train
		//12935--->Bandra--->Andheri--->Borivali--->Virar--->Boisar--->Vapi--->Valsad--->Bilimora--->Navsari--->Surat
		train[0].insert_last(12935,"Intercity express","bandra","7:00","7:20",0);
		train[0].insert_last(12935,"Intercity express","andheri","7:45","7:47",10);
		train[0].insert_last(12935,"Intercity express","borivali","8:00","8:02",20);
		train[0].insert_last(12935,"Intercity express","virar","8:30","8:32",30);
		train[0].insert_last(12935,"Intercity express","boisar","8:45","8:47",40);
		train[0].insert_last(12935,"Intercity express","vapi","9:13","9:15",50);
		train[0].insert_last(12935,"Intercity express","valsad","9:30","9:32",60);
		train[0].insert_last(12935,"Intercity express","bilimora","9:50","9:52",70);
		train[0].insert_last(12935,"Intercity express","navsari","10:18","10:20",80);
		train[0].insert_last(12935,"Intercity express","surat","10:55","null",90);
//		obj.show(train[0].head);
//		System.out.println();
		
//		adding details of second train
		//12951--->Mumbai Central--->Borivali--->Surat--->Vadodara--->Ratlam--->Kota--->New Delhi
		train[1].insert_last(12951, "Rajdhani Express", "mumbaicentral", "8:00", "8:20", 0);
		train[1].insert_last(12951, "Rajdhani Express", "borivali", "9:15", "9:17", 30);
		train[1].insert_last(12951, "Rajdhani Express", "surat", "10:17", "10:20", 70);
		train[1].insert_last(12951, "Rajdhani Express", "vadodara", "11:59", "12:05", 150);
		train[1].insert_last(12951, "Rajdhani Express", "ratlam", "13:40", "13:45", 300);
		train[1].insert_last(12951, "Rajdhani Express", "kota", "15:00", "15:10", 550);
		train[1].insert_last(12951, "Rajdhani Express", "newdelhi", "17:25", "null", 625);
//		obj.show(train[1].head);
//		System.out.println();
		
//		adding details of third train
		//12261--->CST--->Bhusaval--->Nagpur--->Raipur--->Bilaspur--->Tatanagar--->Howrah
		train[2].insert_last(12261, "Duronto Express", "cst","13:00", "13:30", 0);
		train[2].insert_last(12261, "Duronto Express", "bhuvasal","14:20", "14:25", 45);
		train[2].insert_last(12261, "Duronto Express", "nagpur","15:05", "15:07", 110);
		train[2].insert_last(12261, "Duronto Express", "raipur","15:50", "15:53", 195);
		train[2].insert_last(12261, "Duronto Express", "bilaspur","16:01", "16:07", 249);
		train[2].insert_last(12261, "Duronto Express", "tatanagar","17:00", "17:10", 301);
		train[2].insert_last(12261, "Duronto Express", "howrah","18:25", "null", 400);
//		obj.show(train[2].head);
//		System.out.println();
		
//		adding details of fourth train
		//12009--->Mumbai Central---> Borivali--->Vapi--->Surat--->Bharuch--->Vadodara--->Anand--->Nadiad--->Ahmedabad
		train[3].insert_last(12009, "Shatabdi Express", "mumbaicentral","11:00" , "11;25", 0);
		train[3].insert_last(12009, "Shatabdi Express", "borivali","12:00" , "12:02", 25);
		train[3].insert_last(12009, "Shatabdi Express", "vapi","12:50" , "12:52", 50);
		train[3].insert_last(12009, "Shatabdi Express", "surat","13:52" , "13:53", 90);
		train[3].insert_last(12009, "Shatabdi Express", "bharuch","14:30" , "14:32", 120);
		train[3].insert_last(12009, "Shatabdi Express", "vadodara","15:15" , "15:20", 150);
		train[3].insert_last(12009, "Shatabdi Express", "anand","15:41" , "15:45", 195);
		train[3].insert_last(12009, "Shatabdi Express", "nadiad","16:20" , "16:22", 210);
		train[3].insert_last(12009, "Shatabdi Express", "ahmedabad","16:41" , "null", 235);
//		obj.show(train[3].head);
//		System.out.println();
	
//	adding details of fifth train
		//12649--->Banglore--->Dharmavaram--->Kurnool--->Kacheguda--->Nagpur--->Bhopal--->Jhansi--->New Delhi
	train[4].insert_last(12649, "Sampark Kranti Express", "banglore", "15:00", "15:25", 0);
	train[4].insert_last(12649, "Sampark Kranti Express", "dharmavaram", "16:01", "16:03", 35);
	train[4].insert_last(12649, "Sampark Kranti Express", "kurnool", "16:29", "16:31", 72);
	train[4].insert_last(12649, "Sampark Kranti Express", "kacheguda", "17:20", "17:25", 181);
	train[4].insert_last(12649, "Sampark Kranti Express", "nagpur", "18:03", "18:05", 235);
	train[4].insert_last(12649, "Sampark Kranti Express", "bhopal", "19:26", "19:31", 394);
	train[4].insert_last(12649, "Sampark Kranti Express", "jhansi", "20:05", "20:07", 452);
	train[4].insert_last(12649, "Sampark Kranti Express", "newdelhi", "21:00", "null", 602);
//	obj.show(train[4].head);
//	System.out.println();
	
//	adding details of sixth train
	//12878--->New Delhi--->Kanpur--->Prayagraj--->Bhabua--->Sasaram--->Dehri On Son--->Japla--->Garwa-->Latehar--->Tori--->Muri--->Ranchi
	train[5].insert_last(12878, "Garib Rath Express", "newdelhi", "20:20", "20:38", 0);
	train[5].insert_last(12878, "Garib Rath Express", "kanpur", "20:59", "21:02", 25);
	train[5].insert_last(12878, "Garib Rath Express", "prayagraj", "21:35", "21:39", 120);
	train[5].insert_last(12878, "Garib Rath Express", "bhabua", "22:36", "22:38", 142);
	train[5].insert_last(12878, "Garib Rath Express", "sasaram", "22:59", "23:01", 183);
	train[5].insert_last(12878, "Garib Rath Express", "dehrionson", "23:41", "23:45", 221);
	train[5].insert_last(12878, "Garib Rath Express", "jalpa", "00:20", "00:30",267);
	train[5].insert_last(12878, "Garib Rath Express", "garwa", "01:15", "01:20", 345);
	train[5].insert_last(12878, "Garib Rath Express", "latehar", "02:13", "02:17", 397);
	train[5].insert_last(12878, "Garib Rath Express", "tori", "03:11", "03:15", 420);
	train[5].insert_last(12878, "Garib Rath Express", "muri", "03:50", "03:52", 512);
	train[5].insert_last(12878, "Garib Rath Express", "ranchi", "04:30", "null", 580);
//	obj.show(train[5].head);
//	System.out.println();
	
//	adding details of seventh train
	//22913--->Bandra--->Vapi--->Valsad--->Bhestan--->Nandurbar--->Bhusaval--->Itarsi--->Jabalpur--->Satna--->Upadhyaya--->Patna
	train[6].insert_last(22913, "Humsafar Express", "bandra", "14:25", "14:50", 0);
	train[6].insert_last(22913, "Humsafar Express", "vapi", "15:40", "15:43",59);
	train[6].insert_last(22913, "Humsafar Express", "valsad", "16:57", "17:00", 110);
	train[6].insert_last(22913, "Humsafar Express", "bhestan", "18:25", "18:28", 180);
	train[6].insert_last(22913, "Humsafar Express", "nandurbar", "19:25", "19:28", 270);
	train[6].insert_last(22913, "Humsafar Express", "bhusaval", "20:02", "20:07", 353);
	train[6].insert_last(22913, "Humsafar Express", "itarasi", "21:39", "21:45", 491);
	train[6].insert_last(22913, "Humsafar Express", "jabalpur", "22:51", "22:57", 585);
	train[6].insert_last(22913, "Humsafar Express", "satna", "23:36", "23:41", 672);
	train[6].insert_last(22913, "Humsafar Express", "upadhyaya", "00:50", "00:59", 750);
	train[6].insert_last(22913, "Humsafar Express", "patna", "2:50", "null", 870);
	
//	adding details of eight train
	//12949--->Porbandar--->Rajkot--->Viramgaam--->Ahmedabad--->Anand--->Vadodara--->Bharuch--->Surat--->Nandurbar--->Jalgaon--->Bhusaval--->Akola--->Nagpur
	train[7].insert_last(12949, "Nagpur Express", "porbandar", "9:05", "9:25", 0);
	train[7].insert_last(12949, "Nagpur Express", "rajkot", "10:52", "10:55", 153);
	train[7].insert_last(12949, "Nagpur Express", "viramgaam", "12:15", "12:19", 215);
	train[7].insert_last(12949, "Nagpur Express", "ahmedabad", "13:25", "13:29", 305);
	train[7].insert_last(12949, "Nagpur Express", "anand", "13:59", "14:07", 371);
	train[7].insert_last(12949, "Nagpur Express", "vadodara", "14:32", "14:34", 412);
	train[7].insert_last(12949, "Nagpur Express", "bharuch", "15:17", "15:20", 497);
	train[7].insert_last(12949, "Nagpur Express", "surat", "16:29", "16:32", 547);
	train[7].insert_last(12949, "Nagpur Express", "nandurbar", "17:52", "17:58", 672);
	train[7].insert_last(12949, "Nagpur Express", "jalgaon", "18:25", "18:29", 730);
	train[7].insert_last(12949, "Nagpur Express", "bhusaval", "19:35", "19:39", 792);
	train[7].insert_last(12949, "Nagpur Express", "akola", "20:44", "20:49", 870);
	train[7].insert_last(12949, "Nagpur Express", "nagpur", "21:53", "null", 925);
	
//	adding details of ninth train
	//12971-->Bandra--->Andheri--->Borivali--->Vapi--->Valsad--->Navsari--->Surat--->Vadodara--->Anand--->Nadiad--->Ahmedabad--->Viramgam--->Surendranagar--->Jorawarnagar--->Botad--->Songadh--->Sihor--->Bhavnagar
	train[8].insert_last(12971, "Kavi Guru Express", "bandra", "18:25", "18:40", 0);
	train[8].insert_last(12971, "Kavi Guru Express", "andheri", "18:51", "18:53", 17);
	train[8].insert_last(12971, "Kavi Guru Express", "borivali", "19:10", "19:13", 28);
	train[8].insert_last(12971, "Kavi Guru Express", "vapi", "19:30", "19:33", 40);
	train[8].insert_last(12971, "Kavi Guru Express", "valsad", "20:26", "20:30",92);
	train[8].insert_last(12971, "Kavi Guru Express", "navsari", "21:14", "21:17", 153);
	train[8].insert_last(12971, "Kavi Guru Express", "surat", "22:06", "22:09", 261);
	train[8].insert_last(12971, "Kavi Guru Express", "vadodara", "23:16", "23:19", 376);
	train[8].insert_last(12971, "Kavi Guru Express", "anand", "00:39", "00:42", 461);
	train[8].insert_last(12971, "Kavi Guru Express", "nadiad", "01:21", "01:23", 520);
	train[8].insert_last(12971, "Kavi Guru Express", "ahmedabad", "02:14", "02:19", 601);
	train[8].insert_last(12971, "Kavi Guru Express", "viramgam", "02:57", "02:59", 670);
	train[8].insert_last(12971, "Kavi Guru Express", "surendranagar", "03:45", "03:49", 741);
	train[8].insert_last(12971, "Kavi Guru Express", "jorawarnagar", "04:36", "04:39", 803);
	train[8].insert_last(12971, "Kavi Guru Express", "botad", "05:17", "05:21", 894);
	train[8].insert_last(12971, "Kavi Guru Express", "songadh", "06:35", "06:39", 946);
	train[8].insert_last(12971, "Kavi Guru Express", "sihor", "07:42", "07:49", 1009);
	train[8].insert_last(12971, "Kavi Guru Express", "bhavnagar", "09:00", "null", 1100);

//	adding details of tenth train
	//12921--->Mumbai Central--->Andheri--->Borivali--->Palghar--->Dahanu Road--->Vapi--->Valsad--->Bilimora--->Navsari--->Maroli--->Sachin--->Udhna--->Surat
	train[9].insert_last(12921, "Flying Ranee", "mumbaicentral","13:00", "13:24", 0);
	train[9].insert_last(12921, "Flying Ranee", "andheri","14:05", "14:09", 29);
	train[9].insert_last(12921, "Flying Ranee", "borivali","14:47", "14:51", 59);
	train[9].insert_last(12921, "Flying Ranee", "palghar","15:36", "15:40", 101);
	train[9].insert_last(12921, "Flying Ranee", "dahanuroad","16:20", "16:24", 174);
	train[9].insert_last(12921, "Flying Ranee", "vapi","17:01", "17:04", 231);
	train[9].insert_last(12921, "Flying Ranee", "valsad","18:07", "18:10", 315);
	train[9].insert_last(12921, "Flying Ranee", "bilimora","18:58", "19:02", 397);
	train[9].insert_last(12921, "Flying Ranee", "navsari","19:55", "19:59", 467);
	train[9].insert_last(12921, "Flying Ranee", "maroli","20:45", "20:49", 587);
	train[9].insert_last(12921, "Flying Ranee", "sachin","21:57", "22:00", 672);
	train[9].insert_last(12921, "Flying Ranee", "udhna","22:39", "22:41", 700);
	train[9].insert_last(12921, "Flying Ranee", "surat","22:59", "null", 720);
	
	
	return train;
	}
	
	void show(Node head)
	{
		Node current=head;
		if(head==null)
		{
			System.out.println("null");
			return;
		}
		while(current.next!=null)
		{
			System.out.print(current.station_name + " ->" + " ");
			current=current.next;
		}
		System.out.print(current.station_name);
	}
	
	void show_train_details(Node head)//used to print train details while printing ticket
	{
		Node current=head;
		System.out.println("Train Number : " + current.PNR_NO);
		System.out.println("Train Name : " +  current.train_name);
		System.out.println();
		System.out.println("Station    " +"\t" + "Arrival" +"\t"+ "Departure"+ "\t" + "Distance(kms)");
		while(current.next!=null)
		{
			if(current.station_name.length()<8 && current.station_name.length()>5)
			{
				System.out.print(current.station_name + "    \t" + current.arrival_time + " \t" + current.departure_time + "      \t" + current.distance);
			}
			else if(current.station_name.length()<6)
			{
				System.out.print(current.station_name + "      \t" + current.arrival_time + " \t" + current.departure_time + "      \t" + current.distance);
			}
			else
			{
				
			System.out.print(current.station_name + " \t" + current.arrival_time + " \t" + current.departure_time + "      \t" + current.distance);
			}
			current=current.next;
			System.out.println();
		}
		if(current.station_name.length()<8 && current.station_name.length()>5)
		{
			System.out.print(current.station_name + "    \t" + current.arrival_time + " \t" + current.departure_time + "      \t" + current.distance);
		}
		else if(current.station_name.length()<6)
		{
			System.out.print(current.station_name + "      \t" + current.arrival_time + " \t" + current.departure_time + "      \t" + current.distance);
		}
		else
		{
			
		System.out.print(current.station_name + " \t" + current.arrival_time + " \t" + current.departure_time + "      \t" + current.distance);
		}
	System.out.println();
	System.out.println("Note : Distances mentioned are measured from the station where train begin its journey.");
	}
	
	public static void main(String[] args)
	{
//		forward_journey("NO");
		Train_details[] arr=forward_journey();
		Train_details obj=new Train_details();
//		System.out.println(arr.length);
//		int i=0;
//		while(arr[i].head!=null)
//		{
//			i++;
//		}
//		System.out.println(i);
		obj.show_train_details(arr[9].head);
		
		
		
		
		
	}
}
