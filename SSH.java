/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;
import com.jcraft.jsch.*;
import java.io.InputStream;

/**
 *
 * @author CowherRM
 */
public class SSH {
    
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


    
    //This method will be called from the gui to execute commands and control the server.
    public static String execute(String command){
        
            
       try{
             
            java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            Session session=jsch.getSession(username, hostname, 22);
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
              while(in.available()>0){
                int i=in.read(tmp, 0, 1024);
                if(i<0)break;
                System.out.print(new String(tmp, 0, i));
              }
              if(channel.isClosed()){
                System.out.println("exit-status: "+channel.getExitStatus());
                break;
              }
              try{Thread.sleep(1000);}catch(Exception ee){}
            }
            channel.disconnect();
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
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
            ConnectedSuccessfully successMessage = new ConnectedSuccessfully();
            successMessage.setVisible(true);
            
            
            session.disconnect();
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return null;
    }
    
    
}


    