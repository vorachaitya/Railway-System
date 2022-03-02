package railway_system;
//accepting user details
import java.util.*;

//import Binary_Search_Tree.Implementation.TreeNode;
import railway_system.Train_details.Node;
public class User_Details extends Train_details
{
	User_Node user_head;
	TreeNode root;
	// class user_node to create nodes with details of all user
	class User_Node
	{
		User_Node next;
		String first_name;
		String last_name;
		char gender;
		int age;
		String quota;
		String coach_type;
		User_Node(String  first_name,String last_name,char gender,int age,String quota,String coach_type)
		{
			this.first_name=first_name;
			this.last_name=last_name;
			this.gender=gender;
			this.age=age;
			this.quota=quota;
			this.next=null;
			this.coach_type=coach_type;
		}
	}
	
	//class TreeNode to create Binary search tree and search for given PNR_NO
	class TreeNode
	{
		TreeNode right;
		TreeNode left;
		long PNR_NO;
		TreeNode(long PNR_NO)
		{
			this.PNR_NO=PNR_NO;
		}
	}
	
	//function to insert nodes of binary search tree
	void insert(long value)
	{
		root=recursiveInsert(root,value);
	}
	
	TreeNode recursiveInsert(TreeNode root,long value)
	{
		if(root==null)
		{
			root=new TreeNode(value);
			return root;
		}
		if(value<root.PNR_NO)
		{
			root.left=recursiveInsert(root.left,value);
		}
		if(value>root.PNR_NO)
		{
			root.right=recursiveInsert(root.right,value);
		}
		return root;
	}
	
	TreeNode search(long PNR_NO)
	{
		return search(root,PNR_NO);
	}
	
	TreeNode search(TreeNode root,long PNR_NO)
	{
		if(root==null || root.PNR_NO==PNR_NO)
		{
			return root;
		}
		if(PNR_NO<root.PNR_NO)
		{
			return search(root.left,PNR_NO);
		}
		else
		{
			return search(root.right,PNR_NO);
		}
	}
	
	//creating bst with PNR_NO of train
	void make_bst(Train_details[] arr,long key)
	{
		User_Details obj=new User_Details();
		for(int i=0;i<arr.length-1;i++)
		{
			obj.insert(arr[i].head.PNR_NO);
		}
		System.out.println();
		if(null==obj.search(key))
		{
			System.out.println("Sorry! Such train does not exist.");
			System.exit(0);
		}
		
	}
	
	//creating bst of valid train that matches source and destination of user
	void make_bst(ArrayList<Train_details> arr,long key)
	{
		User_Details obj=new User_Details();
		for(int i=0;i<arr.size();i++)
		{
			obj.insert(arr.get(i).head.PNR_NO);
		}
		if(null==obj.search(key))
		{
			System.out.println("Sorry! Such train does not exist.");
			System.exit(0);
		}
	}
	
	//inorder traversal of bst
	void inOrderTraversal(TreeNode root)
	{
		if(root==null)
		{
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.PNR_NO + " ");
		inOrderTraversal(root.right);
	}
	
//	accepting number of tickets to be booked(max:6)
	int no_of_tickets()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Maximum of 6 tickets can be booked.");
		System.out.print("Enter number of tickets to be booked: ");
		int number=sc.nextInt();
		if(number>0 && number<=6)
		{
			return number;
		}
		return no_of_tickets();
	}
	
	//checking if entered PNR_NO exist in train list
	void check_PNR_NO(long PNR_NO)
	{
		Train_details t_obj=new Train_details();
		Train_details[] arr=t_obj.forward_journey();
		Scanner sc=new Scanner(System.in);
		boolean bool=false;
		for(int i=0;i<arr.length-1;i++)
		{
			if(PNR_NO==arr[i].head.PNR_NO)
			{
				bool=true;
				return;
			}
		}
		if(bool==false)
		{
			System.out.println("Sorry! Such train does not exist.");
			System.exit(0);//exiting system if entered PNR_NO is invalid
		}
		
	}
	
//	accepting details of user and returning array containing details of all user
	User_Details[] user_details(int no_of_tickets)
	{
		User_Details u_obj=new User_Details();
		Scanner sc=new Scanner(System.in);
		User_Details[] arr=new User_Details[no_of_tickets];
	
		for(int i=0;i<no_of_tickets;i++)
		{
			arr[i]=new User_Details();
		}
		for(int i=0;i<no_of_tickets;i++)
		{
		System.out.print("Enter First name:");
		String first_name=sc.next();
		System.out.print("Enter Last name:");
		String last_name=sc.next();
		System.out.print("Enter gender M/F/O : ");
		char gender=sc.next().charAt(0);
		System.out.print("Enter age: ");
		int age=sc.nextInt();
		System.out.print("Enter Quota SC(Senior Citizen) / L(Ladies) / HC(Handicapped) / OPEN : ");
		String quota=sc.next();
		System.out.print("Enter your coach type 1A-AC/2A-AC/3A-AC/FC/SL/2S/GEN : ");
		String coach_type=sc.next();
		arr[i].insert_last(first_name, last_name, gender, age, quota,coach_type);
		System.out.println();
		}
		return arr;
	}
	
//	converting entered gender to either M(for male),F(for female) or O(for others)
	char gender(char gender)
	{
		char ch=Character.toUpperCase(gender);
		return ch;
	}
	
//	converting entered quota to either HC,SC,L,OPEN
	String quota(String quota)
	{
		String st=quota.toUpperCase();
		return st;
	}
	
//	converting entered coach type  to upper case
	String coach_type(String coach_type)
	{
		String st=coach_type.toUpperCase();
		return st;
	}

	
//	calculating ticket fare based on travel journey and quota
	double ticket_fare(Node head,String source,String destination,String quota)
	{
		double fuel=10.0;//this is fuel price per km
		Node src=head;
		double begin=0.0,end=0.0;
		Node dest=null;
		while(src!=null)
		{
			if(source.compareTo(src.station_name)==0)
			{
				begin=src.distance;
				dest=src.next;
				while(dest!=null)
				{
					if(destination.compareTo(dest.station_name)==0)
					{
						end=dest.distance;
						break;
					}
					dest=dest.next;
				}
			}
			src=src.next;
	}
		double fare=(end-begin)*fuel;
		if(quota.equals("HC"))//for HC(Hnadicapped),70% of original fare
		{
			fare=fare*0.7;
		}
		else if(quota.equals("SC"))//for SC(Senior Citizen),80% of original fare
		{
			fare=fare*0.8;
		}
		else if(quota.equals("L"))//for L(Ladies quota),90% of original fare
		{
			fare=fare*0.9;
		}
		else//for open,100% of original fare
		{
			fare=fare*1.0;
		}
		return fare;
	}
	
//	calculating ticket_fare based on type of coaches
	double ticket_fare(User_Node user_head,double fare)
	{
		if(user_head.coach_type.equals("1A-AC"))// AC FIRST CLASS,rates is 2.1 times
		{
			fare*=2.1;
		}
		else if(user_head.coach_type.equals("2A-AC"))//AC two tier,rates is 1.85 times
		{
			fare*=1.85;
		}
		else if(user_head.coach_type.equals("3A-AC"))//ac three tier,rate is 1.7 times
		{
			fare*=1.70;
		}
		else if(user_head.coach_type.equals("FC"))//first class,rate is 1.22 times
		{
			fare*=1.22;
		}
		else if(user_head.coach_type.equals("SL"))//sleeper class,rate is 1.3 times
		{
			fare*=1.30;
		}
		else if(user_head.coach_type.equals("2S"))//second seater,rate is 1.1 times
		{
			fare*=1.1;
		}
		else if(user_head.coach_type.equals("GEN"))// rate is same as original fare
		{
			fare*=1;
		}
		else {fare*=1;}
		
		return fare;
	}
	
	
//	function to create single node with single user_details
	void insert_last(String  first_name,String last_name,char gender,int age,String quota,String coach_type)
	{
		User_Details u_obj=new User_Details();
//		double ticket_fare=u_obj.ticket_fare(head, last_name, coach_type, quota)
		User_Node newnode=new User_Node(first_name,last_name,gender,age,quota,coach_type);
		if(user_head==null)
		{
			user_head=newnode;
			return;
		}
		User_Node current=user_head;
		while(current.next!=null)
		{
			current=current.next;
		}
		current.next=newnode;
	}
	
//	displaying personal details of users
	void show(User_Node user_head)
	{
		User_Node current=user_head;
		if(user_head==null)
		{
			return;
		}
			System.out.print(current.first_name + "\t" + current.last_name + "\t" + current.gender + "\t" + current.age + "\t" + current.quota + "\t" + current.coach_type + "\t");
//			System.out.println();		
	}
	
//	remove spaces from string and convert it to lower case
	 static String lower_case(String str)
	{
		String st="";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				continue;
			}
			st+=str.charAt(i);
		}
		st=st.toLowerCase();
		return st;
	}
	 
//	 generating a captcha
	 void get_captcha()
	 {
		 Scanner sc=new Scanner(System.in);
		 int num=(int)Math.floor(Math.random()*900.0)+100;
		 String st="";
		 int b=0,c=0;
		 while(num>0)
		 {
			 c=num%10;
			 b=(int)(26*Math.random())+1;
			 st+=Integer.toString(c)+(Character.toString(b+'A'));
			 num/=10;
		 }
		 System.out.println("Captcha: " + st);
		 System.out.print("Enter the above Captcha: ");
		 String str=sc.nextLine();
		 boolean bool=check_captcha(str,st);
		 if(bool==true)
		 {
			 return;
		 }
		 get_captcha();
	 }
	 
//	 checking whether entered captcha is true or not
	 boolean check_captcha(String str,String captcha)
	 {
		 boolean check=false;
		 if(captcha.compareTo(str)==0)
		 {
			 check=true;
		 }
		 return check;
	 }
//	 checking if source and destination are availabe and returning arraylist of trains that are availabe
	 ArrayList<Train_details> check_source_destination(String source,String destination)
	 {
		 ArrayList<Train_details> arr=new ArrayList<>();
		 Train_details[] train=forward_journey();
		 boolean bool=false;
		 for(int i=0;i<train.length;i++)
		 {
			 Node src=train[i].head;
			 Node dest=null;
			 while(src!=null)
			 {
				 if(source.compareTo(src.station_name)==0)
				 {
					 dest=src.next;
					 while(dest!=null)
					 {
					 if(destination.compareTo(dest.station_name)==0)
					 {
						 arr.add(train[i]);
						 bool=true;
						 break;
					 }
					 dest=dest.next;
					 }
				 }
				 src=src.next;
			 }
		 }
		 if(bool==false)
		 {
			 System.out.println("Sorry! Train could not be found");
			 System.exit(0);
		 }
		 
		 return arr;
	 }
	 
//	 printing all trains with valid source and destination
	 void valid_trains(ArrayList<Train_details> arr)
	 {
		 User_Details u_obj=new User_Details();
		 for(int i=0;i<arr.size();i++)
			{
			 System.out.print(arr.get(i).head.PNR_NO + "\t");
				u_obj.show(arr.get(i).head);
				System.out.println();
			}
	 }
	 
//checking valid PNR_NO 
	 
	 
	 
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		User_Details u_obj=new User_Details();
		Train_details t_obj=new Train_details();
//		System.out.println("Enter the station from which u want to board the train:");
//		String src=sc.nextLine();
//		String source=lower_case(src);
//		System.out.println("Enter the destination:");
//		String dest=sc.nextLine();
//		String destination=lower_case(dest);
//		ArrayList<Train_details> arr=u_obj.check_source_destination(source, destination);
		
		
//		for(int i=0;i<arr.size();i++)
//		{
//			u_obj.show(arr.get(i).head);
//			System.out.println();
//		}
		
//		u_obj.valid_trains(arr);
//		String st=obj.get_captcha();
//		System.out.println(st);
//		System.out.println("enter");
//		String str=sc.nextLine();
//		if(obj.check_captcha(str,st))
//		{
//			System.out.println(true);
//		}
//		else
//		{
//			System.out.println(false);
//		}
//		obj1.forward_journey();
//		User_Details[] a=new User_Details[2];
//		for(int i=0;i<2;i++)
//		{
//			a[i]=new User_Details();
//		}
//		for(int i=0;i<2;i++)
//		{
//		System.out.println("Enter First name:");
//		String first_name=sc.next();
//		System.out.println("Enter Last name:");
//		String last_name=sc.next();
//		System.out.println("Enter gender: ");
//		char gender=sc.next().charAt(0);
//		System.out.println("Enter age: ");
//		int age=sc.nextInt();
//		System.out.println("Enter Quota: ");
//		String quota=sc.next();
//		a[i].insert_last(first_name, last_name, gender, age, quota);
//		}
//		System.out.println(a.length);
//		User_Details[] arr=u_obj.user_details(2);
//		for(int i=0;i<2;i++)
//		{
//			u_obj.show(arr[i].user_head);
//		}
		
//		ArrayList<Train_details> arr=u_obj.check_source_destination("mumbaicentral","surat");
//		u_obj.valid_trains(arr);
//		u_obj.show(arr.get(0).head);
////		double t_fare=u_obj.ticket_fare("2A-AC", u_obj.ticket_fare(arr.get(1).head, "mumbaicentral", "surat", "OBC"));
////		System.out.println(fare);
//		System.out.println("abc");
//		System.out.println("ahdshdbf");
//		User_Details[] arr1=u_obj.user_details(2);
//		for(int i=0;i<2;i++)
//		{
//			u_obj.show(arr1[i].user_head);
//			double fare=u_obj.ticket_fare(arr.get(1).head, "mumbaicentral", "surat", arr1[i].user_head.quota);
//			double t_fare=u_obj.ticket_fare(arr1[i].user_head, fare);
//			System.out.println(t_fare);
//			
//		}
		
//		u_obj.no_of_tickets();
//		String st=u_obj.coach_type("1a-ac");
//		System.out.println(st);
		Train_details[] arr=t_obj.forward_journey();
		u_obj.make_bst(arr,120090);
		ArrayList<Train_details> arr1=u_obj.check_source_destination("mumbaicentral", "surat");
		u_obj.make_bst(arr1,12009);
		//if(null!=u_obj)
	}

}
