/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esocial.reminders;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Francisco Diaz
 */
public class Reminder {
    private String desc;
    private Calendar alertTime;
    
    public Reminder(String _desc) {
        desc = _desc;
    }

    public Reminder(String _desc, Calendar _alertTime) {
        desc = _desc;
        alertTime = _alertTime;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public Calendar getAlertTime() {
        return alertTime;
    }
    
    
}
