package blog.of.obj.controller

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bolg")
class BlogMapping{
    @GetMapping("/{idx}")
    fun readOnePost(@PathVariable("idx") idx:Int ):Int{
        val list: List<Int> = listOf(0,1,2)
        return list[0]
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

    @PutMapping("/{idx}")
    fun modifyPost(@PathVariable("idx") idx:Int ): Boolean{
        return true
    }

    @DeleteMapping("/{idx}")
    fun deletePost(@PathVariable("idx") idx:Int ): Boolean{
        return true
    }



}