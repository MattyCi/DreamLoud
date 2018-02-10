package com.test.controller;

import com.test.DAOs.DreamLoudDao;
import com.test.DaoFactory.DaoFactory;
import com.test.DaoFactory.DaoOptions;
import com.test.Helpers.DreamHelper;
import com.test.Helpers.LoginHelper;
import com.test.Helpers.NewsfeedHelper;
import com.test.Models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class HomeController {
    private DreamLoudDao dao = DaoFactory.getInstance(DaoOptions.HIBERNATE_DAO);
    private LoginHelper loginHelper = new LoginHelper(dao);
    private NewsfeedHelper newsfeedHelper = new NewsfeedHelper(dao);
    private DreamHelper dreamHelper = new DreamHelper(dao);

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
    public String loginUser(@RequestParam(required = false, name="email") String email, @RequestParam(required = false, name="password") String password, HttpServletResponse response)
    {
        AccountEntity acct = loginHelper.loginUsingEmailAndPassword(email, password);
        if (acct == null){
            return "redirect:/index";
        } else {
            setCookie(response, "userId", String.valueOf(acct.getAcctId()));
            return "redirect:/newsfeed";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletResponse response)
    {
        removeCookie(response, "userId");
        return "redirect:/index";
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
    public String newsfeed(Model model, @CookieValue(required = false, name = "userId") String userId) {
        AccountEntity acct = loginHelper.getAcctUsingId(userId);
        ArrayList<TranslatedPosts> posts;
        if(acct == null){
            return "redirect:/index";
        }else {
            posts = newsfeedHelper.getRelatedDreamPosts(userId);
            model.addAttribute("acctInfo", acct);
            model.addAttribute("dreamPosts", posts);
            return "newsfeed";
        }
    }

    @RequestMapping("/dream")
    public String dream(Model model, @CookieValue(required = false, name = "userId") String userId, @RequestParam(required = false, name = "dreamId") String dreamId, HttpServletResponse response, HttpServletRequest request) {
        ArrayList<TranslatedPosts> posts;
        DreamsEntity dream;
        AccountEntity acct;
        if(dreamId == null){
            dreamId = WebUtils.getCookie(request, "dreamId").getValue();
        }
        if(userId == null){
            return "redirect:/index";
        }else {
            acct = loginHelper.getAcctUsingId(userId);
            dream = dreamHelper.getDream(dreamId);
            posts = dreamHelper.getRelatedDreamPosts(dreamId, userId);
            setCookie(response, "dreamId", dreamId);
            model.addAttribute("acctInfo", acct);
            model.addAttribute("dreamPosts", posts);
            model.addAttribute("dreamInfo", dream);
            if(acct == null) {
                return "redirect:/index";
            } else {
                return "dream";
            }
        }
    }

    @RequestMapping("/createPost")
    public String createPost(@RequestParam(required = false, name = "postContent") String postContent, @RequestParam(required = false, name = "dreamId") String dreamId, @RequestParam(required = false, name = "userId") String userId) {
        dreamHelper.createPost(postContent, dreamId, userId);
        return "redirect:/dream";
    }

    @RequestMapping("/postComment")
    public String postComment(@RequestParam(required = false, name = "commentContent") String commentContent, @RequestParam(required = false, name = "userId") String userId, @RequestParam(required = false, name = "postId") String postId) {
        PostCommentsEntity comment = new PostCommentsEntity();
        comment.setCommentContent(commentContent.getBytes());
        comment.setAcctId(Integer.parseInt(userId));
        comment.setPostId(Integer.parseInt(postId));
        newsfeedHelper.postComment(comment);
        return "redirect:/newsfeed";
    }

    @RequestMapping("/followDream")
    public String followDream(Model model, @CookieValue(required = false, name = "userId") String userId, @RequestParam(required = false, name = "dreamId") String dreamId) {
        boolean success = newsfeedHelper.followDream(userId, dreamId);
        if (success){
            model.addAttribute("followMessage", "You are now following this dream!");
        } else {
            model.addAttribute("followMessage", "You are already following this dream!");
        }
        return newsfeed(model, userId);
    }

    @RequestMapping("/unfollowDream")
    public String unfollowDream(Model model, @CookieValue(required = false, name = "userId") String userId, @RequestParam(required = false, name = "dreamId") String dreamId) {
        boolean success = newsfeedHelper.unfollowDream(userId, dreamId);
        if (success){
            model.addAttribute("followMessage", "You have unfollowed this dream!");
        } else {
            model.addAttribute("followMessage", "You are already not following this dream!");
        }
        return newsfeed(model, userId);
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

    private void setCookie(HttpServletResponse response, String cookieName, String userId) {
        Cookie userCookie = new Cookie(cookieName, userId);
        userCookie.setMaxAge(48 * 60 * 60); //sets the cookie for 1 day
        // demonstrates how we can manually add our own cookie value
        response.addCookie(userCookie);
    }

    private void removeCookie(HttpServletResponse response, String cookieName) {
        Cookie userCookie = new Cookie(cookieName, null);
        userCookie.setMaxAge(48 * 60 * 60); //sets the cookie for 1 day
        // demonstrates how we can manually add our own cookie value
        response.addCookie(userCookie);
    }


}
