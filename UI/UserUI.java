package UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import Member.*;
import Order.*;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;

public class UserUI extends JFrame {
	private JPanel contentPane;
	private JButton[][] btn;
	private JTable table;
	private DefaultTableModel dtm;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JButton btnNewButton_5;
	private	JLabel lblNewLabel_1;
	private	JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	private JRadioButton rdbtnIce;
	private JRadioButton rdbtnHot;
	private JRadioButton rdbtnshort;
	private JRadioButton rdbtnNewRadioButton_1_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnTall;
	private JRadioButton rdbtnGrander;
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnYes;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_2_1;
	private JButton btnNewButton_3_1;
	private JButton btnNewButton_4_1;
	private JButton btnNewButton_1_1_1;
	private JButton btnNewButton_2_1_1;
	private JButton btnNewButton_3_1_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_3_2;
	private JLabel lblNewLabel_3_3;
	private JLabel lblNewLabel_3_4;
	private JLabel lblNewLabel_3_4_1;
	private JLabel lblNewLabel_3_4_2;
	private JLabel lblNewLabel_3_4_3;
	private JLabel lblNewLabel_3_4_4;
	private JLabel lblNewLabel_3_4_5;
	private JLabel lblNewLabel_3_4_6;
	private JLabel lblNewLabel_3_4_7;
	private JButton btnDelete;
	private JLabel lbTotal;
	OrderDAO dao = new OrderDAO();
	MemberDAO mdao = new MemberDAO();
	String size, h_i, shot;
	int row, col;
	int total = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI frame = new UserUI();
					Dimension frameSize = frame.getSize();
					// 모니터 크기
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					// (모니터화면 가로 - 프레임화면 가로) / 2, (모니터화면 세로 - 프레임화면 세로) / 2
					frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public UserUI() {
		Object[] columnNames = {"음료명", "사이즈", "가격", "HOT/ICE", "SHOT", "개수"};
		Object[][] rowData = new Object[0][6];
		//setBounds(100, 100, 700, 500);
		
		setSize(700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		dtm = new DefaultTableModel(rowData, columnNames) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
				return false;
			}
		};
		
		table = new JTable(dtm); // 주문내역 실행 창
		table.setBounds(411, 47, 263, 226);
		contentPane.add(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1) {
					row = table.getSelectedRow();
					col = table.getSelectedColumn();
//					System.out.println(table.getValueAt(row, 0));
	
				}
			}
		});
		
		lbTotal = new JLabel(Integer.toString(total));
		lbTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lbTotal.setBounds(459, 275, 108, 34);
		contentPane.add(lbTotal);
		
		btnDelete = new JButton("주문 삭제");
		btnDelete.setBounds(579, 14, 95, 23);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total -= Integer.parseInt(table.getValueAt(row, 2).toString());
				lbTotal.setText(Integer.toString(total));
				dtm.removeRow(row);
			}
		});
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(411, 47, 263, 226);
		contentPane.add(scrollPane);
		
		JButton button = new JButton("New button");
		scrollPane.setColumnHeaderView(button);
		
		btnNewButton = new JButton("아메리카노"); //아메리카노 버튼
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton.getText(), size, 2000, h_i, shot, 1});
					total += 2000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.setBounds(17, 47, 83, 53);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("카페라떼"); //카페라 버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_1.getText(), size, 3000, h_i, shot, 1});
					
					total += 3000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});

		btnNewButton_2 = new JButton("카푸치노"); // 카푸치노 버튼
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 10)); 
		btnNewButton_2.setBounds(208, 47, 83, 53);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_2.getText(), size, 3000, h_i, shot, 1});
					
					total += 3000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton_3 = new JButton("\uC5D0\uC2A4\uD504\uB808\uC18C");  //에스프레소 버튼
		btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_3.setBounds(305, 47, 83, 53);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_3.getText(), size, 2000, h_i, shot, 1});
					total += 2000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_1.setBounds(112, 47, 83, 53); 
		contentPane.add(btnNewButton_1);
		
		//
		JLabel lblNewLabel = new JLabel("주문내역"); // 주문내역 라벨
		lblNewLabel.setBounds(411, 28, 88, 15);
		contentPane.add(lblNewLabel);
		
		btnNewButton_5 = new JButton("결제");
		btnNewButton_5.addActionListener(event -> {
			int ans = JOptionPane.showConfirmDialog(this, "회원 결제", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
			if(ans == 0) {
				int check = 0;
				String ans_str = (String) JOptionPane.showInputDialog(this, "회원 번호 입력 : ", "확인", JOptionPane.PLAIN_MESSAGE, null, null, null);
				System.out.println(ans_str);
				check = mdao.phoneCheck(ans_str);
				System.out.println(check);
				if(check == 1) { // 회원 정보 있음.
					mdao.pointInsert((int)(Integer.parseInt(lbTotal.getText().toString())*0.1), ans_str);
					System.out.println(Integer.parseInt(lbTotal.getText().toString())+"    1234");
					System.out.println(Integer.parseInt(lbTotal.getText().toString())*0.1 + "    1111");
					buy();
				}else if(check == 0) {
					JOptionPane.showMessageDialog(null, "회원 정보가 없습니다.");
				}
				
			}else if(ans == 1) { // 아니오
				buy();
			}
        });
		btnNewButton_5.setBounds(579, 283, 95, 168); // 결제 버튼
		contentPane.add(btnNewButton_5);
		
		lblNewLabel_1 = new JLabel("SIZE"); //SIZE 라벨
		lblNewLabel_1.setBounds(70, 344, 52, 15);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("HOT/ICE"); //HOT/ICE 라벨
		lblNewLabel_1_1.setBounds(51, 384, 52, 15);
		contentPane.add(lblNewLabel_1_1);
		
		lblNewLabel_1_1_1 = new JLabel("SHOT"); //SHOT라벨
		lblNewLabel_1_1_1.setBounds(70, 424, 52, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		rdbtnHot = new JRadioButton("HOT"); //HOT 버튼
		rdbtnHot.setBounds(130, 380, 119, 23);
		contentPane.add(rdbtnHot);
		
		rdbtnIce = new JRadioButton("ICE"); //ICE 버튼
		rdbtnIce.setBounds(253, 380, 119, 23);
		contentPane.add(rdbtnIce);
		
		rdbtnHot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnIce.setSelected(false);
			}
		});
		rdbtnIce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHot.setSelected(false);
			}
		});
		
		
		rdbtnshort = new JRadioButton("short");
		rdbtnshort.setBounds(130, 340, 119, 23);
		contentPane.add(rdbtnshort);
		
		
		rdbtnTall = new JRadioButton("tall"); //tall 버튼
		rdbtnTall.setBounds(253, 340, 119, 23);
		contentPane.add(rdbtnTall);
		
		rdbtnGrander = new JRadioButton("Grande"); //Grande 버튼
		rdbtnGrander.setBounds(380, 380, 119, 23);
		contentPane.add(rdbtnGrander);
		
		// short, tall, grande 라디오 선택 
		rdbtnshort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTall.setSelected(false);
				rdbtnGrander.setSelected(false);
			}
		});
		rdbtnTall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnshort.setSelected(false);
				rdbtnGrander.setSelected(false);
			}
		});
		
		rdbtnGrander.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnshort.setSelected(false);
				rdbtnTall.setSelected(false);
			}
		});

		
		rdbtnNo = new JRadioButton("NO"); //NO 버튼
		rdbtnNo.setBounds(253, 420, 119, 23);
		contentPane.add(rdbtnNo);
		//
		rdbtnYes = new JRadioButton("YES"); //YES버튼
		rdbtnYes.setBounds(130, 420, 119, 23);
		contentPane.add(rdbtnYes);
		
		
		rdbtnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNo.setSelected(false);
			}
		});
		rdbtnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnYes.setSelected(false);
			}
		});
		
		
		btnNewButton_4 = new JButton("\uCF5C\uB4DC\uBE0C\uB8E8"); //콜드 브루 버튼
		btnNewButton_4.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_4.setBounds(17, 133, 83, 53);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_4.getText(), size, 5000, h_i, shot, 1});
					total += 5000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		
		btnNewButton_1_1 = new JButton("마끼아또"); // 마끼아또 버튼
		btnNewButton_1_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(112, 133, 83, 53);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_1_1.getText(), size, 5000, h_i, shot, 1});
					total += 5000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		
		btnNewButton_2_1 = new JButton("헤이즐넛"); // 헤이즐넛 버튼
		btnNewButton_2_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_2_1.setBounds(208, 133, 83, 53);
		contentPane.add(btnNewButton_2_1);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_2_1.getText(), size, 4000, h_i, shot, 1});
					total += 4000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		
		btnNewButton_3_1 = new JButton("카페모카"); // 카페모카 버든
		btnNewButton_3_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_3_1.setBounds(305, 133, 83, 53);
		contentPane.add(btnNewButton_3_1);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_3_1.getText(), size, 4000, h_i, shot, 1});
					total += 4000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton_4_1 = new JButton("바닐라라떼"); //바닐라 라떼 버튼
		btnNewButton_4_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_4_1.setBounds(17, 220, 83, 53);
		contentPane.add(btnNewButton_4_1);
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_4_1.getText(), size, 3000, h_i, shot, 1});
					total += 000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton_1_1_1 = new JButton("아이스티"); // 아이스티 버튼
		btnNewButton_1_1_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBounds(112, 220, 83, 53);
		contentPane.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_1_1_1.getText(), size, 3000, h_i, shot, 1});
					total += 3000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton_2_1_1 = new JButton("커피우유"); // 커피우유 버튼
		btnNewButton_2_1_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_2_1_1.setBounds(208, 220, 83, 53);
		contentPane.add(btnNewButton_2_1_1);
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_2_1_1.getText(), size, 5000, h_i, shot, 1});
					total += 5000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		btnNewButton_3_1_1 = new JButton("딸기우유"); //딸기 우유 버튼
		btnNewButton_3_1_1.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_3_1_1.setBounds(305, 220, 83, 53);
		contentPane.add(btnNewButton_3_1_1);
		btnNewButton_3_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!rdbtnHot.isSelected()&&!rdbtnIce.isSelected())||(!rdbtnNo.isSelected()&&!rdbtnYes.isSelected())) {
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
				}else {
					selectMenu(); 
					
					dtm.addRow(new Object[] {btnNewButton_3_1_1.getText(), size, 2000, h_i, shot, 1});
					total += 2000;
					lbTotal.setText(Integer.toString(total));
				}
			}
		});
		
		lblNewLabel_2 = new JLabel("MENU");
		lblNewLabel_2.setBounds(181, 10, 52, 15);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("2000원");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(27, 100, 62, 15);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_3_1 = new JLabel("3000원");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(122, 100, 62, 15);
		contentPane.add(lblNewLabel_3_1);
		
		lblNewLabel_3_2 = new JLabel("3000원");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setBounds(218, 100, 62, 15);
		contentPane.add(lblNewLabel_3_2);
		
		
		lblNewLabel_3_3 = new JLabel("2000원");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setBounds(315, 100, 62, 15);
		contentPane.add(lblNewLabel_3_3);
		
		lblNewLabel_3_4 = new JLabel("5000원");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4.setBounds(27, 186, 62, 15);
		contentPane.add(lblNewLabel_3_4);
		
		lblNewLabel_3_4_1 = new JLabel("5000원");
		lblNewLabel_3_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_1.setBounds(122, 186, 62, 15);
		contentPane.add(lblNewLabel_3_4_1);
		
		lblNewLabel_3_4_2 = new JLabel("4000원");
		lblNewLabel_3_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_2.setBounds(218, 186, 62, 15);
		contentPane.add(lblNewLabel_3_4_2);
		
		lblNewLabel_3_4_3 = new JLabel("4000원");
		lblNewLabel_3_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_3.setBounds(315, 186, 62, 15);
		contentPane.add(lblNewLabel_3_4_3);
		
		lblNewLabel_3_4_4 = new JLabel("3000원");
		lblNewLabel_3_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_4.setBounds(27, 272, 62, 15);
		contentPane.add(lblNewLabel_3_4_4);
		
		lblNewLabel_3_4_5 = new JLabel("3000원");
		lblNewLabel_3_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_5.setBounds(122, 272, 62, 15);
		contentPane.add(lblNewLabel_3_4_5);
		
		lblNewLabel_3_4_6 = new JLabel("5000원");
		lblNewLabel_3_4_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_6.setBounds(218, 272, 62, 15);
		contentPane.add(lblNewLabel_3_4_6);
		
		lblNewLabel_3_4_7 = new JLabel("2000원");
		lblNewLabel_3_4_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_4_7.setBounds(315, 272, 62, 15);
		contentPane.add(lblNewLabel_3_4_7);
		
		JLabel lblNewLabel_4 = new JLabel("총 금액");
		lblNewLabel_4.setBounds(411, 285, 52, 15);
		contentPane.add(lblNewLabel_4);
	
		
		setVisible(true);
		
	}
	public void buy() {
		dao.InsertOrder(Integer.parseInt(lbTotal.getText()));
		for(int i=0; i<dtm.getRowCount(); i++) {
//			System.out.println(dtm.getValueAt(i, 0).toString());
			OrderdetailDTO ddto = new OrderdetailDTO();
			
			ddto.setO_id(dao.RecentlyOrder());
			ddto.setM_id(dao.menuIdSelect(dtm.getValueAt(i, 0).toString()));
			ddto.setSize(sizeInt(dtm.getValueAt(i, 1).toString()));
			ddto.setPrice(Integer.parseInt(dtm.getValueAt(i, 2).toString()));
			ddto.setH_i(h_iInt(dtm.getValueAt(i, 3).toString()));
			ddto.setShot(shotInt(dtm.getValueAt(i, 4).toString()));
			ddto.setNum(Integer.parseInt(dtm.getValueAt(i, 5).toString()));
			System.out.println(ddto.getO_id()+" o_id");
			System.out.println(ddto.getM_id() + " m_id");

			dao.InsertOrderDetail(ddto);
		}	
		dtm.setNumRows(0);
		lbTotal.setText("0");	
		JOptionPane.showMessageDialog(null, "주문번호 : "+dao.RecentlyOrder()+"번");
	}
	
	public int sizeInt(String str) {
		int s = 0;
		if(str.equals("short")) {
			s = 1;
		}else if(str.equals("tall")){
			s = 2;
		}else if(str.equals("grande")) {
			s = 3;
		}
		return s;
	}
	
	public int h_iInt(String str) {
		int s = 0;
		if(str.equals("HOT")) {
			s = 1;
		}else if(str.equals("ICE")){
			s = 2;
		}
		return s;
	}
	
	public int shotInt(String str) {
		int s = 0;
		if(str.equals("yes")) {
			s = 1;
		}else if(str.equals("no")){
			s = 2;
		}
		return s;
	}
	
	
	public void selectMenu() {
		
		if(rdbtnHot.isSelected()) {
			h_i = "HOT"; // hot
		}else {
			h_i = "ICE"; // ice
		}
		if(rdbtnshort.isSelected()) {
			size = "short"; // short
		}else if(rdbtnTall.isSelected()){
			size = "tall"; // tall
		}else {
			size = "grande"; // Grande
		}
		if(rdbtnNo.isSelected()) {
			shot = "no"; // shot no
		}else {
			shot = "yes"; // shot yes
		}
	}
}