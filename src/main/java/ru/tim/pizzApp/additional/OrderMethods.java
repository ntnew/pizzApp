package ru.tim.pizzApp.additional;

import ru.tim.pizzApp.entity.Bucket;

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
}
