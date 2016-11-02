package com.javarush.spring;

import com.javarush.spring.model.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javarush.spring.model.User;
import com.javarush.spring.service.UserService;


@Controller
public class UserController {

    private int curPage = 1;

     private Filter filter = new Filter();
    private UserService userService;

    private int[] getPageList() {

        int[] pagelist = new int[this.userService.countPage(filter)];
        for(int i=0; i<pagelist.length ;i++)
            pagelist[i] = i+1;
        return pagelist;
    }

    @Autowired(required=true)
    @Qualifier(value="userService")
    public void setUserService(UserService ps){
        this.userService = ps;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listUsers(Model model) {
        return listUsers(1, model);
    }


    @RequestMapping(value = "/users/{page}", method = RequestMethod.GET)
    public String listUsers(@PathVariable("page") int page , Model model) {
        curPage = page;
        model.addAttribute("user", new User());
        model.addAttribute("filter", filter);
        model.addAttribute("curpage", curPage);
        model.addAttribute("listusers",  this.userService.listUsers(page-1, filter));
        model.addAttribute("listpage", getPageList());
        return "user";
    }

    @RequestMapping(value= "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User p){

        if(p.getId() == 0){
            this.userService.addUser(p);
        }else{
            this.userService.updateUser(p);
        }

        return "redirect:/users/"+curPage;

    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){

        User user = this.userService.getUserById(id);

        this.userService.removeUser(id);
        if (curPage > getPageList().length) curPage--;
        return "redirect:/users/"+curPage;
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        User user = this.userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("filter", filter);
        model.addAttribute("curpage", curPage);
        model.addAttribute("listusers", this.userService.listUsers(curPage-1,filter));
        model.addAttribute("listpage", getPageList());

        return "user";
    }

    @RequestMapping("/user/flt")
    public String filterUser(@ModelAttribute("filter") Filter f, Model model){
        filter = f;
        return "redirect:/users/1";
    }


}