document.addEventListener('DOMContentLoaded', function () {
    const signUpButton = document.querySelector('.signup a');
    const loginButton = document.querySelector('.signin a');
    const registerContainer = document.querySelector('.form-container.register');
    const loginContainer = document.querySelector('.form-container.login');

    signUpButton.addEventListener('click', function (event) {
        event.preventDefault();
        registerContainer.style.display = 'block';
        loginContainer.style.display = 'none';
    });

    loginButton.addEventListener('click', function (event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
    });
});

function loadCategories() {
    $.ajax({
        url: '/api/categories',
        type: 'GET',
        success: function (categories) {
            let categoryOptions = '';
            $.each(categories, function (index, category) {
                categoryOptions += `<button class="dropdown-item" onclick="loadProductsByCategory('${category.id}', 0)">
                    ${category.name}</button>`;
            });
            $('#categoryId').html(categoryOptions);
        }
    });
}
function loadProducts(page) {
    $.ajax({
        url: `/api/products?page=${page}`,
        type: 'GET',
        success: function (response) {
            var productContainer = $('#products');
            productContainer.empty();
            response.products.forEach(function (product) {
                var productHtml = `
                    <div class="col-md-6" id="product">
                        <img src="/images/${product.imageURL}">
                        <h6 id="ProductName">${product.name}</h6>
                        <p>${new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(product.price)}</p>
                        <div class="buttons">
                            <button class="btn view-product-btn" onclick="editProduct('${product.id}')">
                        Mua
                    </button>
                        </div>
                    </div>
                `;
                productContainer.append(productHtml);
            });
            loadPagination(response.totalPages, page);
        },
        error: function (err) {
            console.error('Error loading products:', err);
        }
    });
}
function loadProductsByCategory(categoryId, page) {
    $.ajax({
        url: `/api/products/category/${categoryId}?page=${page}`,
        type: 'GET',
        success: function (response) {
            var productContainer = $('#products');
            productContainer.empty();
            response.content.forEach(function (product) {
                var productHtml = `
                    <div class="col-md-6" id="product">
                        <img src="/images/${product.imageURL}">
                        <h6 id="ProductName">${product.name}</h6>
                        <p>${new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(product.price)}</p>
                        <div class="buttons">
                            <button class="btn view-product-btn" onclick="editProduct('${product.id}')">
                        Mua
                    </button>
                        </div>
                    </div>
                `;
                productContainer.append(productHtml);
            });

            loadPagination(response.totalPages, page);
        },
        error: function (err) {
            console.error('Error loading products:', err);
        }
    });
}
function loadPagination(totalPages, currentPage) {
    var paginationContainer = $('#pagination');
    paginationContainer.empty();
    if (totalPages > 1) {
        var paginationHtml = `<ul class="pagination">`;
        if (currentPage > 0) {
            paginationHtml += `
                <li class="page-item">
                    <a class="page-link" href="#" data-page="${currentPage - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>`;
        }
        for (var i = 0; i < totalPages; i++) {
            paginationHtml += `
                <li class="page-item ${i === currentPage ? 'active' : ''}">
                    <a class="page-link" href="#" data-page="${i}">${i + 1}</a>
                </li>`;
        }
        if (currentPage < totalPages - 1) {
            paginationHtml += `
                <li class="page-item">
                    <a class="page-link" href="#" data-page="${currentPage + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>`;
        }
        paginationHtml += `</ul>`;
        paginationContainer.append(paginationHtml);
    }
}
function getProdcutsByCategory(id) {
    $.ajax({
        url: `/api/products/category/${id}`,
        type: 'GET',
        success: function (products) {
            var productContainer = $('#products');
            productContainer.empty();
            products.forEach(function (product) {
                var productHtml = `
                            <div class="col-md-6" id="product">
                                <img src="/images/${product.imageURL}">
                                <h6 id="ProductName">${product.name}</h6>
                                <p>${new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(product.price)}</p>
                                <div class="buttons">
                                    <button class="btn view-product-btn" onclick="editProduct('${product.id}')">
                        Mua
                    </button>
                                </div>
                            </div>
                        `;
                productContainer.append(productHtml);
            });
        },
        error: function (err) {
            console.error('Error loading products:', err);
        }
    });
}
document.addEventListener('DOMContentLoaded', function () {
    const signUpButton = document.querySelector('.signup a');
    const loginButton = document.querySelector('.signin a');
    const forgotPasswordButton = document.querySelector('.forgot a');
    const registerContainer = document.querySelector('.form-container.register');
    const loginContainer = document.querySelector('.form-container.login');
    const forgotPasswordContainer = document.querySelector('.form-container.forgot-password');

    signUpButton.addEventListener('click', function (event) {
        event.preventDefault();
        registerContainer.style.display = 'block';
        loginContainer.style.display = 'none';
        forgotPasswordContainer.style.display = 'none';
    });

    loginButton.addEventListener('click', function (event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        registerContainer.style.display = 'none';
        forgotPasswordContainer.style.display = 'none';
    });

    forgotPasswordButton.addEventListener('click', function (event) {
        event.preventDefault();
        forgotPasswordContainer.style.display = 'block';
        loginContainer.style.display = 'none';
        registerContainer.style.display = 'none';
    });

    // Handle "Remember your password?" link in the Forgot Password form
    const loginLinkInForgot = document.querySelector('.forgot-password .login-link');
    loginLinkInForgot.addEventListener('click', function (event) {
        event.preventDefault();
        loginContainer.style.display = 'block';
        forgotPasswordContainer.style.display = 'none';
        registerContainer.style.display = 'none';
    });
    /*--------------------------------------------*/

});

document.addEventListener('DOMContentLoaded', function () {
    const cartItemsBody = document.getElementById('cartItemsBody');
    const totalPriceElement = document.getElementById('totalPrice');
    document.addEventListener('DOMContentLoaded', function () {
        const cartItemsBody = document.getElementById('cartItemsBody');
        const subtotalElement = document.getElementById('subtotal');
        const shippingFeeElement = document.getElementById('shippingFee');
        const finalTotalElement = document.getElementById('finalTotal');

        function calculateTotalPrice() {
            let totalPrice = 0;
            const rows = cartItemsBody.getElementsByTagName('tr');
            for (let row of rows) {
                const priceCell = row.cells[3];
                const quantityCell = row.cells[2];
                const price = parseFloat(priceCell.textContent.replace(/[^\d.-]/g, ''));
                const quantity = parseInt(quantityCell.textContent);
                totalPrice += price * quantity;
            }
            subtotalElement.textContent = totalPrice.toLocaleString() + '₫';
            return totalPrice;
        }

        function updateFinalTotal() {
            const subtotal = parseFloat(subtotalElement.textContent.replace(/[^\d.-]/g, ''));
            const shippingFee = parseFloat(shippingFeeElement.textContent.replace(/[^\d.-]/g, ''));
            const finalTotal = subtotal + shippingFee;
            finalTotalElement.textContent = finalTotal.toLocaleString() + '₫';
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
    updateFinalTotal();
});
