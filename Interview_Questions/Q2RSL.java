package Interview_Questions;

public class Q2RSL {
    public static void main(String[] args){      
        int[] ans = closestPrime(30);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public static int[] closestPrime(int n){
        int left = n-1;
        int right = n+1;
        int[] ans = new int[2];
        while(!isPrime(left) && !isPrime(right)){
            left--;
            right++;
        }
        if(isPrime(left)) ans[0] = left;
        if(isPrime(right)) ans[1] = right;
        return ans;
    }
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        for(int i=2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}

/*

void swapx(int x, int y) {
    int t;
    t = x;
    x = y;
    y = t;

    printf("Inside swapx: x = %d y = %d\n", x, y);
}

int main() {
    int a = 10, b = 20;

    swapx(a, b);
    printf("Inside main: a = %d b = %d", a, b);
    return 0;
}

*/

/*
void swapx(int* x, int* y) {
    int t;
    t = *x;
    *x = *y;
    *y = t;
    printf("Inside swapx: x = %d y = %d\n", *x, *y);
}

int main() {
    int a = 10, b = 20;

    swapx(&a, &b); 

    printf("Inside main: a = %d b = %d", a, b);
    return 0;
}
 */