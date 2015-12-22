import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestMergeSort {

	@Test
	public void testInteger() {
		MergeSort<Integer> m = new MergeSort<>();
		List<Integer> list = Arrays.asList(4, 1, 200, 201, 33, -6, -7, 44);
		List<Integer> mlist = m.sort(list);
		assertArrayEquals(new Integer[] { -7, -6, 1, 4, 33, 44, 200, 201} , mlist.toArray());
	}


	@Test
	public void testOneString() {
		MergeSort<String> m = new MergeSort<>();
		List<String> list = Arrays.asList("one");
		List<String> mlist = m.sort(list);
		assertArrayEquals(new String[] { "one" } , mlist.toArray());
	}

	@Test
	public void testString() {
		MergeSort<String> m = new MergeSort<>();
		List<String> list = Arrays.asList("one", "two", "three", "four");
		List<String> mlist = m.sort(list);
		assertArrayEquals(new String[] { "four", "one", "three", "two" } , mlist.toArray());
	}

}
