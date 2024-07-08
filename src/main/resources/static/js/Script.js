document.addEventListener('DOMContentLoaded', function() {
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
    updateFinalTotal();
});