package com.cognicart.orderservice.service;

import com.cognicart.orderservice.dto.*;
import com.cognicart.orderservice.model.Order;
import com.cognicart.orderservice.model.OrderLineItems;
import com.cognicart.orderservice.repository.OrderRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
// import org.springframework.web.reactive.function.client.WebClient;

// import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    //private final WebClient webClient;

    // public void placeOrder(OrderRequest orderRequest){
    //     Order order = new Order();
    //     order.setOrderNumber(UUID.randomUUID().toString());

    //     List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
    //             .stream()
    //             .map(this::mapToDto)
    //             .toList();

    //     order.setOrderLineItemsList(orderLineItems);

    //     List<String> skuCodes = order.getOrderLineItemsList().stream()
    //             .map(OrderLineItems::getSkuCode)
    //             .toList();

        // Call Inventory Service to check if the products are in stock
    //     InventoryResponse[] inventoryResponseArray = webClient.get()
    //             .uri("http://localhost:8082/api/inventory",
    //                 uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
    //             .retrieve()
    //             .bodyToMono(InventoryResponse[].class)
    //             .block();

    //     boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
               
    //     if(allProductsInStock){
    //         orderRepository.save(order);
    //     }else{
    //         throw new IllegalArgumentException("Product is not in stock, please try again later");
    //     }

    // }


    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
