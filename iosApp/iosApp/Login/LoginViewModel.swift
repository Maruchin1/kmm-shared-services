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
    
    private let sessionService: SessionService
    private let delegate: LoginDelegate
    
    init(sessionService: SessionService, delegate: LoginDelegate) {
        self.sessionService = sessionService
        self.delegate = delegate
    }
    
    func login() {
        isLoading = true
        sessionService.loginUser(email: email) { error in
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
