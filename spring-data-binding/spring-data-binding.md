## 注解
| 注解             | 用途                                                |
|:---------------|:--------------------------------------------------|
| @RequestParam  | Content-Type: application/x-www-form-urlencoded   |
| @RequestBody   | 非 Content-Type: application/x-www-form-urlencoded |
| @PathVariable  | 请求路径占位符，便于 RESTFul API                            |
| @RequestHeader | 请求头                                               |
| @CookieValue   | Cookie                                            |
| @InitBinder    | 初始化 WebDataBinder                                 |
---
## 自定义类型转换器
- [PropertyEditor](src/main/java/com/ljh/common/MyPropertyEditor.java)
- [Formatter](src/main/java/com/ljh/common/MyDateFormatter.java)
- [Converter](src/main/java/com/ljh/common/MyDateConverter.java)
---
