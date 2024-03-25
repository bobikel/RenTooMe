/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rentoome.auth.controller;

/**
 *
 * @author manbi
 */
/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for the token resource.
 *
 * @author Josh Cummings
 */
@RestController
public class TokenController {
//
//    @Autowired
//    JwtEncoder encoder;
//
//    @PostMapping("/token")
//    public String token(Authentication authentication) {
//        Instant now = Instant.now();
//        long expiry = 36000L;
//        // @formatter:off
//        String scope = authentication.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));
//        JwtClaimsSet claims = JwtClaimsSet.builder()
//                .issuer("self")
//                .issuedAt(now)
//                .expiresAt(now.plusSeconds(expiry))
//                .subject(authentication.getName())
//                .claim("scope", scope)
//                .build();
//        // @formatter:on
//        return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
//    }

}
