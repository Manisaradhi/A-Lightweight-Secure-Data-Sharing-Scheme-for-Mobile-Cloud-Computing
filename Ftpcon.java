/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.net.ftp.FTPClient;

/**
 *
 * @author java4
 */
public class Ftpcon {

    FTPClient client = new FTPClient();
    FileInputStream fis = null;
    boolean status;

    public boolean upload(File file) {
        try {

             System.out.println("Check------------------------------------->1");
            client.connect("ftp.drivehq.com");
            client.login("mani789", "Batch14.");
            client.enterLocalPassiveMode();
            fis = new FileInputStream(file);
            System.out.println("Check------------------------------------->2");
            status = client.storeFile("/" + file.getName(), fis);
            client.logout();
            fis.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        if (status) {
            System.out.println("success");
            return true;
        } else {
            System.out.println("failed");
            return false;

        }

    }
}