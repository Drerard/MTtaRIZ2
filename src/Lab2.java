public class Lab2 {
    public static void main(String[] args){
        int range = 8;
       Lab2.Star(range);
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
}
