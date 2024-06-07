public class replaceElements {
    public int[] replaceElementsBest(int[] arr) {
        int n = arr.length;
        int current = arr[n-1];
        arr[n-1] = -1;
        for(int i = n-2; i>=0 ;i--){
            if(current < arr[i]){
                int temp = current;
                current = arr[i];
                arr[i] = temp;
            }
            else{
                arr[i] = current;
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        replaceElements re = new replaceElements();
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] result = re.replaceElementsBest(arr);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
