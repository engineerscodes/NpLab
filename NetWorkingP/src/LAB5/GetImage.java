/**
 * 
 */
package LAB5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author M.NAVEEN
 * RANDOM CODER'S
 *
 */
public class GetImage  extends JFrame {
	static private JPanel contentPane,panel,panel2,panel3,panel4;
    static String Imgurl[]=new String[4];
    GetImage() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10,10, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 400, 400);
		panel2 = new JPanel();
		panel2.setBackground(new Color(50, 60, 18));
		panel2.setBounds(0, 400, 400, 400);
		panel3 = new JPanel();
		panel3.setBackground(new Color(10, 50, 10));
		panel3.setBounds(400, 0, 400, 400);
		panel4 = new JPanel();
		panel4.setBackground(new Color(50, 0, 18));
		panel4.setBounds(400, 400, 400, 400);
		contentPane.add(panel);
		contentPane.add(panel2);
		contentPane.add(panel3);
		contentPane.add(panel4);
		
    }
    
   

    
    public static void setImage(GetImage frame) {
    	for(int i=0;i<Imgurl.length;i++)
	    	try {
				URL url = new URL(Imgurl[i]);
				
				Image image = ImageIO.read(url);
				Image ic=new ImageIcon(image).getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
				JLabel Jimage=new JLabel(new ImageIcon(ic));
				
				if(i==0)
					panel.add(Jimage);
				if(i==1)
					panel2.add(Jimage);
				if(i==2)
					panel3.add(Jimage);
				if(i==3)
					{
					panel4.add(Jimage);
					}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
    	
    	Timer time=new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				    	 Rectangle temp=panel.getBounds();
				    	 panel.setBounds(panel3.getBounds()); 
				    	 Rectangle temp2=panel2.getBounds();
				    	 panel2.setBounds(temp);
				    	 panel3.setBounds(panel4.getBounds());
				    	 panel4.setBounds(temp2);
				         frame.setVisible(true);
			}
    		
    	});
    	time.start();
    
    }
	public static void main(String[] args) throws IOException {
		
		 GetImage frame = new GetImage();
		 URL url=new URL("https://unsplash.com/s/photos/car");
         BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
         StringBuilder sb=new StringBuilder();
         String line;
         while ((line = in.readLine()) != null) {
                  sb.append(line);           
         }
         GetTextImageURL(sb.toString(),"https://www.rspca.org.uk/");
         System.out.println(Arrays.toString(Imgurl));
         setImage(frame);
         frame.setVisible(true);
         
         

	}
	private static void GetTextImageURL(String string,String domain) {
		Document doc=Jsoup.parse(string);
		Elements links=doc.select("img");
		for(int i=1;i<=4;i++) {
			Imgurl[i-1]=links.get(i).attr("src");
			
		}
		
	}

}
