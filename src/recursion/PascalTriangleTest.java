package recursion;

import java.util.ArrayList;

public class PascalTriangleTest {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> resultArrayList = new ArrayList();
        reversePascal(resultArrayList, 0, 6);
        for (int i = 0; i < resultArrayList.size(); i++) {

            for (int j = 0; j < resultArrayList.get(i).size(); j++) {
                for (int k =resultArrayList.get(resultArrayList.size()-1).size()-i; k>=0; k--){
                    System.out.print(" ");
                }
                System.out.print(" "+resultArrayList.get(i).get(j).toString());
            }
            System.out.println("");
        }
    }

    public static void reversePascal(ArrayList<ArrayList<Integer>> resultArrayList, int lineNum, int totalNum) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (lineNum > totalNum) {
            return;
        }
        for (int i = 0; i < lineNum; i++) {
            if (i == 0 || i == lineNum - 1) {
                arrayList.add(1);
            } else {
                int temp = resultArrayList.get(lineNum - 1).get(i - 1) + resultArrayList.get(lineNum - 1).get(i);
                arrayList.add(temp);
            }
        }
        resultArrayList.add(arrayList);
        reversePascal(resultArrayList, lineNum + 1, totalNum);
    }
}
