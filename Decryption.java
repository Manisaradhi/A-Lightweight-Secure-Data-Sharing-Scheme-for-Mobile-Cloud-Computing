/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

/**
 *
 * @author java3
 */

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Decryption {

    public String decrypt(String txt, String skey) {
        String decryptedtext = null;
        try {
            // Converting string to secretkey
            byte[] bs = Base64.getDecoder().decode(skey);
            SecretKey sec = new SecretKeySpec(bs, "AES");
            System.out.println("Converted string to secretkey: " + sec);

            System.out.println("Secret key: " + sec);

            Cipher aesCipher = Cipher.getInstance("AES"); // Getting AES instance
            aesCipher.init(Cipher.ENCRYPT_MODE, sec); // Initiating ciper encryption using secretkey

            byte[] byteCipherText = Base64.getDecoder().decode(txt); // Encrypting data

            aesCipher.init(Cipher.DECRYPT_MODE, sec, aesCipher.getParameters()); // Initiating ciper decryption

            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            decryptedtext = new String(byteDecryptedText);

            System.out.println("Decrypted Text: " + decryptedtext);
        } catch (Exception e) {
            System.out.println(e);
        }
        return decryptedtext;
    }
}