document.addEventListener('DOMContentLoaded', function() {
    const signUpButton = document.querySelector('.signup a');
    const loginButton = document.querySelector('.signin a');
    const registerContainer = document.querySelector('.form-container.register');
    const loginContainer = document.querySelector('.form-container.login');

    signUpButton.addEventListener('click', function(event) {
        event.preventDefault();
        registerContainer.style.display = 'block';
        loginContainer.style.display = 'none';
    });

    loginButton.addEventListener('click', function(event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    const signUpButton = document.querySelector('.signup a');
    const loginButton = document.querySelector('.signin a');
    const forgotPasswordButton = document.querySelector('.forgot a');
    const registerContainer = document.querySelector('.form-container.register');
    const loginContainer = document.querySelector('.form-container.login');
    const forgotPasswordContainer = document.querySelector('.form-container.forgot-password');

    signUpButton.addEventListener('click', function(event) {
        event.preventDefault();
        registerContainer.style.display = 'block';
        loginContainer.style.display = 'none';
        forgotPasswordContainer.style.display = 'none';
    });

    loginButton.addEventListener('click', function(event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
        forgotPasswordContainer.style.display = 'none';
    });

    forgotPasswordButton.addEventListener('click', function(event) {
        event.preventDefault();
        forgotPasswordContainer.style.display = 'block';
        loginContainer.style.display = 'none';
        registerContainer.style.display = 'none';
    });

    // Handle "Remember your password?" link in the Forgot Password form
    const loginLinkInForgot = document.querySelector('.forgot-password .login-link');
    loginLinkInForgot.addEventListener('click', function(event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        forgotPasswordContainer.style.display = 'none';
        registerContainer.style.display = 'none';
    });
});

document.addEventListener('DOMContentLoaded', function() {
    const cartItemsBody = document.getElementById('cartItemsBody');
    const totalPriceElement = document.getElementById('totalPrice');
    
    function calculateTotalPrice() {
        let totalPrice = 0;
        const rows = cartItemsBody.getElementsByTagName('tr');
        for (let row of rows) {
            const priceCell = row.cells[3]; // Assuming price is the 4th column
            const quantityCell = row.cells[2]; // Assuming quantity is the 3rd column
            const price = parseFloat(priceCell.textContent.replace(/[^\d.-]/g, ''));
            const quantity = parseInt(quantityCell.textContent);
            totalPrice += price * quantity;
        }
        totalPriceElement.textContent = totalPrice.toLocaleString() + '₫';
    }

    calculateTotalPrice();
});

function calculateFinalTotal() {
    const subtotalText = document.getElementById('subtotal').innerText;
    const shippingFeeText = document.getElementById('shippingFee').innerText;

    const subtotal = parseFloat(subtotalText.replace('₫', '').replace(',', ''));
    const shippingFee = parseFloat(shippingFeeText.replace('₫', '').replace(',', ''));

    const finalTotal = subtotal + shippingFee;

    document.getElementById('finalTotal').innerText = finalTotal.toLocaleString() + '₫';
}

// Gọi hàm khi trang được tải
window.onload = calculateFinalTotal;

function applyDiscount() {
    const discountCode = document.getElementById('discountCode').value;

    fetch('/api/discount/apply', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ code: discountCode })
    })
    .then(response => response.json())
    .then(data => {
        if (typeof data === 'number') {
            // Áp dụng giảm giá
            console.log('Discount applied: ' + data + '%');
        } else {
            // Thông báo lỗi
            console.log('Error: ' + data);
        }
    })
    .catch(error => console.error('Error:', error));
}