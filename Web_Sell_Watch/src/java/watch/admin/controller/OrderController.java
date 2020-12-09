/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch.admin.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import watch.admin.model.OrderModel;
import watch.admin.model.ProducersModel;
import watch.admin.model.ProductModel;
import watch.admin.model.Web_User_Model;
import watch.entity.Orders;
import watch.entity.Producers;
import watch.entity.Product;
import watch.entity.WebUser;

/**
 *
 * @author ThinkPad T440s
 */
@Controller
@RequestMapping(value = "/OrderController")
public class OrderController {

    private OrderModel orderModel;
    private ProductModel proModel;
    private Web_User_Model userModel;

    public OrderController() {
        orderModel = new OrderModel();
        proModel = new ProductModel();
        userModel = new Web_User_Model();
    }

    @RequestMapping(value = "/getAll")
    public ModelAndView getAll() {
        ModelAndView mav = new ModelAndView("AdminOrder");
        List<Orders> listOrder = orderModel.getAll();
        mav.addObject("listOrders", listOrder);
        List<Orders> listOrderD = orderModel.getAllDetail();
        mav.addObject("abc", listOrderD);
        List<Product> listPro = proModel.getAll();
        mav.addObject("listPro", listPro);
        List<WebUser> listU = userModel.getAll();
        mav.addObject("listU", listU);
        return mav;
    }
    @RequestMapping(value = "/getActive")
    public ModelAndView getAllS1() {
        ModelAndView mav = new ModelAndView("AdminOrder");
        List<Orders> listOrder = orderModel.getAllS1();
        mav.addObject("listOrders", listOrder);
        List<Orders> listOrderD = orderModel.getAllDetail();
        mav.addObject("abc", listOrderD);
        List<Product> listPro = proModel.getAll();
        mav.addObject("listPro", listPro);
        List<WebUser> listU = userModel.getAll();
        mav.addObject("listU", listU);
        return mav;
    }
    @RequestMapping(value = "/getInActive")
    public ModelAndView getAllS0() {
        ModelAndView mav = new ModelAndView("AdminOrder");
        List<Orders> listOrder = orderModel.getAllS0();
        mav.addObject("listOrders", listOrder);
        List<Orders> listOrderD = orderModel.getAllDetail();
        mav.addObject("abc", listOrderD);
        List<Product> listPro = proModel.getAll();
        mav.addObject("listPro", listPro);
        List<WebUser> listU = userModel.getAll();
        mav.addObject("listU", listU);
        return mav;
    }
}
