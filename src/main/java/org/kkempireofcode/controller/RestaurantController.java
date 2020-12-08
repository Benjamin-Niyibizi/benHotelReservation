package org.kkempireofcode.controller;

import org.kkempireofcode.model.Item;
import org.kkempireofcode.service.HotelSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RestaurantController {

    @Autowired
    private HotelSystemService service;

    @RequestMapping(value = "restaurant")
    public ModelAndView viewRestaurantPage(ModelAndView model){
        model.addObject("allItems",service.getAllItems());
        model.setViewName("restaurant");
        return model;
    }
    @RequestMapping(value = "addItem")
    public ModelAndView viewAddItemPage(ModelAndView model){
        model.addObject("allItems",service.getAllItems());
        model.setViewName("addItem");
        return model;
    }
    @RequestMapping(value = "addItemAction",method = RequestMethod.POST)
    public ModelAndView addItemAction(ModelAndView model, HttpServletRequest request){
        String name=request.getParameter("name");
        Double buyPrice=Double.parseDouble(request.getParameter("buyprice"));
        Double sellPrice=Double.parseDouble(request.getParameter("sellprice"));

        Item item=new Item();
        item.setName(name);
        item.setBuyPrice(buyPrice);
        item.setSellPrice(sellPrice);
        service.addItem(item);

        model.addObject("allItems",service.getAllItems());

        model.setViewName("addItem");
        return model;

    }

    @RequestMapping(value = "sellItem")
    public ModelAndView viewItemsToSell(ModelAndView model){
        model.addObject("allItems",service.getAllItems());
        model.setViewName("sellItem");
        return model;
    }
}
