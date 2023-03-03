//
//  LoginViewModel.swift
//  iosApp
//
//  Created by Marcin Piekielny on 01/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

class LoginViewModel: ObservableObject {
    
    @Published var email: String = "Sincere@april.biz"
    @Published var isLoading: Bool = false
    @Published var errorMessage: String = ""
    
    private let usersService: UsersService
    private let delegate: LoginDelegate
    
    init(usersService: UsersService, delegate: LoginDelegate) {
        self.usersService = usersService
        self.delegate = delegate
    }
    
    func login() {
        isLoading = true
        usersService.loginUser(email: email) { error in
            if (error == nil) {
                self.delegate.onLoggedIn()
            } else {
                self.errorMessage = "Sorry, we can't login you right now"
            }
        }
    }
}

protocol LoginDelegate {
    func onLoggedIn()
}
