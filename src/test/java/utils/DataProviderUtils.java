package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "loginData")
    public Object[][] getDataLogin(){
        return new Object[][] {
            {"John Doe", "ThisIsNotAPassword"},
            {"wrong", "wrong"},
            {"","" },
            {"John Doe", ""},
            {"John Doe","wrong"},
            {"" , "ThisIsNotAPassword"},
            {"wrong" , "ThisIsNotAPassword"}
        };
    }

    @DataProvider(name = "appointmentData")
    public Object[][] getDataAppointment(){
        return new Object[][] {
                {"Tokyo CURA Healthcare Center", true, "None","06/11/2026", "The Data is Added via selenium automation"},
                {"Hongkong CURA Healthcare Center", true, "None", "06/11/2026", "The Data is Added via selenium automation"},
                {"Seoul CURA Healthcare Center", false, "None", "06/11/2026", "The Data is Added via selenium automation"},
                {"Tokyo CURA Healthcare Center", true, "Medicare","06/11/2026", "The Data is Added via selenium automation"},
                {"Hongkong CURA Healthcare Center", true, "Medicaid", "06/11/2026", "The Data is Added via selenium automation"}
        };
    }

}
