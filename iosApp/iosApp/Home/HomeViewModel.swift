//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Marcin Piekielny on 02/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

class HomeViewModel: ObservableObject {
    
    @Published var posts: [PostWithAuthor] = []
    @Published var isLoading: Bool = false
    @Published var errorMessage: String = ""
    
    private let sessionService: SessionService
    private let postsService: PostsService
    private let delegate: HomeDelegate
    
    init(sessionService: SessionService, postsService: PostsService, delegate: HomeDelegate) {
        self.sessionService = sessionService
        self.postsService = postsService
        self.delegate = delegate
        loadPosts()
    }
    
    func logout() {
        sessionService.logoutUser { error in
            if (error == nil) {
                self.delegate.onLoggedOut()
            } else {
                self.errorMessage = "Sorry, we can't logout you right now"
            }
        }
    }
    
    private func loadPosts() {
        isLoading = true
        postsService.getPostsWithAuthors { posts, error in
            self.isLoading = false
            if let posts = posts {
                self.posts = posts
            } else {
                self.errorMessage = "Sorry, we can't load your posts right now"
            }
        }
    }
}

protocol HomeDelegate {
    func onLoggedOut()
}
