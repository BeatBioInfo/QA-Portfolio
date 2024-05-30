package PageTest;

import org.project.pages.AppointmentConfirmationPage;
import org.project.pages.AppointmentPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AppointmentFormTest extends LoginTest
{
    @Test(priority = 2)
    public void testAppointmentForm()
    {
        AppointmentPage appointmentPage = new AppointmentPage(driver);
        String option = "Hongkong CURA Healthcare Center";
        appointmentPage.selectFromDropdown("Hongkong CURA Healthcare Center");
        var selectedDropdownOption = appointmentPage.getSelectedOptions();
        assertEquals(selectedDropdownOption.size(), 1, "Incorrect selection");
        assertTrue(selectedDropdownOption
                .contains(option), "Option not selected");
        appointmentPage.clickCheckBox();
        appointmentPage.selectRadioButtonTypes();
        appointmentPage.clickDatePicker();
        appointmentPage.setComment("Seeing A Doctor Is Very Important");
        AppointmentConfirmationPage appointmentConfirmationPage = appointmentPage.clickBookAppointment();
        appointmentConfirmationPage.getAppointmentConfirmationHeader();
        assertEquals(appointmentConfirmationPage.getAppointmentConfirmationHeader(),"Appointment Confirmation", "Header not correct");
        appointmentConfirmationPage.getConfirmationTextHeader();
        assertTrue(appointmentConfirmationPage.getConfirmationTextHeader().
                contains("Please be informed that your appointment has been booked as following:"),
                "List of the content not accurate");
        appointmentConfirmationPage.returnToHomePage();


    }
}
