
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.*;

public class Demo {
	static JFrame f = new JFrame();
	static JLabel l2 = new JLabel("Destination");
	static JTextField t1 = new JTextField(30);
	static JTextField t2 = new JTextField(30);
	static JButton b1 = new JButton("Start");
	static JButton b2 = new JButton("Stop");
	static JLabel l1 = new JLabel("Source");
	static JProgressBar pb = new JProgressBar(0,100);

	static JTextArea ta = new JTextArea(40,40);
	public static void main(String[] args) {
		
		f.setLayout(new FlowLayout());
		f.setSize(800, 800);
		
		
		f.add(l1);
		f.add(t1);
		f.add(l2);
		f.add(t2);
		f.add(b1);
		f.add(ta);
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				String src = t1.getText();
				String dest = t2.getText();
				pb.setIndeterminate(true);
				pb.setString("Copying");
				pb.setStringPainted(true);
				pb.setVisible(true);
				try {

					f.add(pb);
					f.add(b2);
					f.setVisible(true);
					String content=new String(Files.readAllBytes(Paths.get(src)));
					PrintWriter outPrintWriter=new PrintWriter(dest);
					outPrintWriter.println(content);
					outPrintWriter.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		b2.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				String src = t2.getText();
				pb.setVisible(false);
				b1.setEnabled(false);
				b2.setEnabled(false);
				try{
					String content=new String(Files.readAllBytes(Paths.get(src)));
					ta.setText(content);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
	}

}
