# 基于SpringbBoot的网上考试管理系统

## 介绍
 ### 功能简介

- 支持单选题、多选题、判断题

- 支持学生(student)、教师(teacher)、管理员(admin)三种角色

	- 学生：参加考试和查看我的考试
	- 教师：学生的所有权限+创建/编辑题目+创建/编辑考试
	- 管理员：教师的所有权限+管理用户

###  软件架构

- 后端采用SpringBoot+JPA++Swagger2+JWT校验,根据不同用户的权限返回给用户不同的数据
- 前端采用Vue+AntDesign,组件化拆分，封装了很多年公共组件，方便维护和二次开发

### 系统截图

![image](https://github.com/gpcpp/exam/assets/104951045/f0fb1260-e60e-4628-b6aa-d156a6b79f0a)
![image](https://github.com/gpcpp/exam/assets/104951045/58852fdc-5e78-43b6-bc39-9f9eb0a463bd)
![image](https://github.com/gpcpp/exam/assets/104951045/dcd26a69-d85a-40b1-9ff0-d68ea4b554b4)
![image](https://github.com/gpcpp/exam/assets/104951045/bf0f71f6-ca77-43d4-99c4-a7f354c102ca)
![image](https://github.com/gpcpp/exam/assets/104951045/536b8e15-0f7a-4d5d-b38d-705c05603c82)
