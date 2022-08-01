package SpellCheck;

public class EditDistance {
    private int[][] matrix;
    private int editDistance(String s1, String s2, int m , int n){
        if(m==0)
            return n;

        if(n==0)
            return m;

        if(matrix[m][n]!=-1)
            return matrix[m][n];

        if(s1.charAt(m-1)==s2.charAt(n-1))
            matrix[m][n] = editDistance(s1,s2,m-1,n-1);
        else{
            int insert = editDistance(s1,s2,m,n-1);
            int replace = editDistance(s1,s2,m-1,n-1);
            int delete = editDistance(s1,s2,m-1,n);
            matrix[m][n] = 1+Math.min(insert,Math.min(replace,delete));
        }
        return matrix[m][n];
    }

    public int fetchSimilarity(String s1, String s2){
        int m ,n;
        m = s1.length();
        n = s2.length();
        matrix = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                matrix[i][j] = -1;
            }
        }
        return editDistance(s1,s2,m,n);
    }
}
