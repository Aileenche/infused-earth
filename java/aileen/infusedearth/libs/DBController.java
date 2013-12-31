package aileen.infusedearth.libs;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.Minecraft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBController {
    private static final DBController dbcontroller = new DBController();
    private static Connection connection;
    private static String mcDir = Minecraft.getMinecraft().mcDataDir.getAbsolutePath();
    private static final String DB_PATH = mcDir + "/infusedearthdb.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            FMLLog.getLogger().warning("[Infused Earth] Fehler beim Laden des JDBC-Treibers");
            e.printStackTrace();
        }
    }

    private DBController() {
    }

    public static DBController getInstance() {
        return dbcontroller;
    }

    public void initDBConnection() {
        try {
            if (connection != null)
                return;
            FMLLog.getLogger().info("[Infused Earth] Creating Connection to Database...");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
            if (!connection.isClosed())
                FMLLog.getLogger().info("[Infused Earth] ...Connection established");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    if (!connection.isClosed() && connection != null) {
                        connection.close();
                        if (connection.isClosed())
                            FMLLog.getLogger().info("[Infused Earth] Connection to Database closed");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public int countResultSet(ResultSet rs) {
        int count = 0;
        try {
            while (rs.next()) {
                ++count;
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return count;
    }

    public static String[][] rs2array(ResultSet rs) {
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            List rows = new ArrayList();
            while (rs.next()) {
                String[] row = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getString(i);
                }
                rows.add(row);
            }
            rs.close();
            String[][] rowData = (String[][]) rows.toArray(new String[rows.size()][columnCount]);
            return rowData;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkSelf4DB(int x, int y, int z, int netblock, int world) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT * FROM `networkblocks` WHERE `x` = '" + x + "' AND `y` = '" + y + "' AND `z` = '" + z + "' AND `world`='" + world + "';");
            String[][] temp = rs2array(rs);
            if (temp.length == 0) {
                return false;
            } else {
                if (Integer.parseInt(temp[0][2]) == netblock) {
                    return true;
                }
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return false;
    }

    public boolean check4DB(int x, int y, int z, int world) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT * FROM `networkblocks` WHERE `x` = '" + x + "' AND `y` = '" + y + "' AND `z` = '" + z + "' AND `world`='" + world + "';");
            String[][] temp = rs2array(rs);
            if (temp.length == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return false;
    }

    public boolean check4DBOverID(int id) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT * FROM `networkblocks` WHERE `id` = '" + id + "';");
            String[][] temp = rs2array(rs);
            if (temp.length == 0) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return false;
    }

    public int checkForNetworkBlock(int x, int y, int z, int world) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `networkblock` FROM `networkblocks` WHERE `x`='" + x + "' AND `y`='" + y + "' AND `z`='" + z + "' AND `world`='" + world + "';");
            String[][] temp = rs2array(rs);

            if (temp.length != 0) {
                return Integer.parseInt(temp[0][0]);
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public int getControllerXForNetworkID(String id) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `x`FROM `networkblocks` WHERE `networkid`='" + id + "' AND `networkblock` = '1';");
            String[][] temp = rs2array(rs);
            if (temp.length != 0) {
                return Integer.parseInt(temp[0][0]);
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public int getControllerYForNetworkID(String id) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `y`FROM `networkblocks` WHERE `networkid`='" + id + "' AND `networkblock` = '1';");
            String[][] temp = rs2array(rs);
            if (temp.length != 0) {
                return Integer.parseInt(temp[0][0]);
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public int getControllerZForNetworkID(String id) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `z` FROM `networkblocks` WHERE `networkid`='" + id + "' AND `networkblock` = '1';");
            String[][] temp = rs2array(rs);
            if (temp.length != 0) {
                return Integer.parseInt(temp[0][0]);
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public int getOwnDBId(int x, int y, int z, int world) {
        try {
            Statement q = connection.createStatement();

            ResultSet rs = q.executeQuery("SELECT `name` FROM sqlite_master WHERE type='table' AND name='networkblocks';");
            if (countResultSet(rs) != 0) {
                ResultSet rs2 = q.executeQuery("SELECT `id` FROM `networkblocks` WHERE `x`='" + x + "' AND `y`='" + y + "' AND `z`='" + z + "' AND `world`='" + world + "';");
                String[][] temp = rs2array(rs2);
                if (temp.length != 0) {
                    return Integer.parseInt(temp[0][0]);
                }
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public int getLastActiveBlock(int x, int y, int z, int world) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `lastactiveblock` FROM `networkblocks` WHERE `x`='" + x + "' AND `y`='" + y + "' AND `z`='" + z + "' AND `world`='" + world + "';");
            String[][] temp = rs2array(rs);

            if (temp.length != 0) {
                return Integer.parseInt(temp[0][0]);
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public String getNetworkId(int x, int y, int z, int world) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `networkid` FROM `networkblocks` WHERE `x`='" + x + "' AND `y`='" + y + "' AND `z`='" + z + "' AND `world`='" + world + "';");
            String[][] temp = rs2array(rs);

            if (temp.length != 0) {
                return temp[0][0];
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return "";
    }

    public void createNetwork(String networkID) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `name` FROM sqlite_master WHERE type='table' AND name='networkblocks';");
            if (countResultSet(rs) == 0) {
                q.execute("CREATE TABLE `networkblocks` (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE, networkid TEXT, networkblock INTEGER, x INTEGER, y INTEGER, z INTEGER,world INTEGER, lastactiveblock INTEGER, controllerX INTEGER, controllerY INTEGER, controllerZ INTEGER, style INTEGER)");
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }

    public void changestyle(int x,int y,int z, int world, int style){
        try {
            Statement q = connection.createStatement();
            q.execute("UPDATE `networkblocks` SET `style` = '"+style+"' WHERE `x`='" + x + "' AND `y`='" + y + "' AND `z`='" + z + "' AND `world`='" + world + "';");
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }
    public int getcolorized(int x,int y,int z, int world) {
        try {
            Statement q = connection.createStatement();
            ResultSet rs = q.executeQuery("SELECT `style` FROM `networkblocks` WHERE `x`='" + x + "' AND `y`='" + y + "' AND `z`='" + z + "' AND `world`='" + world + "';");
            String[][] temp = rs2array(rs);
            if (temp.length != 0) {
                return Integer.parseInt(temp[0][0]);
            }
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
        return 0;
    }

    public void registerBlockToNetwork(String networkID, int internalBlockId, int x, int y, int z, int world, int lastactiveblock, int controllerX, int controllerY, int controllerZ,int style) {
        try {
            //FMLLog.getLogger().info("Adding " + internalBlockId + " [" + x + "|" + y + "|" + z + "] to network");
            Statement q = connection.createStatement();
            q.execute("INSERT INTO `networkblocks` (id, networkid, networkblock, x, y, z, world, lastactiveblock, controllerX, controllerY, controllerZ, style) VALUES (null, '" + networkID + "', '" + internalBlockId + "','" + x + "','" + y + "','" + z + "','" + world + "','" + lastactiveblock + "','" + controllerX + "','" + controllerY + "','" + controllerZ + "','" + style + "')");
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }

    public void deleteNetwork(String networkID) {
        try {
            Statement q = connection.createStatement();
            q.executeUpdate("DELETE FROM `networkblocks` WHERE `networkid` = '" + networkID + "';");
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }

    public void deleteFromNetwork(String id) {
        try {
            Statement q = connection.createStatement();
            q.executeUpdate("DELETE FROM `networkblocks` WHERE `networkid` = '" + id + "' AND `networkblock` != '1';");
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }

    /*    public void deleteFromNetwork(int id) {
            try {
                Statement q = connection.createStatement();
                q.executeUpdate("DELETE FROM `networkblocks` WHERE `id` = '" + id + "';");
                boolean temp = true;
                q.execute("CREATE TABLE `temp` (id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE, blockid INTEGER, checked BOOLEAN )");
                q.execute("INSERT INTO `temp` (`id`,`blockid`,`checked`) VALUES ( null, '" + id + "', 'false' )");
                while (temp == true) {
                    ResultSet rs = q.executeQuery("SELECT * FROM `networkblocks` WHERE `lastactiveblock` = '" + id + "'");
                    String[][] temparray = rs2array(rs);
                    rs.close();
                    q.execute("UPDATE `temp` SET`checked` = 'true' WHERE `blockid` = '" + id + "'");
                    q.executeUpdate("DELETE FROM `networkblocks` WHERE `id` = '" + id + "';");
                    for (int i = 0; i < temparray.length; i++) {
                        q.execute("INSERT INTO `temp` (`id`,`blockid`,`checked`) VALUES ( null, '" + temparray[i][0] + "', 'false' )");
                    }
                    ResultSet rs2 = q.executeQuery("SELECT * FROM `temp` WHERE `checked` = 'false'");
                    String[][] temparray2 = rs2array(rs2);
                    if (temparray2.length != 0) {
                        id = Integer.parseInt(temparray2[0][1]);
                    } else {
                        temp = false;
                    }
                }
                q.executeUpdate("DROP TABLE IF EXISTS `temp`");
            } catch (SQLException e) {
                FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
                e.printStackTrace();
            }
        }*/
    public void deleteSelfFromNetwork(int id) {
        try {
            Statement q = connection.createStatement();
            q.executeUpdate("DELETE FROM `networkblocks` WHERE `id` = '" + id + "';");
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }

    public void updatelastactive(int id, int newlastactive) {
        try {
            Statement q = connection.createStatement();
            q.executeUpdate("UPDATE `networkblocks` SET `lastactiveblock` = '" + newlastactive + "' WHERE `id` = '" + id + "'");
        } catch (SQLException e) {
            FMLLog.getLogger().warning("[Infused Earth] Couldn't handle DB-Query");
            e.printStackTrace();
        }
    }

}
