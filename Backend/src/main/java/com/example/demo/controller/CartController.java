package com.example.demo.controller;

import com.example.demo.dto.CartDTO;
import com.example.demo.entity.Cart;
import com.example.demo.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Get the cart for a specific user
    @GetMapping
    public ResponseEntity<CartDTO> getCart(@RequestParam Long userId) {
        Cart cart = cartService.getCartByUser(userId);
        return ResponseEntity.ok(new CartDTO(cart));
    }

    // Add a product to the user's cart
    @PostMapping
    public ResponseEntity<?> addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        try {
            cartService.addToCart(userId, productId, quantity);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding to cart: " + e.getMessage());
        }
    }

    // Remove a product from the user's cart
    @DeleteMapping("/remove/{productId}")   
    public void removeFromCart(@RequestParam Long userId, @PathVariable Long productId) {
        cartService.removeFromCart(userId, productId);
    }

    // Update quantity of a product in the user's cart
    @PutMapping
    public void updateQuantity(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        cartService.updateQuantity(userId, productId, quantity);
    }

}
