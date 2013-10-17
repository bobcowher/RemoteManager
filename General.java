/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CowherRM
 */
public class General {
    public static void infoBox(String infoMessage, String title)
    {
        JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void shellOut(String infoMessage){
       
        JOptionPane.showMessageDialog(null, infoMessage, "Command Output", JOptionPane.INFORMATION_MESSAGE);
    }
}
