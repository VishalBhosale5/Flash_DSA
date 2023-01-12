
public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = { 2,4,3,1 }; 
		
		findpermutation(a,a.length);
		
		for(int l:a)
			System.out.println(l);

	}

	private static void findpermutation(int[] a, int length) {
		// TODO Auto-generated method stub
		
		int i=length-1;
		
		while(a[i]<a[i-1])
		{
			System.out.println("--");
			i--;
			
		}
		
		System.out.println("i"+i);
		int temp=a[i-1];
		a[i-1]=a[i];
		a[i]=temp;
		
		
		for(int l:a)
			System.out.print(" "+l);
		
		System.out.println();
		for(int j=i-1,k=length-1;j<k;j++,k--)
		{
			int temp1=a[j];
			a[j]=a[k];
			a[k]=temp1;
			
		}
	}

}
