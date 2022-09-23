import java.util.*;
import java.lang.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
abstract class Vehicle{

    String VehicleNumber;
	Boolean EV;
	Boolean ChargeRequired;
    Boolean Handicapped;

}

class Two_Wheeler extends Vehicle{

    Two_Wheeler(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Compact_4_W extends Vehicle{

    Compact_4_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Normal_4_W extends Vehicle{

    Normal_4_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}

class Heavy_4_W extends Vehicle{

    Heavy_4_W(String VehicleNumber, boolean EV,boolean ChargeRequired, boolean Handicapped){
        this.VehicleNumber = VehicleNumber;
	    this.EV = EV;
	    this.ChargeRequired = ChargeRequired;
        this.Handicapped = Handicapped;
    }
}



abstract class Floor{
    int current_capacity;
    int max_capacity;
    int four_wheelers;
    int max_four_wheelers;
    int two_wheelers;
    int max_two_wheelers;

    abstract void display_board(); // displays the no of empty slots for parking in order of (total, 4w, 2w)
    abstract void exit(); // does all the functions when a vehicle exits
    abstract void payment(); // gives price for parking
    abstract void update(); // updates the counter of vehicle that exits/enters
}

class Ground_Floor extends Floor{
    int current_capacity=0;
    int max_capacity = 100;
    int handicapped_vehicles = 0;
    int max_handicapped_vehicles = 50;
    int EV_4_wheelers = 0;
    int max_EV_4_Wheelers = 30;
    int EV_2_wheelers = 0;
    int max_EV_2_Wheelers = 20;

    void display_board(){
        System.out.println("Total Empty Slots: " + (max_capacity - current_capacity));
        System.out.println("No. of Handicapped slots available: " + (max_handicapped_vehicles - handicapped_vehicles));
        System.out.println("No. of 4W EV slots available: " + (max_EV_4_Wheelers-EV_4_wheelers));
        System.out.println("No. of 2W EV slots available: " + (max_EV_2_Wheelers-EV_2_wheelers));
    }
    void exit(){};
    void payment(){};
    void update(){};
}

class Normal_Floor extends Floor{
    int current_capacity=0;
    int max_capacity = 100;
    int compact_4_wheelers = 0;
    int max_compact_4_wheelers = 15;
    int normal_4_wheelers = 0;
    int max_normal_4_wheelers = 35;
    int large_4_wheelers = 0;
    int max_large_4_wheelers = 10;
    int two_wheelers = 0;
    int max_two_wheelers = 30;

    void display_board(){
        System.out.println("Total Empty Slots: " + (this.max_capacity - this.current_capacity));
        System.out.println("Total Empty Compact 4W Slots: " + (this.max_compact_4_wheelers - this.compact_4_wheelers));
        System.out.println("Total Empty Normal 4W Slots: " + (this.max_normal_4_wheelers - this.normal_4_wheelers));
        System.out.println("Total Empty Large 4W Slots: " + (this.max_large_4_wheelers - this.large_4_wheelers));
        System.out.println("Total Empty 2W Slots: " + (this.max_two_wheelers - this.two_wheelers));
    }
    void exit(){};
    void payment(){};
    void update(){};
    
}



public class Parking {
	
	static void Entry(String Vehicle_Number,int Vehicle_type, boolean EV, boolean chargeRequired, boolean Handicapped) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to IIT-TP Parking");
		System.out.print("Answer the following:\n1. Enter Vehicle Number:");
		Vehicle_Number=sc.next();
		System.out.println("What is the Vehicle Type?(enter choice number)\n1. 2-Wheeler.\n2. 4-wheeler Compact.\n3. 4-wheeler normal\n 4. 4-wheeler heavy");
		int check=0;
		while(check==0) {			
			if(check==0 )Vehicle_type=sc.nextInt();
			if(Vehicle_type>4 || Vehicle_type<1) 
				System.out.println("Enter Valid option");
			else check = 1;
		}
		System.out.print("2. Is it EV or not?");
		EV = sc.nextBoolean();
		if(EV) {
			System.out.println("2.1 Do you require charging?" );
			chargeRequired = sc.nextBoolean();
		}
		else chargeRequired = false;
		System.out.print("3. Are you Handicapped?");
		Handicapped = sc.nextBoolean();		
	}
	
	static void PrintTicket(String Vehicle_Number,int Vehicle_type, boolean EV, boolean chargeRequired, boolean Handicapped) {
		System.out.println("|------IIT-TP PARKING------|");
		System.out.print("Vehicle Number:"+Vehicle_Number);
		if(Vehicle_type==1) System.out.print("\n 2-wheeler");
		else if(Vehicle_type==2)System.out.print("\n 4-wheeler compact");
		else if(Vehicle_type==3)System.out.print("\n 4-wheeler normal");
		else if(Vehicle_type==4)System.out.print("\n 4-wheeler heavy");
		System.out.print("\nEV:"+EV+"\nEV charging:"+chargeRequired+"\nHandicapped:"+Handicapped);
		System.out.println(java.time.LocalDateTime.now());
		if(EV || Handicapped) System.out.println("Parking in Ground floor only");
		else System.out.println("Parking in levels one to five");
		System.out.println("Price for first 2 hours = ₹50\nPrce per extra hour = ₹20");
	}
	
	
	
//	
//	static void Update(String Vehicle_Number,int Vehicle_type, boolean EV, boolean chargeRequired, boolean Handicapped) {
//		if(Vehicle)
//	}
	
    public static void main(String[] args, Normal_Floor[] floors){
    	Scanner sc = new Scanner(System.in);
        int i, Vehicle_type = 0, floor;
        boolean EV = false, chargeRequired = false, Handicapped = false;
        String Vehicle_Number = null;
        
        //clock object for storing time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));  
        // array to store the objects of normal-floors
        Normal_Floor[] floors1 = new Normal_Floor[5]; //building of 1 ground and 5 normal floors

        // object for ground floor
        Ground_Floor ground = new Ground_Floor();

        //Initializing things for each floor(creating objects of floors)
        for(i=0; i<5; i++) floors1[i] = new Normal_Floor();

        //displaying ground-floor data
        System.out.println("-----  Ground Floor   -----");
        ground.display_board();

        //running a loop to check data on every floor
        for(i=0; i<5; i++){
            System.out.println("-----  Floor ("+(i+1)+")   -----"); // prints the floor number
            floors1[i].display_board(); // its data
        } 
        /*
        Compact_4_W c1 = new Compact_4_W("Sdf", true, true, false);
        Compact_4_W c2 = new Compact_4_W("Ssdfaf", true, true, false);

        System.out.println(c1.VehicleNumber);
        System.out.println(c2.VehicleNumber);
        */
        Entry(Vehicle_Number,Vehicle_type, EV, chargeRequired, Handicapped);
        if(EV || Handicapped) floor = 0;
        else {
        	for(i=0; i<5; i++){
                System.out.println("-----  Floor ("+(i+1)+")   -----"); // prints the floor number
                floors1[i].display_board(); // its data
            } 
        	System.out.print("Which Floor?");
        	floor = sc.nextInt();
        	
        }
        PrintTicket(Vehicle_Number,Vehicle_type, EV, chargeRequired, Handicapped);
        
        
        
    }
}
