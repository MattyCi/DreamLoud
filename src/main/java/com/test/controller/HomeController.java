package com.test.controller;

import com.test.Helpers.LoginHelper;
import com.test.Models.AccountEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView helloWorld() {
        return new
                ModelAndView("index", "message", "Welcome to GC COFFEE");
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam(required = false, name="email") String email, @RequestParam(required = false, name="password") String password)
    {
        AccountEntity acct = LoginHelper.loginUsingEmailAndPassword(email, password);
        if (acct == null){
            return "redirect:/index";
        } else {
            return "redirect:/newsfeed";
        }
    }

    @RequestMapping("/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping("/edit-profile-basic")
    public String editProfileBasic() {
        return "edit-profile-basic";
    }

    @RequestMapping("/edit-profile-interests")
    public String editProfileInterests() {
        return "edit-profile-interests";
    }

    @RequestMapping("/edit-profile-password")
    public String editProfilePassword() {
        return "edit-profile-password";
    }

    @RequestMapping("/edit-profile-settings")
    public String editProfileSettings() {
        return "edit-profile-settings";
    }

    @RequestMapping("/edit-profile-work-edu")
    public String editProfileWorkEdu() {
        return "edit-profile-work-edu";
    }

    @RequestMapping("/index-register")
    public String indexRegister() {
        return "index-register";
    }

    @RequestMapping("/newsfeed")
    public String newsfeed() {
        return "newsfeed";
    }

    @RequestMapping("/newsfeed-friends")
    public String newsfeedFriends() {
        return "newsfeed-friends";
    }

    @RequestMapping("/newsfeed-images")
    public String newsfeedImages() {
        return "newsfeed-images";
    }

    @RequestMapping("/newsfeed-messages")
    public String newsfeedMessages() {
        return "newsfeed-messages";
    }

    @RequestMapping("/newsfeed-people-nearby")
    public String newsfeedPeopleNearby() {
        return "newsfeed-people-nearby";
    }

    @RequestMapping("/newsfeed-videos")
    public String newsfeedVideos() {
        return "newsfeed-videos";
    }

    @RequestMapping("/timeline")
    public String timeline() {
        return "timeline";
    }

    @RequestMapping("/timeline-about")
    public String timelineAbout() {
        return "timeline-about";
    }

    @RequestMapping("/timeline-album")
    public String timelineAlbum() {
        return "timeline-album";
    }

    @RequestMapping("/timeline-friends")
    public String timelineFriends() {
        return "timeline-friends";
    }


}
