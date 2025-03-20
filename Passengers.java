import java.sql.*;
import java.util.*;
public class Passengers{

       public static void main(String[] args){
                try{
                     executeUpdate();
                }
               catch (Exception e){
                    e.printStackTrace();
      }

  }
       public static void readRecords() throws Exception{
                String url="jdbc:mysql://localhost:3306/LogicFirst";
                String username ="root";
 		String password = "12345";

		String query = "select * from customer";
                // sql commands
 
               Connection con = DriverManager.getConnection(url,username,password);
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(query);


               while(rs.next()){

                    System.out.println("id is:"+rs.getInt(1));
	            System.out.println("name is:"+rs.getString(2));
                    System.out.println("place is:"+rs.getString(3));

         }

                con.close();
     }

          public static void updateRecords() throws Exception{
                   String url = "jdbc:mysql://localhost:3306/LogicFirst";
                   String username = "root";
                   String password = "12345";
                   String query = "insert into customer values (5,'preethi','chennai')";

                   Connection con = DriverManager.getConnection(url,username,password);
                   Statement st = con.createStatement();
                   int rows = st.executeUpdate(query);
                
                   System.out.println("number of rows inserted:"+rows);
               con.close();
                
         }

         
        public static void insertUsingPst() throws Exception{
                   String url ="jdbc:mysql://localhost:/3306:LogicFirst";
                   String username = "root";
                   String password = "12345";



                   int id = 6;
		   String name = "sameer";
		   String place = "karaikudi";
                   String query = "insert into customer values (?,?,?);";
                  
 
 		   Connection con = DriverManager.getConnection(url,username,password);
		   PreparedStatement pst = con.prepareStatement(query);
 		   pst.setInt(1,id);
                   pst.setString(2,name);
		   pst.setString(3,place);

                   int rows = pst.executeUpdate(query); 
  
                   System.out.println("number of rows inserted: "+ rows);
		   con.close();
                   
        }

}
