package gui;

import java.awt.EventQueue;
import semana_06.ArregloEdades;
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

public class Problema_6_1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JButton btnAdicionar;
	private JButton btnEliminarAlFinal;
	private JButton btnEliminarTodo;
	private JButton btnIncrementarPrimeraEdadAdulta;
	private JButton btnRemplazarPrimeraEdadAdulta;
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
					Problema_6_1 frame = new Problema_6_1();
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
	public Problema_6_1() {
		setTitle("Problema_6_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 10, 46, 23);
		contentPane.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(66, 10, 86, 23);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(300, 40, 225, 23);
		contentPane.add(btnAdicionar);

		btnEliminarAlFinal = new JButton("Eliminar al final");
		btnEliminarAlFinal.addActionListener(this);
		btnEliminarAlFinal.setBounds(300, 70, 225, 23);
		contentPane.add(btnEliminarAlFinal);

		btnEliminarTodo = new JButton("Eliminar todo");
		btnEliminarTodo.addActionListener(this);
		btnEliminarTodo.setBounds(300, 100, 225, 23);
		contentPane.add(btnEliminarTodo);

		btnIncrementarPrimeraEdadAdulta = new JButton("Incrementar primera edad adulta");
		btnIncrementarPrimeraEdadAdulta.addActionListener(this);
		btnIncrementarPrimeraEdadAdulta.setBounds(300, 130, 225, 23);
		contentPane.add(btnIncrementarPrimeraEdadAdulta);

		btnRemplazarPrimeraEdadAdulta = new JButton("Remplazar primera edad adulta");
		btnRemplazarPrimeraEdadAdulta.addActionListener(this);
		btnRemplazarPrimeraEdadAdulta.setBounds(300, 160, 225, 23);
		contentPane.add(btnRemplazarPrimeraEdadAdulta);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 280, 412);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRemplazarPrimeraEdadAdulta) {
			actionPerformedBtnRemplazarPrimeraEdadAdulta(arg0);
		}
		if (arg0.getSource() == btnIncrementarPrimeraEdadAdulta) {
			actionPerformedBtnIncrementarPrimeraEdadAdulta(arg0);
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

	ArregloEdades ae = new ArregloEdades();

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		try {
			ae.adicionar(leerEdad());
			listar();
		} catch (Exception e) {
			mensaje("error de ingreso");
		}

	}

	protected void actionPerformedBtnEliminarAlFinal(ActionEvent arg0) {
		if (ae.tamanio() > 0) {
			ae.eliminarAlFinal();
			listar();
		} else
			mensaje("el Arreglo está vacío");
	}

	protected void actionPerformedBtnEliminarTodo(ActionEvent arg0) {
		if (ae.tamanio() > 0) {
			ae.eliminarTodo();
			txtS.setText("");
		} else
			mensaje("el Arreglo está vacío");
	}

	protected void actionPerformedBtnIncrementarPrimeraEdadAdulta(ActionEvent arg0) {
		if (ae.tamanio() > 0) {
			ae.incrementarPrimeraEdadAdulta();
			listar();
		} else
			mensaje("el Arreglo está vacío");
	}

	protected void actionPerformedBtnRemplazarPrimeraEdadAdulta(ActionEvent arg0) {
		if (ae.tamanio() > 0) {
			ae.remplazarPrimeraEdadAdulta();
			;
			listar();
		} else
			mensaje("el Arreglo está vacío");
	}

	// Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}

	void limpieza() {
		txtEdad.setText("");
		txtEdad.requestFocus();
	}

	void listar() {
		txtS.setText("");
		for (int i = 0; i < ae.tamanio(); i++) {
			imprimir("n[" + i + "] : " + ae.obtener(i));
		}
	}

	// Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	// Métodos que retornan valor (sin parámetros)
	int leerEdad() {
		return Integer.parseInt(txtEdad.getText().trim());
	}

}