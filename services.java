/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remotemanager;

/**
 *
 * @author CowherRM
 */
public class services {
    public static void apache(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.rexecute("service httpd start", "Apache Started Successfully!", "Apache Failed to Start");
            }
            else if(choice == 1){
                SSH.rexecute("service httpd stop", "Apache Stopped Successfully!", "Apache Failed to Stop");
            }
            else if(choice == 2){
                SSH.rexecute("service httpd restart", "Apache Restarted Successfully!", "Apache Failed to Restart");
            }
        }
    }
    
    public static void mysql(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.rexecute("service mysqld start", "MySQL Started Successfully!", "MySQL Failed to Start");
            }
            else if(choice == 1){
                SSH.rexecute("service mysqld stop", "MySQL Stopped Successfully", "MySQL Failed to Stop");
            }
            else if(choice == 2){
                SSH.rexecute("service mysqld restart", "MySQL Restarted Successfully", "MySQL Failed to Restart");
            }
        }
    }
    
        public static void proftp(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.rexecute("service proftpd start", "ProFTP Started Successfully", "ProFTP Failed to Start");
            }
            else if(choice == 1){
                SSH.rexecute("service proftpd stop", "ProFTP Stopped Successfully", "ProFTP Failed to Stop");
            }
            else if(choice == 2){
                SSH.rexecute("service proftpd restart", "ProFTP Restarted Successfully", "ProFTP Failed to Restart");
            }
        }
    }
        
        public static void sshd(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.rexecute("service sshd start", "SSH Server Started Successfully", "SSH Server Failed to Start");
            }
            else if(choice == 1){
                SSH.rexecute("service sshd stop", "SSH Server Stopped Successfully", "SSH Server Failed to Stop");
            }
            else if(choice == 2){
                SSH.rexecute("service sshd restart", "SSH Server Restarted Successfully", "SSH Server Failed to Restart");
            }
        }
    }
        
    public static void system(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.rexecute("shutdown -h now", "Remote System is Shutting Down", "Remote System Failed to Shut Down");
            }
            else if(choice == 1){
                SSH.rexecute("shutdown -r now", "Remote System is Rebooting", "Remote System Failed to Reboot");
            }
        }
    }
}
