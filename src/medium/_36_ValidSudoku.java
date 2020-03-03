package medium;

public class _36_ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        int cur_num, record;
        char cur_char;
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                record = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        cur_char = board[k][l];
                        if (cur_char != '.'){
                            cur_num = cur_char - '0';
                            if (((record >> (cur_num - 1)) & 1) == 1){
                                return false;
                            }else {
                                record = record | (1 << (cur_num - 1));
                            }
                        }
                    }
                }
            }
        }

        int record_h, record_v, cur_num_h, cur_num_v, cur_char_h, cur_char_v; //分别记录横向的数字和纵向的数字
        for (int i = 0; i < 9; i++) {
            record_h = 0;
            record_v = 0;
            for (int j = 0; j < 9; j++) {
                cur_char_h = board[i][j];
                cur_char_v = board[j][i];
                if (cur_char_h != '.'){
                    cur_num_h = cur_char_h - '0';
                    if (((record_h >> (cur_num_h - 1)) & 1) == 1){
                        return false;
                    }else {
                        record_h = record_h | (1 << (cur_num_h - 1));
                    }
                }
                if (cur_char_v != '.'){
                    cur_num_v = cur_char_v - '0';
                    if (((record_v >> (cur_num_v - 1)) & 1) == 1){
                        return false;
                    }else {
                        record_v = record_v | (1 << (cur_num_v - 1));
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] input = {
            {'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
        };

        char[][] input1 = {
            {'8','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(input1));
/*        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.printf("(%d, %d), ", i, j);
                System.out.printf("(%d, %d), ", j, i);
            }
            System.out.println();
        }*/
    }
}
