package aileen.infusedearth.network;

public interface NetworkBase {
	public boolean gis_controller();
	public boolean gis_connected();
	public boolean gis_networkblock();
	public boolean gcan_connect_to_network();
	public void sis_controller(boolean b);
	public void sis_connected(boolean b);
	public void sis_networkblock(boolean b);
	public void scan_connect_to_network(boolean b);
}
