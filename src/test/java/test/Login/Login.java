package test.Login;

import net.serenitybdd.jbehave.SerenityStory;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class Login extends SerenityStory {

    @Steps
    LoginStep loginStep;

    @Given("I open sepulsa.com home page")
    public void givenThatIAmOnTheSigninPage() {
    }

    @When("I click sign in button")
    public void whenClickSignIn() {
    }

    @When("I input valid email and I input valid password")
    public void whenIInputValidEmailAndPasswordCorrectly() {
        loginStep.loginSuccess();
    }

    @When("I click 'Masuk' button")
    public void whenClickMasuk() {
    }

    @Then("I can see a member area")
    public void thenICanSeeMemberArea() {
        loginStep.validationJSONSchemaLoginSuccess();
    }

//    @When("I enter my email only")
//    public void whenIEnterMyUserNameAndPasswordIncorrectly() {
//        loginStep.loginFailed();
//    }
//
//    @Then("I see an error message 'missing password'")
//    public void thenISeeAnErrorMessageSorryIncorrectUserNameOrPassword() {
//        loginStep.validationMessage();
//        loginStep.validationJSONSchemaLoginFailed();
//    }
}
