/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author foysal
 */
public class Server extends javax.swing.JFrame {

    /**
     * Creates new form Server
     */
    static int port=1234;
    static Server server = null;
    public Server() {
        initComponents();
        server=this;
    }
    public Server(int port){
        this.port=port;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Activity = new javax.swing.JTextArea();
        MyName = new javax.swing.JTextField();
        msg_area = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ActiveClient = new javax.swing.JTextArea();
        status = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Activity.setColumns(20);
        Activity.setRows(5);
        jScrollPane1.setViewportView(Activity);

        MyName.setText("    Server");
        MyName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyNameActionPerformed(evt);
            }
        });

        msg_area.setText("         Server is ON");
        msg_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_areaActionPerformed(evt);
            }
        });

        ActiveClient.setColumns(20);
        ActiveClient.setRows(5);
        jScrollPane2.setViewportView(ActiveClient);

        status.setText("Active");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MyName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msg_area, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(msg_area, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_areaActionPerformed

    }//GEN-LAST:event_msg_areaActionPerformed

    private void MyNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MyNameActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    /**
     * @param args the command line arguments
     */
    
     
    //my code start
    static Vector<ClientHandler>ar=new Vector<>();
    
       
	
	static int ClientCount=1;
	public static void main(String[] args) throws IOException {
            
            
             /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
		
		ServerSocket ss=new ServerSocket(port);
		Socket s;
               
              
		
		while(true) {
			s=ss.accept();
			System.out.println("New client request received "+s );
			
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			String name=dis.readUTF();
			
			System.out.println("creating a new handler for this client..");
			
			ClientHandler mtch=new ClientHandler(s,name,dis,dos,server);
			
			Thread t=new Thread(mtch);
                        
                        //print to server textArea
                      //  msg_area.setText(msg_area.getText().trim()+" "+name+ " Added to Server\n");
                            Activity.setText(Activity.getText().trim()+"\n"+name+" connected to Server");
                            
                            ActiveClient.setText(ActiveClient.getText().trim()+"\n"+name);
                            
      			System.out.println("Adding this client to active client list");
                        
                       
			
			ar.add(mtch);
                        
                       
			
			t.start();
			
			ClientCount++;
			
			
			
		
		}
	}
        
	

//}

    
    
    
    ///end my code
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Server().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextArea ActiveClient;
    private static javax.swing.JTextArea Activity;
    private javax.swing.JTextField MyName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextField msg_area;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables

    void ChangeActivity(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Activity.setText(Activity.getText().trim()+'\n'+s+ " Logged out");
       String logout="",check="",active="";
       logout=ActiveClient.getText().trim();
      
       System.out.println(logout.length());
       System.out.println(logout);
       
//       for(int i=0;i<logout.length();i+=s.length()){
//           int c=0;
//           check="";
//          for(int j=0;j<s.length();j++)
//          {
//              if(logout.charAt(i+j)==s.charAt(j)){c++;}
//              
//          }
//          
//          if(c==s.length()){
//              System.out.println("assee bro");
//             // ActiveClient.setText(s+"out");
//             
//              
//              
//          }
//          else{
//              for(int k=i;k<logout.length();k++){
//                  active+=logout.charAt(k);
//              }
//              
//          }
//          
//           
//       }
       //ActiveClient.setText( "logout.length()");
       
       
       
   
    }
}

///client handler code start
class ClientHandler implements Runnable{
	 
	 Scanner scn=new Scanner(System.in);
	 private String name;
	 private DataInputStream dis;
	 private DataOutputStream dos;
	 Socket s;
	 boolean isloggedin;
         Server server;
	 
	 public ClientHandler(Socket s, String name,DataInputStream dis,DataOutputStream dos,Server server) {
		 
		 this.dis=dis;
		 this.name=name;
		 this.dos=dos;
		 this.isloggedin=true;
                 this.server=server;
                
		 
	 }
         
         void Logout(String s){

             server.ChangeActivity(s);
             
             
         }

	@Override
	public void run() {
		String received;
		while(true) {
			try {
				received=dis.readUTF();
                                
				System.out.println(received+" server");
				if(received.contentEquals("logout")) {
                                         Logout(this.name);
					this.isloggedin=false;
					this.dis.close();
                                        this.dos.close();
                                        this.s.close();
                                       
					break;
				}
				
				//break message to message vs recepient
				StringTokenizer st=new StringTokenizer(received,"#");
				String MsgToSend=st.nextToken();
				String recepient=st.nextToken();
				
				//search recepient in active list
				
				for(ClientHandler mc:Server.ar) {
					if(mc.name.contentEquals(recepient) && mc.isloggedin==true) {
						mc.dos.writeUTF(this.name+ " : " + MsgToSend+'\n');
						break;
					}
                                        
                                        
                                        
				}
				
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		try {
			this.dis.close();
			this.dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

///client handler code end