/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import watch.admin.model.CategoriesModel;
import watch.admin.model.ProducersModel;
import watch.entity.Cart;
import watch.entity.Categories;
import watch.entity.OrderDetail;
import watch.entity.Orders;
import watch.entity.Producers;
import watch.entity.Product;
import watch.entity.WebUser;
import watch.web.model.ProductAdminModel;


/**
 *
 * @author Admin
 */
@Controller
@RequestMapping(value = "/cartController")
public class CartController {
    private ProductAdminModel proModel;
private ProducersModel prodcModel;
private CategoriesModel catModel;
    public CartController() {
        proModel = new ProductAdminModel();
        prodcModel = new ProducersModel();
        catModel = new CategoriesModel();
    }
    @RequestMapping(value = "/getCat")
    public ModelAndView getProbyCatID() {
        ModelAndView mav = new ModelAndView("cart"); 
         List<Categories> listcat = catModel.getAll();
        mav.addObject("listcat", listcat);
        List<Producers> listprodc = prodcModel.getAll();
        mav.addObject("listprodc", listprodc);
        
        return mav;
    }
    
    @RequestMapping(value = "addCart")
    public String addCart(HttpServletRequest request, HttpSession session){
       
        String productId = request.getParameter("productId");
        Product pro = proModel.getProductById(productId);
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
        if(listCart==null){
            listCart = new ArrayList<>();
            Cart cart = new Cart(pro, 1);
            listCart.add(cart);
        }
        else{
             boolean check = false;
            for (Cart cart : listCart) {
                if (cart.getProduct().getProductId().equals(productId)) {
                    check = true;
                  
                    cart.setQuantity(cart.getQuantity() + 1);
                    break;
                }
                
            }
            if(!check){
                Cart cart = new Cart(pro, 1);
                listCart.add(cart);
            }
           
            
        }
        session.setAttribute("listCart", listCart);
        session.setAttribute("totalAmount", sumAmount(listCart));
        return "cart";
    }

    public float sumAmount(List<Cart> listCart){
        float totalAmount = 0;
        for (Cart cart : listCart) {
            totalAmount+= cart.getQuantity()* cart.getProduct().getPrice();
            
        }
        return totalAmount;
    }
 
      @RequestMapping(value = "/updateCart")
    public String updateQuantityCart(HttpSession session,HttpServletRequest request){
        
        List<Cart> listCart = (List<Cart>)session.getAttribute("listCart");
        
        String[] arrQuantity = request.getParameterValues("quantity");
          try {
               for (int i = 0; i < listCart.size(); i++) {
            listCart.get(i).setQuantity(Integer.parseInt(arrQuantity[i]));
        }
          } catch (Exception e) {
              e.printStackTrace();
          }
       
     
        session.setAttribute("listCart", listCart);
        
        session.setAttribute("totalAmount", sumAmount(listCart));
        return "cart";
    }

    @RequestMapping(value = "/getProCat")
    public String getProbyCatID(String catId) {
        return "redirect:/WebProController/getProCat.htm?catId="+catId;
    }
@RequestMapping(value = "/getProProd")
    public String getProbyProdID(String producersId) {
        return "redirect:/WebProController/getProProd.htm?producersId="+producersId;
    }
    @RequestMapping(value = "/delete")
    public String deleteCart(HttpServletRequest request, HttpSession session){
        String productId = request.getParameter("productId");
        
        List<Cart> listCart = (List<Cart>)session.getAttribute("listCart");
       
        for (int i = 0; i < listCart.size(); i++) {
            if (listCart.get(i).getProduct().getProductId().equals(productId)) {
                listCart.remove(i);
                break;
            }
        }    
        session.setAttribute("listCart", listCart);
        session.setAttribute("totalAmount", sumAmount(listCart));
        return "cart";        
    }
}
