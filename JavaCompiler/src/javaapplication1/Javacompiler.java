/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author User
 */
public class Javacompiler {

  private static void printLines(String name, InputStream ins) throws Exception {
    String line = null;
    BufferedReader in = new BufferedReader(
        new InputStreamReader(ins));
    while ((line = in.readLine()) != null) {
        System.out.println(name + " " + line);
    }
  }

  private static void runProcess(String command) throws Exception {
    Process pro = Runtime.getRuntime().exec(command);
    printLines(command + " stdout:", pro.getInputStream());
    printLines(command + " stderr:", pro.getErrorStream());
    pro.waitFor();
    System.out.println(command + " exitValue() " + pro.exitValue());
  }

  public static void main(String[] args) {
    try {
     // runProcess("cd C:\\Users\\User\\Documents\\NetBeansProjects\\JavaApplication1\\src\\javaapplication1");
      runProcess("javac C:\\Users\\ASUS\\Desktop\\java\\Hello.java");
      runProcess("java -cp C:\\Users\\ASUS\\Desktop\\java\\ Hello");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}