package util;

/**
 * @author 王浩
 * @date 2021/7/29 10:51 上午
 */
public class ExampleArray2JavaArray {
    public static void main(String[] args) {
        String[] exampleArrays = {
                "[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]",
                "[[1,4],[2,5]]"
        };
        String exampleArray = exampleArrays[1];
        String result = exampleArray.replaceAll("\\[", "\n\t{");
        result = result.replaceAll("]]", "]\n]");
        result = result.replaceAll("]", "}");
        result = result.replaceAll(",", ", ");
        System.out.println(result);
    }
}
