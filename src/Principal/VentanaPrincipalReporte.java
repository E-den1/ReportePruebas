package Principal;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class VentanaPrincipalReporte extends JFrame implements ActionListener{

	private JPanel PanelPrincipal;
	private JTextField txtTotalCP;
	private JTextField txtCpEjecutados;
	private JTextField txtCpExitosos;
	private JTextField txtCpFallados;
	private JTextField txtNoEjecutados;
	private JTextField txtBloqueados;
	private JTextField txtCancelados;
	private JTextArea txtAHighlights;
	private JTextArea txtASiguientes ;

	JButton BtnGenerarR;
	CalculoReporte calculo;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalReporte frame = new VentanaPrincipalReporte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalReporte() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 548);
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PanelPrincipal);
		
		setLocationRelativeTo(null);
		setTitle("Reporte de Pruebas QA");
		setResizable(false);
		
		iniciarVentana();
		
	}
	
	public void iniciarVentana() {
		PanelPrincipal.setLayout(null);

		JLabel lblNewLabel = new JLabel("Reporte De Pruebas");
		lblNewLabel.setBounds(81, 11, 260, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		PanelPrincipal.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("Total Casos de Prueba:");
		lblTotal.setBounds(88, 72, 155, 14);
		lblTotal.setFont(new Font("Century Gothic", Font.BOLD, 12));
		PanelPrincipal.add(lblTotal);
		
		JLabel lblEjecutados = new JLabel("Casos Ejecutados: ");
		lblEjecutados.setBounds(115, 97, 122, 14);
		lblEjecutados.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		PanelPrincipal.add(lblEjecutados);
		
		JLabel lblExitosos = new JLabel("Exitosos:");
		lblExitosos.setBounds(173, 122, 59, 14);
		lblExitosos.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		PanelPrincipal.add(lblExitosos);
		
		JLabel lblFallados = new JLabel("Fallados:");
		lblFallados.setBounds(173, 147, 59, 21);
		lblFallados.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		PanelPrincipal.add(lblFallados);
		
		JLabel lblNoEjecutados = new JLabel("No Ejecutados:");
		lblNoEjecutados.setBounds(134, 179, 95, 14);
		lblNoEjecutados.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		PanelPrincipal.add(lblNoEjecutados);
		
		JLabel lblBloqueados = new JLabel("Bloqueados:");
		lblBloqueados.setBounds(151, 210, 92, 14);
		lblBloqueados.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		PanelPrincipal.add(lblBloqueados);
		
		JLabel lblCancelados = new JLabel("Cancelados:");
		lblCancelados.setBounds(151, 235, 82, 14);
		lblCancelados.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		PanelPrincipal.add(lblCancelados);
		
		txtTotalCP = new JTextField();
		txtTotalCP.setBounds(229, 70, 86, 20);
		PanelPrincipal.add(txtTotalCP);
		txtTotalCP.setColumns(10);
		
		txtCpEjecutados = new JTextField();
		txtCpEjecutados.setBounds(229, 95, 86, 20);
		txtCpEjecutados.setColumns(10);
		PanelPrincipal.add(txtCpEjecutados);
		
		txtCpExitosos = new JTextField();
		txtCpExitosos.setBounds(229, 120, 86, 20);
		txtCpExitosos.setColumns(10);
		PanelPrincipal.add(txtCpExitosos);
		
		txtCpFallados = new JTextField();
		txtCpFallados.setBounds(229, 148, 86, 20);
		txtCpFallados.setColumns(10);
		PanelPrincipal.add(txtCpFallados);
		
		txtNoEjecutados = new JTextField();
		txtNoEjecutados.setBounds(229, 177, 86, 20);
		txtNoEjecutados.setColumns(10);
		PanelPrincipal.add(txtNoEjecutados);
		
		txtBloqueados = new JTextField();
		txtBloqueados.setBounds(229, 208, 86, 20);
		txtBloqueados.setColumns(10);
		PanelPrincipal.add(txtBloqueados);
		
		txtCancelados = new JTextField();
		txtCancelados.setBounds(229, 233, 86, 20);
		txtCancelados.setColumns(10);
		PanelPrincipal.add(txtCancelados);
		
		BtnGenerarR = new JButton("Generar Reporte");
		BtnGenerarR.setBounds(134, 475, 150, 21);
		BtnGenerarR.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		BtnGenerarR.addActionListener(this);
		PanelPrincipal.add(BtnGenerarR);
		
		JLabel lblHighlights = new JLabel("Highlights:");
		lblHighlights.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblHighlights.setBounds(12, 272, 59, 14);
		PanelPrincipal.add(lblHighlights);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 297, 396, 63);
		PanelPrincipal.add(scrollPane);
		
		txtAHighlights = new JTextArea();
		scrollPane.setViewportView(txtAHighlights);
		txtAHighlights.setLineWrap(true);
		DefaultCaret caret = (DefaultCaret) txtAHighlights.getCaret();
		
		JLabel lblPasos = new JLabel("Siguientes pasos:");
		lblPasos.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblPasos.setBounds(12, 371, 131, 14);
		PanelPrincipal.add(lblPasos);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 394, 396, 58);
		PanelPrincipal.add(scrollPane_1);
		
		txtASiguientes = new JTextArea();
		scrollPane_1.setViewportView(txtASiguientes);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GenerarWord word = new GenerarWord();
		Metricas metricas = new Metricas();
		
		calculo = new CalculoReporte();
		if(BtnGenerarR==e.getSource()) {
			
			double total= Integer.parseInt(txtTotalCP.getText());
			metricas.setTotal((int)total);
			double ejecutados =Integer.parseInt(txtCpEjecutados.getText());
			metricas.setEjecutados((int)ejecutados);
			double exitosos =Integer.parseInt(txtCpExitosos.getText());
			metricas.setExitosos((int)exitosos);
			double fallados =Integer.parseInt(txtCpFallados.getText());
			metricas.setFallados((int)fallados);
			double noEjecutados =Integer.parseInt(txtNoEjecutados.getText());
			metricas.setNoEjecutados((int)noEjecutados);
			double bloqueados =Integer.parseInt(txtBloqueados.getText()); 
			metricas.setBloqueados((int)bloqueados);
			double cancelados =Integer.parseInt(txtCancelados.getText()); 
			metricas.setCancelados((int)cancelados);
			
			double respEjecutados= calculo.formula(total, ejecutados);
			metricas.setRespEjecutados(respEjecutados);
			double respExitosos= calculo.formula(total, exitosos);
			metricas.setRespExitosos(respExitosos);
			double respFallados= calculo.formula(total, fallados);
			metricas.setRespFallados(respFallados);
			double respNoEjecutados= calculo.formula(total, noEjecutados);
			metricas.setRespNoEjecutados(respNoEjecutados);
			double respBloqueados= calculo.formula(total, bloqueados);
			metricas.setRespbloqueados(respBloqueados);
			double respCancelados= calculo.formula(total, cancelados);
			metricas.setRespCancelados(respCancelados);
			
			metricas.setHighlights(txtAHighlights.getText());
			metricas.setSiguientesp(txtASiguientes.getText());
			
			word.crear(metricas);
			
		
			
			
			
			
		}
		
	}
}
