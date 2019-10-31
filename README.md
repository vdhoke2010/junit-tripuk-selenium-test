
Test case for UK trip


TestCase_UkTrip_01 :- Login to www.Trip.com

a. Enter url "www.Trip.uk
b. Click on the account button in the header , verify that  two option "Sign-in" and "Register" is displayed.
c. Click on "Sign-in" button.verify that two text fields for enterering username and password are displayed.
e. Enter username and password and click on sign-in , verify that  user is successfully logged in our not.

TestCase_UkTrip_02:- Register to WWW.trip.com
a. Enter url "www.Trip.uk
b. Click on the account button in the header , verify that  two option "Sign-in" and "Register" is displayed.
c. Click on "Register" button.verify that two text fields for enterering username and password are displayed along with Agree and register button
d. Verify the Label / text = Verification code has been sent to<email address - entcrupted > is displayed  on entering the username and password.


TestCase_UkTrip_03:- Verify that on selecting "one way" option the return date textbox /field is not displayed.
a. Enter url "www.Trip.uk
b. Click on the Flight menue from the header, Click on the "One-Way" verify that  "Return" date field is not displayed.


TestCase_UkTrip_04:- Verify that on selecting "Return" option the return date textbox /field is displayed.
a. Enter url "www.Trip.uk
b. Click on the Flight menue from the header, Click on the "Return" option  verify that  "Return" date field is  displayed.

TestCase_UkTrip_05:- Verify that  Search results are displayed based on City and Date entered.
a. Enter url "www.Trip.uk.
b. Click on the Flight menue from the header, Click on the "One-Way".
c. Enter City in the Form field "London" and To field "Paris".
d. Select the To date.
e. Enter 2 Adults,  Childeren 1 and click on Search button.
f. Verify that Text "Select departure flight to Paris|12 September 2019" is displayed.


TestCase_UkTrip_06:- Verify that  Search results are displayed based on City and Date entered for "Multi-City"
a. Enter url "www.Trip.uk.
b. Click on the Flight menue from the header, Click on the "Multi-Cit

d. Select the To and From date.
e. Enter 2 Adults,  Childeren 1 and click on Search button.
f. Verify that Text "Select departure flight to Paris|12 September 2019" is displayed.