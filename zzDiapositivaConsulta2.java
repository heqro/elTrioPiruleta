public class miConsultaSQL{
  static final String URL = "jdbc:mysql://urlDeEjemplo.es/NombreDB";
  static final String USER = "AlumnoDePrueba";
  static final String PASSWORD = "qwertyui123";
  
  public static void main(String[] args){
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String miConsulta = "SELECT DNI, Nombre, Apellidos, FechaNac From ESTUDIANTES");
    try{
      con = DriverManager.getConnection(URL, USER, PASSWORD);
      st = con.createStatement();
      rs = st.executeQuery(miConsulta);
      while(rs.next()){
       System.out.println("DNI: " + rs.getInt(1)
                          + "\n Nombre: " + rs.getString(2) 
                          + "\n Apellidos: " + rs.getString(3)
                          + "\n FechaNac: " + rs.getDate(4)
                          + "\n ----------------------------------------");
      }
    }catch(SQLException e){ //excepción provocada por error de acceso a la base de datos
      e.printStackTrace();
    } finally {
      try{
        st.close();
        con.close();
      }catch (Exception e){
        e.printStackTrace();
      }
  }
}


