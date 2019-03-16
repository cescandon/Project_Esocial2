package com.esocial.reminders;


import java.util.Calendar;
import java.util.GregorianCalendar;
import com.esocial.utils.dates.Dates;

/**
 * Support adding a reminder through console input
 * @author Francisco Diaz
 */
public final class AddReminder {
    // how many years in advance we can set a reminder alert
    private static final int MAX_ADVANCE = 100;
    private final ReminderList remList;

    // get list to work with
    public AddReminder(ReminderList _remList) {
        remList = _remList;
    }

    @Override
    public String toString() {
        return "Add a reminder";
    }    
      
    public Boolean Add(String desc, int year, int mon, int day, int hour, int min) {
        int _yr, _mo, _day, _hr, _min;
        
        if(year < 0 || mon < 0 || day < 0 || hour < 0 || min < 0)
        	return false;
        
        int thisyr = Dates.getThisYear();
        _yr = (year > thisyr+MAX_ADVANCE)? thisyr+MAX_ADVANCE : year;
        _mo = (mon > Calendar.DECEMBER)? Calendar.DECEMBER: mon;
        _day = (day > 31)? 31: day;
        _hr = (hour > 23)? 23: hour;
        _min = (min > 59)? 59: min;
        GregorianCalendar alert = new GregorianCalendar(_yr, _mo, _day, _hr, _min);
        remList.add(new Reminder(desc, alert));
       
        return true;
    }
}
