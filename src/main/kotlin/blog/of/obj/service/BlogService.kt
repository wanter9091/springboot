package blog.of.obj.service

import blog.of.obj.entity.Post
import blog.of.obj.exception.BaseException
import blog.of.obj.exception.BaseResponseCode
import blog.of.obj.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class BlogService (val postRepository: PostRepository){
    fun readOnePost(id: String): Post {
        return postRepository.findById(id).orElse(null) ?: throw BaseException(BaseResponseCode.POST_NOT_FOUND)
    }

    fun readAllPost(): List<Post>{
        return postRepository.findAll()
    }

    fun createPost(title: String, body: String): Boolean{
        val post=Post(title, body)
        postRepository.save(post)
        return true
    }

    fun modifyPost(id: String, title: String, body: String): Boolean{
        val post=postRepository.findById(id).orElse(null) ?: throw BaseException(BaseResponseCode.POST_NOT_FOUND)
        post.title=title
        post.body=body
        return true
    }

    fun deletePost(id: String):Boolean{
        postRepository.deleteById(id)
        return true
    }
}