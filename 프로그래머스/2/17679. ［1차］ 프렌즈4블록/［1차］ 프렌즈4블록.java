import java.util.*;

class Solution {
    public int[][] deltas = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] blocks = new char[m][n];
        for (int i = 0; i < m; i++) {
            blocks[i] = board[i].toCharArray();
        }

        while(true) {
            List<int[]> list = new ArrayList();

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (blocks[i][j] != ' ' && find(blocks, i, j)) {
                        list.add(new int[]{i, j});
                    }
                }
            }

            if (list.size() == 0) {
                break;
            }    

            answer += remove(blocks, list);

            move(blocks);
        }

        return answer;
    }

    public boolean find(char[][] blocks, int r, int c) {
        for (int d = 1; d <= 3; d++) {
            if (blocks[r][c] != blocks[r + deltas[d][0]][c + deltas[d][1]]) {
                return false;
            }
        }

        return true;
    }

    public int remove(char[][] blocks, List<int[]> list) {
        int count = 0;

        for (int[] pos : list) {
            int r = pos[0];
            int c = pos[1];

            for (int d = 0; d < 4; d++) {
                if (blocks[r + deltas[d][0]][c + deltas[d][1]] != ' ') {
                    blocks[r + deltas[d][0]][c + deltas[d][1]] = ' ';
                    count++;
                }
            }
        }

        return count;
    }

    public void move(char[][] blocks) {
        for (int j = 0; j < blocks[0].length; j++) {
            for (int i = blocks.length - 1; i >= 0; i--) {
                if (blocks[i][j] == ' ') {
                    int l = i - 1;

                    while (l >= 0) {
                        if (blocks[l][j] == ' ') {
                            l--;
                        } else {
                            break;
                        }
                    }

                    if (l < 0) {
                        break;
                    }

                    blocks[i][j] = blocks[l][j];
                    blocks[l][j] = ' ';
                }
            }
        }
    }
}