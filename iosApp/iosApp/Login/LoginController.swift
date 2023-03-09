//
//  LoginController.swift
//  iosApp
//
//  Created by Marcin Piekielny on 01/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

func buildLoginController(delegate: LoginDelegate) -> UIViewController {
    let sdk = DemoSdkProvider.shared.sdk
    let viewModel = LoginViewModel(usersService: sdk.usersService, delegate: delegate)
    let view = LoginView(viewModel: viewModel)
    return UIHostingController(rootView: view)
}
