package gui;

import semana_06.ArregloTemperaturas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class Propuesto_6_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblTemperatura;
	private JTextField txtTemperatura;
	private JButton btnAdicionar;
	private JButton btnEliminarTodo;
	private JButton btnEliminarAlFinal;
	private JButton btnIncrementarTemperaturas;
	private JButton btnRemplazarPrimeraTemperaturaNormal;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Propuesto_6_1 frame = new Propuesto_6_1();
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
	public Propuesto_6_1() {
		setTitle("Propuesto_6_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setBounds(10, 10, 75, 23);
		contentPane.add(lblTemperatura);

		txtTemperatura = new JTextField();
		txtTemperatura.setBounds(95, 10, 86, 23);
		contentPane.add(txtTemperatura);
		txtTemperatura.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(290, 40, 261, 23);
		contentPane.add(btnAdicionar);

		btnEliminarAlFinal = new JButton("Eliminar al final");
		btnEliminarAlFinal.addActionListener(this);
		btnEliminarAlFinal.setBounds(290, 70, 261, 23);
		contentPane.add(btnEliminarAlFinal);

		btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(290, 100, 261, 23);
		contentPane.add(btnEliminarTodo);

		btnIncrementarTemperaturas = new JButton("Incrementar temperaturas");
		btnIncrementarTemperaturas.addActionListener(this);
		btnIncrementarTemperaturas.setBounds(290, 130, 261, 23);
		contentPane.add(btnIncrementarTemperaturas);

		btnRemplazarPrimeraTemperaturaNormal = new JButton("Remplazar primera temperatura normal");
		btnRemplazarPrimeraTemperaturaNormal.addActionListener(this);
		btnRemplazarPrimeraTemperaturaNormal.setBounds(290, 160, 261, 23);
		contentPane.add(btnRemplazarPrimeraTemperaturaNormal);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 275, 412);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRemplazarPrimeraTemperaturaNormal) {
			actionPerformedBtnRemplazarPrimeraTemperaturaNormal(arg0);
		}
		if (arg0.getSource() == btnIncrementarTemperaturas) {
			actionPerformedBtnIncrementarTemperaturas(arg0);
		}
		if (arg0.getSource() == btnEliminarTodo) {
			actionPerformedBtnEliminarTodo(arg0);
		}
		if (arg0.getSource() == btnEliminarAlFinal) {
			actionPerformedBtnEliminarAlFinal(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		limpieza();
	}

	ArregloTemperaturas at = new ArregloTemperaturas();

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			at.adicionar(leerTemperatura());
			listar();
		} catch (Exception e) {
			mensaje("error de ingreso");
		}

	}

	protected void actionPerformedBtnEliminarAlFinal(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.eliminarAlFinal();
			listar();
		} else
			mensaje("el Arreglo está vacío");

	}

	protected void actionPerformedBtnEliminarTodo(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.eliminarTodo();
			txtS.setText("");
		} else
			mensaje("el Arreglo está vacío");

	}

	protected void actionPerformedBtnRemplazarPrimeraTemperaturaNormal(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.remplazarPrimeraTemperaturaNormal();
			;
			listar();
		} else
			mensaje("el Arreglo está vacío");

	}

	protected void actionPerformedBtnIncrementarTemperaturas(ActionEvent arg0) {
		if (at.tamanio() > 0) {
			at.incrementarTemperaturas();
			listar();
		} else
			mensaje("el Arreglo está vacío");

	}

	// M�todos tipo void (sin par�metros)
	void imprimir() {
		imprimir("");
	}

	void limpieza() {
		txtTemperatura.setText("");
		txtTemperatura.requestFocus();
	}

	void listar() {
		txtS.setText("");
		for (int i = 0; i < at.tamanio(); i++) {
			imprimir("n[" + i + "] : " + at.obtener(i));
		}

	}

	// M�todos tipo void (con par�metros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	// M�todos que retornan valor (sin par�metros)
	double leerTemperatura() {
		return Double.parseDouble(txtTemperatura.getText().trim());
	}

}