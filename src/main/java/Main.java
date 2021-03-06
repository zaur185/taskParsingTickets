import gsonParse.GsonParser;
import model.Root;
import percentile.Percentile;
import timeCalculator.TimeCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String... args ) {
        GsonParser gsonParser= new GsonParser();
        TimeCalculator calculator=new TimeCalculator();
        Percentile percentile=new Percentile();

        String resultPercentile;
        String time;

        time = calculator.calculate(gsonParser.parse());
        resultPercentile = percentile.calculatePercentile(calculator.getTimeFlying(),90);

        System.out.println("среднее время полета между городами Владивосток и Тель-Авив составляет->"+time);
        System.out.println("90-й процентиль времени полета между городами Владивосток и Тель-Авив составляет->"+resultPercentile);
    }
}
