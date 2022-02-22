package carsharing;

import carsharing.Company.CreateTableCompany;

public class Main {
    public static void main(String[] args) {
        CreateTableCompany.createTable();
        carsharing.EnterInput.input();
    }
}
