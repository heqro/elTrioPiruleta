public class miConsultaSQL{
  static final String URL = "jdbc:mysql://urlDeEjemplo.es/NombreDB";
  static final String USER = "AlumnoDePrueba";
  static final String PASSWORD = "qwertyui123";
  
  public static void main(String[] args){
    Connection con = null;
    pst = con.prepareStatement(miConsulta);
    String miConsulta = "SELECT DNI, Nombre, Apellidos, FechaNac From ESTUDIANTES"
                        + "WHERE DNI = ?");
    pst = con.prepareStatement(miConsulta);
    pst.setInt(1, dni); //resolvemos la interrogación.
    try{
      con = DriverManager.getConnection(URL, USER, PASSWORD);
      pst = con.prepareStatement(miConsulta);
      pst.setInt(1, dni); //resolvemos la interrogación.
      rs = pst.executeQuery();
      if(rs.next()){
       System.out.println("DNI: " + rs.getInt(1)
                          + "\n Nombre: " + rs.getString(2) 
                          + "\n Apellidos: " + rs.getString(3)
                          + "\n FechaNac: " + rs.getDate(4)
                          + "\n ----------------------------------------");
      } else {
                System.out.println("No se han encontrado resultados");
              }
    }catch(...){
      ...
    }
}
