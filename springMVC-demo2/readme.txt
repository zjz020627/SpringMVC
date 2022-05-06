1.接受get和post请求
@RequestMapping(
            value = {"/testRequestMapping","test"},
            method = {RequestMethod.POST,RequestMethod.GET}
    )

2.要求接受params参数或headers参数
@RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123456"},
            headers = {"Host=localhost:8080"}
    )

3.ant风格（通配符）
@RequestMapping("/a?a/testAnt")// ?表示任意的单个字符, 这个字符必须存在且只能有一个
@RequestMapping("/a*a/testAnt")// *表示任意的0个或多个字符
@RequestMapping("/**/testAnt")// **表示任意的一层或多层目录, 写法只能/**/

4.RESULTful风格接口
@RequestMapping("/testPath/{id}/{username}")// {id}为占位符id




1.获取请求参数
@RequestParam(value = "user_name",required = false,defaultValue = "hehe") String username,

2.获取请求头
@RequestHeader(value = "Host",required = false,defaultValue = "dddd") String host,

3.获取请求cookie
@CookieValue(value = "JSESSIONID") String JSESSIONID

4.通过对象名获取参数属性,要求对象名里的属性与参数名一致
@RequestMapping("/testBean")
public String testBean(User user){
        System.out.println(user);
        return "success";
    }