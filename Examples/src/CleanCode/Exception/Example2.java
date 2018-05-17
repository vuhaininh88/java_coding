package CleanCode.Exception;

// Replace Error Code with Exception
// Returning error codes is an obsolete holdover from procedural programming.
// In modern programming, error handling is performed by special classes, which are named exceptions.
// If a problem occurs, you "throw" an error, which is then "caught" by one of the exception handlers.
// Special error-handling code, which is ignored in normal conditions, is activated to respond.
public class Example2 {
    int balance;

    int withdraw_bad(int amount) {
        if (amount > balance) {
            return -1;
        }
        else {
            balance -= amount;
            return 0;
        }
    }

    void withdraw_good(int amount) throws BalanceException {
        if (amount > balance) {
            throw new BalanceException();
        }
        balance -= amount;
    }

    private class BalanceException extends Exception {
    }
}

