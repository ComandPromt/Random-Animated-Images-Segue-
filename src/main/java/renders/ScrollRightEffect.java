package renders;

import com.defano.jsegue.AnimatedSegue;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * Scroll from left to right.
 */
public class ScrollRightEffect extends AnimatedSegue {

    /** {@inheritDoc} */
    @Override
    public BufferedImage render(BufferedImage src, BufferedImage dst, float progress) {
        BufferedImage frame = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = frame.createGraphics();

        // Calculate the scroll distance, in pixels
        int scrollDistance = (int) (progress * src.getWidth());

        // Slide the from image to the right
        AffineTransform fromTranslate = new AffineTransform();
        fromTranslate.translate(scrollDistance, 0);
        g.setTransform(fromTranslate);
        g.drawImage(src, 0, 0, null);

        // Slide the to image from the left
        AffineTransform toTranslate = new AffineTransform();
        toTranslate.translate(-dst.getWidth() + scrollDistance, 0);
        g.setTransform(toTranslate);
        g.drawImage(dst, 0, 0, null);

        return frame;
    }

}
