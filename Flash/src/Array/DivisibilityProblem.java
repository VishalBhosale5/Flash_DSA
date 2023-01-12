package Array;

import java.util.*;
import java.io.*;

public class DivisibilityProblem
{
    public static void main(String args[]) throws Exception
    {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       Scanner sc=new Scanner(System.in);
        int l=sc.nextInt();
        if(l>=1 && l<=10000)
        {
                  
          LinkedHashMap<Integer,Integer> map=new LinkedHashMap<>();
        for(int j=0;j<l;j++)
        {
                  int key=sc.nextInt();
                  int value=sc.nextInt();
                    map.put(key,value);
          }
          
          
          map.forEach((k,v)->
          {
                    if(k>=1 && v<=1000000000)
                    {
                    int count=0;
                    while(!(k%v==0) && k>=1 & v>1)
                    {
                              k++;
                              count++;
                    }
                    System.out.println(count);
                    }
           });
          
          
          
        }
        
        
    }
        }
        
        
    













