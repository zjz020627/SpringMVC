1.RequestBody:请求体,用在形参列表,返回整个请求体
@RequestBody String requestBody

类似的有@RequestParam(value = "username") String username
获取单个请求


2.RequestEntity:请求报文的信息,用在形参列表,返回整个请求报文信息
RequestEntity<String> requestEntity

类似的有@RequestHeader(value = "Host") String host
获取请求头的某个信息等


3.ResponseBody:响应体,用在注解,把返回值作为响应体返回
@RequestMapping("/testResponseUser")
@ResponseBody
public User testResponseUser(){
    return new User(1001,"admin","123456",16,"男");
}

注：要想返回对象，必须加入依赖jackson-databind，否则报错500，因为要把对象转换成json

@RestController:注解,用在控制器的类上,相当于给这个类添加了@Controller注解,并且为类中的每个
方法都添加@ResponseBody注解

4.ResponseEntity:返回类型,用于方法的返回结果,通常用于下载文件

5.