package appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddExpense {
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/add_new_expense")
	MobileElement addExpenseButton;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_title_edit")
	MobileElement title;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_sum_edit")
	MobileElement sum;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_date_edit")
	MobileElement date;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/new_expense_category_picker")
	MobileElement category;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/save_new_expense")
	MobileElement saveButton;
	@FindBy(id = "platkovsky.alexey.epamtestapp:id/expense_title")
	List<MobileElement> listExpense;

	public AddExpense(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10L)), this);
	}

	public void addNewExpense(String _title, String _sum, String _date, String _category) {
		addExpenseButton.click();
		title.sendKeys(_title);
		sum.sendKeys(_sum);
		date.sendKeys(_date);
		category.sendKeys(_category);
		saveButton.click();
	}

	public boolean checkInfo(String _title) {
		for (MobileElement element : listExpense) {
			if (element.getText().equals(_title)) {
				return true;
			}
		}
		return false;
	}

}
