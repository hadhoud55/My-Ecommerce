package com.example.demo.dto;

import com.example.demo.entity.Cart;
import com.example.demo.entity.CartItem;
import java.util.List;
import java.util.stream.Collectors;


public class CartDTO {
    private Long id;
    private Long userId;
    private List<CartItemDTO> items;

    public CartDTO(Cart cart) {
        this.id = cart.getId();
        this.userId = cart.getUser().getId();
        this.items = cart.getItems().stream()
                .map(CartItemDTO::new)  // Convert CartItem to DTO
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public static class CartItemDTO {
        private Long productId;
        private String productName;
        private String imageUrl; // ✅ Added imageUrl
        private Integer quantity;
        private Double price;

        public CartItemDTO(CartItem item) {
            this.productId = item.getProduct().getId();
            this.productName = item.getProduct().getName();
            this.imageUrl = item.getProduct().getImageUrl(); // ✅ Now includes image
            this.quantity = item.getQuantity();
            this.price = item.getProduct().getPrice();
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
