package Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static CSV_Archives csv_archives = new CSV_Archives();
    static CreateTreeTraverse createTrees = new CreateTreeTraverse();
    static ArrayList<Contacts> ContactList = new ArrayList<>();

    public static void Menu(){
        boolean exit = false;
        int opMenu;
        while(!exit){
            System.out.println("ALMACENAMIENTO DE CONTACTOS. \n Ingrese el valor para seleccionar una opcion.");
            System.out.println("1. Gestion de contactos\n2. Creación de recorridos\n3.Salir");
            try {
                opMenu = sc.nextInt();
                switch(opMenu){
                    case 1:
                        MenuGestion();
                        break;
                    case 2:
                        MenuRecorridos();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Seleccione una opcion entre 1-4");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un valor entero\nPor favor vuelva a intentarlo\n");
                sc.next();
            }
        }
        System.out.println("Gracias por utilizar nuestros servicios, vuelva pronto!");
    }

    public static void MenuGestion() {
        boolean exit = false;
        int opMenuGestion;
        while (!exit) {
            System.out.println("GESTION DE CONTACTOS.\nIngrese el valor para seleccionar una opción:");
            System.out.println("1. Agregar contacto nuevo\n2. Eliminar contacto\n3. Actualizar contacto\n4. Buscar contacto\n5. Ver lista de contactos\n6. Volver");
            try {
                opMenuGestion = sc.nextInt();
                switch (opMenuGestion) {
                    case 1:
                        MenuCreate(); /* Menu para ir a nuevo contacto*/
                        break;
                    case 2:
                        deleteContact(); /* Eliminar contacto*/
                        break;
                    case 3:
                        editContact(); /* Editar contacto*/
                        break;
                    case 4:
                        searchContact(); /* Buscar contacto*/
                        break;
                    case 5:
                        showContactList(); /* Mostrar lista de contactos*/
                        break;
                    case 6:
                        exit = true; // Sale al menú principal
                        break;
                    default:
                        System.out.println("Seleccione una opción entre 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un valor entero. Por favor vuelve a intentarlo.");
                sc.next();
            }
        }
        System.out.println("Volviendo al menú principal...");
    }

    public static void MenuCreate() {
        boolean exitC = false;
        int opMenuC;
        while (!exitC) {
            System.out.println("CREACIÓN DE CONTACTOS. \nElige una opción:");
            System.out.println("1. Crear contacto desde cero\n2. Importar archivo .CSV\n3. Volver");
            try {
                opMenuC = sc.nextInt();
                switch (opMenuC) {
                    case 1:
                        addContact(); /*Crear contacto desde cero*/
                        csv_archives.crearArchivoCSV(ContactList); /*Actualiza el archivo CSV con los nuevos datos*/
                        break;
                    case 2:
                        System.out.println("Se leera la ruta predeterminada para CSV");
                        String archiveRoute = "contactos.csv";
                        csv_archives.leerArchivo(archiveRoute, ContactList); /*Importa los datos del archivo CSV*/
                        csv_archives.crearArchivoCSV(ContactList); /*Actualiza el archivo CSV con los nuevos datos*/
                        System.out.println("Archivo leído con éxito.");
                        break;
                    case 3:
                        exitC = true;
                        break;
                    default:
                        System.out.println("Seleccione una opción entre 1-3.");
                }
            } catch (InputMismatchException | IOException e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
                sc.next();
            }
        }
    }

    public static void MenuRecorridos(){
        boolean exit = false;
        int opMenuRecorridos;
        while(!exit){
            System.out.println("RECORRIDOS. \n Ingrese el valor para seleccionar una opcion.");
            System.out.println("1. Crear recorrido en arbol AVL\n2. Crear recorrido en arbol BST\n3. Salir");
            try {
                opMenuRecorridos = sc.nextInt();
                switch(opMenuRecorridos){
                    case 1:
                        MenuAVL();
                        break;
                    case 2:
                        MenuBST();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Seleccione una opcion entre 1-3");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un valor entero\nPor favor vuelva a intentarlo\n");
                sc.next();
            }
        }
    }


    public static void MenuAVL(){
        boolean exitavl = false;
        int opMenuAVL;
        while(!exitavl){
            System.out.println("RECORRIDO DE ARBOL AVL. \n Seleccione el parametro por el cual desea realizar el recorrido.");
            System.out.println("1. Nombre\n2. Apellido\n3. Apodo\n4. Telefono\n5. Email\n6. Dirección\n7. Fecha de nacimiento\n8. Volver");
            try {
                opMenuAVL = sc.nextInt();
                switch(opMenuAVL){
                    case 1:
                        createTrees.name_AVL(ContactList);
                        break;
                    case 2:
                        createTrees.lastName_AVL(ContactList);
                        break;
                    case 3:
                        createTrees.nick_AVL(ContactList);
                        break;
                    case 4:
                        createTrees.phone_AVL(ContactList);
                        break;
                    case 5:
                        createTrees.email_AVL(ContactList);
                        break;
                    case 6:
                        createTrees.address_AVL(ContactList);
                        break;
                    case 7:
                        createTrees.birth_AVL(ContactList);
                        break;
                    case 8:
                        exitavl = true;
                        break;
                    default:
                        System.out.println("Seleccione una opcion entre 1-8");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un valor entero\nPor favor vuelva a intentarlo\n");
                sc.next();
            }
        }
    }

    public static void MenuBST(){
        boolean exitbst = false;
        int opMenuBST;
        while(!exitbst){
            System.out.println("RECORRIDO DE ARBOL BST. \n Seleccione el parametro por el cual desea realizar el recorrido.");
            System.out.println("1. Nombre\n2. Apellido\n3. Apodo\n4. Telefono\n5. Email\n6. Dirección\n7. Fecha de nacimiento\n8. Volver");
            try {
                opMenuBST = sc.nextInt();
                switch(opMenuBST){
                    case 1:
                        createTrees.name_BST(ContactList);
                        break;
                    case 2:
                        createTrees.lastName_BST(ContactList);
                        break;
                    case 3:
                        createTrees.nick_BST(ContactList);
                        break;
                    case 4:
                        createTrees.phone_BST(ContactList);
                        break;
                    case 5:
                        createTrees.email_BST(ContactList);
                        break;
                    case 6:
                        createTrees.address_BST(ContactList);
                        break;
                    case 7:
                        createTrees.birth_BST(ContactList);
                        break;
                    case 8:
                        exitbst = true;
                        break;
                    default:
                        System.out.println("Seleccione una opcion entre 1-8");
                }
            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un valor entero\nPor favor vuelva a intentarlo\n");
                sc.next();
            }
        }
    }

    //Apartado para manejar una lista de contactos
    public static void addContact() {
        System.out.println("Creación de contacto\nPor favor complete los siguientes datos:");
        sc.nextLine(); // Limpiar buffer
        System.out.print("ID: ");
        int ID = Integer.parseInt(sc.nextLine());
        System.out.print("Nombre: ");
        String Name = sc.nextLine();
        System.out.print("Apellido: ");
        String LastName = sc.nextLine();
        System.out.print("Apodo: ");
        String Nick = sc.nextLine();
        System.out.print("Teléfono: ");
        Integer Phone = Integer.parseInt(sc.nextLine());
        System.out.print("Correo electrónico: ");
        String Email = sc.nextLine();
        System.out.print("Dirección: ");
        String Address = sc.nextLine();
        System.out.print("Fecha de nacimiento: ");
        String Birth = sc.nextLine();

        Contacts newContact = new Contacts(ID, Name, LastName, Nick, Phone, Email, Address, Birth);
        ContactList.add(newContact);
        System.out.println("¡Contacto agregado exitosamente!");
    }

    public static void deleteContact() {
        System.out.println("Ingrese el ID del contacto que desea eliminar:");
        int deleteID = sc.nextInt();


        Contacts contactoAEliminar = null;
        for (Contacts contact : ContactList) {
            if (contact.getID() == deleteID) {
                contactoAEliminar = contact;
                break;
            }
        }

        if (contactoAEliminar == null) {
            System.out.println("Contacto no encontrado. No se realizó ninguna acción.");
            return;
        }

        ContactList.remove(contactoAEliminar);
        System.out.println("¡Contacto eliminado de la lista!");

        createTrees.deleteAllTrees();
        System.out.println("¡Árboles actualizados con éxito!");
    }

    public static void editContact() {
        System.out.println("Ingrese el ID del contacto que desea editar:");
        int editID = sc.nextInt();
        for (Contacts contact : ContactList) {
            if (contact.getID() == editID) {
                sc.nextLine();
                System.out.println("Editar contacto " + contact.getID());
                contact.setID(Integer.parseInt(sc.nextLine()));
                System.out.print("Nuevo Nombre (actual: " + contact.getName() + "): ");
                contact.setName(sc.nextLine());
                System.out.print("Nuevo Apellido (actual: " + contact.getLastName() + "): ");
                contact.setLastName(sc.nextLine());
                System.out.print("Nuevo Apodo (actual: " + contact.getNick() + "): ");
                contact.setNick(sc.nextLine());
                System.out.print("Nuevo Teléfono (actual: " + contact.getPhone() + "): ");
                contact.setPhone(Integer.parseInt(sc.nextLine()));
                System.out.print("Nuevo Correo Electrónico (actual: " + contact.getEmail() + "): ");
                contact.setEmail(sc.nextLine());
                System.out.print("Nueva Dirección (actual: " + contact.getAddress() + "): ");
                contact.setAddress(sc.nextLine());
                System.out.print("Nueva Fecha de nacimiento (actual: " + contact.getBirthDate() + "): ");
                contact.setBirthDate(sc.nextLine());
                System.out.println("¡Contacto actualizado exitosamente!");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public static void searchContact() {
        System.out.println("Ingrese el ID del contacto que desea buscar:");
        int searchID = sc.nextInt();
        for (Contacts contact : ContactList) {
            if (contact.getID() == searchID) {
                System.out.println("Contacto encontrado:");
                contact.showContact(contact);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    public static void showContactList() {
        if (ContactList.isEmpty()) {
            System.out.println("No hay contactos registrados.");
        } else {
            System.out.println("Lista de contactos:");
            for (Contacts contact : ContactList) {
                System.out.println("-------------------------");
                contact.showContact(contact);
                System.out.println("-------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}