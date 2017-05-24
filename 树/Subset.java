import java.util.*;

public class Subset {
    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if(set.size() == index) {//终止条件
			allsubsets = new ArrayList<<>>();
			allsubsets.add(new ArrayList());//空集合
		} else {
			allsubsets = getSubsets(set, index + 1);
			int idem = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<<>>();
			for(ArrayList<Integer> subsets : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<>();
				newsubset.addAll(subsets);
				newsubset.add(item);
				newsubset.add(newsubset);
			}
			allsubsets.add(moresubsets);
		}
		
		return allsubsets;
    }
}