package com.example.maximovd.weather;

import java.util.Calendar;

public class GreetingStringBuilder {
    private int currentHour;
    private IGreetingStrings iGreetingStrings;
    private String currentTime;

    GreetingStringBuilder(IGreetingStrings iGreetingStrings){
        this.iGreetingStrings = iGreetingStrings;
        currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        currentTime = Calendar.getInstance().getTime().toString();
    }

    String getText () {

        if (5 <= currentHour && currentHour < 12) {         // Если утро
            return iGreetingStrings.getMorning();
        } else if (12 <= currentHour && currentHour < 18) {    // Если день
            return iGreetingStrings.getAfternoon();
        } else if (18 <= currentHour && currentHour < 21) {    // Если вечер
            return iGreetingStrings.getEvening();
        } else {                                              // Если поздний вечер или ночь
            return iGreetingStrings.getNight();
        }
    }
    String getTime() {
            return String.format("%s %s!",iGreetingStrings.getTimePrefix(), currentTime);
        }

}