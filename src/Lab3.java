import java.util.Scanner;

/*
        x
        o
        X̶
        0̶
        |
*/

public class Lab3 {
    public static void main(String[] args){
        char x = 'x';
        char o = 'o';
        boolean stop = false;
        int cord;
        int step_count = 0;

        Scanner scanner = new Scanner(System.in);
        Play_Field pf = new Play_Field();
        Player player1 = new Player(pf, x);
        Player player2 = new Player(pf, o);


        System.out.print("Введите имя первого игрока: ");
        player1.name = scanner.next();
        System.out.print("Введите имя второго игрока: ");
        player2.name = scanner.next();

        Lab3.Rule();

        do {
            System.out.print("Ход "+player1.name+" (введите число от 1 до 9 включительно): ");
            do {
                cord = scanner.nextInt();
                while (!(cord < 10 && cord > 0)) {
                    System.out.print("Введено некорректное число, попробуйте еще раз: ");
                    cord = scanner.nextInt();
                }
            } while (!(player1.Step(cord-1)));
            step_count++;
            pf.Include_data();

            if(pf.Winner(player1.shape)){
                stop = true;
            }
            else {

                if (step_count == 9) {
                    stop = true;
                }
                else {

                    System.out.print("Ход " + player2.name + " (введите число от 1 до 9 включительно): ");
                    do {
                        cord = scanner.nextInt();
                        while (!(cord < 10 && cord > 0)) {
                            System.out.print("Введено некорректное число, попробуйте еще раз: ");
                            cord = scanner.nextInt();
                        }
                    } while (!(player2.Step(cord - 1)));
                    step_count++;
                    pf.Include_data();
                    if (pf.Winner(player2.shape)) {
                        player2.count_W++;
                        stop = true;
                    }
                }
            }
        } while (!stop);
    }

    public static void Rule(){
        System.out.println("\nЧтоб указать в какую ячейку сетки сделать свой ход - ориентируйтесь по данной таблице, где цифра соответствует координате ячейки");

        int count = 1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                if(j == 1 || j == 3) {
                    System.out.print('|');
                }
                else{
                    System.out.print(count++);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Player {
    Play_Field pf;
    String name;
    int count_W = 0;
    int count_L = 0;
    char shape;

    public Player(Play_Field pf, char shp){
        this.pf = pf;
        shape = shp;
    }

    public boolean Step(int cord){
        if(pf.place_data[cord] == ' '){
            pf.place_data[cord] = shape;
            return true;
        }
        else{
            System.out.print("Ячейка уже занята, выберите другую :");
            return false;
        }
    }
}

class Play_Field {
    char[] place_data = {' ', ' ',' ',' ',' ',' ',' ',' ',' ',};
    char[][] canvas = new char[3][5];


    public void Include_data(){
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                if(j == 1 || j == 3) {
                    canvas[i][j] = '|';
                }
                else{
                    canvas[i][j] = place_data[count++];
                }
            }
        }
        Print();
    }

    public boolean Winner(char ch){
        return (place_data[0]==ch)&&(place_data[1]==ch)&&(place_data[2]==ch)||
                (place_data[3]==ch)&&(place_data[4]==ch)&&(place_data[5]==ch)||
                (place_data[6]==ch)&&(place_data[7]==ch)&&(place_data[8]==ch)||
                (place_data[0]==ch)&&(place_data[3]==ch)&&(place_data[6]==ch)||
                (place_data[1]==ch)&&(place_data[4]==ch)&&(place_data[7]==ch)||
                (place_data[2]==ch)&&(place_data[5]==ch)&&(place_data[8]==ch)||
                (place_data[0]==ch)&&(place_data[4]==ch)&&(place_data[8]==ch)||
                (place_data[2]==ch)&&(place_data[4]==ch)&&(place_data[6]==ch);
    }

    public void Print(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }
}
