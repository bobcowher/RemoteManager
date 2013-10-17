/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;
import com.jcraft.jsch.*;
import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author CowherRM
 */
public class SSH {
    private static InputStream String;
 
    /*
    public String hostname(String x){
            String hostname = x;
            return hostname;
    }
    public String username(String x){
            String username = x;
            return username;
    }
    public String password(String x){
            String password = x;
            return password;
    }
    public int port(int x){
            int port = x;
            return port;
    }
*/
    

    
    //This method will be called from the gui to execute commands and control the server.
    public static String rexecute(String command, String success, String failure){
        
            //Queries the data class for login credentials. The data class directly queries
            //A local embedded database for the information. 
            String username = data.getUser();
            String hostname = data.getHost();
            String password = data.getPass();
            int port = data.getPort();
       try{
             
            java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(username, hostname, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            System.out.println("Connected");
             
            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            channel.setInputStream(null);
            
            ((ChannelExec)channel).setErrStream(System.err);
             
            InputStream in=channel.getInputStream();
            channel.connect();
            byte[] tmp=new byte[1024];
            while(true){
                
              StringBuilder outputVar = new StringBuilder();                
              
                           
              while(in.available()>0){
                int i=in.read(tmp, 0, 1024);
                if(i<0)break;
                System.out.print(new String(tmp, 0, i));
               // outputVar.append(new String(tmp, 0, i));
               // outputVar.append("\n");
              }         
             //String outputVar2 = outputVar.toString();
             // General.shellOut(outputVar.toString());
              
              
              if(channel.isClosed()){
                System.out.println("exit-status: "+channel.getExitStatus());
                
                if(channel.getExitStatus() == 0){
                    General.infoBox(success, "Success!");
                }
                else{
                    General.infoBox(failure, "Failure");
                }
                
                break;
              }
              try{Thread.sleep(1000);}catch(Exception ee){}
              
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SSH.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSchException ex) {
            java.util.logging.Logger.getLogger(SSH.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        return null;
    }
    
    //This method will be called by the initial password prompt box and 
    //will test the connection to the ssh server with the credentials
    //provided by the user.
    
    public static String testConnection(String host, String user, String password, Integer port){
        
           
       try{
             
            java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session;
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig(config);
            session.connect();
            /*ConnectedSuccessfully successMessage = new ConnectedSuccessfully();
            successMessage.setVisible(true);
            successMessage.dispose();
            */
            
            General.infoBox("Connected Successfully!", "Success");
            
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            General.infoBox("Failed to Connect", "Connection Failure");
        }
        
        
        return null;
    }
    
    
}


    