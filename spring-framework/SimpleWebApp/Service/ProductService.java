package com.telusko.SimpleWebApp.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.telusko.SimpleWebApp.Model.Product;


@Service
public class ProductService {
     
        List<Product> product=new ArrayList<>(Arrays.asList(
            new Product(101,"Iphone",5000),
            new Product(102, "canon camera", 40000),
            new Product(103,"shure Mic",10000))
        );

        public List<Product> getProducts(){
            return product;
        }

        public Product getProductById(int prodId){
            return (Product)  product.stream()
            .filter(p-> p.getProdId()==prodId)
            .findFirst().get();

        }


        public void addProduct(Product prod){
            product.add(prod);
        }

        public void updateProduct(Product prod){
            int index=0;
            for(int i=0; i<product.size(); i++){
               if(product.get(i).getProdId()==prod.getProdId())
                index=i;
                product.set(index,prod);
            }
        }

    public void deleteProduct(int prodId) {
        int index=0;
        for(int i=0; i<product.size(); i++){
            if(product.get(i).getProdId()==prodId)
                index =i;
        product.remove(i);
        }

    }
     
     }



     

