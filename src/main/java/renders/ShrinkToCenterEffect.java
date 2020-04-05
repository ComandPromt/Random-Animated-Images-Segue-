package renders;

/**
 * The source image shrinks from the center of the screen exposing the destination.
 */
public class ShrinkToCenterEffect extends AbstractShrinkEffect {

    public ShrinkToCenterEffect() {
        super(ShrinkDirection.FROM_CENTER);
    }

}
