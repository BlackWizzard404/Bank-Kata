package org.account;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.account.service.Impl.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class AccountStepDefinitions {
    Account account = new Account();

    @Given("a client makes a deposit of {int} on {string}")
    public void a_client_makes_a_deposit_of_on(int amount, String date) throws ParseException {
        if (account == null) {
            account = new Account();
        }
        account.deposit(amount, parseDate(date));
    }

    @Given("a deposit of {int} on {string}")
    public void a_deposit_of_on(int amount, String date) throws ParseException {
        account.deposit(amount, parseDate(date));
    }

    @Given("a withdrawal of {int} on {string}")
    public void a_withdrawal_of_on(int amount, String date) throws ParseException {
        account.withdraw(amount, parseDate(date));
    }

    @When("they print their bank statement")
    public void they_print_their_bank_statement() {
        account.printStatement();
    }

    @Then("they would see")
    public void they_would_see(String expectedStatement) {
        String actualStatement = account.getPrintStatement();

        assertEquals(actualStatement, expectedStatement);
    }

    private Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).parse(date);
    }
}
