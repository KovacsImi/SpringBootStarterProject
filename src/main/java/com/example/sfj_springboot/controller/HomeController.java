package com.example.sfj_springboot.controller;

import com.example.sfj_springboot.domain.Story;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/")
    public String  stories(Model model){
        model.addAttribute("pageTitle", "Ez lesz a honlap új címe, amelyet a modell ad át!");
        model.addAttribute("stories", getStories());
        return "stories";
    }

    @RequestMapping("/user/{id}")
    public String  searchForUser(Model model, @PathVariable(value = "id") String id) throws Exception {
        if(id == null){
            throw new Exception("Nincs ilyen ID-val rendelkező felhasználó!");
        }

        return null;
    }

//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(HttpServletRequest httpServletRequest, Exception exception, Model model){
//        model.addAttribute("errMessage", exception.getMessage());
//        return "exceptionHandlerPage";
//    }

    private List<Story> getStories(){
        List<Story> storyList = new ArrayList<>();

        Story story1 = new Story();
        story1.setAuthor("Én");
        story1.setPosted(new Date());
        story1.setContent("<p>Milyen remek időnk van!</p>");
        story1.setTitle("Időjárásjelentés");

        Story story2 = new Story();
        story2.setAuthor("Egy másik személy");
        story2.setPosted(new Date());
        story2.setContent("<p>Egy nagy szar, amit csinálunk!</p>");
        story2.setTitle("Őszinte vélemény");

        storyList.add(story1);
        storyList.add(story2);

        return storyList;
    }

}
