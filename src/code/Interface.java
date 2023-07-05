package code;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

public class Interface extends JFrame {
	private JLabel titleAllTela;
	
	private JPanel painel1;
	private JTextArea titletela;
	private JButton buttonC1;
	private JButton buttonR1;
	private JButton buttonU1;
	private JButton buttonD1;
	
	private JPanel painel2;
	private JTextArea titletela2;
	private JButton buttonC2;
	private JButton buttonR2;
	private JButton buttonU2;
	private JButton buttonD2;
	
	private JPanel painel3;
	private JTextArea titletela3;
	private JButton buttonC3;
	private JButton buttonR3;
	private JButton buttonU3;
	private JButton buttonD3;
	
	public Interface () {
		titletela = new JTextArea();
		setSize(900,350);
		setTitle("CRUD - Esthéfani, Gabriel Alves e Luís Felipe Ceron ");
        Container contentPane = getContentPane();
        contentPane.setBackground(new Color(242, 242, 242));
		setLayout(null);
		setLocationRelativeTo(null);
		componentesCriar();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void componentesCriar () {
		
		Font fontetitle = new Font( "Poppins", Font.PLAIN, 16);
		Font fontelabels = new Font( "Poppins", Font.PLAIN, 14);
		Color borderColor = new Color (156, 185, 188);
		Color background = new Color (242, 242, 242); 
		Color resultcolor = new Color (191, 107, 33);
		
		Rectangle positionC = new Rectangle(35,30,180,30);
		Rectangle positionR = new Rectangle(35,70,180,30);
		Rectangle positionU = new Rectangle(35,110,180,30);
		Rectangle positionD = new Rectangle(35,150,180,30);
		
		Rectangle positionC3 = new Rectangle(27,30,250,30);
		Rectangle positionR3 = new Rectangle(27,70,250,30);
		Rectangle positionU3 = new Rectangle(27,110,250,30);
		Rectangle positionD3 = new Rectangle(27,150,250,30);
		
		
		titleAllTela = new JLabel("Gerenciamento de uma universidade EAD");
		titleAllTela.setBounds(20, 10, 600, 25);
		titleAllTela.setForeground( borderColor );
		titleAllTela.setFont(fontetitle);
		getContentPane().add(titleAllTela);
	
			painel1 = new JPanel();
			painel1.setLayout(null);
			painel1.setBounds(20,50,250,200);
			painel1.setBackground(background);
			int borderWidth = 2; 
			Border matteBorder = BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, borderColor);
			Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Usuários");
			((TitledBorder) titledBorder).setTitleColor(borderColor);
			painel1.setBorder(titledBorder);
			((TitledBorder) titledBorder).setTitleFont(fontelabels);
			painel1.setBorder(titledBorder);
			getContentPane().add(painel1);
			
			buttonC1 = new JButton();
			buttonC1.setText("Criar usuário");
			buttonC1.setHorizontalAlignment(SwingConstants.CENTER);
			buttonC1.setFont(fontelabels);
			buttonC1.setBounds(positionC);
			buttonC1.setBackground(background);
			buttonC1.setForeground( resultcolor );
			Border customBorderButton = BorderFactory.createLineBorder(resultcolor, 2 );
			buttonC1.setBorder(customBorderButton);
			buttonC1.setFocusPainted(false);
			painel1.add(buttonC1);
			
			
			buttonC1.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	 InterfaceCreateUsers interfaceCreateUsers = new InterfaceCreateUsers(1, 0);
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonC1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			    
			    
			});
			
			buttonR1 = new JButton();
			buttonR1.setText("Listar usuários");
			buttonR1.setHorizontalAlignment(SwingConstants.CENTER);
			buttonR1.setFont(fontelabels);
			buttonR1.setBounds(positionR);
			buttonR1.setBackground(background);
			buttonR1.setForeground( resultcolor );
			buttonR1.setBorder(customBorderButton);
			buttonR1.setFocusPainted(false);
			painel1.add(buttonR1);
			
	        buttonR1.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	InterfaceRead interfaceReadUsers = new InterfaceRead(1);
	            }

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                buttonR1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	            }
	        });
			
			buttonU1 = new JButton();
			buttonU1.setText("Atualizar usuário");
			buttonU1.setHorizontalAlignment(SwingConstants.CENTER);
			buttonU1.setFont(fontelabels);
			buttonU1.setBounds(positionU);
			buttonU1.setBackground(background);
			buttonU1.setForeground( resultcolor );
			buttonU1.setBorder(customBorderButton);
			buttonU1.setFocusPainted(false);
			
			painel1.add(buttonU1);
			buttonU1.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	String input = JOptionPane.showInputDialog("Qual o Código do usuário que deseja atualizar os dados?");
			    	int iduserupdate;

			    	if (input != null && !input.isEmpty()) {
			    	    try {
			    	        iduserupdate = Integer.parseInt(input);
			    	        System.out.println(iduserupdate);
			    	       	InterfaceCreateUsers interfaceCreateUsers = new InterfaceCreateUsers(2, iduserupdate );
			    	        
						    
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "O valor inserido é inválido. É necessário fornecer um número inteiro.");
			    	    }
			    	} 

				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonU1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			buttonD1 = new JButton();
			buttonD1.setText("Deletar usuários");
			buttonD1.setHorizontalAlignment(SwingConstants.CENTER);
			buttonD1.setFont(fontelabels);
			buttonD1.setBounds(positionD);
			buttonD1.setBackground(background);
			buttonD1.setForeground( resultcolor );
			buttonD1.setBorder(customBorderButton);
			buttonD1.setFocusPainted(false);
			
			painel1.add(buttonD1);
			buttonD1.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	
			    	String input = JOptionPane.showInputDialog("Qual o Código do usuário que deseja excluir?");
			    	int iduserupdate;

			    	if (input != null && !input.isEmpty()) {
			    	    try {
			    	        iduserupdate = Integer.parseInt(input);
			    	        Banco banco = new Banco();
							Connection conn = banco.getConexao();
							UsersBanco uBanco = new UsersBanco();
							uBanco.removeUsers(conn, iduserupdate );
			    	        
						    
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "O valor inserido é inválido. É necessário fornecer um número inteiro.");
			    	    }
			    	} 
			    	
					
                   
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonD1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			
			painel2 = new JPanel();
			painel2.setLayout(null);
			painel2.setBounds(290,50,250,200);
			painel2.setBackground(background);
			Border titledBorder2 = BorderFactory.createTitledBorder(matteBorder, "Disciplinas");
			((TitledBorder) titledBorder2).setTitleColor(borderColor);
			painel2.setBorder(titledBorder2);
			((TitledBorder) titledBorder2).setTitleFont(fontelabels);
			painel2.setBorder(titledBorder2);
			getContentPane().add(painel2);
				
			buttonC2 = new JButton();
			buttonC2.setText("Criar disciplina");
			buttonC2.setHorizontalAlignment(SwingConstants.CENTER);
			buttonC2.setFont(fontelabels);
			buttonC2.setBounds(positionC);
			buttonC2.setBackground(background);
			buttonC2.setForeground( resultcolor );
			buttonC2.setBorder(customBorderButton);
			buttonC2.setFocusPainted(false);
			
			painel2.add(buttonC2);
			buttonC2.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	InterfaceCreateSubjects interfaceCreateSubjects = new InterfaceCreateSubjects(1,0);
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonC2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			buttonR2 = new JButton();
			buttonR2.setText("Listar disciplinas");
			buttonR2.setHorizontalAlignment(SwingConstants.CENTER);
			buttonR2.setFont(fontelabels);
			buttonR2.setBounds(positionR);
			buttonR2.setBackground(background);
			buttonR2.setForeground( resultcolor );
			buttonR2.setBorder(customBorderButton);
			buttonR2.setFocusPainted(false);
			
			painel2.add(buttonR2);
			buttonR2.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	InterfaceRead interfaceReadUsers = new InterfaceRead(2);
                   
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonR2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			buttonU2 = new JButton();
			buttonU2.setText("Atualizar disciplina");
			buttonU2.setHorizontalAlignment(SwingConstants.CENTER);
			buttonU2.setFont(fontelabels);
			buttonU2.setBounds(positionU);
			buttonU2.setBackground(background);
			buttonU2.setForeground( resultcolor );
			buttonU2.setBorder(customBorderButton);
			buttonU2.setFocusPainted(false);
			
			painel2.add(buttonU2);
			buttonU2.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	
			    	String input = JOptionPane.showInputDialog(null, "Qual o código da disciplina que deseja atualizar?");
			    	int iduserupdate;

			    	if (input != null && !input.isEmpty()) {
			    	    try {
			    	        iduserupdate = Integer.parseInt(input);
			    	        InterfaceCreateSubjects interfaceCreateSubjects = new InterfaceCreateSubjects(2,iduserupdate);
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "O valor inserido é inválido. É necessário fornecer um número inteiro.");
			    	    }
			    	} 
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonU2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			buttonD2 = new JButton();
			buttonD2.setText("Deletar disciplina");
			buttonD2.setHorizontalAlignment(SwingConstants.CENTER);
			buttonD2.setFont(fontelabels);
			buttonD2.setBounds(positionD);
			buttonD2.setBackground(background);
			buttonD2.setForeground( resultcolor );
			buttonD2.setBorder(customBorderButton);
			buttonD2.setFocusPainted(false);
			
			painel2.add(buttonD2);
			buttonD2.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	String input = JOptionPane.showInputDialog(null, "Qual o código da disciplina que deseja deletar?");
			    	int iduserdelete;

			    	if (input != null && !input.isEmpty()) {
			    	    try {
			    	    	iduserdelete = Integer.parseInt(input);
			    	        Banco banco = new Banco();
							Connection conn = banco.getConexao();
							SubjectsBanco sBanco = new SubjectsBanco();
							sBanco.removeSubjects(conn, iduserdelete);
			    	    	
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "O valor inserido é inválido. É necessário fornecer um número inteiro.");
			    	    }
			    	} 
                   
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonD2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});

			painel3 = new JPanel();
			painel3.setLayout(null);
			painel3.setBounds(560,50,304,200);
			painel3.setBackground(background);
			Border titledBorder3 = BorderFactory.createTitledBorder(matteBorder, "Usuários x Turmas");
			((TitledBorder) titledBorder3).setTitleColor(borderColor);
			painel3.setBorder(titledBorder3);
			((TitledBorder) titledBorder3).setTitleFont(fontelabels);
			painel3.setBorder(titledBorder3);
			getContentPane().add(painel3);
				
			buttonC3 = new JButton();
			buttonC3.setText("Adicionar usuário a uma turma");
			buttonC3.setHorizontalAlignment(SwingConstants.CENTER);
			buttonC3.setFont(fontelabels);
			buttonC3.setBounds(positionC3);
			buttonC3.setBackground(background);
			buttonC3.setForeground( resultcolor );
			buttonC3.setBorder(customBorderButton);
			buttonC3.setFocusPainted(false);
			
			painel3.add(buttonC3);
			buttonC3.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	String input = JOptionPane.showInputDialog(null, "Qual o ID do usuário?");
			    	String idclasses = JOptionPane.showInputDialog(null, "Qual o ID da turma que o usuário será inserido?");
			    	int iduserdelete;
			    	int idclas;
			    	
			    	if (input != null && !input.isEmpty() && idclasses != null && !idclasses.isEmpty()) {
			    	    try {
			    	    	iduserdelete = Integer.parseInt(input);
			    	    	idclas = Integer.parseInt(idclasses);
			    	    	UserHasClass userHasClass = new UserHasClass();
			    	    	userHasClass.users_id = iduserdelete;
			    	    	userHasClass.classes_id = idclas;
			    	    	
			    	    	Banco banco = new Banco();
							Connection conn = banco.getConexao();
							UserHasClassBanco uBanco = new UserHasClassBanco();
							uBanco.insereUsers(conn, userHasClass);
			    	    	
			    	    	
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "Um ou mais valores fornecidos são inválidos.  ");
			    	    }
			    	} 
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonC3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			buttonR3 = new JButton();
			buttonR3.setText("Listar usuários de uma turma");
			buttonR3.setHorizontalAlignment(SwingConstants.CENTER);
			buttonR3.setFont(fontelabels);
			buttonR3.setBounds(positionR3);
			buttonR3.setBackground(background);
			buttonR3.setForeground( resultcolor );
			buttonR3.setBorder(customBorderButton);
			buttonR3.setFocusPainted(false);
			
			painel3.add(buttonR3);
			buttonR3.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	String input = JOptionPane.showInputDialog(null, "Qual o ID da turma que deseja visualizar os usuários?");
			    	
			    	int iduserdelete;
			    	if (input != null && !input.isEmpty()) {
			    	    try {
			    	    	iduserdelete = Integer.parseInt(input);
			    	    	InterfaceReadUsersInClass interfaceReadUsers = new InterfaceReadUsersInClass(iduserdelete);
			    	    	
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "Um ou mais valores fornecidos são inválidos.  ");
			    	    }
			    	} 
                   
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonR3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
			
			buttonU3 = new JButton();
			buttonU3.setText("Deletar usuário de uma turma");
			buttonU3.setHorizontalAlignment(SwingConstants.CENTER);
			buttonU3.setFont(fontelabels);
			buttonU3.setBounds(positionU3);
			buttonU3.setBackground(background);
			buttonU3.setForeground( resultcolor );
			buttonU3.setBorder(customBorderButton);
			buttonU3.setFocusPainted(false);
			
			painel3.add(buttonU3);
			buttonU3.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	String input = JOptionPane.showInputDialog(null, "Qual o ID do usuário?");
			    	String idclasses = JOptionPane.showInputDialog(null, "Qual o ID da turma?");
			    	int iduserdelete;
			    	int idclas;
			    	

			    	if (input != null && !input.isEmpty() && idclasses != null && !idclasses.isEmpty()) {
			    	    try {
			    	    	iduserdelete = Integer.parseInt(input);
			    	    	idclas = Integer.parseInt(idclasses);

			    	    	Banco banco = new Banco();
							Connection conn = banco.getConexao();
							UserHasClassBanco uBanco = new UserHasClassBanco();
							uBanco.removeUsersForClass(conn, iduserdelete, idclas);
			    	    	
			    	    } catch (NumberFormatException el) {
			    	        JOptionPane.showInternalMessageDialog(null, "Um ou mais valores fornecidos são inválidos.  ");
			    	    }
			    	} 
				}
			    
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        buttonU3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    }
			});
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Interface interfaceObj = new Interface();

	}

}
