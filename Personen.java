package stammdatenPackage;

public class Personen {
    private String vorname;
    private String nachname;
    private String wohnort;
    private String Iban;
   public Personen(String vorname, String nachname, String wohnort, String iban) {
   
       this.setVorname  (vorname);
       this.setNachname (nachname);
       this.setWohnort  (wohnort);
       this.setIban 	  (iban)
   ;
   }
   public boolean containsVorname(String vornamee) {
       if(vorname.equals(vornamee)) {
           return true;
       }
       return false;
       
   }
   public String getVorname() {
       return vorname;
   }
   public void setVorname(String vorname){
       this.vorname = vorname;
   }
   
   public String getWohnort() {
       return wohnort;
   }
   public void setWohnort(String wohnort) {
       this.wohnort = wohnort;
   }
   public String getNachname() {
       return nachname;
   }
   public void setNachname(String nachname) {
       this.nachname = nachname;
   }
   public String getIban() {
	   return Iban;
   }
   public void setIban(String iban) {
	   this.Iban = iban;
   }
}
