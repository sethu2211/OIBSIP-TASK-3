Algorithm for ATM System

Initialization (Code in User.java and ATMSystem.java):

Initialize user data with User ID, User PIN, and initial balance.
Store user data in a data structure (HashMap).
Prompt the user for their User ID and User PIN.
Authentication (Code in ATMSystem.java):

Check if the provided User ID exists in the user data (HashMap).
Verify if the provided User PIN matches the stored PIN for that user.
If authentication succeeds, proceed to the main menu; otherwise, display an error message and exit.
Main Menu Loop (Code in ATMSystem.java):

Display a menu of available options (e.g., check balance, deposit, withdraw, transfer, transaction history, quit).
Continuously prompt the user for their choice until they choose to quit.
Check Balance (Code in ATMSystem.java and User.java):

Retrieve and display the user's current balance.
Deposit (Code in User.java and ATMSystem.java):

Prompt the user to enter the deposit amount.
Update the user's balance by adding the deposit amount.
Record the deposit transaction in the user's transaction history.
Withdraw (Code in User.java and ATMSystem.java):

Prompt the user to enter the withdrawal amount.
Verify if the user has sufficient balance for the withdrawal.
If sufficient balance, update the user's balance by subtracting the withdrawal amount.
Record the withdrawal transaction in the user's transaction history.
If insufficient balance, display an error message.
Transfer (Code in User.java and ATMSystem.java):

Prompt the user to enter the recipient's User ID and the transfer amount.
Verify if the recipient's User ID exists in the user data.
If the recipient exists and the user has sufficient balance, perform the transfer:
Deduct the transfer amount from the user's balance.
Add the transfer amount to the recipient's balance.
Record the transfer transaction in both the user's and recipient's transaction history.
If the recipient doesn't exist or the user has insufficient balance, display an error message.
Transaction History (Code in User.java and ATMSystem.java):

Display the user's transaction history, including details of each transaction (e.g., type and amount).
Quit (Code in ATMSystem.java):

Terminate the program and display a farewell message.
