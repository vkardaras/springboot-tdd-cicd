package com.example.catsservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatRepository extends JpaRepository<Cat, Integer> {

    Cat findByName(String name);
}
