//
//  LoginView.swift
//  iosApp
//
//  Created by Marcin Piekielny on 01/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    
    @ObservedObject var viewModel: LoginViewModel
    
    var body: some View {
        
        NavigationView {
            ZStack {
                Color.secondary.opacity(0.1).ignoresSafeArea()
                VStack(alignment: .center) {
                    Spacer()
                    Text("Welcome")
                        .font(.largeTitle)
                        .padding(.horizontal, 24)
                        .padding(.vertical, 12)
                    Text(viewModel.email)
                        .font(.body)
                        .padding(.horizontal, 24)
                        .padding(.vertical, 12)
                    Button(
                        action: {
                            viewModel.login()
                            
                        },
                        label: {
                            if (viewModel.isLoading) {
                                ProgressView()
                                    .frame(maxWidth: .infinity)
                            } else {
                                Text("Login")
                                    .frame(maxWidth: .infinity)
                            }
                            
                        }
                    )
                        .buttonStyle(.borderedProminent)
                        .padding(.horizontal, 24)
                        .padding(.vertical, 12)
                        .disabled(viewModel.isLoading)
                    Spacer()
                }
                .padding()
            }
        }
        .navigationTitle("Login")
        
        
    }
}
