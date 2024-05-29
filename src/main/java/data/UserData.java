package data;

import dataFactory.UserFactory;

public class UserData {

    public static UserFactory createJhonUser() {
        return new UserFactory("Jhon@teste.com", "Jhon Magalhães", "senha", "senha");
    }

    public static UserFactory createJoaoUser() {
        return new UserFactory("Joao@teste.com", "Joao Teste", "senha", "senha");
    }
}