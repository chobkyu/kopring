package com.example.demo.blog.controller

import com.example.demo.blog.dto.BlogDto
import com.example.demo.blog.entity.Wordcount
import com.example.demo.blog.service.BlogService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/blog")
@RestController
class BlogController (
    val blogService :BlogService
) {
    @GetMapping("")
    fun search(@RequestBody @Valid blogDto: BlogDto): String? {
        return blogService.searchKakao(blogDto)
    }

    @GetMapping("/rank")
    fun searchWordRank() : List<Wordcount> = blogService.searchWordRank()
}