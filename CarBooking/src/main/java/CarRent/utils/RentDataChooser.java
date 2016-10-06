package CarRent.utils;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RentDataChooser {
	
	Date startDateToCheck;
	Date endDateToCheck;

    private Date readInput(String message,String messageRepeat){
        Scanner scan = new Scanner(System.in);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
		System.out.println(message);
		System.out.println("For example, it is now " + format.format(new Date()));
		Date date = null;
		while (date == null) {
			String line = scan.nextLine();
			try {
				date = format.parse(line);
			} catch (ParseException e) {
				System.out.println(messageRepeat);
			}
		}
		return date;


    }
    
    private Date readStartDate(){
        return this.readInput("Please enter start date(valid format yyyy-mm-dd):", "Please enter valid date(yyyy-mm-dd):");
    }
    
    private Date readEndDate(){
        return this.readInput("Please enter end date(valid format yyyy-mm-dd):", "Please enter valid date(yyyy-mm-dd):");
    }

    public void dataChooser(){
    	startDateToCheck = this.readStartDate();
    	endDateToCheck = this.readEndDate();
    	while(true){
    		if(startDateToCheck.after(endDateToCheck)){
    			System.out.println("End date should be later or equal from start date");
    			endDateToCheck=this.readEndDate();
    		}
    		else if(startDateToCheck.before( new Date() )||endDateToCheck.before ( new Date() ) ){
    			System.out.println("Start date should be later or equal than today");
    			startDateToCheck = this.readStartDate();
    		}
    	}
    	
    }
    
}
