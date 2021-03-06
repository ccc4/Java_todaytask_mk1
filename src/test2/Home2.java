package test2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Home2 extends JFrame{
	T2_Class t2c;
	
	public void init(T2_Class t2c) {
		this.t2c = t2c;
	}
	
	public Home2() throws Exception {
		
		
		// 내용 불러오는곳
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		Object header[] = {" "};
		Object contents[][] = null;
		DefaultTableModel model = new DefaultTableModel(contents, header);
		
		
		JTable jTable = new JTable(model);
		jTable.setRowHeight(45);
		jTable.setFont(new Font(null, Font.ITALIC, 15));
		JScrollPane sp = new JScrollPane(jTable);
		contentPanel.add(sp);
		
		
		LinkedList<String> loader;
		if(t2c.load() == null) {
			loader = new LinkedList<>();
		} else {
			loader = t2c.load();
			String[] inputStr = new String[1];
			for(int i=0;i<loader.size();i++) {
				inputStr[0] = loader.get(i);
//			System.out.println(inputStr[0]);
				model.addRow(inputStr);
			}		
		}
		
		
		
		
		
		// 버튼넣을 틀 제작
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
		// input,btn2 제작
		JTextField textField = new JTextField();
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String getText = textField.getText();
				t2c.input(getText);
				
				
				textField.setText("");
				textField.requestFocus();
				
			}
		});
		JButton deleteBtn = new JButton("Delete");
		
		
		// 설치
		inputPanel.add(textField);
		inputPanel.add(addBtn);
		inputPanel.add(deleteBtn);
		
		
		
		
		
		
		
		// 2 큰틀. 여러 컨텐츠 품고있음
		JPanel articlePanel = new JPanel();
//		Container c = getContentPane();
		articlePanel.setLayout(new BoxLayout(articlePanel, BoxLayout.Y_AXIS));
		articlePanel.add(inputPanel);
		articlePanel.add(contentPanel);
		
		// 1 큰틀. 메인아티클을 갖고있는다.
		add(articlePanel, BorderLayout.NORTH);
		
		// 0 기본틀. 초기설정
		setTitle("ToDo List");
		setLocation(100, 100);
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws Exception {
		Home2 home2 = new Home2();
		T2_Class t2c = new T2_Class();
		home2.init(t2c);
		Loader loader = new Loader(t2c);
		Saver saver = new Saver(t2c);
		loader.start();
		saver.start();
		
	}
}
