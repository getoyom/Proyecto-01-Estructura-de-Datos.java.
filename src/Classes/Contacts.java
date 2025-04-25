package Classes;
public class Contacts {
    protected int ID;
    protected String Name;
    protected String LastName;
    protected String Nick;
    protected Integer Phone;
    protected String Email;
    protected String Address;
    protected String Birth;

    // Constructor
    public Contacts(int ID, String Name, String LastName, String Nick, Integer Phone, String Email, String Address, String Birth) {
        this.ID = ID;
        this.Name = Name;
        this.LastName = LastName;
        this.Nick = Nick;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.Birth = Birth;
    }

    // Getters y Setters
    public int getID() { return ID; }
    public void setID(int ID) { this.ID = ID; }
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }
    public String getLastName() { return LastName; }
    public void setLastName(String LastName) { this.LastName = LastName; }
    public String getNick() { return Nick; }
    public void setNick(String Nick) { this.Nick = Nick; }
    public Integer getPhone() { return Phone; }
    public void setPhone(Integer Phone) { this.Phone = Phone; }
    public String getEmail() { return Email; }
    public void setEmail(String Email) { this.Email = Email; }
    public String getAddress() { return Address; }
    public void setAddress(String Address) { this.Address = Address; }
    public String getBirthDate() { return Birth; }
    public void setBirthDate(String Birth) { this.Birth = Birth; }

    /*Metodo para convertir los datos a un array de Strings, para poder guardarlo en un archivo CSV.*/
    public String[] toArray() {
        return new String[]{String.valueOf(ID), Name, LastName, Nick, String.valueOf(Phone), Email, Address, Birth};
    }

    /*Mostrar los datos de un contacto en pantalla.*/
    public void showContact(Contacts contact){
        System.out.printf("Nombre: %s\nApellido: %s\nApodo: %s\nTeléfono: %d\nCorreo: %s\nDirección: %s\nFecha de nacimiento: %s\n",
                contact.getName(), contact.getLastName(),contact.getNick(), contact.getPhone(), contact.getEmail(), contact.getAddress(), contact.getBirthDate());
    }
}