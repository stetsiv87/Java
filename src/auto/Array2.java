package auto;

import javax.sound.midi.Soundbank;

/**
 * Created by Yura on 18.10.2016.
 */
public class Array2
{

    private static int boardSize = 8;
    private static int[][] desk = new int[boardSize][boardSize];
    private static int i = 0;
    private static int j = 0;
    private static int count = 1;
    private static int[] iStep = {2, 2, -2, -2, 1, -1, 1, -1};
    private static int[] jStep = {1, -1, -1, 1, -2, -2, 2, 2};

    private static int k;
    private static int[] minStep = {8, 0, 0};  // {<кількість валідних ходів з поточної позиції>, <індекс і>, <індекс j>}

    public static void main(String[] args)
    {
         /*створюємо матрицю 8*8 і присвоюємо 0 значення*/
        for (i = 0; i < boardSize; i++)
        {
            for (j = 0; j < boardSize; j++)
            {
                desk[i][j] = 0;
            }
        }


        /* Заповнюємо масив "ходом коня" використовуючи метод checkStep() */
        i = 0;
        j = 0;
        /* початкова позиція коня на матриці, помічаємо 1 як перший хід */
        desk[i][j] = 1;

        /*  */
        for (count = 2; count <= 64; count++)
        {
            minStep[0] = 8;

            System.out.println("Current position indexes: i= " + i + ";  j= " + j + "\n");
            for (k = 0; k < 8; k++)
            {
             /* перевірки чи хід коня валідний, не за межами дошки */

                if (0 <= (i + iStep[k]) && (i + iStep[k]) < boardSize &&
                        0 <= (j + jStep[k]) && (j + jStep[k]) < boardSize &&
                        desk[i + iStep[k]][j + jStep[k]] == 0 &&
                        CheckHS(i + iStep[k], j + jStep[k]) <= minStep[0])
                {

//                        System.out.println("\n");

                       System.out.println("Number of cycle " + k + ":   валідний хід iStep = " + iStep[k] + "    jStep = " + jStep[k]);


//
                      // System.out.println("Value of iStep massive = " + iStep[k]);
                      // System.out.println("Value of jStep massive = " + jStep[k]);

                       minStep[0] = CheckHS(i + iStep[k], j + jStep[k]);
//                        System.out.println("кількість ходів з координат " + minStep[0]);
                    minStep[1] = i + iStep[k];
                    minStep[2] = j + jStep[k];
                } else
                {
                       System.out.println("Number of cycle " + k + ":   не валідний хід ");

                }
            }


            i = minStep[1];
            j = minStep[2];
            System.out.println("\n");
            System.out.println("вибраний хід  " +"і = " + i + "  j=  " + j);

            showStep(i,j);

            desk[i][j] = count;

            //System.out.println(desk[i][j]);


            System.out.println(i + " " + j);
            System.out.println("\n");
        }
    }


    /* Выводим массив на печать */

    private static void showStep(int i, int j)
    {

        for (i = 0; i < boardSize; i++)
        {
            for (j = 0; j < boardSize; j++)
            {
//                if (desk[i][j] == 0)
//                {
//                    System.out.print("   X");
//                } else
//                {
                System.out.print(desk[i][j] + "\t");
                // }
            }
            System.out.println();
        }
       // System.out.println("y,x = "+ y+" "+x);
    }





    /* Метод ChechHS(int, int) подсчитывает количество
     * возможных ходов на пустые клетки из квадрата с
     * заданными координатами
     */
    private static int CheckHS (int i, int j){
        int  steps = 0;
        int n;

        for (n=0; n<8; n++){
            if (0<=(i+iStep[n]) && (i+iStep[n])<boardSize && 0<=(j+jStep[n]) &&
                    (j+jStep[n])<boardSize && desk[i+iStep[n]][j+jStep[n]]==0){
                steps++;
            }
        }
        return steps;
    }



    }




