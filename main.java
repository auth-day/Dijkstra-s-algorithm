package dwa.main;

public class dwa {

    public static int distance;

    public static int[][] used = new int[6][6];
    static int save = 0;

    public static int[][] matrix = {
                            {999, 10, 11,  6,999,999},//x1
                            {999,999, 13,  8, 11, 17},//x2
                            {999,999,999,  5,  6, 15},//x3
                            {999,999,999,999,  7,999},//x4
                            {999,999,999,999,999,  9},//x5  x1 -> x4 -> x5 -> x6
                            {999,999,999,999,999,999}};//x6       //22
        

    public static void main(String[] arr){           /*** MAIN METHOD ***/



                // Определяем граф
        int[] visited = new int[6];               // Посещённые вершины
        int[] compare = {999,999,999,999,999,999 };
        int min;
        int nextNode = 0;


        compare[0] = -1;              // убрал вершину из массива
        visited[0] = 1;               // посещённая вершина
        nextNode = 0;                 // следующая вершина массива


        for(int i = 0; i < matrix.length; ){

            min = 999;
            for(int j = 0; j < 6; j++){
                if(matrix[nextNode][j] < 999 & visited[j] != 1 &
                   matrix[nextNode][j] != compare[j] & matrix[nextNode][j]+distance < compare[j] )
                compare[j] = matrix[nextNode][j]+distance;
                int count = 0;
            }

            for(int l = 0; l < compare.length; l++)  {
                if(min > compare[l] & compare[l] != -1) {
                    min = compare[l];
                    nextNode = l;
                }
            }

            distance = min;
            System.out.println("Вершина: " + nextNode + "\nС весом: " + distance);
            compare[nextNode] = -1;
            visited[nextNode] = 1;

            if(nextNode == 5)
            break;
            
        }

    }
}
