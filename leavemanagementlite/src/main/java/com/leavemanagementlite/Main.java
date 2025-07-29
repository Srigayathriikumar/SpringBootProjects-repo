package com.leavemanagementlite;

import com.leavemanagementlite.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.start();
    }
}
