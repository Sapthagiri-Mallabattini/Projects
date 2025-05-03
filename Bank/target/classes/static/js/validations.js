function validateDepositForm() {
    const amount = document.querySelector('input[name="amount"]').value;
    if (amount <= 0) {
        alert("Amount must be greater than zero.");
        return false;
    }
    return true;
}

function validateCreateAccountForm() {
    const initialDeposit = document.querySelector('input[name="initialDeposit"]').value;
    if (initialDeposit < 0) {
        alert("Initial deposit cannot be negative.");
        return false;
    }
    return true;
}
function validateWithdrawForm() {
    const amount = document.querySelector('input[name="amount"]').value;
    if (amount <= 0) {
        alert("Amount must be greater than zero.");
        return false;
    }
    return true;
}
function validateTransferForm() {
    const amount = document.querySelector('input[name="amount"]').value;
    if (amount <= 0) {
        alert("Transfer amount must be greater than zero.");
        return false;
    }
    const fromAccount = document.querySelector('input[name="fromAccount"]').value;
    const toAccount = document.querySelector('input[name="toAccount"]').value;
    if (fromAccount === toAccount) {
        alert("From Account and To Account must be different.");
        return false;
    }
    return true;
}

