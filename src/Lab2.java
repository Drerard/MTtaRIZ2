import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab2 {

    private int range;

    public Lab2(){
        range = 0;
    }
    public Lab2(int range){
        this.range = range;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Lab2 firstObject = new Lab2();
        Lab2 secondObject = new Lab2(7);

        System.out.print("Введите высоту первой елки : ");
        firstObject.range = scanner.nextInt();

        firstObject.Star(firstObject.range);
        firstObject.Array(6,6);

        System.out.println("\nВторая елка : ");
        secondObject.Star(secondObject.range);
    }

    public void Star(int range){
        int max_star, current_star, space_num;

        max_star = (range-1)*2+1;

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

    public void Array(int n, int m){
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
