package Amazon;

import java.util.ArrayList;
import java.util.Collections;

public class ThekthFactorofn1492 {
    public static void main(String[] args) {
        var result = kthFactor(7,2);
        System.out.println(result);
    }

    //Approach2 Time Complexity - O(N)  and Space Complexity - O(1)
    public static int kthFactor2(int n,int k){
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n % i == 0){
                count++;
                if(count == k)
                    return i;
            }
        }
        return -1;
    }

    //Approach1 Time Complexity -  O(N log N) Space Complexity -O(N)
    public static int kthFactor(int n, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n % i == 0) {
                arrayList.add(i);
                if (i != n / i)
                    arrayList.add(n / i);
            }
        }
        for(Integer arr:arrayList)
            System.out.println(arr);

        Collections.sort(arrayList);

        if(arrayList.size() < k)
            return -1;

        if(arrayList.get(k-1) != null)
            return arrayList.get(k-1);
        else
            return -1;
    }
}
