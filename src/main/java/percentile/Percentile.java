package percentile;

import timeCalculator.TimeCalculator;

import java.util.Collections;
import java.util.List;

public class Percentile implements CalculatePercentile {

    @Override
    public String calculatePercentile(List<Integer> list, double percentile) {
        Collections.sort(list);
        int index = (int) Math.ceil(percentile /  100.0*list.size() );

        TimeCalculator timeCalculator = new TimeCalculator();
        return  timeCalculator.convertTime(list.get(index - 1));

    }

}
