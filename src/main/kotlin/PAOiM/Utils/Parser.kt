package PAOiM.Utils

import com.google.gson.Gson
import PAOiM.Models.Post

class Parser {
    fun parse(json: String): Array<Post>? {
        val gson = Gson();
        return gson.fromJson(json, Array<Post>::class.java)
    }
}