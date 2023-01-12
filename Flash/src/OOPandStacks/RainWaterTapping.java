package OOPandStacks;

public class RainWaterTapping {

	/*
	 * time: O(n)
	 * space:O(n)  for two extra arrays of size n
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar= {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		CalculateUnitWater(ar);
	}

	private static void CalculateUnitWater(int[] ar) {
		
		int[] MaxLeft=new int[ar.length];
		int[] MaxRight=new int[ar.length];
		
		
		MaxLeft[0]=ar[0];
		
		for(int i=1;i<ar.length;i++)
		{
			MaxLeft[i]=Math.max(MaxLeft[i-1], ar[i]);
			
		}
		
		MaxRight[ar.length-1]=ar[ar.length-1];
		
		for(int i=ar.length-2;i>0;i--)
		{
			MaxRight[i]=Math.max(MaxRight[i+1], ar[i]);
		}
		int unit=0;
		
		for(int i=0;i<ar.length;i++)
		{
			unit+=Math.min(MaxRight[i], MaxLeft[i])-ar[i];
		}
		
		System.out.println(unit);
	}

}
