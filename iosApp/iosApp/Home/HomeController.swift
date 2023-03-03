//
//  HomeController.swift
//  iosApp
//
//  Created by Marcin Piekielny on 02/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

func buildHomeController(delegate: HomeDelegate) -> UIViewController {
    let library = Provider.shared.sharedLibrary
    let viewModel = HomeViewModel(
        usersService: library.usersService,
        postsService: library.postsService,
        delegate: delegate
    )
    let view = HomeView(viewModel: viewModel)
    return UIHostingController(rootView: view)
}
