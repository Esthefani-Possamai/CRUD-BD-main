package code;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InterfaceCreateUsers extends JFrame {
	
	private JPanel painel4;
	private JLabel lnameuser;
	private JTextArea nameuser;
	
	private JLabel lcodeperson;
	private JTextArea codeperson;
	
	private JLabel lemail;
	private JTextArea email;
	
	private JLabel lfone;
	private JTextArea fone;
	
	private JLabel lcpf;
	private JTextArea cpf;
	
	private JLabel lspace;
	private JTextArea space;
	
	private JButton caduser;
	private JButton voltar;
	
	private int minhaVariavel;
	private int idupdate;
	Users users = null;
		
	public InterfaceCreateUsers (int valor, int idupdate) {
		
		minhaVariavel = valor;
		idupdate = idupdate;
		if (minhaVariavel == 2) {
			//PARA ATUALIZAR USUÁRIO
			 Banco banco = new Banco();
				Connection conn = banco.getConexao();
				UsersBanco uBanco = new UsersBanco();
				users = uBanco.findUsers(conn, idupdate);
		}
		
		setSize(455,390);
		setTitle("Inserir usuário ");
		// Obtém o painel de conteúdo do JFrame
        Container contentPane = getContentPane();
        // Define a cor de fundo do painel de conteúdo
        contentPane.setBackground(new Color(242, 242, 242));
		setLayout(null);
		//setBackground(getColorModel(255,69,0));
		setLocationRelativeTo(null);
		componentesCriar();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	

	private void componentesCriar () {
		
		Font fontetitle = new Font( "Poppins", Font.PLAIN, 16);
		Font fontelabels = new Font( "Poppins", Font.PLAIN, 14);
		Color borderColor = new Color (156, 185, 188); // Cor verde em RGB
		Color background = new Color (242, 242, 242); //Cor areia de fundo
		Color resultcolor = new Color (191, 107, 33);
		
		painel4 = new JPanel();
		painel4.setLayout(null);
		int borderWidth = 2; // Espessura da borda em pixels
		Border matteBorder = BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, borderColor);
		Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Usuários");
		((TitledBorder) titledBorder).setTitleColor(borderColor);
		Border titledBorder4 = BorderFactory.createTitledBorder(matteBorder, "Criar usuário");
		((TitledBorder) titledBorder4).setTitleColor(borderColor);
		painel4.setBorder(titledBorder4);
		((TitledBorder) titledBorder4).setTitleFont(fontelabels);
		if (minhaVariavel == 1) {
			painel4.setBounds(20,20,400,300);
		} else if (minhaVariavel == 2) {
			painel4.setBounds(20,20,400,300);
		}
		getContentPane().add(painel4);
		
		
		
		lnameuser = new JLabel("Nome:");
		lnameuser.setBounds(20,40,50,25);
		lnameuser.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lnameuser);
		nameuser = new JTextArea();
		nameuser.setBounds(80,40,280,25);
		painel4.add(nameuser);
		
		lcodeperson = new JLabel("Código:");
		lcodeperson.setBounds(20,75,50,25);
		lcodeperson.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lcodeperson);
		codeperson = new JTextArea();
		codeperson.setBounds(80,75,280,25);
		painel4.add(codeperson);
		
		lemail = new JLabel("Email:");
		lemail.setBounds(20,110,50,25);
		lemail.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lemail);
		email = new JTextArea();
		email.setBounds(80,110,280,25);
		painel4.add(email);
		
		lfone = new JLabel("Telefone:");
		lfone.setBounds(0,145,70,25);
		lfone.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lfone);
		fone = new JTextArea();
		fone.setBounds(80,145,280,25);
		painel4.add(fone);
		
		lcpf = new JLabel("CPF:");
		lcpf.setBounds(20,180,50,25);
		lcpf.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lcpf);
		cpf = new JTextArea();
		cpf.setBounds(80,180,280,25);
		painel4.add(cpf);
		
		lspace = new JLabel("Endereço:");
		lspace.setBounds(0,215,70,25);
		lspace.setHorizontalAlignment(JLabel.RIGHT);
		painel4.add(lspace);
		space = new JTextArea();
		space.setBounds(80,215,280,25);
		painel4.add(space);
		
		caduser = new JButton();
		if (minhaVariavel == 1) {
			caduser.setText("Criar usuário");
		} else if (minhaVariavel == 2) {
			caduser.setText("Atualizar usuário");
		}
		caduser.setHorizontalAlignment(SwingConstants.CENTER);
		caduser.setFont(fontelabels);
		caduser.setBounds(200, 250, 150, 25);
		caduser.setBackground(background);
		caduser.setForeground( resultcolor );
		Border customBorderButton = BorderFactory.createLineBorder(resultcolor, 2 );
		caduser.setBorder(customBorderButton);
		caduser.setFocusPainted(false);
		painel4.add(caduser);
		
		if (minhaVariavel == 2) {
			nameuser.setText(users.name);
			codeperson.setText(String.valueOf(users.cod_person));
			email.setText(users.email);
			fone.setText(users.fone_number);
			cpf.setText(users.cpf);
			space.setText(String.valueOf(users.spaces_id));
			codeperson.setEditable(false);
		}
		
		caduser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Nenhum campo pode estar vazio para atualizar ou criar um usuário
				if (nameuser.getText() != "" && codeperson.getText() != "" && email.getText() != "" && fone.getText() != "" && cpf.getText() != ""  && space.getText() != "") {
					String name = nameuser.getText();
					int code = Integer.parseInt(codeperson.getText());
					String emailuser = email.getText();
					String foneuser = fone.getText();
					String cpfuser = cpf.getText();
					int idspace = Integer.parseInt(space.getText());
					
					if (minhaVariavel == 1) {
						//PARA ADICIONAR NOVO USUÁRIO
						Banco banco = new Banco();
						Connection conn = banco.getConexao();
						UsersBanco uBanco = new UsersBanco();
						
						Users users = new Users();
						users.name = name;
						users.cod_person = code;
						users.email = emailuser;
						users.fone_number = foneuser;
						users.cpf = cpfuser;
						users.spaces_id = idspace;
						uBanco.insereUsers(conn, users);
						
					} else if (minhaVariavel == 2) {
						Banco banco = new Banco();
						Connection conn = banco.getConexao();
						UsersBanco uBanco = new UsersBanco();
						
						Users users = new Users();
						users.name = name;
						users.cod_person = code;
						users.email = emailuser;
						users.fone_number = foneuser;
						users.cpf = cpfuser;
						users.spaces_id = idspace;
						uBanco.updateUsers(conn, users);	
					}
				}
				
			}
		});
		
		voltar = new JButton();
		voltar.setText("Voltar");
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setFont(fontelabels);
		voltar.setBounds(90, 250, 100, 25);
		voltar.setBackground(background);
		voltar.setForeground( resultcolor );
		voltar.setBorder(customBorderButton);
		voltar.setFocusPainted(false);
		painel4.add(voltar);
		
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				
			}
		});
	}
	

	public static void main(String[] args) {
		 Interface InterfaceUsers = new Interface();

	}

}
