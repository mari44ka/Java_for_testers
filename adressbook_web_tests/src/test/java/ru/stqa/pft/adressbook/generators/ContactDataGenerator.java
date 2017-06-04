package ru.stqa.pft.adressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.adressbook.model.Contactdata;
import ru.stqa.pft.adressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mari on 5/30/17.
 */
public class ContactDataGenerator {
  @Parameter(names = "-c",description = "Group count")
  public int count;

  @Parameter(names = "-f",description ="Target file")
  public String file;

  @Parameter(names = "-d",description ="Data format")
  public String format;


  public static void main (String[] args) throws IOException {

   ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);

    try{
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();

    }

  private void run() throws IOException {
    List<Contactdata> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv(contacts,new File(file));
    }
    else if(format.equals("xml")){
      saveAsXml(contacts,new File(file));
    }
    else if(format.equals("json")){
      saveAsJson(contacts,new File(file));
    }
    else{
      System.out.println("Unrecognized format" + format);
    }
  }

  private void saveAsJson(List<Contactdata> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();

  }

  private void saveAsXml(List<Contactdata> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(Contactdata.class);
    String xml = xstream.toXML(contacts); //change name to group
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<Contactdata> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (Contactdata contact : contacts){
      writer.write(String.format("%s;%s;%s\n",contact.getFirstname(),contact.getLastname(),contact.getAddress()));
      }
    writer.close();
    }

  private static List<Contactdata> generateContacts(int count) {
    List<Contactdata> contacts = new ArrayList<Contactdata>();
    for (int i = 0; i < count; i++){
      contacts.add(new Contactdata().withFirstname(String.format("Firstname%s",i)).withLastname(String.format("Lastname%s",i)).
              withAddress(String.format("Address%s",i)));
    }
    return contacts;
    }


  }


