package ventanas;

import java.awt.image.BufferedImage;
import java.util.TimerTask;

import javax.swing.ImageIcon;

import com.defano.jsegue.AnimatedSegue;

public class Animacion extends TimerTask implements SegueAnimationObserver {

	public Animacion() {
		//
	}

	@Override
	public void run() {
		try {
			Login.getLblNewLabel().setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo.jpg")));

			if (Login.isTerminado()) {
				Login.setTerminado(false);
				Login.getMySegue().stop();

			}
			Login.setPaso(true);
		} catch (Exception e) {
			//
		}
	}

	public void onFrameRendered(AnimatedSegue segue, BufferedImage image) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFrameRendered(ventanas.AnimatedSegue segue, BufferedImage image) {
		// TODO Auto-generated method stub

	}

}