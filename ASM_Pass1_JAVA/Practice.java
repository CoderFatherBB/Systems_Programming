import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice {

    static int mot_size = 21;
    static int asm_code_size = 10;

    public static void mottable(String[][] mot_table) {
        try {
            File motfile = new File("mot_table.txt");
            Scanner scanner = new Scanner(motfile);

            int row = 0;
            while (scanner.hasNextLine() && row < 25) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");

                if (tokens.length == 4) {
                    for (int col = 0; col < 4; col++) {
                        mot_table[row][col] = tokens[col];
                    }
                }
                row ++;
            }
            scanner.close();

            // System.out.println("Contents of the array:");
            // for (int i = 0; i < row; i++) {
            //     System.out.println("Operator: " + mot_table[i][0] +
            //                 "\t Opcode: " + mot_table[i][1] +
            //                 "\t Size: " + mot_table[i][2] +
            //                 "\t Type: " + mot_table[i][3]);
            // }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found : " + e);
        }
    }

    public static void asmcode(String[][] asm_code) {

        try {
            File asmFile = new File("asm_code.txt");
            Scanner scanner = new Scanner(asmFile);

            int row = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll(",", "");
                String[] tokens = line.split(" ");
                
                if (tokens.length == 4) {
                    for (int col = 0; col < 4; col++) {
                        asm_code[row][col] = tokens[col];
                    }
                }
                else if (tokens.length == 3) {
                    // System.out.println(tokens[1]);
                    if ("DC".equals(tokens[1]) || "DS".equals(tokens[1])/*tokens[1] == "DC" || tokens[1] == "DS"*/) {
                        // System.out.println("h");
                        for (int col = 0; col < 3; col++) {
                            asm_code[row][col] = tokens[col];
                        }
                    }
                    else {
                        for (int col = 0; col < 3; col++) {
                            asm_code[row][col+1] = tokens[col];
                        }
                    }
                }
                else if (tokens.length == 2) {
                    for (int col = 0; col < 2; col++) {
                        asm_code[row][col+1] = tokens[col];
                    }
                }
                else {
                    for (int col = 0; col < 1; col++) {
                        asm_code[row][col+1] = tokens[col];
                    }
                }
                row ++;
            }
            scanner.close();

            // System.out.println("\n \nWhole ASM Code : ");
            // for (int i = 0; i < row; i++) {
            //     System.out.println("Field 1 : " + asm_code[i][0] + 
            //                        "\t Field 2 : " + asm_code[i][1] +
            //                        "\t Field 3 : " + asm_code[i][2] +
            //                        "\t Field 4 : " + asm_code[i][3] );
            // }

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found : " + e);
        }
  
    }
    public static void main(String[] args) {

        String[][] mot_table = new String[25][4];
        mottable(mot_table);

        String[][] asm_code = new String[100][5];
        asmcode(asm_code);
  
    }
}
