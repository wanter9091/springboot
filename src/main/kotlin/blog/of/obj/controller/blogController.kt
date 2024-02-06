package blog.of.obj.controller

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bolg")
class BlogMapping{
    @GetMapping()
    fun readOnePost():Int{
        val list: List<Int> = listOf(0,1,2)
        return list
    }

    @GetMapping()
    fun readAllPost(): List<Int>{
        val list: List<Int> = listOf(0,1,2)
        return list
    }

    @PostMapping()
    fun createPost(): Boolean{
        return true
    }

    @PutMapping()
    fun modifyPost(): Boolean{
        return true
    }

    @DeleteMapping()
    fun deletePost(): Boolean{
        return true
    }



}