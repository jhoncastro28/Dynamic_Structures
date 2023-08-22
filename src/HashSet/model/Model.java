package HashSet.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author jhonm
 */
public class Model {
    
   public <T> Set<Set<T>> generatePowerSet(Set<T> inputSet) {
        List<T> elements = new ArrayList<>(inputSet);
        int numOfSubsets = 1 << elements.size();
        Set<Set<T>> powerSet = new HashSet<>();

        for (int i = 0; i < numOfSubsets; i++) {
            Set<T> subset = new HashSet<>();
            for (int j = 0; j < elements.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(elements.get(j));
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }
}
