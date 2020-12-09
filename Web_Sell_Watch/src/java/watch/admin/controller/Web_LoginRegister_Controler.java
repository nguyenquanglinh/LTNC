/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package watch.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import watch.admin.model.CategoriesModel;
import watch.admin.model.OrderModel;
import watch.admin.model.ProducersModel;
import watch.admin.model.ProductModel;
import watch.admin.model.Web_User_Model;
import watch.entity.Cart;
import watch.entity.Categories;
import watch.entity.Images;
import watch.entity.OrderDetail;
import watch.entity.OrderDetailId;
import watch.entity.Orders;
import watch.entity.Producers;
import watch.entity.Product;
import watch.entity.WebUser;
import watch.web.model.ProductAdminModel;

/**
 *
 * @author ThinkPad T440s
 */
@Controller
@RequestMapping(value = "/LoginRegisterController")
public class Web_LoginRegister_Controler {

    private Web_User_Model UserLgModel;
    private CategoriesModel catModel;
    private ProducersModel prodcModel;
    private OrderModel orModel;
    private ProductModel proModel;

    public Web_LoginRegister_Controler() {
        UserLgModel = new Web_User_Model();
        prodcModel = new ProducersModel();
        catModel = new CategoriesModel();
        orModel = new OrderModel();
        proModel = new ProductModel();
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ModelAndView account() {
        ModelAndView mav = new ModelAndView("my-account");
        List<Categories> listcat = catModel.getAll();
        mav.addObject("listcat", listcat);
        List<Producers> listprodc = prodcModel.getAll();
        mav.addObject("listprodc", listprodc);
        return mav;
    }

    @RequestMapping(value = "/LoginRegister", method = RequestMethod.GET)
    public ModelAndView LoginRegister() {
        ModelAndView mav = new ModelAndView("login-register");
        List<Categories> listcat = catModel.getAll();
        mav.addObject("listcat", listcat);
        List<Producers> listprodc = prodcModel.getAll();
        mav.addObject("listprodc", listprodc);
        return mav;
    }
//    @RequestMapping(value = "/preregister")
//    public String preRegistera(@ModelAttribute("userBuy") WebUser p, Model model, HttpSession session) {
//
//        return "registerUser";
//    }

    @RequestMapping(value = "/Register")
    public ModelAndView initRegister(@ModelAttribute("userBuy") WebUser p, Model model, HttpSession session) {
        ModelAndView mav = new ModelAndView("register");
        List<Categories> listcat = catModel.getAll();
        mav.addObject("listcat", listcat);
        List<Producers> listprodc = prodcModel.getAll();
        mav.addObject("listprodc", listprodc);
//        WebUser unew = new WebUser();
//        mav.addObject("unew", unew);
        return mav;
    }

    @RequestMapping(value = "/Registers")
    public String register(@ModelAttribute("userBuy") WebUser u, HttpServletRequest request, HttpSession session) {
        boolean a = UserLgModel.InsertUser(u);
        u.getUserName();
        if (a == true) {
            session.removeAttribute("listCart");
            return "redirect:/LoginRegisterController/LoginRegister.htm?note=Success";
        } else {
            return "redirect:/LoginRegisterController/Register.htm?note=Error";
        }
    }
    public boolean CustomerOffline() {
        List<WebUser> usersCheck = (List<WebUser>) UserLgModel.getUserOnline();
        int c = usersCheck.size();
        if (c == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Customer1Online() {
        try {
            List<WebUser> usersCheck = (List<WebUser>) UserLgModel.getUserOnline();
            int c = usersCheck.size();
            if (c == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/useraccount")
    public String dangKy(Model model, HttpSession session) {
        if (CustomerOffline() == true) {
//            model.addAttribute();
            return "login-register";
        } else {
            boolean a = Customer1Online();
            WebUser u = UserLgModel.getUserOnlineO();
            model.addAttribute("uid", u.getUserId());
            model.addAttribute("userod", u);

            return "CustomerInfo";
        }
    }

    @RequestMapping("/preupdateuseraccount")
    public String preUpdateUser(Model model) {
        boolean a = Customer1Online();
        WebUser u = UserLgModel.getUserOnlineO();
        model.addAttribute("userod", u);
        return "UpdateUserAccount";
    }

    @RequestMapping("/updateuseraccount")
    public String UpdateUser(@ModelAttribute("u") WebUser u, HttpServletRequest request, Model model) {

        WebUser u1 = UserLgModel.getUserOnlineO();
        u.setUserId(u1.getUserId());
        u.setUserStatus(Boolean.TRUE);
        System.out.println("111111111 " + u.getUserId() + "  " + u.getAddresss());
        boolean a = UserLgModel.UpdateUser(u);
        if (a == true) {

            return "redirect:/WebProController/getAll.htm?success=Update_Success";
        } else {
            return "redirect:/WebProController/getAll.htm?error=Error";
        }

    }

    @RequestMapping("/loginuser")
    public String login(HttpServletRequest request, Model model) {

        String uname = request.getParameter("userName");
        model.addAttribute("taiKhoan", uname.trim());
        String pass = request.getParameter("passwords");
        model.addAttribute("matKhau", pass.trim());
        System.out.println("Đã getTHong tin: " + uname + "  " + pass);
        List<WebUser> u = UserLgModel.checkAccountUser(uname, pass);
        int k = u.size();
        if (k == 0) {
            model.addAttribute("note", "Incorrect username or password.");
            return "UserLogin";
//            return "redirect:/productController/login.htm?error=Error1";
        } else {

            UserLgModel.setStatusUserfalse();
            boolean a = UserLgModel.setStatusUsertrue(uname, pass);
            if (a == true) {
                return "redirect:/WebProController/getAll.htm?note=Update_Success";
            } else {
                return "redirect:/LoginRegisterController/login.htm?note=Error2";
            }
        }

    }

    @RequestMapping("/signout")
    public String signOut(Model model) {
        UserLgModel.setStatusUserfalse();
        model.addAttribute("note", "Signout success");
        return "login-register";
    }

    @RequestMapping("/preOrderProduct")
    public String orderProduct(Model model, HttpSession session) {

        if (Customer1Online() == true) {
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            boolean a = Customer1Online();
            WebUser u = UserLgModel.getUserOnlineO();
            model.addAttribute("userod", u);
            session.setAttribute("listCart", listCart);
            session.setAttribute("totalAmount", sumAmount(listCart));
            return "CustomerOrder";
        } else {
            return "login-register";
        }

    }

    public float sumAmount(List<Cart> listCart) {
        float totalAmount = 0;
        for (Cart cart : listCart) {
            totalAmount += cart.getQuantity() * cart.getProduct().getPrice();

        }
        return totalAmount;
    }

    @RequestMapping(value = "/orderPrpreOrderProductoduct")
    public String saveCart(@ModelAttribute("userod") WebUser u, HttpServletRequest request, HttpSession session) throws ParseException {
        List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
        Date now = new Date();
        String strDate = s.format(now);
        Date d = s.parse(strDate);

//        String  [] sl=request.getParameterValues("quantity");
        List<WebUser> u1 = UserLgModel.getUserOnline();
        WebUser u2 = u1.get(0);
        Orders od = new Orders();
        od.setWebUser(u2);
        od.setCreated(new Date());
        od.setName(u.getUserName());
        od.setOrderStatus(Boolean.FALSE);
        od.setMail(u.getMail());
        od.setPhone(u.getPhone());
        od.setAddresss(u.getAddresss());
        boolean bl = orModel.insertOrderProduct(od);

        boolean bld = false;
        if (bl) {

            for (Cart oddl : listCart) {
                List<Orders> od1 = orModel.getMaxOrders();

                String proid = oddl.getProduct().getProductId();
                Product p = proModel.getById(proid);

                Orders od2 = od1.get(0);
                int sl = oddl.getQuantity();

                OrderDetailId oid = new OrderDetailId(od2.getOrderId(), proid);
                OrderDetail dt = new OrderDetail();
                dt.setId(oid);
                dt.setOrders(od2);
                dt.setProduct(p);
                dt.setQuantity(sl);

                System.out.println("11111: " + dt.toString() + " " + od2.getOrderId() + " " + proid + "  " + sl);
                orModel.insertOrderDetail(dt);
            }
        }

        if (bl) {
            session.removeAttribute("listCart");
            return "redirect:/WebProController/getAll.htm?success=Dat hang thanh cong";
        } else {
            return "redirect:/WebProController/getAll.htm?error=Co loi khong dat hang duoc";
        }
    }

}
