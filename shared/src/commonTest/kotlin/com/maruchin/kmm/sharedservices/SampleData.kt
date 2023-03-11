package com.maruchin.kmm.sharedservices

import com.maruchin.kmm.sharedservices.posts.PostJson
import com.maruchin.kmm.sharedservices.posts.Post
import com.maruchin.kmm.sharedservices.posts.PostWithAuthor
import com.maruchin.kmm.sharedservices.users.UserJson
import com.maruchin.kmm.sharedservices.users.User

internal val sampleUsersJson = listOf(
    UserJson(
        id = 1,
        name = "Leanne Graham",
        email = "Bret"
    ),
    UserJson(
        id = 2,
        name = "Ervin Howell",
        email = "Antonette",
    ),
    UserJson(
        id = 3,
        name = "Clementine Bauch",
        email = "Samantha",
    )
)

internal val sampleUsers = listOf(
    User(
        id = 1,
        name = "Leanne Graham",
        email = "Bret"
    ),
    User(
        id = 2,
        name = "Ervin Howell",
        email = "Antonette",
    ),
    User(
        id = 3,
        name = "Clementine Bauch",
        email = "Samantha",
    )
)

internal val samplePostsJson = listOf(
    PostJson(
        id = 1,
        userId = 1,
        title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit" +
            " molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
    ),
    PostJson(
        id = 2,
        userId = 2,
        title = "qui est esse",
        body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores " +
            "neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui " +
            "aperiam non debitis possimus qui neque nisi nulla",
    ),
    PostJson(
        id = 3,
        userId = 3,
        title = "ea molestias quasi exercitationem repellat qui ipsa sit aut",
        body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem " +
            "doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
    )
)

internal val sampleFreshPostsJson = listOf(
    PostJson(
        id = 1,
        userId = 1,
        title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit" +
            " molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
    ),
    PostJson(
        id = 2,
        userId = 2,
        title = "qui est esse",
        body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores " +
            "neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui " +
            "aperiam non debitis possimus qui neque nisi nulla",
    ),
    PostJson(
        id = 3,
        userId = 3,
        title = "ea molestias quasi exercitationem repellat qui ipsa sit aut",
        body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem " +
            "doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
    ),
    PostJson(
        id = 4,
        userId = 2,
        title = "eum et est occaecati",
        body = "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident " +
            "rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis " +
            "sunt voluptatem rerum illo velit"
    ),
    PostJson(
        id = 5,
        userId = 1,
        title = "nesciunt quas odio",
        body = "repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem " +
            "omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"
    )
)

internal val samplePosts = listOf(
    Post(
        id = 1,
        userId = 1,
        title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit" +
            " molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
    ),
    Post(
        id = 2,
        userId = 2,
        title = "qui est esse",
        body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores " +
            "neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui " +
            "aperiam non debitis possimus qui neque nisi nulla",
    ),
    Post(
        id = 3,
        userId = 3,
        title = "ea molestias quasi exercitationem repellat qui ipsa sit aut",
        body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem " +
            "doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
    ),
)

internal val sampleFreshPosts = listOf(
    Post(
        id = 1,
        userId = 1,
        title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
        body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit" +
            " molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
    ),
    Post(
        id = 2,
        userId = 2,
        title = "qui est esse",
        body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores " +
            "neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui " +
            "aperiam non debitis possimus qui neque nisi nulla",
    ),
    Post(
        id = 3,
        userId = 3,
        title = "ea molestias quasi exercitationem repellat qui ipsa sit aut",
        body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem " +
            "doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
    ),
    Post(
        id = 4,
        userId = 2,
        title = "eum et est occaecati",
        body = "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident " +
            "rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis " +
            "sunt voluptatem rerum illo velit"
    ),
    Post(
        id = 5,
        userId = 1,
        title = "nesciunt quas odio",
        body = "repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem " +
            "omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque"
    )
)

internal val samplePostsWithAuthors = listOf(
    PostWithAuthor(samplePosts[0], sampleUsers[0]),
    PostWithAuthor(samplePosts[1], sampleUsers[1]),
    PostWithAuthor(samplePosts[2], sampleUsers[2]),
)
