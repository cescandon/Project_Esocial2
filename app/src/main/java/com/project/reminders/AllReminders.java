package com.project.reminders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author villa
 */
public class AllReminders implements Serializable {
    private static final String saveFileName = "reminders.save";
    private static final int NO_CHOICE = -1;
    private final List<ReminderList> allrems;
    private int chosenList;

    // Initialize reminders to empty list
    public AllReminders() {
        allrems = new ArrayList<>();
        chosenList = NO_CHOICE;    // no list chosen
    }

    // Add a new list of reminders at the end
    public void addCategory(String catName) {
        allrems.add(new ReminderList(catName));
    }
    
    // Getter for the lists
    public List<ReminderList> getCategories() {
        return allrems;
    }

    // set the "current" list
    public void setFocus(int index) {
        chosenList = index;
    }

    // Add a reminder to the "current" list
    public void addReminder(Reminder rem) {
        allrems.get(chosenList).add(rem);
    }

    // Get all reminders from today, regardless of category
    public List<Reminder> getTodays() {
        List<Reminder> result = new ArrayList<>();
        for (ReminderList remList: allrems)
            result.addAll(remList.getTodaysReminders());
        return result;
    }

    // Get alerts for all reminders, regardless of category
    public List<Reminder> getRemindersWithAlerts() {
        List<Reminder> result = new ArrayList<>();
        for (ReminderList remList: allrems)
            result.addAll(remList.getRemindersWithAlerts());
        return result;
    }

    public ReminderList getCategory(int chosenList) {
        return allrems.get(chosenList);
    }
    
    // Save all reminders to disk
    public static void save(AllReminders toSave) {
        ObjectOutputStream saveFile = null;
        try {
            saveFile = new ObjectOutputStream(new FileOutputStream(saveFileName));
            saveFile.writeObject(toSave);
            saveFile.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AllReminders.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AllReminders.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                saveFile.close();
            } catch (IOException ex) {
                Logger.getLogger(AllReminders.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Load all reminders from disk
    // If file not found, return new object with "Personal" list
    public static AllReminders load()  {
        AllReminders saved;
        try {
            ObjectInputStream saveFile = new ObjectInputStream(new FileInputStream(saveFileName));
            saved = (AllReminders) saveFile.readObject();
            saveFile.close();
            return saved;
        } catch (IOException | ClassNotFoundException ex) {

        }
        saved = new AllReminders();
        saved.addCategory("Personal");
        save(saved);
        return saved;

    }
}
