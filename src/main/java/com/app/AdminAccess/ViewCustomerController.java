//package com.app.AdminAccess;
//
//import org.springframework.web.bind.annotation.GetMapping;
//
//public class ViewCustomerController {
//    @GetMapping("/TEST")
//    public String showForm() {
//            boolean isAdmin = hasRole(authentication, "ROLE_ADMIN");
//            model.addAttribute("isAdmin", isAdmin);
//        }
//        return "signup"; // This assumes the HTML file is named "signup.html" in the "resources/templates" directory
//    }
//
//    private boolean hasRole(Authentication authentication, String role) {
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        return authorities.stream().anyMatch(authority -> authority.getAuthority().equals(role));
//    }
//}
