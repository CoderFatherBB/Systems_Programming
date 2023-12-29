public class Literal {

    static int mot_size = 21;
    static int asm_code_size = 10;

    public static void literaltable(String[][] literal_table, int[] lc, String[][] mot_table, String[][] asm_code) {
        
        int count = 0;
        int address = asm_code_size;

        for (int i = 0; i < asm_code_size; i++) {
            if (asm_code[i][3] != null && asm_code[i][3].startsWith("=")) {
                literal_table[count][0] = count+1 + "";
                literal_table[count][1] = asm_code[i][3];

                // if (asm_code[i][1].equals("LTORG")) {
                //     literal_table[count][2] = lc[i++] + "";
                // }
                count ++;
            }
        }
        for (int i = 0; i < count; i++) {
            if (literal_table[count][2] == null) {
                // System.out.println(lc[address-1]);
                literal_table[i][2] = lc[address-1]+1 + "";
            }
        }
        
        System.out.println("\n Literal Table : \n");
        for (int i = 0; i < count; i++) {
            System.out.println("Index : " + literal_table[i][0] + 
                               "\t Name : " + literal_table[i][1] +
                               "\t Address : " + literal_table[i][2]);
        }
    }
    public static void main(String[] args) {
        String[][] mot_table = new String[25][4];
        Practice.mottable(mot_table);

        String[][] asm_code = new String[100][5];
        Practice.asmcode(asm_code);

        int[] lc = new int[25];
        LCcount.lc(lc, mot_table, asm_code);

        String[][] literal_table = new String[20][3];
        literaltable(literal_table, lc, mot_table, asm_code);
    }
}
