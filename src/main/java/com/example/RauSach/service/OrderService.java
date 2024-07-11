package com.example.RauSach.service;

import com.example.RauSach.model.CartItem;
import com.example.RauSach.model.Order;
import com.example.RauSach.model.OrderDetail;
import com.example.RauSach.repository.OrderDetailRepository;
import com.example.RauSach.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartService cartService;  // Assuming you have a CartService

    public Order createOrder(String customerName, String customerEmail, String customerPhone, String customerAddress,String oroderStatus,Double total , List<CartItem> cartItems) {
        if (cartItems == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("Cart items cannot be empty");
        }

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setCustomerEmail(customerEmail);
        order.setCustomerPhone(customerPhone);
        order.setCustomerAddress(customerAddress);
        order.setOderStatus(oroderStatus);
        order.setTotal(total);
        try {
            order = orderRepository.save(order);
            for (CartItem item : cartItems) {
                OrderDetail detail = new OrderDetail();
                detail.setOrder(order);
                detail.setProduct(item.getProduct());
                detail.setQuantity(item.getQuantity());
                orderDetailRepository.save(detail);
            }

            // Clear the cart after order placement
            cartService.clearCart();

            logger.info("Order created successfully for customer: {}", customerName);

        } catch (Exception e) {
            logger.error("Error occurred while creating order for customer: {}", customerName, e);
            throw e;
        }

        return order;
    }
}
