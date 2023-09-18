package com.formacionbdi.springboot.app.productos.springbootservicioproductos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacionbdi.springboot.app.productos.springbootservicioproductos.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
