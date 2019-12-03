public class miConsultaSQL{
  static final String URL = "jdbc:mysql://urlDeEjemplo.es/NombreDB";
  static final String USER = "AlumnoDePrueba";
  static final String PASSWORD = "qwertyui123";
  
  public static void main(String[] args){
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String miConsulta = "SELECT Sueldo, DNI, Nombre_Apellidos, FechaNac From EMPLEADOS");
    int contsueldo=0; //inicializamos el contador de los sueldos
    try{
      con = DriverManager.getConnection(URL, USER, PASSWORD);
      st = con.createStatement();
      rs = st.executeQuery(miConsulta);
      while(rs.next()){
       contsueldo+=rs.getInt(1); // sumamos los sueldos de todas las tuplas de la tabla
      }
    }catch(SQLException e){ //excepción provocada por error de acceso a la base de datos
      e.printStackTrace();
    } finally {
      try{
        st.close();
        con.close();
      }catch (SQLException e){
        e.printStackTrace();
      }
  }
}
