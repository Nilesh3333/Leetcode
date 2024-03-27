public class canPlaceFlowers605 {
    //Time Complexity - O(n)
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,1,0,1,0,1};
        int n = 1;
        boolean ans = canPlaceFlowers(flowerbed,n);
        System.out.println(ans);
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l=flowerbed.length;
        if(l==1){
            if(flowerbed[0]==0){
                n--;
                return n<=0;
            }
        }
        for(int i=0;i<flowerbed.length;i++){
            if(i==0){
                if(i+1<l && flowerbed[i]==0 && flowerbed[i+1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }else if(i==l-1 ){
                if(i-1>=0 && flowerbed[i]==0 && flowerbed[i-1]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }else{
                if(flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0){
                    flowerbed[i]=1;
                    n--;
                }
            }
            if(n<=0){
                return true;
            }
        }
        return false;
    }
}

