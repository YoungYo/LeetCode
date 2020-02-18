public class BinaryIndexedTree {
    public int[] BIT;
    public int[] A;

    public BinaryIndexedTree(int[] array){
        A = array;
        BIT = new int[array.length+1];
        build();
    }
    int lowbit(int x){
        return x & (-x);
    }

    void build(){
        for (int i = 1; i <= A.length; i++){
            BIT[i] = A[i - 1];
            for (int j = i - 2; j >= i - lowbit(i); j--)
                BIT[i] += A[j];
        }
    }

    void edit(int i, int delta)
    {
        for (int j = i; j <= A.length; j += lowbit(j))
            BIT[j] += delta;
    }

    int sum (int k) {
        int ans = 0;
        for (int i = k; i > 0; i -= lowbit(i))
            ans += BIT[i];
        return ans;
    }

    public static void main(String[] args) {
        BinaryIndexedTree bit = new BinaryIndexedTree(new int[]{1, 7, 3, 0, 5, 8, 3, 2, 6, 2, 1, 1, 4, 5});
        for(int i: bit.BIT){
            System.out.print(i + ", ");
        }
        System.out.println();
        System.out.println(bit.sum(13));
    }
}
