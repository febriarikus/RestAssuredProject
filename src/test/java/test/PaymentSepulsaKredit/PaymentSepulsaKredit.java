package test.PaymentSepulsaKredit;

import net.serenitybdd.jbehave.SerenityStory;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class PaymentSepulsaKredit extends SerenityStory {
    @Steps
    PaymentSepulsaKreditSteps paymentSepulsaKreditSteps;

    @Given("I have been logged in, with account that have sepulsa kredit balance")
    public void givenThatIHaveBeenLoggedIn() {
        paymentSepulsaKreditSteps.loginSuccess();
        paymentSepulsaKreditSteps.validationJSONSchemaLoginSuccess();
    }
    @When("Add Product To Cart with <$product_id> and <$phone_number>")
    public void whenAddToCart(String ID, String phone){
        paymentSepulsaKreditSteps.addToCartSuccess(ID,phone);
        paymentSepulsaKreditSteps.validationJSONSchemaAddToCartSuccess();
    }
    @When("Select Sepulsa Kredit method")
    public void whenSelectSepulsaKreditMethod() {
        paymentSepulsaKreditSteps.processSuccess();
        paymentSepulsaKreditSteps.validationJSONSchemaProcessSuccess();
    }
    @When("click Bayar Sekarang button")
    public void whenBayarSekarang() {
        paymentSepulsaKreditSteps.completeSuccess();
    }
    @Then("user gets success message")
    public void thenGetMessage(){
        paymentSepulsaKreditSteps.validationJSONSchemaCompleteSuccess();
    }

    @Given("I have been logged in and on the payment page")
    public void IHaveBeenLogged(){
        paymentSepulsaKreditSteps.HaveBeenLogged();
    }
    @When("I add product to cart ($ID) and ($phone)")
    public void addProduct(String id, String phone_number){
        paymentSepulsaKreditSteps.isAddProduct(id,phone_number);
    }
    @When("the Sepulsa Kredit balance is Rp 0")
    public void EmptyBalance(){
        paymentSepulsaKreditSteps.HaveBeenLoggedIn();
        paymentSepulsaKreditSteps.getPaymentList();
    }
    @Then("Sepulsa Kredit payment method doesn't exist and user can't pay using Sepulsa Kredit")
    public void canNotPaySk(){
    }

    @When("the Sepulsa Kredit balance is not enough to make the payment")
    public void NotEnough(){
    }
    @Then("User can't pay using Sepulsa Kredit")
    public void canNotPaySepulsaKredit(){
    }
}
