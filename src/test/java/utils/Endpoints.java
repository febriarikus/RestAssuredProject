package utils;

public interface Endpoints {
    String get_token="https://altaqeproject.sepulsa.id/bumi/get_token";
    String login="https://altaqeproject.sepulsa.id/bumi/account/login";
    String get_product="https://altaqeproject.sepulsa.id/bumi/product";
    String add_to_cart="https://altaqeproject.sepulsa.id/bumi/bumi_cart/add";
    String get_payment_list="https://altaqeproject.sepulsa.id/bumi/checkout_payment_list";
    String post_process="https://altaqeproject.sepulsa.id/bumi/bumi_checkout/process";
    String post_complete="https://altaqeproject.sepulsa.id/bumi/bumi_checkout/complete";
}
