package P5;

public class Main {

    public static void main(String[] args) {

        User admin = new User(new AdminRole());
        admin.accessSystem();

        User client = new User(new ClientRole());
        client.accessSystem();

        User guest = new User(new GuestRole());
        guest.accessSystem();

        // Nuevo rol agregado sin tocar código existente
        User moderator = new User(new ModeratorRole());
        moderator.accessSystem();
    }
}

/* ===== INTERFAZ ===== */

interface UserRole {
    void accessPanel();
}

/* ===== IMPLEMENTACIONES ===== */

class AdminRole implements UserRole {

    @Override
    public void accessPanel() {
        System.out.println("Admin: acceso total al sistema");
    }
}

class ClientRole implements UserRole {

    @Override
    public void accessPanel() {
        System.out.println("Cliente: acceso a sus datos y compras");
    }
}

class GuestRole implements UserRole {

    @Override
    public void accessPanel() {
        System.out.println("Invitado: acceso solo lectura");
    }
}

/* ===== NUEVO ROL (EXTENSIÓN) ===== */

class ModeratorRole implements UserRole {

    @Override
    public void accessPanel() {
        System.out.println("Moderador: acceso para moderar contenido");
    }
}

/* ===== USUARIO ===== */

class User {

    private UserRole role;

    public User(UserRole role) {
        this.role = role;
    }

    public void accessSystem() {
        role.accessPanel();
    }
}