package com.tiy.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justins PC on 5/17/2016.
 */
@Controller
public class ToDoListController {
    @Autowired
    ToDoRespitory todolist;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        Iterable<ToDoList> allItems = todolist.findAll();
        List<ToDoList> toDoItems = new ArrayList<>();
        for(ToDoList toDoItem: allItems) {
            toDoItems.add(toDoItem);
        }
        model.addAttribute("todolist",toDoItems);
        return "home";
    }
    @RequestMapping(path = "/add-item", method = RequestMethod.POST)
    public String addItem(String todotext,Boolean isdone) {
        isdone = false;
        ToDoList todoitem = new ToDoList(todotext,isdone);
        todolist.save(todoitem);
        return "redirect:/";
    }
//    @RequestMapping(path = "/togglewithcheck", method = RequestMethod.POST)
//    public String togglecheck(String toggletodo, Integer itemID) {
//        if (toggletodo !=null)  {
//            if (itemID !=null) {
//                ToDoList toDoItem = todolist.findOne(itemID);
//                toDoItem.isdone = true;
//                todolist.save(toDoItem);
//            }
//            return "redirect:/";
//        }
//        return "redirect:/";
//    }
    @RequestMapping(path = "/remove-item", method = RequestMethod.GET)
    public String deleteItem(Model model,Integer itemID) {
        if (itemID != null) {
            todolist.delete(itemID);
        }
        return "redirect:/";
    }
    @RequestMapping(path = "/toggle-item", method = RequestMethod.GET)
    public String toggleItem(Model model,Integer itemID) {
        if(itemID != null) {
           ToDoList toDoItem = todolist.findOne(itemID);
           toDoItem.isdone = true;
           todolist.save(toDoItem);
        }
        return "redirect:/";
    }

}
