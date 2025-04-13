package org.example.dataTest.pages;
import org.example.dataTest.utils.WebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FindTransactionPage extends Pages {

    @FindBy( linkText = "Find Transactions")
    private WebElement FindTransactionsButton;

    @FindBy(id = "accountId")
    private WebElement Selectaccount;

    @FindBy(id = "transactionId")
    private WebElement transactionId;

    @FindBy(id = "findById")
    private WebElement findById;

    @FindBy(xpath ="//p[@class=\"error\"]")
    private WebElement idwrongmassage;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
    private WebElement AccountsOverviewFirstAcount;

    @FindBy(xpath = "//a[text()=\"Funds Transfer Sent\"]")
    private WebElement FindTransferSentFirst;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/table/tbody/tr[1]/td[2]")
    private WebElement TransactionID;

    @FindBy(xpath = "//*[@id=\"transactionTable\"]/tbody/tr/td[1]")
    private WebElement date;


    @FindBy(id = "transactionDate")
    private WebElement transactionDate ;

    @FindBy(id = "findByDate")
    private WebElement findByDateButton;

    @FindBy(id = "fromDate")
    private WebElement Between ;

    @FindBy(id = "toDate")
    private WebElement and ;

    @FindBy(id = "findByDateRange")
    private WebElement findByDateRangeDat;

    @FindBy(id = "amount")
    private WebElement amount;

    @FindBy(id = "findByAmount")
    private WebElement findByAmountButton;

    @FindBy(linkText = "Accounts Overview")
    private WebElement AccountsOverview;

    @FindBy(xpath = "//*[@id=\"resultContainer\"]/h1")
    private WebElement HaapySenario ;

    @FindBy(linkText = "Log Out")
    private WebElement logoutLink;


    public FindTransactionPage(WebDriver driver) {
        super(driver);
    }


    public void enterFindTransactionsButton() {

        WebActions.click(FindTransactionsButton);

    }

    public void Selectaccount(int i) {
        WebActions.select(Selectaccount,i);
    }


    public void entertransactionId(String id) {
        WebActions.sendKeysWithClear(transactionId,id);
    }

    public void enterfindById() {
        WebActions.click(findById);
    }

    public boolean idwrongmassage() {
        boolean isDisplayed = WebActions.waitForElement(driver, idwrongmassage, 10);
        Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
        return isDisplayed;
    }

    public String getdate() {
        boolean isDisplayed = WebActions.waitForElement(driver, date, 10);
        String getdatee = WebActions.gittext(date);
        return getdatee;
    }

    public void entertransactionDate(String date) {
        WebActions.sendKeysWithClear(transactionDate,date);
    }


    public void findByDateButton() {
        WebActions.click(findByDateButton);
    }




    public void enterBetween(String Betweenn) {
        WebActions.sendKeysWithClear(Between,Betweenn);
    }

    public void enterand(String andd) {
        WebActions.sendKeysWithClear(and,andd);
    }

    public void enterfindByDateRangeDat() {
        WebActions.click(findByDateRangeDat);
    }




    public void enteramount(String amountt) {
        WebActions.sendKeysWithClear(amount,amountt);
    }

    public void enterfindByAmountButton() {
        WebActions.click(findByAmountButton);
    }

    public void enterAccountsOverview() {
        WebActions.click(AccountsOverview);
    }

    public void enterAccountsOverviewFirstAcount() {
        boolean isDisplayed = WebActions.waitForElement(driver, AccountsOverviewFirstAcount, 10);
        WebActions.click(AccountsOverviewFirstAcount);
    }

    public void enterFindTransferSentFirst() {
        boolean isDisplayed = WebActions.waitForElement(driver, FindTransferSentFirst, 10);
        WebActions.scrollToElement(driver,FindTransferSentFirst);
        WebActions.click(FindTransferSentFirst);
    }

    public String getTransactionID() {
        String transactionIdText = WebActions.gittext(TransactionID);
        return transactionIdText;
    }

    public void verifyHappyScenario() {
        boolean isDisplayed = WebActions.waitForElement(driver, HaapySenario, 10);
        Assert.assertTrue(isDisplayed, "الرسالة 'Congratulations, your account is now open.' لم تظهر كما هو متوقع.");
    }


    public void logout() {
        WebActions.click(logoutLink);
    }
}




