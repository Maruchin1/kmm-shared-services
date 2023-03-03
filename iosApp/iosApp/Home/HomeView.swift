//
//  HomeView.swift
//  iosApp
//
//  Created by Marcin Piekielny on 02/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    
    @ObservedObject var viewModel: HomeViewModel
    
    var body: some View {
        NavigationView {
            List(viewModel.posts, id: \.post.id) { post in
                ArticleView(
                    postTitle: post.post.title,
                    authorName: post.author.name,
                    postBody: post.post.body
                )
            }
        }
        .navigationTitle("Home")
        .toolbar {
            Button("Logout") {
                viewModel.logout()
            }
        }
    }
}

struct ArticleView: View {
    
    let postTitle: String
    let authorName: String
    let postBody: String
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(postTitle)
                .font(.title2)
            Text(authorName)
                .font(.caption)
                .padding(.vertical, 8)
            Text(postBody)
                .font(.body)
        }
    }
}
