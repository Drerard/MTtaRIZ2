import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args){
        int range;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите высоту елки : ");
        range = scanner.nextInt();

        Lab2.Star(range);
        Lab2.Array(6,6);
    }

    public static void Star(int range){
        int max_star = (range-1)*2+1;
        int current_star = 0;
        int space_num = 0;

        for(int i = 1;i<=range;i++){
            current_star = (i-1)*2+1;
            space_num = (max_star-current_star)/2;

            for(int sp = 0; sp < space_num; sp++){
                System.out.print(" ");
            }
            for(int st = 0; st < current_star; st++){
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void Array(int n, int m){
        int[][] arr = new int[n][m];
        int buf = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = buf + 3;
                buf = arr[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(new DecimalFormat( "000 " ).format(arr[i][j]));
            }
            System.out.println();
        }
    }
}
