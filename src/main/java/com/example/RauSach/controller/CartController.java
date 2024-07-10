/*
package com.example.RauSach.controller;


import com.example.RauSach.model.CartItem;
import com.example.RauSach.model.CartProduct;
import com.example.RauSach.model.Order;
import com.example.RauSach.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.RauSach.service.OrderService;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "/cart/cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam String productId, @RequestParam int quantity) {
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }
    @GetMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable String productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }
    @GetMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }

    @GetMapping("/payment/{id}")
    public String home(Model model,@PathVariable Long id){
        Order orderCustom = OrderService.getbyid(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
        List<CartItem> cartItems = cartService.getCartItems();
        List<CartItem> cartProducts = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartProduct", cartProducts);
        model.addAttribute("orders",orderCustom);
// Calculate the total price

        long totalPriceProduct = cartProducts.stream()
                .filter(cartItem -> cartItem.getProduct() != null)
                .mapToLong(cartItem -> cartItem.getProduct().getPrice().longValue() * cartItem.getQuantity())
                .sum();
        model.addAttribute("totalPriceProduct", totalPriceProduct);
        // Calculate the total price for pets
        long totalPricePet = cartItems.stream()
                .filter(cartItem -> cartItem.getProduct() != null)
                .mapToLong(cartItem -> cartItem.getProduct().getPrice().longValue() * cartItem.getQuantity())
                .sum();
        model.addAttribute("totalPricePet", totalPricePet);
        long total = totalPriceProduct + totalPricePet;
        model.addAttribute("total", total);
        return "Payment/createOrder";
    }

    //payment
    // Chuyển hướng người dùng đến cổng thanh toán VNPAY
    @PostMapping("/payment/{id}")
    public String submidOrder(
            HttpServletRequest request, @PathVariable Long id, @Valid @ModelAttribute("orders") Order_Custom orderCustom){
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(request,orderCustom.getTotalAmount(),orderCustom.getId().toString(), baseUrl);
        return "redirect:" + vnpayUrl;
    }
}
*/
