## 注解
>###@RequestParam
>用来处理 Content-Type: 为 application/x-www-form-urlencoded 编码的内容。（HTTP 协议中，如果不指定 Content-Type，则默认传递的参数就是 application/x-www-form-urlencoded 类型）  
>可以接受简单类型的属性，也可以接受对象类型。  
>将 Request.getParameter() 中的 Key-Value 参数利用 Spring 的转化机制 ConversionService，转化成接受参数或对象。
>- name / value 
>- required
>- defaultValue
>---
>###@RequestBody
>处理 HttpEntity 传递过来的数据，一般用来处理非 Content-Type: application/x-www-form-urlencoded 编码格式的数据。
>- required
>---
>###@PathVariable
>接收请求路径中占位符的值，利于编写 RESTFul API
>- name / value
>- required
>---
>###[@InitBinder](https://blog.csdn.net/Dongguabai/article/details/83656392)
>1. 绑定同属性多对象
>2. 类型转换
>- value
>---
## 自定义类型转换器
- PropertyEditor
- Formatter
- Converter
---