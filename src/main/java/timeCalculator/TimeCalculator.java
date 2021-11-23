package timeCalculator;

import model.Root;


import java.util.ArrayList;
import java.util.Locale;

public class TimeCalculator {
    int count = 0;
    int sumTime = 0;
    int avgTime = 0;
    ArrayList<Integer> timeFlying = new ArrayList<>();//list of time flying


    //calculation arithmetic mean of flight
    public String calculate( Root root) {
        int departureMinutes = 0;
        int arrivalMinutes = 0;
        String inputTime;

        for (int i = 0; i < root.getTickets().size(); i++) {

            inputTime = root.getTickets().get(i).getDeparture_time();
            departureMinutes = convertTime(inputTime);
            inputTime = root.getTickets().get(i).getArrival_time();
            arrivalMinutes = convertTime(inputTime);

            sumTime += arrivalMinutes - departureMinutes;
            count++;

            timeFlying.add(arrivalMinutes - departureMinutes);
        }

        avgTime = sumTime / count;

        return convertTime(avgTime);
    }

    //Converting String to integers
    public int convertTime(String time) {
        int hours = 0;
        int minutes = 0;
        boolean hasHours = false;

        String[] arrayTime = time.split("");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i <= arrayTime.length; i++) {

            if (i == arrayTime.length) {
                minutes = Integer.parseInt(stringBuffer.toString());
                break;
            }

            if ((arrayTime[i].matches("[0-9]+"))) {
                stringBuffer.append(arrayTime[i]);
            } else {
                if (!hasHours) {
                    hours = Integer.parseInt(stringBuffer.toString());
                    stringBuffer.delete(0, i);
                    hasHours = true;
                }
            }
        }
        minutes += hours * 60;//convert all hours to minutes


        return minutes;//return converted time
    }

    public String convertTime(int minutes){
        int hours = minutes/60;
        minutes=minutes%60;
        String time = String.format(Locale.getDefault(),
                "%02d:%02d", hours, minutes);
        return time;
    }

    public ArrayList<Integer> getTimeFlying() {
        return timeFlying;
    }
}
