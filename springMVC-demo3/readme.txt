域对象共享数据

1.使用ModelAndView向request域对象共享数据(推荐使用)

public ModelAndView testModelAndView(){
    ModelAndView mav = new ModelAndView();
    // 处理模型数据, 即向请求域request共享数据
    mav.addObject("testRequestScope","hello,ModelAndView");
    // 设置视图名称
    mav.setViewName("success");
    return mav;
}

2.使用Model向request域对象共享数据

public String testModel(Model model){
    model.addAttribute("testRequestScope","hello,model");
    return "success";
}

3.使用map向request域对象共享数据

public String testMap(Map<String,Object> map){
    map.put("testRequestScope","hello,map");
    return "success";
}

4.使用ModelMap向request域对象共享数据

@RequestMapping("/testModelMap")
public String testModelMap(ModelMap modelMap){
    modelMap.addAttribute("testRequestScope","hello,modelmap");
    return "success";
}

5.向session域共享数据

public String testSession(HttpSession session){
    session.setAttribute("testSessionScope","hello,session");
    return "success";
}

6.向application域(整个工程)共享数据

public String testApplication(HttpSession session){
    ServletContext application = session.getServletContext();
    application.setAttribute("testApplicationScope","hello,application");
    return "success";
}


视图控制器

当控制器方法中，仅仅用来实现页面跳转，即只需要设置视图名称，可以将处理器方法使用view-controller标签进行表示

path:路径
view-name:要跳转的视图名称

<mvc:view-controller path="/" view-name="index"></mvc:view-controller>

注：
一旦使用视图控制器后，一定要开启注解驱动，否则注解不生效
<!--开启MVC的注解驱动-->
<mvc:annotation-driven/>