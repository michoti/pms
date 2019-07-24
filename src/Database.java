import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Database{
           //create the connection host here
    String host="jdbc:mySql://localhost:3306/prison";
    String user="root";
    String pass="";
    //dclare connect object 
    Connection conn;
    
    //initialize the connection object
    public Connection getConnection(){
        try{
          conn=DriverManager.getConnection(host,user,pass);
          //JOptionPane.showMessageDialog(null,"connection Successive" );
          return conn;
        }
       catch(SQLException ex){
           JOptionPane.showMessageDialog(null, ""+ex.getMessage());
           return null;
       }
    }
        //insert the student  record
        public void insertPrisoners (String fname,String sname,String ag,String crime,String pisid){
            String q="INSERT INTO prisoners(Firstname,Secondname,Age,Crime,Prisonerid)VALUES (?,?,?,?,?)";
            
            
            try{
                int k=0;
                PreparedStatement st=getConnection().prepareStatement(q);
                st.setString(1,fname);
                st.setString(2,sname);
                st.setString(3,ag);
                st.setString(4,crime);
                st.setString(5,pisid);
                
                if(st.executeUpdate()>k){
                    JOptionPane.showMessageDialog(null,pisid+"registered susccessfully");
                }
            }
        
    catch(SQLException x){
    JOptionPane.showMessageDialog(null, x.getMessage());
}
        }
        // defines how delete can be done
        public void deletePrisoners(String pisid){
            String q="DELETE FROM prisoners WHERE Prisonerid=?";
            try
            {
                int k=0;
                PreparedStatement st=getConnection().prepareStatement(q);
                st.setString(1, pisid);
                 if(st.executeUpdate()>k){
                    JOptionPane.showMessageDialog(null,pisid+"deleted successively");
                    
                 }
            }
            catch(SQLException x){
                JOptionPane.showMessageDialog(null, x.getMessage());
            }
           
            //defines how update can be done
        }
        public void updatePatient(String fname,String sname,String ag,String crime,String pisid){
            String q="UPDATE prisoners SET Firstname=?,Secondname=?,Age=? Crime=? WHERE Prisonerid=?";
            {
                try
                {
                    int k=0;
                    PreparedStatement st=getConnection().prepareStatement(q);
                    st.setString(1,fname);
                    st.setString(2,sname);
                    st.setString(3,ag);
                    st.setString(4,crime);
                    st.setString(5,pisid);
                    
                     if(st.executeUpdate()>k){
                    JOptionPane.showMessageDialog(null, fname+"record updated");
                }
       
            }
                 catch(SQLException x){
                JOptionPane.showMessageDialog(null, x.getMessage());
        } 
            }
        }
            //retreieve
            public ResultSet getPrisoners(){
            
                String q="SELECT *FROM prisoners";
                try{
                    Statement st=getConnection().createStatement();
                    ResultSet rs=st.executeQuery(q);
                    return rs;
                }
                catch(SQLException x){
                    JOptionPane.showMessageDialog(null,x.getMessage());
                    return null;
                }
                
            }
    
            }