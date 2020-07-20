package cl.inacap.musicapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Usuario  {
   private String rut, nombre, ApPaterno, ApMaterno, Direccion, Email, Nacimiento, username, pass, Perfil;

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


