package auto;

import javax.sound.midi.Soundbank;

public class Array2
{

    private static int boardSize = 8;
    private static int[][] desk = new int[boardSize][boardSize];
    private static int i = 0;
    private static int j = 0;
    private static int count = 1;
    private static int[] iStep = {2, 1, -2, -2, 2, -1, 1, -1};
    private static int[] jStep = {1, -2, -1, 1, -1, -2, 2, 2};

    static int iStep_selected;
    static int  jStep_selected;

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
        for (count = 2; count < 66; count++)
        {
            minStep[0] = 8;

            System.out.println("Current position: i= " + i + ";  j= " + j + "\n");
            showStep(i,j);
            System.out.println("\n");

            for (k = 0; k < 8; k++)
            {
             /* перевірки чи хід коня валідний, не за межами дошки */

                if (0 <= (i + iStep[k]) && (i + iStep[k]) < boardSize &&
                        0 <= (j + jStep[k]) && (j + jStep[k]) < boardSize &&
                        desk[i + iStep[k]][j + jStep[k]] == 0 &&
                        checkStep(i + iStep[k], j + jStep[k]) <= minStep[0])

                {
                   // System.out.println("result of function: " +CheckHS(i  + iStep[k] , j + jStep[k]) + "<= minStep " +  minStep[0]  );

                    System.out.println("Можливі ходи:");
                    System.out.println( "Number of cycle " + k + ":   валідний хід iStep = " + iStep[k] + "    jStep = " + jStep[k]);

                    minStep[0] = checkStep(i + iStep[k], j + jStep[k]);
                    System.out.println(minStep[0]);
//                       System.out.println("кількість ходів з координат " + minStep[0]);
                    minStep[1] = i + iStep[k];
                    minStep[2] = j + jStep[k];
                    iStep_selected = iStep[k];
                    jStep_selected = jStep[k];
                } else {
                    //System.out.println("Number of cycle " + k + ":   не валідний хід ");
                }
            }

            System.out.println("Вибраний хід: iStep " + iStep_selected + "    jStep = " + jStep_selected);
            System.out.println("======================================================================================================================");

            i = minStep[1];
            j = minStep[2];

            System.out.println("\n");

            desk[i][j] = count;

        }
    }

    /* Друкуємо масив */

    private static void showStep(int i, int j)
    {

        for (i = 0; i < boardSize; i++)
        {
            for (j = 0; j < boardSize; j++)
            {
                System.out.print(desk[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /* Метод checkStep (int, int) підраховує кількість можливих ходів на вільні клітинки з заданими координатами */

    private static int checkStep (int i, int j){
        int  steps = 0;
        int n;

        for (n=0; n<8; n++){
            // визначення кількісті валідних степів
            if (0<=(i+iStep[n]) && (i+iStep[n])<boardSize && 0<=(j+jStep[n]) &&
                   (j+jStep[n])<boardSize && desk[i+iStep[n]][j+jStep[n]]==0)
            {
                steps++;
            }
        }
        return steps;
    }
}




