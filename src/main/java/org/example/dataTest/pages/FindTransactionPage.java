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

    @FindBy(id = "findByDate")
    private WebElement findByAmountButton;


    @FindBy(linkText = "Transaction Results")
    private WebElement HaapySenario ;

    @FindBy(linkText = "Accounts Overview")
    private WebElement AccountsOverview;

    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")
    private WebElement AccountsOverviewFirstAcount;

    @FindBy(xpath = "//*[@id=\"transactionTable\"]/tbody/tr[1]/td[2]/a")
    private WebElement FindTransferSentFirst;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/table/tbody/tr[1]/td[2]")
    private WebElement TransactionID;

    @FindBy(xpath = "    //*[@id=\"transactionTable\"]/tbody/tr/td[1]")
    private WebElement date;



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

    public String getdate() {
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
        WebActions.click(AccountsOverviewFirstAcount);
    }

    public void enterFindTransferSentFirst() {
        WebActions.click(FindTransferSentFirst);
    }

    public String getTransactionID() {
        String transactionIdText = WebActions.gittext(TransactionID);
        return transactionIdText;
    }


    public void setTransferFudsSucess() {
        Assert.assertTrue(HaapySenario.isDisplayed(), "Transfer Complete!");

    }
    public void logout() {
        WebActions.click(logoutLink);
    }





}




