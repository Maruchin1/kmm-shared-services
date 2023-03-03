//
//  Provider.swift
//  iosApp
//
//  Created by Marcin Piekielny on 01/03/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import shared

class Provider {
    
    static let shared = Provider()
    
    let sharedLibrary: SharedLibrary
    
    private init() {
        let config = SharedConfig(settingsName: "demo_settings")
        sharedLibrary = SharedLibrary(config: config)
    }
}
