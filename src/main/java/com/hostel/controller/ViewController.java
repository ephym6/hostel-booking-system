package com.hostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /*
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/book-room")
    public String bookRoomPage(@RequestParam("roomId") Long roomId, Model model) {
        model.addAttribute("roomId", roomId);
        return "book-room";
    }

     */

    @GetMapping("/browse-rooms")
    public String browseRoomsPage() {
        return "browse-rooms";
    }

    @GetMapping("/admin-dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }
}
