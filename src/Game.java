import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;



public class Game {
	public static void main(String[] args) {
		
		SudokuFactory sudokuFactory = new SudokuFactory();
		
		int[][] array = sudokuFactory.produceGameSudoku();
		
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// System.out.println("Hello World!");
		JFrame frame = new JFrame("hello,world");
        // ���óߴ�
        //frame.setSize(100, 500);
        // JFrame����Ļ����
        frame.setLocationRelativeTo(null);
        // JFrame�ر�ʱ�Ĳ���
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        GridLayout gLayout = new GridLayout(9, 9, 10, 10);
        JPanel panel = new JPanel();
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setLayout(gLayout);
        panel.setBorder(empty);
        
        
        for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JTextField textField = new JTextField(5);
				// ������ı����о���
				textField.setHorizontalAlignment(JTextField.CENTER);
				if (array[i][j] != 0) {
					textField.setText(String.valueOf(array[i][j]));
					textField.setEditable(false);
				}
				
				panel.add(textField);
			}
		}
        
        JPanel panel2 = new JPanel();
        panel2.setBorder(empty);
        JButton jb1 = new JButton("��ʾ");
        jb1.setBounds(new Rectangle(new Dimension(30, 30)));
        panel2.add(jb1);
        panel2.add(new JButton("�˳�"));
        
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.pack();
        
        // ��ʾJFrame
        frame.setVisible(true);
        
        
        
	}
}
