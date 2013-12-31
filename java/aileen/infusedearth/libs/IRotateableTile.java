package aileen.infusedearth.libs;

import net.minecraftforge.common.ForgeDirection;

public abstract interface IRotateableTile
{
    public abstract boolean canRotate();

    public abstract void rotate();

    public abstract ForgeDirection getDirectionFacing();
}
