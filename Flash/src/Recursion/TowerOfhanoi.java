package Recursion;

public class TowerOfhanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int n=3;
towerOfHanoi(n,'S','D','H');
	}

	private static void towerOfHanoi(int n, char src, char dest, char helper) {
		// TODO Auto-generated method stub
		if(n<1)
			return;
		
		towerOfHanoi(n-1,src, helper, dest);
		System.out.println("Move "+n+" disk from peg "+src+" to peg "+dest+" ");
		
		towerOfHanoi(n-1, helper,dest, src);
	}

}
