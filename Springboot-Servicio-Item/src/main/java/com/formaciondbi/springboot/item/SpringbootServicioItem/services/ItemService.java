package com.formaciondbi.springboot.item.SpringbootServicioItem.services;

import com.formaciondbi.springboot.item.SpringbootServicioItem.models.Item;
import com.formaciondbi.springboot.item.SpringbootServicioItem.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemService {
    @Autowired
    private RestTemplate clienteRest;
    public List<Item> findAll(){
        String url = "http://localhost:8001/listar";
        // Necesitamos pasarle un Array, nos devuelve el array pero luego hay uqe pasarlo a una lista
        List<Producto> productos = Arrays.asList(clienteRest.getForObject(url, Producto[].class));
        // Tenemos que convertir la lista productos a una lista de items, vamos a hacerlo con prog funcional
        // Usamos
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    public Item getItemById(Long id, int cantidad){
        Map<String, String> pathVariable = new HashMap<String, String>();
        pathVariable.put("id", String.valueOf(id));
        String url = "http://localhost:8001/ver/{id}";
        Producto producto = clienteRest.getForObject(url, Producto.class, pathVariable);
        return new Item(producto, cantidad);
    }
}
