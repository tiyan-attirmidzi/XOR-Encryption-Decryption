import java.util.Scanner;

public class Main {
    private static Scanner in;
    public static void main(String[] args) {

        in = new Scanner(System.in);

        System.out.println("1. Enkripsi");
        System.out.println("2. Dekripsi");
        System.out.print("Pilih (1,2) : ");

        int choose = in.nextInt();
        in.nextLine();

        if (choose == 1) {
            System.out.println("--- Enkripsi ---");
            encryptionCipher();
        }
        else if (choose == 2) {
            System.out.println("--- Dekripsi ---");
            decryptionCipher();
        }
        else {
            System.out.println("Pilihan Tidak Valid");
        }

    }

    //ENCRYPTION
    private static void encryptionCipher() {
        System.out.print("Masukkan Pesan : ");
        String msg = in.nextLine();

        System.out.print("Masukkan Kunci : ");
        String key = in.nextLine();

        String encrypHexa = "";
        int keyItr = 0;
        for (int i = 0; i < msg.length(); i++) {
            // XOR Operation
            int temp = msg.charAt(i) ^ key.charAt(keyItr);
            encrypHexa += String.format("%02x", (byte)temp);
            keyItr++;
            if (keyItr >= key.length()) {
                keyItr = 0;
            }
        }
        System.out.print("Teks Enkripsi : " + encrypHexa);
    }

    //DECRYPTION
    private static void decryptionCipher() {
        System.out.print("Masukkan Pesan : ");
        String msg = in.nextLine();

        System.out.print("Masukkan Kunci : ");
        String key = in.nextLine();

        String decryHexa = "";
        for (int i = 0; i < msg.length()-1; i+=2) {
            String output = msg.substring(i, (i+2));
            int decimal = Integer.parseInt(output, 16);
            decryHexa += (char)decimal;
        }
        String decryText = "";
        int keyItr = 0;
        for (int i = 0; i < decryHexa.length(); i++) {
            //XOR Operation
            int temp = decryHexa.charAt(i) ^ key.charAt(keyItr);
            decryText += (char)temp;
            keyItr++;
            if (keyItr >= key.length()) {
                keyItr = 0;
            }
        }
        System.out.print("Teks Dekripsi : " + decryText);
    }

}
