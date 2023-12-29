
public class LCcount {

    static int mot_size = 21;
    static int asm_code_size = 10;

    public static void lc(int[] lc, String[][] mot_table, String[][] asm_code) {
        int lc_start = 0;
        int flag = 0;

        if ("START".equals(asm_code[0][1])) {
            lc_start = Integer.parseInt(asm_code[0][2]);
        }

        for (int i = 0; i < asm_code_size; i++) {
            for (int j = 0; j < 21; j++) {
                if (asm_code[i][1].equals(mot_table[j][0])) {
                    int temp = Integer.parseInt(mot_table[j][2]);
                    lc_start = lc_start + temp;
                    lc[i] = lc_start;
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println(asm_code[i][1] + " Not Found");
            }
            flag = 0;
        }

        // System.out.println("LC Count : \n");
        // for (int i = 0; i < asm_code_size; i++) {
        //     System.out.println(i+1 + ") " + lc[i]);
        // }
    }
    public static void main(String[] args) {
        
        String[][] mot_table = new String[25][4];
        Practice.mottable(mot_table);

        String[][] asm_code = new String[100][5];
        Practice.asmcode(asm_code);

        int[] lc = new int[25];
        lc(lc, mot_table, asm_code);
    }
}
