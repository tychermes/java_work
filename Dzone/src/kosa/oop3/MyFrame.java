package kosa.oop3;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends Frame implements ActionListener, WindowListener {

	public MyFrame() {
		Button b = new Button("Button");
		add(b);
		b.addActionListener(this); 
		//△ implements ActionListener를 하고 && actionPerformed()를 오버라이딩해야 한다.
		// 그러지 않으면 밑줄 오류뜸
		
		addWindowListener(this); // WindowListener를 implments
		
		setSize(300, 200);
		setLocation(300, 200);
		setVisible(true);
	}
	
	@Override // ActionListener의 메소드를 구현
	public void actionPerformed(ActionEvent e) {
		Button b = (Button)e.getSource();
		String label = b.getLabel();
		System.out.println(label+" 선택됨");
		
	}
	
	@Override // WindowListener의 메소드를 구현
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


}
