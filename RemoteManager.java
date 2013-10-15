/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;

import javax.swing.JFrame;

/**
 *
 * @author CowherRM
 */
public class RemoteManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //PasswordPrompt passwordInput = new PasswordPrompt();
        //passwordInput.setSize(403, 300);
        //passwordInput.setVisible(true);
        SSH.execute("service iptables stop");
    }
}
