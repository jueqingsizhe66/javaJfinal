## 第一次试验
2. 添加HelloController.java
3. 在其上面添加@Path("/hello")
4. 在HelloController类中集成Controller类
5. 新建一个hello12函数， 调用renderText,使用localhost:80/hello/hello12访问
6. 新建一个hello34函数， 调用renderText,使用localhost:80/hello/hello34访问
7. 新建一个helloHtml函数， 调用render,访问hello.html
8. 在webapp新建hello文件夹，在该文件夹内新建hello.html
9. 使用localhost:80/hello/helloHtml访问
10. 新建一个getMyselRender函数， 调用自定义render(基于RenderFactory),使用RenderText