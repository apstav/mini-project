package gr.aueb.cf.miniProjects;

public class Project3 {

    public static void main(String[] args) {
        int[][] arr = {{1,2},{9,5},{8,4}};
        int[][] shallow = new int[3][2];
        int[][] deep = new int[3][2];

        shallow=shallowCopy(arr);
        deep=deepCopy(arr);

        System.out.println("The source array:");
        printArr(arr);
        System.out.println("The shallow copy:");
        printArr(shallow);
        System.out.println("The deep copy:");
        printArr(deep);

        for (int i=0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] +=1;
            }
        }

        System.out.println("We added 1 in each element of the source array");
        System.out.println("The source array.");
        printArr(arr);
        System.out.println("The shallow copy.");
        printArr(shallow);
        System.out.println("The deep copy.");
        printArr(deep);


    }

    public static int[][] shallowCopy(int[][] arr) {
        int[][] shallow = arr;
        return shallow;
    }

    public static int[][] deepCopy(int[][] arr) {
        int[][] deep =new int[arr.length][2];

        for (int i=0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++) {
                deep[i][j] = arr[i][j];
            }
        }
        return deep;
    }

    public static void printArr(int[][] arr){
        for (int[] row : arr){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
