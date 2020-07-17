package cl.inacap.musicapp;

public class Usuario {
   private String rut,nombre,ApPaterno,ApMaterno,Direccion,Email,Nacimiento,username,pass,Perfil;

   public Usuario() {

   }

   public Usuario(String rut, String nombre, String apPaterno, String apMaterno, String direccion, String email, String nacimiento, String username, String pass, String perfil) {
      this.rut = rut;
      this.nombre = nombre;
      ApPaterno = apPaterno;
      ApMaterno = apMaterno;
      Direccion = direccion;
      Email = email;
      Nacimiento = nacimiento;
      this.username = username;
      this.pass = pass;
      Perfil = perfil;
   }

   public String getRut() {
      return rut;
   }

   public void setRut(String rut) {
      this.rut = rut;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getApPaterno() {
      return ApPaterno;
   }

   public void setApPaterno(String apPaterno) {
      ApPaterno = apPaterno;
   }

   public String getApMaterno() {
      return ApMaterno;
   }

   public void setApMaterno(String apMaterno) {
      ApMaterno = apMaterno;
   }

   public String getDireccion() {
      return Direccion;
   }

   public void setDireccion(String direccion) {
      Direccion = direccion;
   }

   public String getEmail() {
      return Email;
   }

   public void setEmail(String email) {
      Email = email;
   }

   public String getNacimiento() {
      return Nacimiento;
   }

   public void setNacimiento(String nacimiento) {
      Nacimiento = nacimiento;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPass() {
      return pass;
   }

   public void setPass(String pass) {
      this.pass = pass;
   }

   public String getPerfil() {
      return Perfil;
   }

   public void setPerfil(String perfil) {
      Perfil = perfil;
   }
}
