package test1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame{

	public Home() throws Exception {
		SaveClass svc = new SaveClass();
		
		
		
		
		
		
		// ���� �ҷ����°�
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		Object header[] = {" "};
		Object contents[][] = null;
		DefaultTableModel model = new DefaultTableModel(contents, header);
		
		LinkedList<String> loader = svc.loader();
		String[] inputStr = new String[1];
		for(int i=0;i<loader.size();i++) {
			inputStr[0] = loader.get(i);
			System.out.println(inputStr[0]);
			model.addRow(inputStr);
		}
		
		JTable jTable = new JTable(model);
		JScrollPane sp = new JScrollPane(jTable);
		contentPanel.add(sp);
		
		
		
		
		
		
		
		// ��ư���� Ʋ ����
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		// input,btn2 ����
		JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String getText = textField.getText();
				try {
					svc.saver(getText);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				
				
				textField.setText("");
				textField.requestFocus();
				
			}
		});
		JButton deleteBtn = new JButton("Delete");
		
		
		// ��ġ
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		
		
		
		
		// 2 ūƲ. ���� ������ ǰ������
//		JPanel articlePanel = new JPanel();
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		c.add(inputPanel);
		c.add(contentPanel);
		
		// 1 ūƲ. ���ξ�ƼŬ�� �����ִ´�.
		add(c, BorderLayout.NORTH);
		
		// 0 �⺻Ʋ. �ʱ⼳��
		setTitle("����");
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Home();
	}
}