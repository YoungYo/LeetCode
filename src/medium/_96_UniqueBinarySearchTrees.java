package medium;

public class _96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        _96_UniqueBinarySearchTrees unst = new _96_UniqueBinarySearchTrees();
        int n = 19;
        System.out.println(unst.numTrees(n));
    }
}
