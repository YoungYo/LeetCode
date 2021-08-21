package util;

/**
 * @author 王浩
 * @date 2021/7/29 10:51 上午
 */
public class ExampleArray2JavaArray {
    public static void main(String[] args) {
        String[] exampleArrays = {
                "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]",
                "[[1,4],[2,5]]",
                "[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]",
                "[[2,1,5],[3,3,7]]",
                "[[2,1,5],[3,3,7]]",
                "[[2,1,5],[3,5,7]]",
                "[[3,2,7],[3,7,9],[8,3,9]]",
                "[[1,2,10],[2,3,20],[2,5,25]]",
                "[[1,2,10],[2,2,15]]"
        };
        String exampleArray = exampleArrays[8];
        String result = exampleArray.replaceAll("\\[", "\n\t{");
        result = result.replaceAll("]]", "]\n]");
        result = result.replaceAll("]", "}");
        result = result.replaceAll(",", ", ");
        System.out.println(result);
    }
}
