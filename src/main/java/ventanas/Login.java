package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.defano.jsegue.AnimatedSegue;
import com.defano.jsegue.SegueBuilder;

import util.Metodos;

@SuppressWarnings("all")

public class Login extends javax.swing.JFrame
		implements ActionListener, ChangeListener, SegueAnimationObserver, com.defano.jsegue.SegueAnimationObserver {
	private String separador, directorioActual;
	public static int prueba = 1;
	private int contador = 0;
	private static String[] login;
	private static boolean paso = true;

	private static JLabel lblNewLabel = new JLabel("");

	public static Object claseanimacion = new Object();

	public static JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public static boolean terminado = false;

	public static boolean isTerminado() {
		return terminado;
	}

	public static void setTerminado(boolean terminado) {
		Login.terminado = terminado;
	}

	public static AnimatedSegue mySegue = null;

	public static AnimatedSegue getMySegue() {
		return mySegue;
	}

	public Login() throws IOException {

		getContentPane().setBackground(Color.WHITE);

		setTitle("Test");

		setType(Type.POPUP);

		initComponents();

		Timer t = new Timer();

		Animacion mTask = new Animacion();

		t.scheduleAtFixedRate(mTask, 0, 2500);

		animar();

		this.setVisible(true);

	}

	void animar() throws IOException {

		terminado = false;
		BufferedImage mySource = getOrangeRect(200, 200, (int) (Math.random() * 11) + 1);
		BufferedImage myDestination = getBlueCircle(200, 200);

		// Create a cross-dissolve segue
		AnimatedSegue mySegue = SegueBuilder
				.of((Class<? extends AnimatedSegue>) Metodos.calcularAnimacion((int) (Math.random() * 23) + 1))
				.withSource(mySource).withDestination(myDestination).withDuration(1500, TimeUnit.MILLISECONDS) // Animation
																												// lasts
																												// 1.5
																												// seconds
				.withMaxFramesPerSecond(30) // No more than 30fps
				.withAnimationObserver(this) // Make this class an observer
				// Overlay images; see FAQs
				.build();

		// Kick it off...
		mySegue.start();
		terminado = true;
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo.jpg")));

	}

	public static void setMySegue(Object object) throws IOException {

		BufferedImage mySource = getOrangeRect(200, 200, (int) (Math.random() * 11) + 1);
		BufferedImage myDestination = getBlueCircle(200, 200);
		Login.mySegue = SegueBuilder.of((Class<? extends AnimatedSegue>) object).withSource(mySource)
				.withDestination(myDestination).withDuration(4800, TimeUnit.MILLISECONDS).withMaxFramesPerSecond(30)
				.build();

	}

	public static BufferedImage getBlueCircle(int width, int height) throws IOException {

		BufferedImage src = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Image img = ImageIO.read(Login.class.getResource("/imagenes/logo.jpg"));

		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D bGr = bimage.createGraphics();

		bGr.drawImage(img, 0, 0, null);

		bGr.dispose();

		return bimage;

	}

	public static BufferedImage getOrangeRect(int width, int height, int paisaje) throws IOException {

		Image img = ImageIO.read(Login.class.getResource("/paisajes/" + paisaje + ".jpg"));

		if (img instanceof BufferedImage) {
			return (BufferedImage) img;
		}

		BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D bGr = bimage.createGraphics();

		bGr.drawImage(img, 0, 0, null);

		bGr.dispose();

		return bimage;
	}

	private void initComponents() throws IOException {

		directorioActual = new File(".").getCanonicalPath() + separador;

		int animacion = (int) (Math.random() * 24) + 1;

		claseanimacion = Metodos.calcularAnimacion(1);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		setResizable(false);

		lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override

			public void mousePressed(MouseEvent e) {

				if (!terminado && paso) {

					try {
						animar();
					}

					catch (IOException e1) {
						//
					}

				}

				else {

					paso = false;

					if (contador % 2 == 0) {
						terminado = false;
					}

				}

				contador++;

			}

		});

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addGap(39)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(242)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(19).addComponent(lblNewLabel).addContainerGap(523, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);
		setSize(new Dimension(347, 235));
		setLocationRelativeTo(null);
	}

	public boolean isPaso() {
		return paso;
	}

	public static void setPaso(boolean paso) {
		Login.paso = paso;
	}

	public static Object getClaseanimacion() {
		return claseanimacion;
	}

	public static void setClaseanimacion(Object claseanimacion) {
		Login.claseanimacion = claseanimacion;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void onFrameRendered(AnimatedSegue segue, BufferedImage image) {

		lblNewLabel.setIcon(new ImageIcon(image));

	}

	public void onFrameRendered(ventanas.AnimatedSegue segue, BufferedImage image) {
		//

	}

	private void login() {

	}

}