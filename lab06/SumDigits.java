public class SumDigits {
    public static int sumDigits(int num) {
        int sum = 0;
        while(num != 0){
            int temp = num % 10;
            sum += temp;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        int n = 9876;
        int b = sumDigits(n);
        int c = sumDigits(b);
    }
}
