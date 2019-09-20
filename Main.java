package stammdatenPackage;

import java.util.List;
import java.util.Scanner;

import stammdatenPackage.Person;
import stammdatenPackage.Personen;

public class Main {
   
   public static void main(String[] args) {
       System.out.println("Projekt enabled");
       
       Personen pers1 = new Personen();
       Scanner scanner = new Scanner(System.in);
       uiAddPersonen(scanner, pers1);
       while(true) {
       System.out.println("Hinzufügen mit [h], Löschen mit [l], Suchen mit [s], Alle anzeigen mit [a]:");   
       String action = scanner.next();
       if (action.equalsIgnoreCase("h")) {
           uiAddPersonen(scanner, pers1);
       }
       
       if (action.equalsIgnoreCase("l")) {
           uiRemovePersonen(scanner, pers1);
       }
       
       if (action.equalsIgnoreCase("s")) {
           uiFindPerson(scanner, pers1);
       }
       
       if (action.equalsIgnoreCase("a")) {
           uiListAll(scanner, pers1);
       }
       }
  }
   
   public static void uiFindPerson(Scanner scanner, Personen pers1) {
       
       
       while(true) {
           
           List<Person> alle = pers1.getPersonen();
           if(alle != null) {
               System.out.println("Bitte Vorname, Nachname oder Wohnort angeben:");
               String gesucht = scanner.next();
               List<Person> p = pers1.getPersonByNachname(gesucht);
               List<Person> p2 = pers1.getPersonByVorname(gesucht);
               List<Person> p3 = pers1.getPersonByWohnort(gesucht);
               boolean found = false;
               
               if(p != null) {
                   for (Person person : p) {
                       System.out.println("- " + person.getVorname() + ", " + person.getNachname() + ", " + person.getWohnort() );
                   }
                   found = true;
               }
               
               if(p2 != null) {
                   for (Person person : p2) {
                       System.out.println("- " + person.getVorname() + ", " + person.getNachname() + ", " + person.getWohnort() );
                   }
                    found = true;
               }
               
               if(p3 != null) {
                   for (Person person : p3) {
                       System.out.println("- " + person.getVorname() + ", " + person.getNachname() + ", " + person.getWohnort() );
                   }
                    found = true;
               }
               if(!found) {
                   System.out.println("Nichts gefunden!");
               }
           
           } else {
               
               break;
           }
           
           System.out.println("mit [f] beenden, mit anderer Taste fortfahren");   
           String loop = scanner.next();
           
           if (loop.equalsIgnoreCase("f")) {
               break;
             }
          }
   }
   
   public static void uiListAll(Scanner scanner, Personen pers1) {
       
       List<Person> alle = pers1.getPersonen();
         
       if(alle != null) {
          System.out.println("Liste aller Personen:");   
          for (Person p : alle) {
          System.out.println("- " + p.getVorname() + ", " + p.getNachname() + ", " + p.getWohnort() + ", " + p.getIban());   
             }
       }
   }
   
   public static void uiRemovePersonen(Scanner scanner, Personen pers1) {
       List<Person> alle = pers1.getPersonen();
       if(alle != null) {
       
       System.out.println("Bitte zu löschende Person angeben:");
       
       while(true) {
           System.out.println("Vorname:");
           String vorname = scanner.next();
           System.out.println("Nachname:");
           String nachname = scanner.next();
           System.out.println("Wohnort:");
           String wohnort = scanner.next();
           System.out.println("IBAN:");
           String iban = scanner.next();
           System.out.println("Mit [y] bestätigen, mit anderer Taste abbrechen");   
           String control = scanner.next();
       
           if (control.equalsIgnoreCase("y")) {
               
               for(int i=0;i<alle.size();i++)  {
                   Person p = alle.get(i);
                   if(p.getNachname().equalsIgnoreCase(nachname) && p.getVorname().equalsIgnoreCase(vorname) &&  p.getWohnort().equalsIgnoreCase(wohnort)) {
                       
                       alle.remove(i);
                   }
               }
             }
           
           System.out.println("mit [f] beenden, mit anderer Taste fortfahren");   
           String loop = scanner.next();
           
           if (loop.equalsIgnoreCase("f")) {
               break;
               }
           }
        }
       }
   
   
   public static void uiAddPersonen(Scanner scanner, Personen pers1) {
       System.out.println("Bitte neue Personen hinzufügen:");
       
       while(true) {
           System.out.println("Vorname:");   
           String vorname = scanner.next();
           System.out.println("Nachname:");   
           String nachname = scanner.next();
           System.out.println("Wohnort:");   
           String wohnort = scanner.next();
           System.out.println("IBAN:");
           String iban = scanner.next();
           System.out.println("Mit [y] bestätigen, mit anderer Taste abbrechen");   
           String control = scanner.next();
       
           if (control.equalsIgnoreCase("y")) {
               pers1.addPerson(new Person(vorname, nachname, wohnort, iban));
             }
           
           System.out.println("mit [f] beenden, mit anderer Taste fortfahren");   
           String loop = scanner.next();
           
           if (loop.equalsIgnoreCase("f")) {
           break;
             }
         }
  }
}
