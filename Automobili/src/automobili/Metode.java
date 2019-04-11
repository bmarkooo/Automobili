package automobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.PreparedQuery;

public class Metode {
	
	
	private Connection konktujSe (String baza) throws SQLException{
		
		final String url = "jdbc:mysql://localhost:3306/"+baza+"?useSSL=false";
		final String user = "root";
		final String password = "root";
		
		return DriverManager.getConnection(url, user, password);
	}

	public void ubaciMarku(String nazivMarke, String zemlja){
		
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = konktujSe("automobili");
			String query = "INSERT INTO marke VALUES (NULL,?,?)";
			pst = konekcija.prepareStatement(query);
			pst.setString(1, nazivMarke);
			pst.setString(2, zemlja);
			pst.execute();
			System.out.println("Uspesan unos!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Neuspesan unos!");
		}finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		
		
		
		
	}
	
	
	
	
}
