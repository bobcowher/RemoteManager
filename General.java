/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;

import javax.swing.JOptionPane;

/**
 *
 * @author CowherRM
 */
public class General {
    public static void infoBox(String infoMessage, String location)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + location, JOptionPane.INFORMATION_MESSAGE);
    }
}
