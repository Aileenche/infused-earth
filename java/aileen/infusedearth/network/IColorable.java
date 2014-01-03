package aileen.infusedearth.network;

import net.minecraft.util.Icon;

/**
 * Created by Aileen on 30.12.13.
 */
public interface IColorable {
    public Icon iconoverride = null;
    public String get_Icon();
    public void set_Icon(int i,int meta);
}
