public class Symbol {

    static int mot_size = 21;
    static int asm_code_size = 10;

    public static void symboltable(String[][] symbol_table, int[] lc, String[][] mot_table, String[][] asm_code) {
        
        int count = 0;

        for (int i = 0; i < asm_code_size; i++) {
            if (asm_code[i][0] != null) {
                symbol_table[count][0] = count+1 + "";
                symbol_table[count][1] = asm_code[i][0];
                symbol_table[count][2] = lc[i] + "";

                count ++;
            }
        }

        System.out.println("\n Symbol Table : \n");
        for (int i = 0; i < count; i++) {
            System.out.println("Index : " + symbol_table[i][0] + 
                               "\t Name : " + symbol_table[i][1] +
                               "\t Address : " + symbol_table[i][2]);
        }
    }
    public static void main(String[] args) {
        String[][] mot_table = new String[25][4];
        Practice.mottable(mot_table);

        String[][] asm_code = new String[100][5];
        Practice.asmcode(asm_code);

        int[] lc = new int[25];
        LCcount.lc(lc, mot_table, asm_code);

        String[][] symbol_table = new String[20][3];
        symboltable(symbol_table, lc, mot_table, asm_code);
    }
}
