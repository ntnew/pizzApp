package ru.tim.pizzApp.additional;

import ru.tim.pizzApp.entity.Bucket;
import ru.tim.pizzApp.entity.Order;

import java.util.List;

public class OrderMethods {
    public static Double getFullPrice(List<Bucket> bucketList){
        Double fullPrice = 0.0;
        Bucket bucket;
        for(int i=0; i<bucketList.size(); i++){
            bucket = bucketList.get(i);
            fullPrice=fullPrice+bucket.getPrice();
        }
        return fullPrice;
    }

    public static String getOrderString(List<Bucket> bucketList){
        String finalOrder = "";
        Bucket bucket;
        for(int i=0; i<bucketList.size(); i++){
            bucket = bucketList.get(i);
            finalOrder=finalOrder + "(" +bucket.getOrder() + ". Добавки: " + bucket.getAdditives() + ".)\n";
        }
        return finalOrder;
    }

    public static List<Order> parseOrderLine(List<Order> orders){
        for(int i=0; i<orders.size(); i++){
            orders.get(i).setOrder(orders.get(i).getOrder().replace("(", "●"));
            orders.get(i).setOrder(orders.get(i).getOrder().replace(")", "\n"));
            orders.get(i).setOrder(orders.get(i).getOrder().replace("null", ""));
            orders.get(i).setOrder(orders.get(i).getOrder().replace(",", ", "));
            orders.get(i).setOrder("\n" + orders.get(i).getOrder());
        }
        return orders;
    }
    public static Order parseBackOrderLine(Order order){
        order.setOrder(order.getOrder().replace("●","("));
        order.setOrder(order.getOrder().replace("\n",")"));
        order.setOrder(order.getOrder().replace("\r",""));
        return order;
    }
}
