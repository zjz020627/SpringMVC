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