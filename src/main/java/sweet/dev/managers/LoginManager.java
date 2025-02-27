package sweet.dev.managers;

import sweet.dev.models.Admin;
import sweet.dev.models.supplier;
import sweet.dev.models.user;

import java.util.*;

public class LoginManager {
    private boolean validation;
    private Integer roleInSys;
    private boolean forget;
    private String enteredUsername;
    private List<user> users;
    private List<supplier> suppliers;
    private List<Admin> admins;
    private String loggedInSupplier;
    private String loggedInUser;

    private supplier loggedSupplierObj;
    private user loggedUserObj;
    private Map<String, String> resetTokens = new HashMap<>();


    public LoginManager(List<user> users, List<supplier> suppliers, List<Admin> admins) {
        this.users = users;
        this.suppliers = suppliers;
        this.admins=admins;
    }


    public void setRoleInSys(Integer roleInSys) {
        this.roleInSys = roleInSys;
    }

    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    public boolean isValidation() {
        return validation;
    }

    public Integer getRoleInSys() {
        return roleInSys;
    }

    public boolean isForget() {
        return forget;
    }


    public String getEnteredUsername() {
        return enteredUsername;
    }


    public void setUsernameAndPasswordFromSystem(String userName, String password) {
        validation = false;
        for (user u : users) {
            if (u.getUserName().equals(userName) && u.getPassword().equals(password)) {
                validation = true;
                roleInSys = 0;
                enteredUsername=userName;
                loggedInUser = userName;
                return;
            }
        }
        for (supplier s : suppliers) {
            if (s.getUserName().equals(userName) && s.getPassword().equals(password)) {
                validation = true;
                loggedInSupplier = userName;
                enteredUsername=userName;
                roleInSys = 1;
            }
        }
        for (Admin admin : admins) {
            if (admin.getAdminName().equals(userName) && admin.getPassword().equals(password)) {
                validation = true;
                enteredUsername=userName;
                roleInSys = 2;
            }
        }
    }


    public void setEmptyUsernameAndPasswordFromSystem(String username, String password) {
        if (username.isEmpty() && !password.isEmpty()) {
            validation = false;
        }
    }

    public void setUsernameAndEmptyPasswordFromSystem(String username, String password) {
        if (!username.isEmpty() && password.isEmpty()) {
            validation = false;
        }
    }

    public void validUsernameAndForgetPassword(String username, String forget) {
        this.forget = false;
        for (user u : users) {
            if (u.getUserName().equals(username) && forget.equals("Forget")) {
                this.forget = true;
                this.enteredUsername = username;
                loggedInUser = username;
                return;
            }
        }
    }

    public void updatePassword(String newPassword) {
        if (isForget()) {
            for (user u : users) {
                if (u.getUserName().equals(enteredUsername)) {
                    u.setPassword(newPassword);
                    roleInSys = 0;
                    break;
                }
            }
        }
    }

}
