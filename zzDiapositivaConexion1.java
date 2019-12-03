public class miConsultaSQL{
  static final String URL = "jdbc:mysql://urlDeEjemplo.es/NombreDB";
  static final String USER = "AlumnoDePrueba";
  static final String PASSWORD = "qwertyui123";
  
  public static void main(String[] args){
    Connection con = null;
    try{
      con = DriverManager.getConnection(URL, USER, PASSWORD);
      System.out.println("Conexion establecida");
    }catch(SQLException e){ //excepción provocada por error de acceso a la base de datos
      e.printStackTrace();
    } finally {
      try{
        con.close(); 
      }catch (Exception e){
        e.printStackTrace();
      }
  }
}
