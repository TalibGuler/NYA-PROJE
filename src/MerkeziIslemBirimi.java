import javax.xml.stream.FactoryConfigurationError;
import java.sql.*;

public class MerkeziIslemBirimi {

    Connection conn;
    ResultSet rs;
    Statement stmt;

    public void veritabaniBaglan() {
        try
        {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkıllıCihaz",
                    "postgres", "g181210011");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String sorgu(String table, String column) {
        String result = " ";
        String sql = "Select * From public.\"" + table + "\"";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                result = rs.getString(column);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public boolean sorguBool(String table, String column) {
        boolean result = false;
        String sql = "Select * From public.\"" + table + "\"";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                result = rs.getBoolean(column);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    public boolean kullanici(String isim, String sifre) {
        String username1 = " ";
        String password1 = " ";
        String sql = "Select * From public.\"Kullanıcı\"";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                username1 = rs.getString("isim");
                password1 = rs.getString("sifre");

                if (isim.equals(username1) && sifre.equals(password1))
                    return true;

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void veritabaniKes() {
        try {
            if (rs != null)
                rs.close();
            conn.close();
            if (stmt != null)
                stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void veriEkle(String table, String column, String Value) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO  public.\"" + table + "\" (\"" + column + "\") VALUES (?)");
            st.setString(1, Value);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void veriEkle(String table, String column, boolean Value) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO  public.\"" + table + "\" (\"" + column + "\") VALUES (?)");
            st.setBoolean(1, Value);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}



