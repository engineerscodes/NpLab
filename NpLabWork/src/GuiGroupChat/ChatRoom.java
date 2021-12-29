/**
 * 
 */
package GuiGroupChat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class ChatRoom {

	public JFrame frame;
	MulticastSocket ms;
	InetAddress in;
	static String group="239.0.0.0";
	private JTextField textField;
	JTextArea textArea ;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatRoom window = new ChatRoom(group);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChatRoom(String group) {
		this.group=group;
		initialize();
		try {
			ms=new MulticastSocket();
			in = InetAddress.getByName(group);
			new ServerNode(group,in,textArea ).start();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 495, 530);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chat Room : "+group);
		lblNewLabel.setBounds(10, 10, 166, 40);
		panel.add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 74, 475, 294);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setBackground(new Color(220, 220, 220));
		textField.setBounds(129, 378, 330, 65);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("TEXT");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(20, 378, 82, 65);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg=textField.getText();
				
				try {
					
					DatagramPacket dp=new DatagramPacket(msg.getBytes(),msg.getBytes().length,in,5000);
					ms.send(dp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(129, 462, 119, 47);
		panel.add(btnNewButton);
		
	}
}

class ServerNode extends Thread{
	
	String group;
	MulticastSocket ms;
	InetAddress in;
	JTextArea textArea ;
	ServerNode(String group,InetAddress in,JTextArea textArea ){
		this.group=group;
		try {
			ms=new MulticastSocket(5000);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.in=in;
		this.textArea=textArea;
	}
	
	 @Override
	    public void run()
	    { System.out.println("CURRENT THREAD :"+Thread.currentThread().getName());
		 try {
			ms.joinGroup(in);
			while(true) {
				byte buf[]=new byte[1024];
			    
			    DatagramPacket dp=new DatagramPacket(buf,1024);
			    
			    ms.receive(dp);
			    String text=new String(dp.getData());
			    System.out.println("Received : "+text.trim());
				textArea.setText(textArea.getText()+"\n "+text.trim() );
			   
			}
			 
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    }
	
	
}



