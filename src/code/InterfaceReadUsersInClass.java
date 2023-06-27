package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class InterfaceReadUsersInClass extends JFrame{
	
	private JButton voltar;
	private int idlist;
	
	public InterfaceReadUsersInClass (int id) {
		idlist = id;
		
		setSize(900,700);
		setTitle("Listar usuários");
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
		Color background = new Color (242, 242, 242); //Cor areia de fundo
		Color resultcolor = new Color (191, 107, 33);
    	Color borderColor = new Color (156, 185, 188); // Cor verde em RGB
    	Font fontelabels = new Font( "Poppins", Font.PLAIN, 14);
    	int borderWidth = 2; // Espessura da borda em pixels
		Border matteBorder = BorderFactory.createMatteBorder(borderWidth, borderWidth, borderWidth, borderWidth, borderColor);
		Border titledBorder = BorderFactory.createTitledBorder(matteBorder, "Usuários");
		
    	JPanel painel5 = new JPanel();
		painel5.setLayout(new BorderLayout());
		Border titledBorder5 = BorderFactory.createTitledBorder(matteBorder, "Lista de usuários");
		((TitledBorder) titledBorder5).setTitleColor(borderColor);
		painel5.setBorder(titledBorder5);
		((TitledBorder) titledBorder5).setTitleFont(fontelabels);
		painel5.setBounds(20,270,845,300);
		getContentPane().add(painel5);
    	
		Banco banco = new Banco();
		Connection conn = banco.getConexao();
		UserHasClassBanco uBanco = new UserHasClassBanco();
		
		List<Users> userList = uBanco.listausers(conn, idlist);
		
    	DefaultTableModel modelo = new DefaultTableModel();
    	JTable tabela = new JTable(modelo);
    	
    	modelo.addColumn("ID");
    	modelo.addColumn("Nome");
    	modelo.addColumn("Código");
    	modelo.addColumn("Email");
    	modelo.addColumn("Telefone");
    	modelo.addColumn("CPF");
    	modelo.addColumn("Endereço");
		for (Users user : userList) {
    	modelo.addRow(new Object[]{user.id, user.name, user.cod_person, user.email, user.fone_number, user.cpf, user.spaces_id});
		}
    	JScrollPane scrollPane = new JScrollPane(tabela);
    	painel5.add(scrollPane, BorderLayout.CENTER);
    	
    	voltar = new JButton();
		voltar.setText("Voltar");
		voltar.setHorizontalAlignment(SwingConstants.CENTER);
		voltar.setFont(fontelabels);
		voltar.setBounds(60, 250, 100, 25);
		voltar.setBackground(background);
		voltar.setForeground( resultcolor );
		Border customBorderButton = BorderFactory.createLineBorder(resultcolor, 2 );
		voltar.setBorder(customBorderButton);
		voltar.setFocusPainted(false);
		getContentPane().add(voltar);
		painel5.setVisible(true);
		
		voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
//				Interface interfaceObj = new Interface();
				
			}
		});
    }

    
	public static void main(String[] args) {
		 Interface InterfaceReadUsers = new Interface();

	}

}
