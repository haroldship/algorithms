import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

	public List<T> sort(List<T> list) {
		if (list.size() <= 1) {
			return list;
		}
		return merge(sort(list.subList(0, list.size()/2)), sort(list.subList(list.size()/2, list.size())));
	}

	private List<T> merge(List<T> subList1, List<T> subList2) {
		int n1 = subList1.size();
		int n2 = subList2.size();
		int n = n1 + n2;
		int i1 = 0;
		int i2 = 0;
		List<T> result = new ArrayList<T>(n);
		for (int i=0; i<n; ++i) {
			if (i1 >= n1) {
				result.addAll(subList2.subList(i2, n2));
				break;
			}
			if (i2 >= n2) {
				result.addAll(subList1.subList(i1, n1));
				break;
			}
			
			T v1 = subList1.get(i1);
			T v2 = subList2.get(i2);
			
			if (v1.compareTo(v2) < 0) {
				result.add(v1);
				i1++;
			} else {
				result.add(v2);
				i2++;
			}
		}
		return result;
	}

}
