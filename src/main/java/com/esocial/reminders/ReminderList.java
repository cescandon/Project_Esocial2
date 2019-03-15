/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esocial.reminders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Francisco Diaz
 */
public class ReminderList {
    private final String category;
    private final List<Reminder> reminders;

    public ReminderList(String _category) {
        category = _category;
        reminders = new ArrayList<>();
    }

    public void add(Reminder rem) {
        reminders.add(rem);
    }

    public List<Reminder> getTodaysReminders() {
        List<Reminder> todays = new ArrayList<>();
        Calendar today = new GregorianCalendar();
        int thisYear = today.get(Calendar.YEAR),
            thisMonth = today.get(Calendar.MONTH),
            thisDay = today.get(Calendar.DAY_OF_MONTH);
        for (Reminder rem: reminders) {
            if (rem.getAlertTime() != null
                   && thisYear == rem.getAlertTime().get(Calendar.YEAR)
                    && thisMonth == rem.getAlertTime().get(Calendar.MONTH)
                    && thisDay == rem.getAlertTime().get(Calendar.DAY_OF_MONTH))
                todays.add(rem);
        }
        return todays;
    }
    
}
