class Solution {
    public int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int[][] matrix;
    
    public int rows, columns;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        matrix = new int[rows][columns];
        rows = rows;
        columns = columns;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        
        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            
            answer[i] = turn(query[0] - 1, query[1] - 1, query[2] - 1, query[3] - 1);
        }
    
        
        return answer;
    }
    
    public int turn(int sr, int sc, int er, int ec) {        
        int tmp = matrix[sr][sc];
        int minVal = tmp;
        
        int cr = sr;
        int cc = sc;
        
        int d = 0;
        
        while(isIn(cr, cc, sr, sc, er, ec)) {
            int nr = cr + deltas[d][0];
            int nc = cc + deltas[d][1];
            
            if(nr == sr && nc == sc) {
                matrix[cr][cc] = tmp;
                break;
            }
            
            if(isIn(nr, nc, sr, sc, er, ec)) {
                matrix[cr][cc] = matrix[nr][nc];
                minVal = Math.min(minVal, matrix[nr][nc]);
                cr = nr;
                cc = nc;
            } else {
                d = (d + 1) % 4;
            }
        }
        
        return minVal;
    }
    
    public boolean isIn(int r, int c, int sr, int sc, int er, int ec) {
        return r >= sr && r <= er && c >= sc && c <= ec;
    }
}