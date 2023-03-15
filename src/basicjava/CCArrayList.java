package basicjava;

import java.util.ArrayList;

public class CCArrayList {

	public static int indexOfIgnoreCase(ArrayList<String> strs, String string) {
		// TODO Auto-generated method stubs
		for (int index = 0; index <strs.size(); index++) {
			if(strs.get(index).equalsIgnoreCase(string)) {
				return index;
			}
		}
		return -1;
	}

	public static void insert(ArrayList<Double> nums, double d, int i) {
		// TODO Auto-generated method stub
		if (i < 0 || i > nums.size()) {
			return;
		}
		nums.add(i,d);
		
	}

}
