package com.formacionbdi.springboot.app.productos.springbootservicioproductos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.productos.springbootservicioproductos.models.Producto;
import com.formacionbdi.springboot.app.productos.springbootservicioproductos.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto findById(Long id){
        return productoRepository.findById(id).orElse(null);
    }
}
