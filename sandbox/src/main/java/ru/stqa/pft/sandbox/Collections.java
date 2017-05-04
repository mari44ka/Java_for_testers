package ru.stqa.pft.sandbox;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Mari on 5/3/17.
 */
public class Collections {

  public static void main(String[] args) {

    // String[] langs= new String[4];
    //langs[0]= "Java";
    //langs[1]="Python";
    //langs[2]="C#";
    //langs[3]="PHP";  we can describe collections in this way or
    String[] langs = {"Java", "Python", "C#", "PHP"};

    //for (int i=0;i<langs.length;i++){
    //System.out.println(" i want to learn "+langs[i]); or we use
    for (String l : langs) {
      System.out.println("i want to learn " + l);
    }
  }

  //public static void main(String[] args) {

    //List<String> languages = new ArrayList<String>();
    //languages.add("Java");
    //languages.add("Python");
    //languages.add("C#");
    //languages.add("PHP");
    //for (String k : languages) {
      //System.out.println("I want to learn" + k);
    //}
  //}

}
