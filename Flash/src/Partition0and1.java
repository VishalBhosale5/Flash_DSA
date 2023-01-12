
public class Partition0and1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = { 1, 0, 0, 1, 0, 1, 0, 1, 0 };
		partition(ar, ar.length);

		for (int i : ar)
			System.out.print(" " + i);

	}

	private static void partition(int[] ar, int length) {
		// TODO Auto-generated method stub
		int i = 0, j = length - 1;

		while (i < j) {
			while (ar[i] == 0) {
				i++;
			}
			while (ar[j] == 1) {
				j--;
			}

			if (i < j) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
			}

		}
	}

}
