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
                SSH.execute("service httpd start");
            }
            else if(choice == 1){
                SSH.execute("service httpd stop");
            }
            else if(choice == 2){
                SSH.execute("service httpd restart");
            }
        }
    }
    
    public static void mysql(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.execute("service mysqld start");
            }
            else if(choice == 1){
                SSH.execute("service mysqld stop");
            }
            else if(choice == 2){
                SSH.execute("service mysqld restart");
            }
        }
    }
    
        public static void proftp(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.execute("service proftpd start");
            }
            else if(choice == 1){
                SSH.execute("service proftpd stop");
            }
            else if(choice == 2){
                SSH.execute("service proftpd restart");
            }
        }
    }
        
        public static void sshd(int os, int choice){
        if(os == 0){
            if(choice == 0){
                SSH.execute("service sshd start");
            }
            else if(choice == 1){
                SSH.execute("service sshd stop");
            }
            else if(choice == 2){
                SSH.execute("service sshd restart");
            }
        }
    }
}
