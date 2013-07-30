import java.util.Calendar;
import java.util.GregorianCalendar;

/*
You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

public class P19 {
	final int upperLimit = 2000;
	
	public void solve(){
		int sundays = 0;
		
		for (int year = 1901; year <= upperLimit; year++){
			for (int month=1; month<=12; month++){
				if (new GregorianCalendar(year, month, 1).get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
					sundays++;
				}
			}
		}
		System.out.println(sundays);
	}
}
