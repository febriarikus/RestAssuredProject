Meta: @SepulsaKredit

Narrative:
As a user
I want to pay
So I can pay my transaction

Scenario: Sepulsa Kredit balance is enough to make the payment
Given I have been logged in, with account that have sepulsa kredit balance
When Add Product To Cart with <ID> and <phone>
And Select Sepulsa Kredit method
And click Bayar Sekarang button
Then user gets success message

Examples:
|ID|phone|
|4|081234000003|

Scenario: Sepulsa kredit balance is Rp 0
Given I have been logged in and on the payment page
When I add product to cart (id) and (phone_number)
When the Sepulsa Kredit balance is Rp 0
Then Sepulsa Kredit payment method doesn't exist and user can't pay using Sepulsa Kredit

Examples:
|id|phone_number|
|4|081234000003|

Scenario:Sepulsa Kredit balance is not enough to make the payment
Given I have been logged in and on the payment page
When I add product to cart (product_id) and (mobile_number)
When the Sepulsa Kredit balance is not enough to make the payment
Then User can't pay using Sepulsa Kredit

Examples:
|product_id|mobile_number|
|4|081234000003|