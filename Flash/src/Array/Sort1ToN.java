package Array;
/**
 * time complexity O(n)
 * take input for range of input
 * @author USER
 *
 */
public class Sort1ToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,4,3,2,6};
		cyclicsort(arr, arr.length);
		for(int i:arr)
			System.out.print(i+" ");
	}
public static void cyclicsort(int[] a,int length)
{
for(int i=0;i<length;i++)
{
if(a[i]!=i+1)
{
int temp=a[i];
a[i]=a[temp-1];
a[temp-1]=temp;
}
}

}
}
