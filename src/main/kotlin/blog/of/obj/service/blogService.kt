package blog.of.obj.service

import blog.of.obj.exception.BaseException
import blog.of.obj.exception.BaseResponseCode
import org.springframework.stereotype.Service

data class Post(val title: String, val body: String)

@Service
class blogService {
    val posts: MutableList<Post> = mutableListOf<Post>()

    fun readOnePost(id: Int): Post{
        if (id<0||posts.size -1< id){
            throw BaseException(BaseResponseCode.POST_NOT_FOUND)
        }
        return posts[id]
    }

    fun readAllPost(): List<Post>{
        return posts
    }

    fun createPost(title: String, body: String): Boolean{
        val post=Post(title, body)
        posts.add(post)
        return true
    }

    fun modifyPost(id: Int, title: String, body: String): Boolean{
        val post=Post(title, body)
        posts[id]=post
        return true
    }

    fun deletePost(id: Int):Boolean{
        posts.removeAt(id)
        return true
    }
}