import java.util.*;

public class Demo {

	public static void main(String[] args) {
		HashMap<Integer, String> calList = new HashMap<Integer,String>();
		Scanner sc = new Scanner(System.in);
		int n=10;
		System.out.println("Enter the details of the callers in the list");
		for(int i=0; i<n; i++)
		{
			System.out.println("Enter the name, number of person "+(i+1));
			String name = sc.next();
			int number = sc.nextInt();
			calList.put(number, name);
		}

		ArrayList<Call> misCall = new ArrayList<>();

		System.out.println("Enter the missed calls, one after another");
		int ch=0;
		int i=0;
		while(ch!=2)
		{
			System.out.println("1. Insert Call\n2. Exit");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter the number, time of the call");
				int num = sc.nextInt();
				String t = sc.next();
				String name = "Private Caller";
				if(calList.containsKey(num))
				{
					name = calList.get(num);
				}
				Call call =  new Call(name, num, t);
				try
				{
					misCall.set(i,  call);
				}catch(Exception e)
				{
					misCall.add(call);
				}finally
				{
					i = (i+1)%10;
				}
				break;
				
			case 2:
				break;
			}
		}

		System.out.println("List of Missed calls");
		for (Iterator<Call> iterator = misCall.iterator(); iterator.hasNext(); ) 
		{
		    Call ca = iterator.next();
		    System.out.println("Number : " + ca.phoneNumber);
			int choice=0;
			System.out.println("1. Delete call\n2. Next Missed Call\n3. Display Call details");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				iterator.remove();
				break;
			case 2:
				break;
			case 3:
				ca.display();
				break;
			}
		}

		sc.close();
	}

}