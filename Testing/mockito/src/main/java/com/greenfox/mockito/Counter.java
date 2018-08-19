package com.greenfox.mockito;

public class Counter {

    DatabaseConnection dbCon;

    public Counter() {
    }
/*Itt csak létrehoztuk az objektumot, nem beinjektáltuk*/
    public Counter(DatabaseConnection dbCon) {
        this.dbCon = dbCon;
    }

    public Integer sumNumbers(String username, String password, int number1, int number2) {
        boolean checkUser = dbCon.checkUserPass(username, password);

        if (checkUser)
            return number1 + number2;

        return null;
    }
}
