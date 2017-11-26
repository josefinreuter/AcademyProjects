import fi.academy.papu.Viesti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Haku {

    public static ArrayList<Viesti> haeSanat(Connection c, String sana) {
        sana = "%" + sana + "%";
        ArrayList<Viesti> sanat = new ArrayList<>();
        String sql = "SELECT * FROM viesti WHERE otsikko LIKE ? OR viesti LIKE ?";
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, sana);
            ps.setString(2, sana);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Viesti v = new Viesti();
                v.setViestiID(rs.getInt("id"));
                v.setOtsikko(rs.getString("otsikko"));
                v.setViesti(rs.getString("viesti"));
                v.setAjankohta(rs.getString("kirjoitettu"));
                sanat.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return sanat;
    }
}
