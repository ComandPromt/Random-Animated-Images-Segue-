package renders;

import com.defano.jsegue.AnimatedSegue;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Slides the destination image over the source from right to left.
 */
public class WipeLeftEffect extends AnimatedSegue {

    /** {@inheritDoc} */
    @Override
    public BufferedImage render(BufferedImage src, BufferedImage dst, float progress) {
        BufferedImage frame = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = frame.createGraphics();

        // Calculate wipe distance
        int distance = Math.min(src.getWidth() - 1, (int) (progress * src.getWidth()));
        BufferedImage sub = src.getSubimage(0, 0, src.getWidth() - distance, src.getHeight());

        g.drawImage(dst, 0, 0, null);
        g.drawImage(sub, 0, 0, null);

        return frame;
    }
}
