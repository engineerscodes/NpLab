/**
 * 
 */
package GuiGroupChat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class Main {

	private JFrame frame;
	private JTextField textField;

	String group=null;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 525, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 511, 546);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER GROUP");
		lblNewLabel.setBounds(143, 93, 116, 67);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(126, 203, 179, 44);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("JOIN CHAT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(textField.getText());
				group=textField.getText();
				ChatRoom chatroom=new ChatRoom(group); 
				frame.dispose();
				chatroom.frame.setVisible(true);
				
				
				
			}
		});
		btnNewButton.setBounds(140, 305, 142, 33);
		panel.add(btnNewButton);
	}
}
