package Classes;

import java.util.ArrayList;
import java.util.Comparator;

public class CreateTreeTraverse {
    TreeStorage gestor = new TreeStorage();

    public void deleteAllTrees() {
        gestor.getTrees().forEach((criterio, pair) -> {
            if (pair.AVL != null) {
                pair.AVL = null; // Elimina el AVL asociado
            }
            if (pair.BST != null) {
                pair.BST = null; // Elimina el BST asociado
            }
            System.out.printf("Árboles asociados al criterio '%s' eliminados.%n", criterio);
        });
        gestor.getTrees().clear(); // Limpia completamente el mapa de árboles
        System.out.println("¡Todos los árboles han sido eliminados!");
    }

    // AVL format
    public void name_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> name_AVL = new AVL_Trees<>((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        if (gestor.registerAVL("Nombre", name_AVL)){
            for (Contacts contacts : ContactList) {
                name_AVL.insert(contacts);
            }
            name_AVL.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void lastName_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> lastName_AVL = new AVL_Trees<>((c1, c2) -> c1.getLastName().compareToIgnoreCase(c2.getLastName()));
        if (gestor.registerAVL("Apellido", lastName_AVL)){
            for (Contacts contacts : ContactList) {
                lastName_AVL.insert(contacts);
            }
            lastName_AVL.traverseByLevels(Contacts::getID);
            System.out.println();

        }
    }

    public void nick_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> nick_AVL = new AVL_Trees<>((c1, c2) -> c1.getNick().compareToIgnoreCase(c2.getNick()));
        if (gestor.registerAVL("Apodo", nick_AVL)){
            for (Contacts contacts : ContactList) {
                nick_AVL.insert(contacts);
            }
            nick_AVL.traverseByLevels(Contacts::getID);
            System.out.println();

        }
    }

    public void phone_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> phone_AVL = new AVL_Trees<>(Comparator.comparing(Contacts::getPhone));
        if (gestor.registerAVL("Telefono", phone_AVL)){
            for (Contacts contacts : ContactList) {
                phone_AVL.insert(contacts);
            }
            phone_AVL.traverseByLevels(Contacts::getID);
            System.out.println();

        }
    }

    public void email_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> email_AVL = new AVL_Trees<>((c1, c2) -> c1.getEmail().compareToIgnoreCase(c2.getEmail()));
        if (gestor.registerAVL("Email", email_AVL)){
            for (Contacts contacts : ContactList) {
                email_AVL.insert(contacts);
            }
            email_AVL.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void address_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> address_AVL = new AVL_Trees<>((c1, c2) -> c1.getAddress().compareToIgnoreCase(c2.getAddress()));
        if (gestor.registerAVL("Direccion", address_AVL)){
            for (Contacts contacts : ContactList) {
                address_AVL.insert(contacts);
            }
            address_AVL.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void birth_AVL(ArrayList<Contacts> ContactList){
        AVL_Trees<Contacts> birth_AVL = new AVL_Trees<>((c1, c2) -> c1.getBirthDate().compareToIgnoreCase(c2.getBirthDate()));
        if (gestor.registerAVL("Nacimiento", birth_AVL)){
            for (Contacts contacts : ContactList) {
                birth_AVL.insert(contacts);
            }
            birth_AVL.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    // BST format
    public void name_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> name_BST = new BST_Trees<>((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        if (gestor.registerBST("Nombre", name_BST)){
            for (Contacts contacts : ContactList) {
                name_BST.insert(contacts);
            }
            name_BST.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void lastName_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> lastName_BST = new BST_Trees<>((c1, c2) -> c1.getLastName().compareToIgnoreCase(c2.getLastName()));
        if (gestor.registerBST("Apellido", lastName_BST)){
            for (Contacts contacts : ContactList) {
                lastName_BST.insert(contacts);
            }
            lastName_BST.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void nick_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> nick_BST = new BST_Trees<>((c1, c2) -> c1.getNick().compareToIgnoreCase(c2.getNick()));
        if (gestor.registerBST("Apodo", nick_BST)){
            for (Contacts contacts : ContactList) {
                nick_BST.insert(contacts);
            }
            nick_BST.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void phone_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> phone_BST = new BST_Trees<>(Comparator.comparing(Contacts::getPhone));
        if (gestor.registerBST("Telefono", phone_BST)){
            for (Contacts contacts : ContactList) {
                phone_BST.insert(contacts);
            }
            phone_BST.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void email_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> email_BST = new BST_Trees<>((c1, c2) -> c1.getEmail().compareToIgnoreCase(c2.getEmail()));
        if (gestor.registerBST("Email", email_BST)){
            for (Contacts contacts : ContactList) {
                email_BST.insert(contacts);
            }
            email_BST.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void address_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> address_BST = new BST_Trees<>((c1, c2) -> c1.getAddress().compareToIgnoreCase(c2.getAddress()));
        if (gestor.registerBST("Direccion", address_BST)){
            for (Contacts contacts : ContactList) {
                address_BST.insert(contacts);
            }
            address_BST.traverseByLevels(Contacts::getID);
            System.out.println();
        }
    }

    public void birth_BST(ArrayList<Contacts> ContactList){
        BST_Trees<Contacts> birth_BST = new BST_Trees<>((c1, c2) -> c1.getBirthDate().compareToIgnoreCase(c2.getBirthDate()));
        if (gestor.registerBST("Nacimiento", birth_BST)){
            for (Contacts contacts : ContactList) {
                birth_BST.insert(contacts);
            }
            birth_BST.traverseByLevels(Contacts::getID);
        }
    }
}
