package basicjava;

import java.util.ArrayList;

public class RecursionExercises {

	public int countDigits(int i) {
		// TODO Auto-generated method stub
		if (i < 0) {
            i = -i;
        }
        if (i < 10) {
            return 1;
        }
        return 1 + countDigits(i / 10);
    }

	public int addDigits(int sum) {
		// TODO Auto-generated method stub
		if (sum < 0) {
            sum = -sum;
        }
        if (sum < 10) {
            return sum;
        }
        return sum % 10 + addDigits(sum / 10);
    }

	public int sum(int sumFrom, int sumTo) {
		// TODO Auto-generated method stub
		if (sumFrom > sumTo || sumFrom < 0 || sumTo < 0) {
            return 0;
        }
        if (sumFrom == sumTo) {
            return sumFrom;
        }
        return sumFrom + sum(sumFrom + 1, sumTo);
    }

	public int sumEvenNumbers(int i) {
		// TODO Auto-generated method stub
		if (i < 0) {
            return 0;
        }
        if (i % 2 == 0) {
            return i + sumEvenNumbers(i - 2);
        }
        return sumEvenNumbers(i - 1);
    }

	public int countVowels(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = "AEIOUaeiou".indexOf(str.charAt(0)) != -1 ? 1 : 0;
        return count + countVowels(str.substring(1));
    }

	public String removeVowels(String str) {
		// TODO Auto-generated method stub
		if (str == null || str.isEmpty()) {
            return str;
        }
        char first = str.charAt(0);
        if ("AEIOUaeiou".indexOf(first) != -1) {
            return removeVowels(str.substring(1));
        }
        return first + removeVowels(str.substring(1));
    }

	public int sumOfMultiple(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (list == null || list.size() == 0) {
            return 0;
        }
        int last = list.remove(list.size() - 1);
        if (last % 5 == 0) {
            return last + sumOfMultiple(list);
        }
        return sumOfMultiple(list);
    }

}
