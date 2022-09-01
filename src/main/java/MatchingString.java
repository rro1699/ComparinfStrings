import org.simmetrics.StringMetric;
import org.simmetrics.metrics.StringMetrics;

import java.util.ArrayList;
import java.util.List;

public class MatchingString {
    private List<String> resultSet;

    public MatchingString() {
        resultSet = new ArrayList<>();
    }

    public List<String> getResultSet() {
        return resultSet;
    }

    public void matching(List<String> firstSet, List<String> secondSet){
        StringMetric metrics = StringMetrics.smithWatermanGotoh();
        float metricValue;
        float maxValueOnStep;
        int j;
        int resultOnStep;
        while(firstSet.size()>0){
            if(secondSet.isEmpty())
                break;
            if(firstSet.size()==1 && secondSet.size()==1){
                resultSet.add(firstSet.get(0) + ":" + secondSet.get(0));
                firstSet.remove(0);
                secondSet.remove(0);
                break;
            }
            j=0;
            resultOnStep = 0;
            maxValueOnStep = 0.0f;
            while (j<secondSet.size()){
                metricValue = metrics.compare(firstSet.get(0),secondSet.get(j));
                if(metricValue > maxValueOnStep){
                    maxValueOnStep = metricValue;
                    resultOnStep = j;
                }
                j++;
            }
            if(maxValueOnStep != 0) {
                resultSet.add(firstSet.get(0) + ":" + secondSet.get(resultOnStep));
                firstSet.remove(0);
                secondSet.remove(resultOnStep);
            }else{
                firstSet.add(firstSet.get(0));
                firstSet.remove(0);
            }
        }
        if(firstSet.size()>0){
            firstSet.forEach(element -> {
                resultSet.add(0,element+":?");
            });
        }
        if(secondSet.size()>0){
            secondSet.forEach(element ->{
                resultSet.add(element+":?");
            });
        }
    }
}
